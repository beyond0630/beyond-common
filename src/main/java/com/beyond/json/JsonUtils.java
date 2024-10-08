package com.beyond.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;

public final class JsonUtils {

    private JsonUtils() {
        throw new UnsupportedOperationException();
    }

    private static ObjectMapper getObjectMapper() {
        return StandardObjectMapper.getInstance();
    }

    private static ObjectMapper getCondensedObjectMapper() {
        return CondensedObjectMapper.getInstance();
    }

    public static String serialize(final Object value) {
        try {
            return getObjectMapper().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String condensedSerialize(final Object value) {
        try {
            return getObjectMapper().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] serializeAsBytes(final Object value) {
        try {
            return getObjectMapper().writeValueAsBytes(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] condensedSerializeAsBytes(final Object value) {
        try {
            return getObjectMapper().writeValueAsBytes(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(final String json, final Class<T> clazz) {
        try {
            return getObjectMapper().readValue(json, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(final String json, final TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(json, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(final byte[] data, final Class<T> clazz) {
        try {
            return getObjectMapper().readValue(data, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(final byte[] data, final TypeReference<T> typeReference) {
        try {
            return getObjectMapper().readValue(data, typeReference);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T deserialize(final Reader reader, final Class<T> clazz) {
        try {
            return getObjectMapper().readValue(reader, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
