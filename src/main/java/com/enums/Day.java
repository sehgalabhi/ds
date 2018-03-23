package com.enums;

import java.util.Arrays;

public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY
}


class DayTest {
    public static void main(String[] args) {
        new DayTest().test();
    }

    private void test() {
        Day day = Day.MONDAY;
        Day day1 = Day.FRIDAY;
        Day default1 = Day.THURSDAY;
        tellItLike(day);
        tellItLike(day1);
        tellItLike(default1);

        Arrays.stream(Day.values()).forEach(System.out::println);

        System.out.println(Day.THURSDAY);
        System.out.println(Day.THURSDAY.ordinal());
        System.out.println(String.valueOf(Day.THURSDAY.ordinal()));

        Day thursday = Day.valueOf("THURSDAY");
        System.out.println(thursday);


    }

    void tellItLike(Day day) {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays");
                break;
            case FRIDAY:
                System.out.println("Fridays");
                break;
            default:
                System.out.println("Default");
        }
    }
}