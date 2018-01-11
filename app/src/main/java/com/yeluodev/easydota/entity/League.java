package com.yeluodev.easydota.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/7 1:33
 * 修改人  yeluodev1226
 * 修改时间 2018/1/7 1:33
 * 备注
 */
public class League {

    private String name;
    @SerializedName("leagueid")
    private int leagueId;
    private String description;
    @SerializedName("tournament_url")
    private String tournamentUrl;
    private int itemdef;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTournamentUrl() {
        return tournamentUrl;
    }

    public void setTournamentUrl(String tournamentUrl) {
        this.tournamentUrl = tournamentUrl;
    }

    public int getItemdef() {
        return itemdef;
    }

    public void setItemdef(int itemdef) {
        this.itemdef = itemdef;
    }
}
