package com.moon.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class JsonUtils {
    //序列化 : 对象->字符串
    public static String toJSON(Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    //反序列化 : 字符串->对象
    public static <T> T toObj(String json, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, clazz);
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    //反序列化 : 字符串->对象列表
    public static <T> List<T> toObjList(String json, Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(json, new TypeReference<List<T>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //
}
