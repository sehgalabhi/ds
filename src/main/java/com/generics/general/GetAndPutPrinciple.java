package com.generics.general;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by asehgal on 5/11/2017.
 */
public class GetAndPutPrinciple {

    public static void main(String[] args) {
/*
        GetAndPutPrinciple getAndPutPrinciple = new GetAndPutPrinciple();
        getAndPutPrinciple.testExtends();
        getAndPutPrinciple.testSuper();
*/

        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        List<String> numbersSplit = Arrays.asList(numbers.split(""));
        List<String> lower_caseSplit = Arrays.asList(lower_case.split(""));
        List<String> upper_case_split = Arrays.asList(upper_case.split(""));
        List<String> special_characters_split = Arrays.asList(special_characters.split(""));

        String input = "#HackerRank";

        String[] split = input.split("");

        int numberN = 0, lowerN = 0, upperN = 0, specialN = 0;

        for (int i = 0; i < split.length; i++) {
            if (numbersSplit.contains(split[i])) {
                numberN++;
            }
            if (lower_caseSplit.contains(split[i])) {
                lowerN++;
            }
            if (upper_case_split.contains(split[i])) {
                upperN++;
            }
            if (special_characters_split.contains(split[i])) {
                specialN++;
            }
        }

        int countToSuggest = 0;
        if (numberN == 0) {
            countToSuggest++;
        }
        if (lowerN == 0) {
            countToSuggest++;
        }
        if (upperN == 0) {
            countToSuggest++;
        }
        if (specialN == 0) {
            countToSuggest++;
        }

        int remaining  = 6 -(split.length + countToSuggest);
        if(remaining >0 ){
            countToSuggest+= remaining;
        }

        System.out.println(countToSuggest);


    }

    private void testSuper() {
        List<Object> objs = new ArrayList<>();
        objs.add(1);
        objs.add(2);

        List<? super Integer> ints = objs;

        //only get Object
        for (Object integer : ints) {
            System.out.println(integer.toString());
        }


        Utilities.count(ints, 5);
        //put principle
        //Utilities.sum(ints);
    }

    private void testExtends() {
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> nums = ints;

        Utilities.sum(nums);
        //get principle
        //nums.add(1);
        // only add null is allowed
        nums.add(null);
        System.out.println(nums.get(0));
    }

    public static <T extends String> T max(Collection<T> coll) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }

}
