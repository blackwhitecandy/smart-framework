package org.smart4j.framework.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Auther glz
 * @Date 2019-11-19 下午10:59
 * @Description
 */
public  final class CodeUtil {
    public static String EncodeURL (String source) {
        String target  = "";
        try {
            target = URLEncoder.encode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return target;
    }

    public static String decodeURL (String source) {
        String target = "";
        try {
            target = URLDecoder.decode(source, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return target;
    }
}
