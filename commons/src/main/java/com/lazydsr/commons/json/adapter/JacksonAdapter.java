package com.lazydsr.commons.json.adapter;

import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.lazydsr.commons.exception.JsonParseException;

/**
 * Jackson 适配器
 *
 * @author : daisenrong
 */
public class JacksonAdapter implements JsonAdapter {

    private ObjectMapper objectMapper;
    
    public JacksonAdapter() {
        objectMapper = new ObjectMapper();
    }

    public JacksonAdapter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String writeValueAsString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }

    @Override
    public <T> T readValue(String json, Type type) {
        try {
            return objectMapper.readValue(json, TypeFactory.defaultInstance().constructType(type));
        } catch (Exception e) {
            throw new JsonParseException(e);
        }
    }
}
