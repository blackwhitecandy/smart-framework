package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;

import java.util.Map;

/**
 * @Auther glz
 * @Date 2019-11-17 下午5:00
 * @Description request parameter entity
 */
public final class Param {
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public String getString(String name){
        return CastUtil.castString(paramMap.get(name));
    }

    public Long getLong(String name){
        return CastUtil.castLong(paramMap.get(name));
    }

    public int getInt(String name){
        return CastUtil.castInt(paramMap.get(name));
    }

    public boolean getBoolean(String name){
        return CastUtil.castBoolean(paramMap.get(name));
    }

    public double getDouble(String name) {
        return CastUtil.castDouble(paramMap.get(name));
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }
}
