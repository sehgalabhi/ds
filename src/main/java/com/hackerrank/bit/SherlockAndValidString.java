package com.hackerrank.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SherlockAndValidString {

    public static void main(String[] args) {
        new SherlockAndValidString().test("abcc");
    }

    private void test(String input) {

        Map<String, Long> collect = Arrays.stream(input.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        Map<Long, List<String>> reverse = new HashMap<>();

        collect.forEach((k,v) -> {
            if(reverse.get(v) != null){
                reverse.get(v).add(k);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(k);
                reverse.put(v, temp);
            }
        });

        System.out.println(reverse);




    }
}
