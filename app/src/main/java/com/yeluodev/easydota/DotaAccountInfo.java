package com.yeluodev.easydota;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/20 16:54
 * 修改人  yeluodev1226
 * 修改时间 2018/1/20 16:54
 * 备注
 */
public class DotaAccountInfo {
    private String name;
    private String avatarUrl;
    private int mmr;
    private int win;
    private int lose;
    private float kda;
    private float rank;
    private float winRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getMmr() {
        return mmr;
    }

    public void setMmr(int mmr) {
        this.mmr = mmr;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public float getKda() {
        return kda;
    }

    public void setKda(float kda) {
        this.kda = kda;
    }

    public float getRank() {
        return rank;
    }

    public void setRank(float rank) {
        this.rank = rank;
    }

    public float getWinRate() {
        return winRate;
    }

    public void setWinRate(float winRate) {
        this.winRate = winRate;
    }
}
