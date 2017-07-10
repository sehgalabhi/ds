package com.datatype;

/**
 * Created by asehgal on 6/22/2017.
 */
public class ByteArith_Arithmetic {

    public static void main(String[] args) {
        new ByteArith_Arithmetic().test();
    }

    private void test() {
        byte a = 0x0A;
        System.out.println(Integer.toBinaryString(a));

        byte val1 = 0x01;
        byte val2 = 0x00;

        int carry = 0x02;
        boolean isCarry = false;
        if(val1 + val2 == carry){
            isCarry = true;
        }
        System.out.println("isCarry " + isCarry);
        System.out.println("1 | 1 " + (byte)(val1 + val2));

        byte b = 0x0C;
        System.out.println(Integer.toBinaryString(b));

//        byte result = a & b;
   //     int result = add(a, b);

    }

    public int add(int a, int b) {
        int i = 0;
        do {

            a = a & b;
            System.out.println(Integer.toBinaryString(a));
            b = a ^ b;
            System.out.println(Integer.toBinaryString(b));

            a = a << 1;
            System.out.println(Integer.toBinaryString(a));
            i++;

        } while (i < 32);
        return b;

    }

    public int sub(int a, int b) {
        return add(a, ~b);
    }
}
