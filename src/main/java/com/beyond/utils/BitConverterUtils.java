package com.beyond.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * @author beyond
 * @since 2022/12/1
 */
public class BitConverterUtils {


    public static byte[] longToBytes(long value) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.order(ByteOrder.nativeOrder());
        buffer.putLong(value);
        return buffer.array();
    }

    public static long bytesToLong(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.nativeOrder());
        return buffer.getLong();
    }
}
