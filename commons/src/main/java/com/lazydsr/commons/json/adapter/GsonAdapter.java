package com.lazydsr.commons.json.adapter;


import com.google.gson.Gson;
import com.lazydsr.commons.exception.JsonParseException;

import java.lang.reflect.Type;

/**
 * gson 适配器
 *
 * @author : daisenrong
 */
public class GsonAdapter implements JsonAdapter {

    private Gson gson;

    public GsonAdapter() {
        this.gson = new Gson();
    }

    public GsonAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String writeValueAsString(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public <T> T readValue(String json, Type type) {
        try {
            return gson.fromJson(json, type);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}
