package com.hackerrank.practice;

import java.util.Arrays;

public class GridChallengeGreedy {

    public static void main(String[] args) {
        GridChallengeGreedy gridChallengeGreedy = new GridChallengeGreedy();
        /*System.out.println(gridChallengeGreedy.test(new String[]{"abc", "lmp", "qrt"}));
        System.out.println(gridChallengeGreedy.test(new String[]{"mpxz", "abcd", "wlmf"}));*/
        System.out.println(gridChallengeGreedy.test(new String[]{"abc", "hjk", "mpq", "rtv"}));
    }

    private String test(String[] grid) {
        String[][] temp = new String[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            String[] split = grid[i].split("");
            Arrays.sort(split);
            temp[i] = split;
        }

        int j = 0;
        int length = temp[0].length;
        boolean isOrdered = true;
        while (j < length) {

            for (int i = 0; i < grid.length - 1; i++) {
                if (temp[i + 1][j].compareTo(temp[i][j]) < 0) {
                    isOrdered = false;
                    break;
                }
            }
            if (!isOrdered) {
                break;
            }
            j++;
        }

        return isOrdered ? "YES" : "NO";
    }
}
