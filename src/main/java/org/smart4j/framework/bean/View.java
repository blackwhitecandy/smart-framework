package org.smart4j.framework.bean;

import java.util.Map;

/**
 * @Auther glz
 * @Date 2019-11-17 下午5:16
 * @Description
 */
public class View {
    /**
     * view path
     */
    private String path;

    /**
     * model data
     */
    private Map<String, Object> model;

    public View(String path, Map<String, Object> model) {
        this.path = path;
        this.model = model;
    }

    public View addModel (String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return this.path;
    }

    public Map<String, Object> getModel () {
        return this.model;
    }

}
