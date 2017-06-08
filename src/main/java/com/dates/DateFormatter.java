package com.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by asehgal on 6/2/2017.
 */
public class DateFormatter {
    public static void main(String[] args) throws ParseException {
        new DateFormatter().test();
    }

    private void test() throws ParseException {
        Date date1 = testInternal(1, 2, 20);
        Date date2 = testInternal(1, 11, 20);
        Date date3 = testInternal(21, 10, 20);
        Date date4 = testInternal(21, 15, 33);
        testIntenal1(date1);
        testIntenal1(date2);
        testIntenal1(date3);
        testIntenal1(date3);
        testIntenal1(date4);
    }

    private Date testInternal(int day, int month, int year) throws ParseException {
        String prepared = String.valueOf(year) + "/"
                + String.valueOf(month) + "/" + String.valueOf(day);
        System.out.println(new SimpleDateFormat("yy/M/d", Locale.getDefault()).parse(prepared));
        return new SimpleDateFormat("yy/M/d", Locale.getDefault()).parse(prepared);
    }

    private void testIntenal1(Date date){
        System.out.println("Year " + new SimpleDateFormat("yy").format(date));
        System.out.println("Month " + new SimpleDateFormat("M").format(date));
        System.out.println("Day " + new SimpleDateFormat("d").format(date));
    }


}
