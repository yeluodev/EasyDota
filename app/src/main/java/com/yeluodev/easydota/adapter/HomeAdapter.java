package com.yeluodev.easydota.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yeluodev.easydota.DotaAccountInfo;
import com.yeluodev.easydota.R;
import com.yeluodev.easydota.entity.Player;
import com.yeluodev.easydota.entity.openapi.RecentMatches;
import com.yeluodev.easydota.util.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/13 18:41
 * 修改人  yeluodev1226
 * 修改时间 2018/1/13 18:41
 * 备注
 */
public class HomeAdapter extends RecyclerView.Adapter {

    public static final String ITEM_ACCOUNT_INFO = "item_account_info";
    public static final String ITEM_TRADEMARK_HERO = "item_trademark_hero";
    public static final String ITEM_RECENT_GAMES = "item_recent_games";
    public static final String ITEM_MMR_KDA = "item_mmr_kda";
    public static final String ITEM_LEIDA = "item_leida";

    public static final int TYPE_ACCOUNT_INFO = 1;
    public static final int TYPE_TRADEMARK_HERO = 2;
    public static final int TYPE_RECENT_GAMES = 3;
    public static final int TYPE_MMR_KDA = 4;
    public static final int TYPE_LEIDA = 5;

    private Context mContext;
    private List mDataList = new ArrayList();
    private List<RecentMatches> mRecentMatchesList = new ArrayList<>();

    public HomeAdapter(Context context, Collection collection) {
        mContext = context;
        mDataList.addAll(collection);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        View view;
        switch (viewType) {
            case TYPE_ACCOUNT_INFO:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_home_account_info, parent, false);
                holder = new AccountInfoHolder(view);
                break;
            case TYPE_TRADEMARK_HERO:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_home_trademark_hero, parent, false);
                holder = new TrademarkHeroHolder(view);
                break;
            case TYPE_RECENT_GAMES:
                view = LayoutInflater.from(mContext).inflate(R.layout.item_home_recent_games, parent, false);
                holder = new RecentGamesHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPE_ACCOUNT_INFO:
                if (mDataList.get(position) instanceof Player
                        || mDataList.get(position) instanceof DotaAccountInfo) {
                    ((AccountInfoHolder) holder).bindData(mDataList.get(position));
                } else {
                    ((AccountInfoHolder) holder).bindData(null);
                }
                break;
            case TYPE_TRADEMARK_HERO:
                ((TrademarkHeroHolder) holder).bindData();
                break;
            case TYPE_RECENT_GAMES:
                ((RecentGamesHolder) holder).bindData(mRecentMatchesList);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Object obj = mDataList.get(position);
        if (obj instanceof String) {
            int type;
            switch ((String) obj) {
                case ITEM_ACCOUNT_INFO:
                    type = TYPE_ACCOUNT_INFO;
                    break;
                case ITEM_TRADEMARK_HERO:
                    type = TYPE_TRADEMARK_HERO;
                    break;
                case ITEM_RECENT_GAMES:
                    type = TYPE_RECENT_GAMES;
                    break;
                case ITEM_MMR_KDA:
                    type = TYPE_ACCOUNT_INFO;
                    break;
                case ITEM_LEIDA:
                    type = TYPE_ACCOUNT_INFO;
                    break;
                default:
                    type = super.getItemViewType(position);
            }
            return type;
        } else if (obj instanceof Player
                || obj instanceof DotaAccountInfo) {
            return TYPE_ACCOUNT_INFO;
        }

        return super.getItemViewType(position);
    }

    public void setDatas(Collection collection) {
        mDataList.clear();
        mDataList.addAll(collection);
    }

    public List<RecentMatches> getRecentMatchesList() {
        return mRecentMatchesList;
    }

    public void setRecentMatchesList(List<RecentMatches> recentMatchesList) {
        if(!Util.isEmpty(recentMatchesList)){
            mRecentMatchesList.clear();
            mRecentMatchesList.addAll(recentMatchesList);
        }
    }

    public class AccountInfoHolder extends RecyclerView.ViewHolder {

        CircleImageView avatarIV;
        TextView nameTV, rankTV, mmrTV, kdaTV, wrTV;

        public AccountInfoHolder(View itemView) {
            super(itemView);
            avatarIV = itemView.findViewById(R.id.iv_avatar);
            nameTV = itemView.findViewById(R.id.tv_nick);
            rankTV = itemView.findViewById(R.id.tv_rank);
            mmrTV = itemView.findViewById(R.id.tv_mmr);
            kdaTV = itemView.findViewById(R.id.tv_kda);
            wrTV = itemView.findViewById(R.id.tv_wr);
        }

        public void bindData(Object obj) {
            if (obj != null) {
                if (obj instanceof Player) {
                    Glide.with(mContext).load(((Player) obj).getAvatarFull()).into(avatarIV);
                    nameTV.setText(((Player) obj).getPersonaName());
                    rankTV.setText("Ranking:8%");
                    mmrTV.setText("4856");
                    kdaTV.setText("4.21");
                    wrTV.setText("58%");
                } else if (obj instanceof DotaAccountInfo) {
                    Glide.with(mContext).load(((DotaAccountInfo) obj).getAvatarUrl()).into(avatarIV);
                    nameTV.setText(((DotaAccountInfo) obj).getName());
                    rankTV.setText("Ranking:8%");
                    mmrTV.setText(((DotaAccountInfo) obj).getMmr() + "");
                    kdaTV.setText(((DotaAccountInfo) obj).getKda() + "");
                    wrTV.setText(((DotaAccountInfo) obj).getWinRate() + "");
                }
            } else {
                avatarIV.setImageResource(R.color.cardview_dark_background);
                nameTV.setText("NaN");
                rankTV.setText("Ranking:NaN%");
                mmrTV.setText("NaN");
                kdaTV.setText("NaN");
                wrTV.setText("NaN%");
            }
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/Anton-Regular.ttf");
            rankTV.setTypeface(typeface);
            mmrTV.setTypeface(typeface);
            kdaTV.setTypeface(typeface);
            wrTV.setTypeface(typeface);
        }
    }

    public class TrademarkHeroHolder extends RecyclerView.ViewHolder {

        ImageView heroIV;
        TextView titleTV, heronameTV, mpTV, wrTV, kdaTV, mmrTV;

        public TrademarkHeroHolder(View itemView) {
            super(itemView);
            heroIV = itemView.findViewById(R.id.iv_hero);
            titleTV = itemView.findViewById(R.id.tv_title);
            heronameTV = itemView.findViewById(R.id.tv_hero_name);
            mpTV = itemView.findViewById(R.id.tv_mp);
            mmrTV = itemView.findViewById(R.id.tv_mmr);
            kdaTV = itemView.findViewById(R.id.tv_kda);
            wrTV = itemView.findViewById(R.id.tv_wr);
        }

        public void bindData() {
            Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515939090901&di=0efb6b410bb57da8e5529ecd109fc8f2&imgtype=0&src=http%3A%2F%2Fimg.sgamer.com%2Fdota2_sgamer_com%2Fimages%2F20130319%2F5e311f0a974e05abea40a4579dbb7f6f.jpg").into(heroIV);
            titleTV.setText("TRADEMARK HERO");
            heronameTV.setText("Templar Assassin");
            mpTV.setText("394");
            mmrTV.setText("4856");
            kdaTV.setText("7.14");
            wrTV.setText("81.3%");
            Typeface typeface = Typeface.createFromAsset(mContext.getAssets(), "fonts/Anton-Regular.ttf");
            heronameTV.setTypeface(typeface);
            mpTV.setTypeface(typeface);
            mmrTV.setTypeface(typeface);
            kdaTV.setTypeface(typeface);
            wrTV.setTypeface(typeface);
        }
    }

    public class RecentGamesHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView titleTV;
        InnerAdapter adapter;

        public RecentGamesHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.rv_recent_games);
            titleTV = itemView.findViewById(R.id.tv_title);
            titleTV.setText("RECENT GAMES");
            recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
            adapter = new InnerAdapter();
            recyclerView.setAdapter(adapter);
        }

        public void bindData(List<RecentMatches> recentMatches) {
            if(!Util.isEmpty(recentMatches)){
                adapter.setDatas(recentMatches);
            }
        }
    }

    private class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.ItemHolder>{
        List<RecentMatches> innerDataList = new ArrayList<>();

        @Override
        public InnerAdapter.ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_recent_games, parent, false);
            return new ItemHolder(view);
        }

        @Override
        public void onBindViewHolder(InnerAdapter.ItemHolder holder, int position) {
            holder.bindData(innerDataList.get(position));
        }

        @Override
        public int getItemCount() {
            return innerDataList.size()>5?5:innerDataList.size();
        }

        public void setDatas(List<RecentMatches> list){
            innerDataList.clear();
            innerDataList.addAll(list);
            notifyDataSetChanged();
        }

        public class ItemHolder extends RecyclerView.ViewHolder{
            CircleImageView avatarCIV;
            TextView resultTV,levelTV,endtimeTV,gamemodeTV,kdaTV,kdaNumberTV;

            public ItemHolder(View itemView) {
                super(itemView);
                avatarCIV = itemView.findViewById(R.id.iv_avatar);
                resultTV = itemView.findViewById(R.id.tv_result);
                levelTV = itemView.findViewById(R.id.tv_level);
                endtimeTV = itemView.findViewById(R.id.tv_endtime);
                gamemodeTV = itemView.findViewById(R.id.tv_gamemode);
                kdaTV = itemView.findViewById(R.id.tv_kda);
                kdaNumberTV = itemView.findViewById(R.id.tv_kda_number);
            }

            public void bindData(RecentMatches recentMatch){
                Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1515939090901&di=0efb6b410bb57da8e5529ecd109fc8f2&imgtype=0&src=http%3A%2F%2Fimg.sgamer.com%2Fdota2_sgamer_com%2Fimages%2F20130319%2F5e311f0a974e05abea40a4579dbb7f6f.jpg").into(avatarCIV);
                resultTV.setText(recentMatch.isRadiant_win()?"天辉胜利":"夜魇胜利");
                levelTV.setText("未知");
                endtimeTV.setText(recentMatch.getStart_time()+"");
                gamemodeTV.setText(recentMatch.getGame_mode()+"");
                kdaTV.setText("7.14");
                StringBuffer sb = new StringBuffer();
                sb.append(recentMatch.getKills());
                sb.append("/");
                sb.append(recentMatch.getDeaths());
                sb.append("/");
                sb.append(recentMatch.getAssists());
                kdaNumberTV.setText(sb.toString());
            }
        }
    }

}
