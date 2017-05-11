package com.generics.general;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by asehgal on 5/11/2017.
 */
public class WildcardCapture {

    public static void reverse(List<?> list){
        rev(list);
    }

    private static <T> void rev(List<T> list){
        List<T> tmp = new ArrayList<T>(list);

        for(int i=0; i<list.size();i++){
            list.set(i, tmp.get(list.size()-i-1));
        }
    }
    //good way with type paramtere
    /*public static <T> void reverse(List<T> list){
        List<T> tmp = new ArrayList<T>(list);

        for(int i=0; i<list.size();i++){
            list.set(i, tmp.get(list.size()-i-1));
        }
    }*/


}
