package com.strings;

/**
 * Created by asehgal on 6/20/2017.
 */
public class RemoveLastOccurence {

    public static void main(String[] args) {
        new RemoveLastOccurence().test();
    }

    private void test() {
        String test = "343567567576687435685F";
        String test1 = "343567567576687435685";
        String test2 = "3435675675F76687435685F";
        System.out.println(removeLastOccurence(test));
        System.out.println(removeLastOccurence(test1));
        System.out.println(removeLastOccurence(test2));


    }

    private String removeLastOccurence(String track2Data) {
        return track2Data.lastIndexOf('F') != -1 ? track2Data.substring(0, track2Data.lastIndexOf('F')) : track2Data;
    }
}
