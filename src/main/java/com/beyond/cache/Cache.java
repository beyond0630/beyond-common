package com.beyond.cache;

import java.util.function.Supplier;

/**
 * @author beyond
 * @since 2022/12/1
 */
public interface Cache<K, V> {

    /**
     * 查找缓存
     */
    V get(K k);

    /**
     * 更新缓存
     */
    void put(K k, V v);

    /**
     * 删除缓存
     */
    V evict(K k);

    /**
     * 查找缓存，若不存在返回  defaultValue
     */
    V getOrDefault(K k, V defaultValue);

    /**
     * 查找缓存
     * @param k key
     * @param supplier supplier
     * @return V
     */
    V getIfAbsent(K k, Supplier<V> supplier);

    /**
     * 清除所有缓存
     */
    void clear();

}
