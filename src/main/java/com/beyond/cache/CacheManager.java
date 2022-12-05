package com.beyond.cache;

import java.time.Duration;

/**
 * @author beyond
 * @since 2022/12/1
 */
public interface CacheManager {


    /**
     * 创建缓存
     * @param keyClz key class
     * @param valClz value class
     * @return Cache<K, V>
     * @param <K> key type
     * @param <V> value type
     */
    <K, V> Cache<K, V> createCache(Class<K> keyClz, Class<V> valClz);

    /**
     * 创建缓存
     * @param keyClz key class
     * @param valClz value class
     * @param capacity 容量
     * @param expiration 过期时长
     * @return Cache<K, V>
     * @param <K> key type
     * @param <V> value type
     */
    <K, V> Cache<K, V> createCache(Class<K> keyClz, Class<V> valClz, int capacity, Duration expiration);

    /**
     * 获取缓存
     * @param keyClz key class
     * @param valClz value class
     * @return Cache<K, V>
     * @param <K> key type
     * @param <V> value type
     */
    <K, V> Cache<K, V> getCache(Class<K> keyClz, Class<V> valClz);
}
