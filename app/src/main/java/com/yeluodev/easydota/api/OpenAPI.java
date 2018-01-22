package com.yeluodev.easydota.api;

import com.yeluodev.easydota.entity.openapi.Player;
import com.yeluodev.easydota.entity.openapi.RecentMatches;
import com.yeluodev.easydota.entity.openapi.TotalFiled;
import com.yeluodev.easydota.entity.openapi.WinAndLose;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/20 16:21
 * 修改人  yeluodev1226
 * 修改时间 2018/1/20 16:21
 * 备注
 */
public interface OpenAPI {

    /**
     * 获取比赛详情
     * @param matchId
     * @return
     */
    @GET("matches/{match_id}")
    Observable<ResponseBody> getMatchDetails(
            @Path("match_id") String matchId
    );

    @GET("players/{account_id}")
    Observable<Player> getAccountInfos(
            @Path("account_id") String accountId
    );

    @GET("players/{account_id}/wl")
    Observable<WinAndLose> getAccountWinAndLose(
            @Path("account_id") String accountId
    );

    @GET("players/{account_id}/totals")
    Observable<List<TotalFiled>> getAccountTotals(
            @Path("account_id") String accountId
    );

    @GET("players/{account_id}/recentMatches")
    Observable<List<RecentMatches>> getRecentMatches(
            @Path("account_id") String accountId
    );
}
