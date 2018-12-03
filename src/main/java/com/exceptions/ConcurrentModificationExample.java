package com.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
        new ConcurrentModificationExample().test();
    }

    private void test() {
        List<String> myList = new ArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
            if(next.equals("3")) {
//                myList.remove("3");
            }
        }

        Map<String, String> map = new HashMap<>();
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        Iterator<String> iterator1 = map.keySet().iterator();
        while (iterator1.hasNext()){
            String next = iterator1.next();
            System.out.println(map.get(next));
            if(next.equals("2")) {
                map.put("1", "4");
//                map.put("4", "4");
            }
        }

    }
}
