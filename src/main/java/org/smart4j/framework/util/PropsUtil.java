package org.smart4j.framework.util;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties util class
 */
public final class PropsUtil {
    public static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * load properties file
     * @param fileName
     * @return
     */
    public static Properties loadProps(String fileName) {
        Properties properties = null;
        InputStream is = null;
        try {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if (is == null) {
                throw new FileNotFoundException(fileName + " file is not found");
            }
            properties = new Properties();
            properties.load(is);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("load properties file failure", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    LOGGER.error("input stream close failure", e);
                }
            }
        }
        return properties;
    }

    /**
     * get String value from properties( default blank )
     * @param properties
     * @param key
     * @return
     */
    public static String getString (Properties properties, String key) {
        return getString(properties, key, "");
    }

    /**
     * get string value from properties also can set default value if the key is not exist
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getString(Properties properties, String key, String defaultValue) {
        String value = defaultValue;
        if (properties != null && properties.containsKey(key)) {
            value =  properties.getProperty(key);
        }
        return value;
    }


    /**
     * get int value from properties( default 0 )
     * @param properties
     * @param key
     * @return
     */
    public static int getInt (Properties properties, String key) {
        return getInt(properties, key, 0);
    }

    /**
     * get int value from properties also can set default value if the key is not exist
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static int getInt(Properties properties, String key, int defaultValue) {
        int value = defaultValue;
        if (properties != null && properties.containsKey(key)) {
            value =  CastUtil.castInt(properties.getProperty(key));
        }
        return value;
    }



    /**
     * get boolean value from properties( default false )
     * @param properties
     * @param key
     * @return
     */
    public static Boolean getBoolean (Properties properties, String key) {
        return getBoolean(properties, key, false);
    }

    /**
     * get boolean value from properties also can set default value if the key is not exist
     * @param properties
     * @param key
     * @param defaultValue
     * @return
     */
    public static Boolean getBoolean(Properties properties, String key, Boolean defaultValue) {
        Boolean value = defaultValue;
        if (properties != null && properties.containsKey(key)) {
            value = CastUtil.castBoolean(properties.getProperty(key));
        }
        return value;
    }

}
