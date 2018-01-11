package com.yeluodev.easydota;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yeluodev.easydota.api.EasyDota;
import com.yeluodev.easydota.entity.League;
import com.yeluodev.easydota.entity.Match;
import com.yeluodev.easydota.util.GsonUtil;
import com.yeluodev.easydota.util.Util;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

import static com.yeluodev.easydota.api.EasyDota.ACCOUNT_ID;
import static com.yeluodev.easydota.api.EasyDota.KEY;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    private Long matchId = 111111111L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.response);
        testGetMatchDetails();
    }

    private void testGetLeagueListing() {
        EasyDota.getInstance().getSteamService().getLeagueListing(KEY)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        try {
                            String res = responseBody.string().replaceAll("\\n", "");
                            JSONObject obj = new JSONObject(res);
                            List<League> list = GsonUtil.jsonToArrayList(obj.optJSONObject("result")
                                    .optJSONArray("leagues").toString(), League.class);
                            Log.d("yeluo", list.get(0).getDescription());
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

        EasyDota.getInstance().getSteamService().getMatchHistroy(KEY, null, null, null, null, ACCOUNT_ID, null, null, null)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody s) {
                        Log.d("yeluo", s.getClass().getName());
                        try {
                            String res = s.string().replaceAll("\\n", "");
                            mTextView.setText(res);

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
                        Log.d("yeluo", s.getClass().getName());
                        try {
                            String res = s.string().replaceAll("\\n", "");
                            mTextView.setText(res);
                            Log.d("yeluo", res);

//                            JSONObject object = new JSONObject(res);
//                            JSONArray matches = object.optJSONObject("result").optJSONArray("matches");
//                            Gson gson = new Gson();
//                            Match match = gson.fromJson(matches.optJSONObject(1).toString(), Match.class);
//                            List<Match.PlayersBean> players = match.getPlayers();
//                            for(Match.PlayersBean player : players){
//                                Log.d("yeluo", player.getAccountId()+"-"+ Util.convertToSteam64Id(player.getAccountId()+""));
//                            }
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
                        Log.d("yeluo", "complete");
                    }
                });
    }

//    https://steamcommunity.com/dev
//    https://wiki.teamfortress.com/wiki/WebAPI/GetLeagueListing
//    http://steamwebapi.azurewebsites.net/
//    http://dota2api.readthedocs.io/en/latest/responses.html#get-league-listing
}
