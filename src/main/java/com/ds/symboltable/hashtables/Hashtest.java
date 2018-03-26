package com.ds.symboltable.hashtables;

import java.util.Date;

/**
 * Created by abhi on 25/3/18.
 */
public class Hashtest {
    private final String who;
    private final Date when;
    private final Double value;


    public Hashtest(String who, Date when, Double value) {
        this.who = who;
        this.when = when;
        this.value = value;
    }



    @Override
    public int hashCode() {
        //combine each significant field with x+31y rule
        //null return 0
        //primitive use Wrapper hashcode
        //reference type hashcode
        // array, apply to each entry

        // hash code is between -2e31 and 2e31
        //hash function is between 0 and M-1
        int hash = 17;
        hash = hash + 31*who.hashCode();
        hash = hash + 31* when.hashCode();
        hash = hash + 31*value.hashCode();
        return hash;
    }

    private int hash(){
        int M = 97;
        return (hashCode() & 0x7fffffff )% M;
    }
}

