package com.yeluodev.easydota.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 * 作者   yeluodev1226
 * 创建时间 2018/1/7 1:39
 * 修改人  yeluodev1226
 * 修改时间 2018/1/7 1:39
 * 备注
 */
public class GsonUtil {

    public static <T> List<T> jsonToArrayList(String json, Class<T> clazz){
        List<T> list =new ArrayList<>();
        try {
            Gson gson = new Gson();
            JsonArray array = new JsonParser().parse(json).getAsJsonArray();
            for(JsonElement jsonElement : array){
                list.add(gson.fromJson(jsonElement,clazz));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
