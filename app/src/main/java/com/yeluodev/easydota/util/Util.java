package com.yeluodev.easydota.util;

import org.json.JSONArray;

import java.util.Collection;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/7 2:08
 * 修改人  yeluodev1226
 * 修改时间 2018/1/7 2:08
 * 备注
 */
public class Util {

    /**
     * 将指定id转换为steam64位id
     *
     * @param id
     * @return
     */
    public static String convertToSteam64Id(String id) {
        long accountId;
        if (id.toString().length() == 17) {
            accountId = Long.parseLong(id.substring(3)) - 61197960265728L;
            return accountId + "";
        } else {
            accountId = Long.parseLong(id) + 61197960265728L;
            return "765" + accountId;
        }
    }

    public static boolean isEmpty(JSONArray array) {
        if (array == null || array.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Collection collection) {
        if (collection == null || collection.size() == 0) {
            return true;
        }
        return false;
    }
}
