package org.smart4j.framework.bean;

/**
 * @Auther glz
 * @Date 2019-11-17 下午5:21
 * @Description  response data entity
 */
public class Data {
    private Object model;

    public Data(Object model) {
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}
