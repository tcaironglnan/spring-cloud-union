package com.cloud.docker.tools;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * json作为中间件转换工具类
 *
 * @author FaceFeel
 * @Created 2018-03-02 10:14
 **/
public class ToolJson {

    private static final Gson gson = new GsonBuilder().create();

    public static <T> T jsonToModel(String json, Class<T> target) {

        return gson.fromJson(json, target);
    }

    public static List jsonToList(String json, Class<List> target) {

        return gson.fromJson(json, target);
    }

    public static <T>Map modelToMap(T clzz){
        return jsonToMap(anyToJson(clzz));
    }

    /**
     * 将Map进行JSON编码
     *
     * @param json
     * @return
     */
    public static Map jsonToMap(String json) {
        if (json == null) {
            return Maps.newHashMapWithExpectedSize(1);
        }
        return gson.fromJson(json, new TypeToken<TreeMap<String, Object>>() {
        }.getType());
    }

    public static Map jsonToMap(String json, Class<Map> target) {

        return gson.fromJson(json, target);
    }

    public static <T> String anyToJson(T target) {

        return gson.toJson(target);
    }

    public static String listToJson(List list) {

        return gson.toJson(list);
    }

    public static String mapToJson(Map map) {

        return gson.toJson(map);
    }

    public static <T> String modelToJson(T target) {

        return gson.toJson(target);
    }
}
