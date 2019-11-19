package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * @Auther glz
 * @Date 2019-11-17 上午9:13
 * @Description
 */
public class Handler {
    /**
     * Controller class
     */
    private Class<?> ControllerClass;
    /**
     * Action method
     */
    private Method ActionMethod;


    public Handler(Class<?> controllerClass, Method actionMethod) {
        ControllerClass = controllerClass;
        ActionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return ControllerClass;
    }

    public Method getActionMethod() {
        return ActionMethod;
    }
}
