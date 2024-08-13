package com.beyond.id;

import java.io.Serializable;

/**
 * @author beyond
 * @since 2022/12/2
 */
public interface IdFactory<T extends Serializable > {

    /**
     * 生成 Id
     *
     * @return long
     */
    T generate();
}
