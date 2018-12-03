package com.hackerrank.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LuckBalance {

    public static void main(String[] args) {
        LuckBalance luckBalance = new LuckBalance();
        System.out.println(luckBalance.test(2, new int[][]{{5, 1}, {1, 1}, {4, 0}}));
        System.out.println(luckBalance.test(1, new int[][]{{5, 1}, {1, 1}, {4, 0}}));

    }

    private int test(int k, int[][] contests) {

        List<Integer> important = new ArrayList<>();
        List<Integer> notImportant = new ArrayList<>();

        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 1) {
                important.add(contests[i][0]);
            } else {
                notImportant.add(contests[i][0]);
            }

        }

        important.sort(Comparator.comparingInt(Integer::intValue));
        int size = important.size();
        int toReduce = size - k;

        int sumToAdd = important.stream().skip(toReduce).mapToInt(Integer::intValue).sum();
        int sumToreduce = important.stream().limit(toReduce).mapToInt(Integer::intValue).sum();
        int nonImp = notImportant.stream().mapToInt(Integer::intValue).sum();

       /* List<Temp> collect = Arrays.stream(contests).map(t -> new Temp(t[0], t[1])).collect(Collectors.toList());
        AtomicInteger atomicInteger = new AtomicInteger();
        Map<Integer, List<Temp>> collect1 = collect.stream().sorted(Comparator.comparingInt(Temp::getVal)).collect(Collectors.groupingBy(t -> t.getImportant()));
        collect1.keySet().stream().forEach(t -> {
            if (t == 0) {
                atomicInteger.getAndAdd(collect1.get(t).stream().mapToInt(y -> y.getVal()).sum());
            } else {
                int size = collect1.get(t).size();
                int toReduce = size - k;

                atomicInteger.getAndAdd(collect1.get(t).stream().skip(toReduce).mapToInt(y -> y.getVal()).sum());
                atomicInteger.getAndAdd(-1*(collect1.get(t).stream().limit(toReduce).mapToInt(y -> y.getVal()).sum()));
            }
        });*/


        return sumToAdd + nonImp - sumToreduce;


    }

    private static class Temp {
        private int val;
        private int important;

        public Temp(int val, int important) {
            this.val = val;
            this.important = important;
        }

        public int getVal() {
            return val;
        }

        public int getImportant() {
            return important;
        }
    }
}
