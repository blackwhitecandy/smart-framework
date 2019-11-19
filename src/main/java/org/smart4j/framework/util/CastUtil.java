package org.smart4j.framework.util;

public final class CastUtil {
    /**
     * cast to string from object default value ""
     * @param o
     * @return
     */
    public static String castString(Object o) {
        return CastUtil.castString(o, "");
    }

    /**
     * cast to string from object (can set default value)
     * @param o
     * @param defaultValue
     * @return
     */
    public static String castString(Object o, String defaultValue) {
        return o == null ? defaultValue : String.valueOf(o);
    }


    /**
     * cast to int from String default value 0
     * @param o
     * @return
     */
    public static int castInt(Object o) {
        return CastUtil.castInt(o, 0);
    }

    /**
     * cast to int from string (can set default value)
     * @param o
     * @param defaultValue
     * @return
     */
    public static int castInt(Object o, int defaultValue) {
        int value = defaultValue;
        if (null != o) {
            String valueString = CastUtil.castString(o);
            if (!valueString.isEmpty()) {
                try {
                    value = Integer.parseInt(valueString);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    value = defaultValue;
                }
            }
        }
        return value;
    }

    /**
     * cast to double from object default value 0
     * @param o
     * @return
     */
    public static double castDouble(Object o) {
        return CastUtil.castDouble(o, 0);
    }

    /**
     * cast to double from object (can set default value)
     * @param o
     * @param defaultValue
     * @return
     */
    public static double castDouble(Object o, double defaultValue) {
        double  doubleValue = defaultValue;
        if (null != o) {
            String stringValue = CastUtil.castString(o);
            if (!stringValue.isEmpty()) {
                try {
                    doubleValue = Double.parseDouble(stringValue);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    /**
     * cast to long from object default value 0
     * @param o
     * @return
     */
    public static long castLong(Object o) {
        return CastUtil.castLong(o, 0);
    }

    /**
     * cast to long from object (can set default value)
     * @param o
     * @param defaultValue
     * @return
     */
    public static long castLong(Object o, long defaultValue) {
        long longValue = defaultValue;
        if (null != o) {
            String stringValue = CastUtil.castString(o);
            if (!stringValue.isEmpty()) {
                try {
                    longValue = Long.parseLong(stringValue);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    longValue = defaultValue;
                }
            }
        }
        return longValue;
    }

    /**
     * cast to boolean from object default value false
     * @param o
     * @return
     */
    public static boolean castBoolean(Object o) {
        return CastUtil.castBoolean(o, false);
    }

    /**
     * cast to boolean from object (can set default value)
     * @param o
     * @param defaultValue
     * @return
     */
    public static boolean castBoolean(Object o, boolean defaultValue) {
        boolean booleanValue = defaultValue;
        if (null != o) {
            String stringValue = CastUtil.castString(o);
            if (!stringValue.isEmpty()) {
                try {
                    booleanValue = Boolean.parseBoolean(stringValue);
                } catch (NumberFormatException e){
                    e.printStackTrace();
                    booleanValue = defaultValue;
                }
            }
        }
        return booleanValue;
    }
}
