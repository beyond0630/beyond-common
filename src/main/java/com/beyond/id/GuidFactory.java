package com.beyond.id;

import org.apache.commons.codec.binary.Hex;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * GUID 主键自动生成策略
 *
 * @author wuxuan@jqzms.com
 * @since 2022-06-01
 */
public class GuidFactory implements IdFactory<String> {

    private static final long JAN_FIRST_2020 = 1577836800000000L; // 2020-01-01 in microseconds since epoch

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static final int BYTES_OF_LONG = 8;


    /**
     * 时间种子
     */
    private final long seed;

    /**
     * 开始时间
     */
    private final long startTime;

    public GuidFactory() {
        this.seed = getSeqGuidSeed();
        this.startTime = System.nanoTime() / 10000;
    }

    public String generate() {

        byte[] randomBytes = new byte[10];

        SECURE_RANDOM.nextBytes(randomBytes);

        long nowTime = System.nanoTime() / 10000;

        // 10us
        long diff = nowTime - startTime;
        long ts = seed + diff;

        byte[] bytes = getBytes(ts);

        return Hex.encodeHexString(Arrays.copyOfRange(randomBytes, 0, 4), false) +
            "-" +
            Hex.encodeHexString(Arrays.copyOfRange(randomBytes, 4, 6), false) +
            "-" +
            Hex.encodeHexString(Arrays.copyOfRange(randomBytes, 6, 8), false) +
            "-" +
            Hex.encodeHexString(Arrays.copyOfRange(randomBytes, 8, 10), false) +
            "-" +
            Hex.encodeHexString(Arrays.copyOfRange(bytes, 2, 8), false);
    }

    /**
     * 根据长整型获取 byte 数组, 大端序(BE)
     *
     * @param value 长整型
     * @return byte[]
     */
    public static byte[] getBytes(long value) {
        byte[] buffer = new byte[BYTES_OF_LONG];
        buffer[0] = (byte) ((value >> 56) & 0xff);
        buffer[1] = (byte) ((value >> 48) & 0xff);
        buffer[2] = (byte) ((value >> 40) & 0xff);
        buffer[3] = (byte) ((value >> 32) & 0xff);
        buffer[4] = (byte) ((value >> 24) & 0xff);
        buffer[5] = (byte) ((value >> 16) & 0xff);
        buffer[6] = (byte) ((value >> 8) & 0xff);
        buffer[7] = (byte) (value & 0xff);
        return buffer;
    }

    private long getSeqGuidSeed() {
        long nowMicros = System.nanoTime() / 10000; // Convert to microseconds
        return nowMicros - JAN_FIRST_2020;
    }

}
