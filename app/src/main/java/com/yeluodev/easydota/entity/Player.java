package com.yeluodev.easydota.entity;

import com.google.gson.annotations.SerializedName;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/13 20:12
 * 修改人  yeluodev1226
 * 修改时间 2018/1/13 20:12
 * 备注
 */
public class Player {

    @SerializedName("steamid")
    private String steamId;
    @SerializedName("communityvisibilitystate")
    private int communityVisibilityState;
    @SerializedName("profilestate")
    private int profileState;
    @SerializedName("personaname")
    private String personaName;
    @SerializedName("lastlogoff")
    private int lastLogOff;
    @SerializedName("commentpermission")
    private int commentPermission;
    @SerializedName("profileurl")
    private String profileUrl;
    private String avatar;
    @SerializedName("avatarmedium")
    private String avatarMedium;
    @SerializedName("avatarfull")
    private String avatarFull;
    @SerializedName("personastate")
    private int personaState;
    @SerializedName("primaryclanid")
    private String primaryClanId;
    @SerializedName("timecreated")
    private int timeCreated;
    @SerializedName("personastateflags")
    private int personaStateFlags;
    @SerializedName("loccountrycode")
    private String locCountryCode;
    @SerializedName("locstatecode")
    private String locStateCode;
    @SerializedName("loccityid")
    private int locCityId;

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public int getCommunityVisibilityState() {
        return communityVisibilityState;
    }

    public void setCommunityVisibilityState(int communityVisibilityState) {
        this.communityVisibilityState = communityVisibilityState;
    }

    public int getProfileState() {
        return profileState;
    }

    public void setProfileState(int profileState) {
        this.profileState = profileState;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }

    public int getLastLogOff() {
        return lastLogOff;
    }

    public void setLastLogOff(int lastLogOff) {
        this.lastLogOff = lastLogOff;
    }

    public int getCommentPermission() {
        return commentPermission;
    }

    public void setCommentPermission(int commentPermission) {
        this.commentPermission = commentPermission;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAvatarMedium() {
        return avatarMedium;
    }

    public void setAvatarMedium(String avatarMedium) {
        this.avatarMedium = avatarMedium;
    }

    public String getAvatarFull() {
        return avatarFull;
    }

    public void setAvatarFull(String avatarFull) {
        this.avatarFull = avatarFull;
    }

    public int getPersonaState() {
        return personaState;
    }

    public void setPersonaState(int personaState) {
        this.personaState = personaState;
    }

    public String getPrimaryClanId() {
        return primaryClanId;
    }

    public void setPrimaryClanId(String primaryClanId) {
        this.primaryClanId = primaryClanId;
    }

    public int getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(int timeCreated) {
        this.timeCreated = timeCreated;
    }

    public int getPersonaStateFlags() {
        return personaStateFlags;
    }

    public void setPersonaStateFlags(int personaStateFlags) {
        this.personaStateFlags = personaStateFlags;
    }

    public String getLocCountryCode() {
        return locCountryCode;
    }

    public void setLocCountryCode(String locCountryCode) {
        this.locCountryCode = locCountryCode;
    }

    public String getLocStateCode() {
        return locStateCode;
    }

    public void setLocStateCode(String locStateCode) {
        this.locStateCode = locStateCode;
    }

    public int getLocCityId() {
        return locCityId;
    }

    public void setLocCityId(int locCityId) {
        this.locCityId = locCityId;
    }
}
