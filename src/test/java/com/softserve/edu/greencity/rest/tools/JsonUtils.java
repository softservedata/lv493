package com.softserve.edu.greencity.rest.tools;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;

public class JsonUtils {
    private Gson gson;
    public JsonUtils() {
        gson = new Gson();
    }

    public String entityToJson(Object entity, Type type) {
        return gson.toJson(entity, type);
    }

    public String entityToJson(List<Object> entities, Type type) {
        return gson.toJson(entities, type);
    }
}
