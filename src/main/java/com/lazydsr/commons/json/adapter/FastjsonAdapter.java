package com.lazydsr.commons.json.adapter;



import com.alibaba.fastjson.JSON;
import com.lazydsr.commons.exception.JsonParseException;

import java.lang.reflect.Type;

/**
 * Fastjson 适配器
 *
 * @author : daisenrong
 */
public class FastjsonAdapter implements JsonAdapter {

    @Override
    public String writeValueAsString(Object obj) {
        try {
            return JSON.toJSONString(obj);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public <T> T readValue(String json, Type type) {
        try {
            return JSON.parseObject(json, type);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}
