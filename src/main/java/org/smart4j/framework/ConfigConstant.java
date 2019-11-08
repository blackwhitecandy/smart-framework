package org.smart4j.framework;

/**
 * @Author: glz
 * @Description: 提供相关配置项常量
 * @Date: Create in 10:52 2019/11/8
 */
public interface ConfigConstant {
    String CONFIG_FILE = "smart.properties";

    String JDBC_DRIVER = "smart.framework.jdbc.driver";
    String JDBC_CLASS = "smart.framework.jdbc.class";
    String JDBC_USERNAME = "smart.framework.jdbc.username";
    String JDBC_PASSWORD = "smart.framework.jdbc.password";

    String BASIC_PACKAGE = "smart.framework.app.basic_package";
    String JSP_PATH = "smart.framework.app.jsp_path";
    String STATIC_PATH = "smart.framework.app.static_path";
}
