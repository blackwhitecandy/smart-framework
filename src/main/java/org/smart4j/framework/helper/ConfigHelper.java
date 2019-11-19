package org.smart4j.framework.helper;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;

import java.util.Properties;

/**
 * @Author: glz
 * @Description:
 * @Date: Create in 10:58 2019/11/8
 */
public final class ConfigHelper {
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * get jdbc driver
     * @return
     */
    public static String getJDBCDriver () {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * get jdbc class
     * @return
     */
    public static String getJDBCUrl () {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * get jdbc username
     * @return
     */
    public static String getJDBCUsername () {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }


    /**
     * get jdbc password
     * @return
     */
    public static String getJDBCPassword () {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * get app base package
     * @return
     */
    public static String getAppBasePackage () {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.BASIC_PACKAGE);
    }


    /**
     * get app jsp package
     * @return
     */
    public static String getAppJspPackage () {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JSP_PATH, "/WEB-INFO/view/");
    }



    /**
     * get app static resources package
     * @return
     */
    public static String getAppStaticPackage () {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.STATIC_PATH, "/static/");
    }
}
