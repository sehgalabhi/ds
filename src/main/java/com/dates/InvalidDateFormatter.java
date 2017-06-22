package com.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asehgal on 6/16/2017.
 */
public class InvalidDateFormatter {
    public static void main(String[] args) throws ParseException {
        InvalidDateFormatter invalidDateFormatter = new InvalidDateFormatter();

//        invalidDateFormatter.test( "dd/MM/yyyy", "32/02/2012");
        invalidDateFormatter.test("yyMMdd", "221133");
    }

    private void test(String dateFormat, String dateToValidate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
//        simpleDateFormat.setLenient(false);
        Date date = simpleDateFormat.parse(dateToValidate);
        System.out.println(date);
    }
}
