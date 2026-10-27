package com.hackerrank;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        char val = 'a';


        val = test2.execute("111aAAAAAAabbbaacc");
        System.out.println(val);

        val = test2.execute("bbbaaacc");
        System.out.println(val);


        val = test2.execute("helloworld");
        System.out.println(val);

    }

    private char execute(String text) {
        String[] splittedText = text.split("");


        Map<String, Long> characterMap = Arrays.stream(splittedText)
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));

        Optional<String> maxOccurenceChar = Optional.empty();
        long maxOccurence = 0;
        Set<Map.Entry<String, Long>> entries = characterMap.entrySet();
        for(Map.Entry<String, Long> var: entries) {
            if(var.getValue() > maxOccurence) {
                maxOccurenceChar = Optional.of(var.getKey());
                maxOccurence = var.getValue();
            }

        }

        return maxOccurenceChar.get().charAt(0);


    }


}
