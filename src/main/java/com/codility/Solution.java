package com.codility;

import java.util.Arrays;

public class Solution {

    public String solution(int[] T) {
        // write your code in Java SE 8
        int numElements = T.length;

        int numTemperaturesInSeason = numElements / 4;
        int maxAmplitude = Season.WINTER.getAmplitude(T, numTemperaturesInSeason);
        String seasonWithMaxApmplitude = Season.WINTER.getDesc();

        for (Season season :
                Season.values()) {
            if (season == Season.WINTER) {
                continue;
            }
            int amplitude = season.getAmplitude(T, numTemperaturesInSeason);
            if (amplitude > maxAmplitude) {
                seasonWithMaxApmplitude = season.getDesc();
                maxAmplitude = amplitude;
            }
        }
        return seasonWithMaxApmplitude;
    }

    private enum Season {
        WINTER("WINTER", 1) {
            @Override
            int getAmplitude(int[] T, int numTemperaturesInSeason) {
                return getSeasonAmplitude(T, numTemperaturesInSeason, getIndex());
            }
        },
        SPRING("SPRING", 2) {
            @Override
            int getAmplitude(int[] T, int numTemperaturesInSeason) {
                return getSeasonAmplitude(T, numTemperaturesInSeason, getIndex());
            }
        },
        SUMMER("SUMMER", 3) {
            @Override
            int getAmplitude(int[] T, int numTemperaturesInSeason) {
                return getSeasonAmplitude(T, numTemperaturesInSeason, getIndex());
            }
        },
        AUTUMN("AUTUMN", 4) {
            @Override
            int getAmplitude(int[] T, int numTemperaturesInSeason) {
                return getSeasonAmplitude(T, numTemperaturesInSeason, getIndex());
            }
        };

        private String desc;
        private int index;

        Season(String desc, int index) {
            this.desc = desc;
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public String getDesc() {
            return desc;
        }

        abstract int getAmplitude(int[] T, int numTemperaturesInSeason);

        private static int getSeasonAmplitude(int[] T, int numTemperaturesInSeason, int index) {
            int lowIndex = numTemperaturesInSeason *(index -1);

            int highIndex = numTemperaturesInSeason *(index);
            int[] temperatures = Arrays.copyOfRange(T, lowIndex, highIndex);
            Arrays.sort(temperatures);

            return Math.abs(temperatures[0] - temperatures[temperatures.length-1]);
        }
    }
}
