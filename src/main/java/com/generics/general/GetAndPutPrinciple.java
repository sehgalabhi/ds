package com.generics.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by asehgal on 5/11/2017.
 */
public class GetAndPutPrinciple {

    public static void main(String[] args) {
        GetAndPutPrinciple getAndPutPrinciple = new GetAndPutPrinciple();
        getAndPutPrinciple.testExtends();
        getAndPutPrinciple.testSuper();

    }

    private void testSuper() {
        List<Object> objs = new ArrayList<>();
        objs.add(1);
        objs.add(2);

        List<? super Integer> ints = objs;

        //only get Object
        for (Object integer: ints){
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
}
