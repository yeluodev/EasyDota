package com.yeluodev.easydota.entity.openapi;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/23 0:24
 * 修改人  yeluodev1226
 * 修改时间 2018/1/23 0:24
 * 备注
 */
public class RecentMatches {

    /**
     * match_id : 3581880685
     * player_slot : 128
     * radiant_win : true
     * duration : 2118
     * game_mode : 3
     * lobby_type : 7
     * hero_id : 71
     * start_time : 1511621698
     * version : null
     * kills : 3
     * deaths : 12
     * assists : 14
     * skill : null
     * xp_per_min : 239
     * gold_per_min : 209
     * hero_damage : 11566
     * tower_damage : 0
     * hero_healing : 0
     * last_hits : 18
     * lane : null
     * lane_role : null
     * is_roaming : null
     * cluster : 224
     * leaver_status : 0
     * party_size : null
     */

    private long match_id;
    private int player_slot;
    private boolean radiant_win;
    private int duration;
    private int game_mode;
    private int lobby_type;
    private int hero_id;
    private int start_time;
    private Object version;
    private int kills;
    private int deaths;
    private int assists;
    private Object skill;
    private int xp_per_min;
    private int gold_per_min;
    private int hero_damage;
    private int tower_damage;
    private int hero_healing;
    private int last_hits;
    private Object lane;
    private Object lane_role;
    private Object is_roaming;
    private int cluster;
    private int leaver_status;
    private Object party_size;

    public long getMatch_id() {
        return match_id;
    }

    public void setMatch_id(long match_id) {
        this.match_id = match_id;
    }

    public int getPlayer_slot() {
        return player_slot;
    }

    public void setPlayer_slot(int player_slot) {
        this.player_slot = player_slot;
    }

    public boolean isRadiant_win() {
        return radiant_win;
    }

    public void setRadiant_win(boolean radiant_win) {
        this.radiant_win = radiant_win;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getGame_mode() {
        return game_mode;
    }

    public void setGame_mode(int game_mode) {
        this.game_mode = game_mode;
    }

    public int getLobby_type() {
        return lobby_type;
    }

    public void setLobby_type(int lobby_type) {
        this.lobby_type = lobby_type;
    }

    public int getHero_id() {
        return hero_id;
    }

    public void setHero_id(int hero_id) {
        this.hero_id = hero_id;
    }

    public int getStart_time() {
        return start_time;
    }

    public void setStart_time(int start_time) {
        this.start_time = start_time;
    }

    public Object getVersion() {
        return version;
    }

    public void setVersion(Object version) {
        this.version = version;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public Object getSkill() {
        return skill;
    }

    public void setSkill(Object skill) {
        this.skill = skill;
    }

    public int getXp_per_min() {
        return xp_per_min;
    }

    public void setXp_per_min(int xp_per_min) {
        this.xp_per_min = xp_per_min;
    }

    public int getGold_per_min() {
        return gold_per_min;
    }

    public void setGold_per_min(int gold_per_min) {
        this.gold_per_min = gold_per_min;
    }

    public int getHero_damage() {
        return hero_damage;
    }

    public void setHero_damage(int hero_damage) {
        this.hero_damage = hero_damage;
    }

    public int getTower_damage() {
        return tower_damage;
    }

    public void setTower_damage(int tower_damage) {
        this.tower_damage = tower_damage;
    }

    public int getHero_healing() {
        return hero_healing;
    }

    public void setHero_healing(int hero_healing) {
        this.hero_healing = hero_healing;
    }

    public int getLast_hits() {
        return last_hits;
    }

    public void setLast_hits(int last_hits) {
        this.last_hits = last_hits;
    }

    public Object getLane() {
        return lane;
    }

    public void setLane(Object lane) {
        this.lane = lane;
    }

    public Object getLane_role() {
        return lane_role;
    }

    public void setLane_role(Object lane_role) {
        this.lane_role = lane_role;
    }

    public Object getIs_roaming() {
        return is_roaming;
    }

    public void setIs_roaming(Object is_roaming) {
        this.is_roaming = is_roaming;
    }

    public int getCluster() {
        return cluster;
    }

    public void setCluster(int cluster) {
        this.cluster = cluster;
    }

    public int getLeaver_status() {
        return leaver_status;
    }

    public void setLeaver_status(int leaver_status) {
        this.leaver_status = leaver_status;
    }

    public Object getParty_size() {
        return party_size;
    }

    public void setParty_size(Object party_size) {
        this.party_size = party_size;
    }
}
