package org.smart4j.framework.util;

import java.io.*;

/**
 * @Auther glz
 * @Date 2019-11-17 下午11:27
 * @Description
 */
public class StreamUtil {
    public static String getString(InputStream is) {
        StringBuilder stringBuilder =  new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
