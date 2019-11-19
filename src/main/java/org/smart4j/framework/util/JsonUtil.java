package org.smart4j.framework.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther glz
 * @Date 2019-11-19 下午11:04
 * @Description json util class
 */
public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * transfer POJO to JSON
     * @param object
     * @param <T>
     * @return
     */
    public static <T> String toJson (T object) {
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOGGER.error("convert object to json failure", e);
            throw new RuntimeException();
        }
        return json;
    }

    public static <T> T toObjectFromJson (String json, Class<T> type) {
        T pojo = null;
        try {
            pojo = OBJECT_MAPPER.readValue(json, type);
        } catch (Exception e) {
            LOGGER.error("convert json to pojo failure", e);
            throw new RuntimeException();
        }
        return pojo;
    }
}
