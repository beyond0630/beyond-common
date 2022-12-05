package com.beyond.cache;

import java.time.Duration;

/**
 * @author beyond
 * @since 2022/12/1
 */
public interface CacheOptions {

    /**
     * 最大容量
     * @return int
     */
    int getMaxCapacity();

    /**
     * 过期时长
     * @return Duration
     */
    Duration getExpiration();
}
