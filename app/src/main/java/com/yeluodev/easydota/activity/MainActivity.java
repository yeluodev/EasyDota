package com.yeluodev.easydota.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.yeluodev.easydota.DotaAccountInfo;
import com.yeluodev.easydota.R;
import com.yeluodev.easydota.adapter.HomeAdapter;
import com.yeluodev.easydota.api.EasyDota;
import com.yeluodev.easydota.entity.Match;
import com.yeluodev.easydota.entity.Player;
import com.yeluodev.easydota.entity.openapi.RecentMatches;
import com.yeluodev.easydota.entity.openapi.TotalFiled;
import com.yeluodev.easydota.entity.openapi.WinAndLose;
import com.yeluodev.easydota.util.GsonUtil;
import com.yeluodev.easydota.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function3;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import static com.yeluodev.easydota.api.EasyDota.ACCOUNT_ID;
import static com.yeluodev.easydota.api.EasyDota.KEY;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/13 18:31
 * 修改人  yeluodev1226
 * 修改时间 2018/1/13 18:31
 * 备注
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private HomeAdapter mAdapter;

    private List mDatas;
    private Long matchId = 3250690650L;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_main);

        mRecyclerView = findViewById(R.id.rv_content);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        addData();
        mAdapter = new HomeAdapter(this,mDatas);
        mRecyclerView.setAdapter(mAdapter);

        fetchAccount();
        fetchRecentMatches();
//        fetchAccountInfo();
//        testGetMatchHistroy();
//        testGetMatchDetails();
    }

    private void addData(){
        mDatas = new ArrayList();
        mDatas.add(HomeAdapter.ITEM_ACCOUNT_INFO);
        mDatas.add(HomeAdapter.ITEM_TRADEMARK_HERO);
        mDatas.add(HomeAdapter.ITEM_RECENT_GAMES);
    }

    private void fetchAccount(){
        Observable<com.yeluodev.easydota.entity.openapi.Player> observable1 = EasyDota.getInstance().getOpenAPI().getAccountInfos("109926499")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observable<WinAndLose> observable2 = EasyDota.getInstance().getOpenAPI().getAccountWinAndLose("109926499")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observable<List<TotalFiled>> observable3 = EasyDota.getInstance().getOpenAPI().getAccountTotals("109926499")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observable.zip(observable1, observable2, observable3,
                new Function3<com.yeluodev.easydota.entity.openapi.Player, WinAndLose, List<TotalFiled>, DotaAccountInfo>() {
            @Override
            public DotaAccountInfo apply(com.yeluodev.easydota.entity.openapi.Player player, WinAndLose wl,List<TotalFiled> list) throws Exception {
                Log.d("yeluo", "apply");
                if(player!=null && wl!=null && !Util.isEmpty(list)){
                    DotaAccountInfo accountInfo = new DotaAccountInfo();
                    accountInfo.setName(player.getProfile().getPersonaname());
                    accountInfo.setAvatarUrl(player.getProfile().getAvatarfull());
                    accountInfo.setWin(wl.getWin());
                    accountInfo.setLose(wl.getLose());
                    accountInfo.setWinRate(wl.getWin()/(wl.getWin()+wl.getLose()+1.0f));
                    accountInfo.setMmr(player.getMmr_estimate().getEstimate());
                    accountInfo.setRank(0);
                    for(TotalFiled filed:list){
                        if(filed.getField().equals("kda") && filed.getN()!=0){
                            accountInfo.setKda((float) (filed.getSum() / filed.getN()));
                        }
                    }
                    return accountInfo;
                }
                return null;
            }
        }).subscribe(new DisposableObserver<Object>() {

            @Override
            public void onNext(Object o) {
                Log.d("yeluo", "onNext");
                if(o!=null && o instanceof DotaAccountInfo){
                    mDatas.remove(0);
                    mDatas.add(0,o);
                    mAdapter.setDatas(mDatas);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d("yeluo", "onError");
            }

            @Override
            public void onComplete() {
                Log.d("yeluo", "onComplete");
            }
        });
    }

    private void fetchRecentMatches(){
        EasyDota.getInstance().getOpenAPI().getRecentMatches("109926499")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<RecentMatches>>() {
                    @Override
                    public void onNext(List<RecentMatches> list) {
                        if(!Util.isEmpty(list)){
                            mAdapter.setRecentMatchesList(list);
                            mAdapter.notifyItemChanged(2);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.d("yeluo", "onComplete");
                    }
                });
    }

    private void fetchAccountInfo(){
        EasyDota.getInstance().getSteamService().getPlayerSummaries(KEY,ACCOUNT_ID)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String res = responseBody.string().replaceAll("\\n", "");
                            JSONObject object = new JSONObject(res);
                            JSONArray players = object.optJSONObject("response").optJSONArray("players");
                            if(!Util.isEmpty(players)){
                                List<Player> list = GsonUtil.jsonToArrayList(players.toString(), Player.class);
                                if(!Util.isEmpty(list)){
                                    mDatas.remove(0);
                                    mDatas.add(0,list.get(0));
                                    mAdapter.setDatas(mDatas);
                                    mAdapter.notifyDataSetChanged();
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.d("yeluo", "onComplete");
                    }
                });
    }

    private void testGetMatchHistroy() {

        EasyDota.getInstance().getSteamService().getMatchHistroy(KEY, null, null, null, null, ACCOUNT_ID, null, "3246131899", null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody s) {
                        Log.d("yeluo", s.getClass().getName());
                        try {
                            String res = s.string().replaceAll("\\n", "");
                            JSONObject object = new JSONObject(res);
                            JSONArray matches = object.optJSONObject("result").optJSONArray("matches");
                            Gson gson = new Gson();
                            Match match = gson.fromJson(matches.optJSONObject(1).toString(), Match.class);
                            List<Match.PlayersBean> players = match.getPlayers();
                            for(Match.PlayersBean player : players){
                                Log.d("yeluo", player.getAccountId()+"-"+ Util.convertToSteam64Id(player.getAccountId()+""));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        Log.d("yeluo", "complete");
                    }
                });
    }

    private void testGetMatchDetails() {

        EasyDota.getInstance().getSteamService().getMatchDetails(KEY, matchId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody s) {
                        try {
                            String res = s.string().replaceAll("\\n", "");
                            JSONObject object = new JSONObject(res);
                            JSONArray players = object.optJSONObject("result").optJSONArray("players");
                            if(!Util.isEmpty(players)){
                                for (int i=0;i<players.length();i++){
                                    JSONObject player = players.optJSONObject(i);
                                    if(player.optString("account_id").equals("109926499")){
                                        Log.d("yeluomatch","histroy没有的比赛历史="+object.optJSONObject("result").optLong("match_id"));
                                        break;
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        matchId++;
                        testGetMatchDetails();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
//                        Log.d("yeluo", "complete");
                    }
                });
    }
}
