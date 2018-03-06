package com.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalDateTimeTest {

    public static void main(String[] args) throws ParseException {
        String now = "2016-11-09 10:30";

   //     LocalDateTime localDateTime = LocalDateTime.parse("1201100500", DateTimeFormatter.ofPattern("MMddmmss"));
//        LocalDateTime localDateTime1 = LocalDateTime.parse(now, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Date parsedDate = simpleDateFormat.parse("1201100500");
        System.out.println(parsedDate);



        //System.out.println(localDateTime);
    }
}
