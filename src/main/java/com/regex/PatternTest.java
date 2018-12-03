package com.regex;

import com.sun.org.apache.regexp.internal.RE;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {

        Integer integer = new Integer("0100");
        System.out.println("0123".replaceFirst("^0*", ""));
        System.out.println("00000123".replaceFirst("^0*", ""));
        System.out.println("01230".replaceFirst("^0*", ""));
        System.out.println("23".replaceFirst("^0*", ""));
        System.out.println(integer);
        System.out.println("000000".matches("0{6}"));
        System.out.println("00000000000".matches("0{11}"));
        System.out.println("000005".matches("0{6}"));
        System.out.println("00000".matches("0{6}"));
        System.out.println("111111".matches("0{6}"));

//        new PatternTest().testGroups();
        new PatternTest().testMatcherStartAndExtract();
    /*    new PatternTest().testMatcherStartEnd();
        new PatternTest().testMatchesAndLookingAt();
        new PatternTest().testAppend();*/

    }

    private void testMatcherStartAndExtract() {
        String REGEX = "ATC_VAL_OFFLINE_RANGE.*";
        String INPUT = "ATC_VAL_OFFLINE_RANGE=953;ATC_VAL=000;TOKEN_STATE_VAL=000;";

        System.out.println(INPUT.matches(REGEX));

        testPart(REGEX, INPUT);

        String INPUT1 = "TEST1=1;TEST2=2;ATC_CODE=3;TEST3=3";
        testPart(REGEX, INPUT1);
        String INPUT2 = "TEST1=1;TEST2=2;ATC_CODE=3;TEST3=3;ATC_OFFLINE=4;";
        testPart(REGEX, INPUT2);

    }

    private void testPart(String REGEX, String INPUT) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        if(matcher.find()){
            int startIndex = matcher.start();
            String value = INPUT.substring(startIndex, INPUT.indexOf(";", startIndex));
            String substring = value.substring(value.indexOf("=")+1, value.length());
            System.out.println(substring);
        }
    }

    private void testAppend() {
        String REGEX = "a*b";
        String INPUT = "aabfooaabfooabfoob";
        String REPLACE = "-";

        Pattern compile = Pattern.compile(REGEX);
        Matcher matcher = compile.matcher(INPUT);

        StringBuffer  stringBuilder = new StringBuffer();
        while(matcher.find()){
            matcher.appendReplacement(stringBuilder, REPLACE);
        }
        matcher.appendTail(stringBuilder);
        System.out.println(stringBuilder.toString());
    }

    private void testMatchesAndLookingAt() {
         final String REGEX = "foo";
        final String INPUT = "fooooooooooooooooo";

        Pattern compile = Pattern.compile(REGEX);
        Matcher matcher = compile.matcher(INPUT);
        System.out.println(matcher.matches());
        System.out.println(matcher.lookingAt());


    }

    private void testMatcherStartEnd() {
        String input = "cat cat cat cattie cat";
        String regex = "\\bcat\\b";

        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(input);

        int count = 0;

        while (matcher.find()){
            count++;
            System.out.println("Match number "+ count);
            System.out.println("start() "+ matcher.start());
            System.out.println("end() "+ matcher.end());
        }

    }

    private void testGroups() {
       /* Pattern pattern = Pattern.compile("a*b");
        Matcher matcher = pattern.matcher("aaaab");
        System.out.println(matcher.matches());

        Pattern capturingGroups = Pattern.compile("((A)(B(C)))");
        Matcher matcherGroup = capturingGroups.matcher("ABC");
        System.out.println(matcherGroup.groupCount());
*/

        String line = "This order was placed for QT3000! OK?67";
        Pattern patternDigit = Pattern.compile("(^\\D+)(\\d)+");
        Matcher matcher1 = patternDigit.matcher(line);
        System.out.println(matcher1.groupCount());

        if(matcher1.find()){

            System.out.println(matcher1.start(2));
//            System.out.println(matcher1.group(0));
            System.out.println(matcher1.group(1));
            System.out.println(matcher1.group(2));

        } else {
            System.out.println("Not matched");
        }


    }
}
