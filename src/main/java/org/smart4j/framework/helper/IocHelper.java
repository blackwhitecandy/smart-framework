package org.smart4j.framework.helper;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * ioc controller
 */
public final class IocHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(IocHelper.class);

    static {
        Map<Class<?>, Object> beanClassMap = BeanHelper.getBeanMap();
        if (CollectionUtils.isNotEmpty((Collection<?>) beanClassMap)) {
            //loop bean map
            for(Map.Entry<Class<?>, Object> entry : beanClassMap.entrySet()) {
                Class<?> beanClass = entry.getKey();// get class
                Object  beanInstance = entry.getValue(); // get instance of class
                Field[] beanFields = beanClass.getDeclaredFields(); // get all declared fields
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanClassMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }



            }
        }
    }
}
