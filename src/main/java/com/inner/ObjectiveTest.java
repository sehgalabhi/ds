package com.inner;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class ObjectiveTest {

        public static void main(String args[])
        {
            int x,y =10;
            System.out.println("hello" + args[0]);


        }
}

enum Enums
{
    A, B, C;

    private Enums()
    {
        System.out.println(10);
    }
}


class Boo
{
    Boo(String s) { }
    Boo() { }
}
class Bar extends Boo
{
    Bar() { }
    Bar(String s) {super(s);}
    void zoo()
    {
        // insert code here
    }
}
