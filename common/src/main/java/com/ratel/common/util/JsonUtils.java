package com.ratel.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.ratel.common.exception.ServiceException;

import java.io.IOException;


/**
 * json util
 *
 * @author daiyun
 * @date 2020/8/19
 */
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final ObjectMapper NON_NULL_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private JsonUtils() {}

    public static String toJson(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ServiceException("json serialization error：" + obj, e);
        }
    }

    public static String toJsonNonNull(Object obj) {
        try {
            return NON_NULL_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new ServiceException("json serialization error：" + obj, e);
        }
    }

    public static <T> T fromJson(String jsonStr, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, type);
        } catch (IOException e) {
            throw new ServiceException("invalid json：" + jsonStr, e);
        }
    }

    public static <T> T fromJson(byte[] jsonBytes, Class<T> type) {
        try {
            return OBJECT_MAPPER.readValue(jsonBytes, type);
        } catch (IOException e) {
            throw new ServiceException("invalid json byte[]：" + new String(jsonBytes), e);
        }
    }

    public static <T> T fromJson(byte[] jsonBytes, TypeReference<T> type) {
        try {
            return OBJECT_MAPPER.readValue(jsonBytes, type);
        } catch (IOException e) {
            throw new ServiceException("invalid json byte[]：" + new String(jsonBytes), e);
        }
    }

    public static <T> T fromJson(String jsonStr, TypeReference<T> type) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, type);
        } catch (IOException e) {
            throw new ServiceException("invalid json：" + jsonStr, e);
        }
    }

    public static boolean isValidJson(String jsonStr) {
        try {
            OBJECT_MAPPER.readTree(jsonStr);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static JsonNode readTree(String jsonStr) {
        try {
            return OBJECT_MAPPER.readTree(jsonStr);
        } catch (IOException e) {
            throw new ServiceException("invalid json：" + jsonStr, e);
        }
    }

    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return OBJECT_MAPPER.convertValue(fromValue, toValueType);
    }

    public static <T> T convertValue(Object fromValue, TypeReference<?> toValueTypeRef) {
        return OBJECT_MAPPER.convertValue(fromValue, toValueTypeRef);
    }

    public static ObjectNode createNode() {
        return OBJECT_MAPPER.createObjectNode();
    }
}
