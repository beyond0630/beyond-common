package com.beyond.id;

import java.nio.ByteOrder;

/**
 * @author beyond
 * @since 2022/12/1
 */
public class TestId {

    public static void main(String[] args) {
        System.out.println(ByteOrder.nativeOrder());
        IdFactory<String> idFactory = new GuidFactory();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            final String ID = idFactory.generate();
            System.out.println(ID);
            str.append(String.format("('%s'),", ID));
        }
        System.out.println(str.toString());
    }
}
