package com.generics.general;

import java.util.Collection;

/**
 * Created by asehgal on 5/11/2017.
 */
public class WildCardVsTypeParameter {
    public static void main(String[] args) {

    }
}


//backward
interface CollectionWildCard {

    boolean contains(Object o);

    boolean containsAll(Collection<?> c);

}

//better
interface CollectionTypeParameter<E>{
    boolean contains(E o);

    boolean containsAll(Collection<? extends E> c);

}