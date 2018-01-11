package com.yeluodev.easydota.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/6 12:02
 * 修改人  yeluodev1226
 * 修改时间 2018/1/6 12:02
 * 备注
 */
public class Match {

    @SerializedName("match_id")
    private long matchId;
    @SerializedName("match_seq_num")
    private long matchSeqNum;
    @SerializedName("start_time")
    private long startTime;
    @SerializedName("lobby_type")
    private int lobbyType;
    @SerializedName("radiant_team_id")
    private int radiantTeamId;
    @SerializedName("dire_team_id")
    private int direTeamId;
    private List<PlayersBean> players;

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public long getMatchSeqNum() {
        return matchSeqNum;
    }

    public void setMatchSeqNum(long matchSeqNum) {
        this.matchSeqNum = matchSeqNum;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getLobbyType() {
        return lobbyType;
    }

    public void setLobbyType(int lobbyType) {
        this.lobbyType = lobbyType;
    }

    public int getRadiantTeamId() {
        return radiantTeamId;
    }

    public void setRadiantTeamId(int radiantTeamId) {
        this.radiantTeamId = radiantTeamId;
    }

    public int getDireTeamId() {
        return direTeamId;
    }

    public void setDireTeamId(int direTeamId) {
        this.direTeamId = direTeamId;
    }

    public List<PlayersBean> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayersBean> players) {
        this.players = players;
    }

    public static class PlayersBean {

        @SerializedName("account_id")
        private long accountId;
        @SerializedName("player_slot")
        private int playerSlot;
        @SerializedName("hero_id")
        private int heroId;

        public long getAccountId() {
            return accountId;
        }

        public void setAccountId(long accountId) {
            this.accountId = accountId;
        }

        public int getPlayerSlot() {
            return playerSlot;
        }

        public void setPlayerSlot(int playerSlot) {
            this.playerSlot = playerSlot;
        }

        public int getHeroId() {
            return heroId;
        }

        public void setHeroId(int heroId) {
            this.heroId = heroId;
        }
    }
}
