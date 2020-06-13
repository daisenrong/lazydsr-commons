package com.lazydsr.commons.json.adapter;

import com.lazydsr.commons.exception.JsonParseException;

import java.lang.reflect.Type;


/**
 * Json 类库适配器
 *
 * @author : daisenrong
 */
public interface JsonAdapter {

    /**
     * 转化 java 对象为 json 字符串
     *
     * @param obj java 对象
     * @return json 字符串
     * @throws JsonParseException 转化异常
     */
    String writeValueAsString(Object obj) throws JsonParseException;

    /**
     * 转化 json 字符串为 java 对象
     *
     * @param json json 字符串
     * @param type java 对象的类型
     * @param <T> 输出 java 对象的范性
     * @return java 对象
     * @throws JsonParseException 转化异常
     */
    <T> T readValue(String json, Type type) throws JsonParseException;
}
