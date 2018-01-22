package com.yeluodev.easydota.entity.openapi;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/20 16:47
 * 修改人  yeluodev1226
 * 修改时间 2018/1/20 16:47
 * 备注
 */
public class Player {

    /**
     * tracked_until : null
     * solo_competitive_rank : null
     * competitive_rank : null
     * rank_tier : null
     * leaderboard_rank : null
     * profile : {"account_id":109926499,"personaname":"....","name":null,"cheese":0,"steamid":"76561198070192227","avatar":"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/7d/7d517a6846d31a43ed19923751197700809116ba.jpg","avatarmedium":"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/7d/7d517a6846d31a43ed19923751197700809116ba_medium.jpg","avatarfull":"https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/7d/7d517a6846d31a43ed19923751197700809116ba_full.jpg","profileurl":"http://steamcommunity.com/profiles/76561198070192227/","last_login":null,"loccountrycode":"CN"}
     * mmr_estimate : {"estimate":3137}
     */

    private Object tracked_until;
    private Object solo_competitive_rank;
    private Object competitive_rank;
    private Object rank_tier;
    private Object leaderboard_rank;
    private ProfileBean profile;
    private MmrEstimateBean mmr_estimate;

    public Object getTracked_until() {
        return tracked_until;
    }

    public void setTracked_until(Object tracked_until) {
        this.tracked_until = tracked_until;
    }

    public Object getSolo_competitive_rank() {
        return solo_competitive_rank;
    }

    public void setSolo_competitive_rank(Object solo_competitive_rank) {
        this.solo_competitive_rank = solo_competitive_rank;
    }

    public Object getCompetitive_rank() {
        return competitive_rank;
    }

    public void setCompetitive_rank(Object competitive_rank) {
        this.competitive_rank = competitive_rank;
    }

    public Object getRank_tier() {
        return rank_tier;
    }

    public void setRank_tier(Object rank_tier) {
        this.rank_tier = rank_tier;
    }

    public Object getLeaderboard_rank() {
        return leaderboard_rank;
    }

    public void setLeaderboard_rank(Object leaderboard_rank) {
        this.leaderboard_rank = leaderboard_rank;
    }

    public ProfileBean getProfile() {
        return profile;
    }

    public void setProfile(ProfileBean profile) {
        this.profile = profile;
    }

    public MmrEstimateBean getMmr_estimate() {
        return mmr_estimate;
    }

    public void setMmr_estimate(MmrEstimateBean mmr_estimate) {
        this.mmr_estimate = mmr_estimate;
    }

    public static class ProfileBean {
        /**
         * account_id : 109926499
         * personaname : ....
         * name : null
         * cheese : 0
         * steamid : 76561198070192227
         * avatar : https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/7d/7d517a6846d31a43ed19923751197700809116ba.jpg
         * avatarmedium : https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/7d/7d517a6846d31a43ed19923751197700809116ba_medium.jpg
         * avatarfull : https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/7d/7d517a6846d31a43ed19923751197700809116ba_full.jpg
         * profileurl : http://steamcommunity.com/profiles/76561198070192227/
         * last_login : null
         * loccountrycode : CN
         */

        private int account_id;
        private String personaname;
        private Object name;
        private int cheese;
        private String steamid;
        private String avatar;
        private String avatarmedium;
        private String avatarfull;
        private String profileurl;
        private Object last_login;
        private String loccountrycode;

        public int getAccount_id() {
            return account_id;
        }

        public void setAccount_id(int account_id) {
            this.account_id = account_id;
        }

        public String getPersonaname() {
            return personaname;
        }

        public void setPersonaname(String personaname) {
            this.personaname = personaname;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public int getCheese() {
            return cheese;
        }

        public void setCheese(int cheese) {
            this.cheese = cheese;
        }

        public String getSteamid() {
            return steamid;
        }

        public void setSteamid(String steamid) {
            this.steamid = steamid;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAvatarmedium() {
            return avatarmedium;
        }

        public void setAvatarmedium(String avatarmedium) {
            this.avatarmedium = avatarmedium;
        }

        public String getAvatarfull() {
            return avatarfull;
        }

        public void setAvatarfull(String avatarfull) {
            this.avatarfull = avatarfull;
        }

        public String getProfileurl() {
            return profileurl;
        }

        public void setProfileurl(String profileurl) {
            this.profileurl = profileurl;
        }

        public Object getLast_login() {
            return last_login;
        }

        public void setLast_login(Object last_login) {
            this.last_login = last_login;
        }

        public String getLoccountrycode() {
            return loccountrycode;
        }

        public void setLoccountrycode(String loccountrycode) {
            this.loccountrycode = loccountrycode;
        }
    }

    public static class MmrEstimateBean {
        /**
         * estimate : 3137
         */

        private int estimate;

        public int getEstimate() {
            return estimate;
        }

        public void setEstimate(int estimate) {
            this.estimate = estimate;
        }
    }
}
