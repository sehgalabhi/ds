package com.enums;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapTest {

    public static void main(String[] args) throws Exception {
        new EnumMapTest().test();
    }

    private enum Importance {
        Low, Medium, High;
    }

    private void test() throws Exception {
        EnumMap<Importance, String> e = new EnumMap<Importance, String>(Importance.class);
        e.put(Importance.Low, "=Low");
        e.put(Importance.High, "=High");

        Map<Importance, String> h = new HashMap<>();
        h.put(Importance.Low, "=Low");
        h.put(Importance.High, "=High");

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < 10000000; i++) {
            if (!e.containsKey(Importance.Low)) {
                throw new Exception();
            }
        }

        long t2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            if (!h.containsKey(Importance.Low)) {
                throw new Exception();
            }
        }

        long t3 = System.currentTimeMillis();

        System.out.println(t2 - t1);
        System.out.println(t3 - t2);

    }
}
