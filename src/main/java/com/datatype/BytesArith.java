package com.datatype;

/**
 * Created by asehgal on 6/21/2017.
 */
public class BytesArith {

    static final char[] digits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static void main(String[] args) {
        new BytesArith().test();
    }

    private void test() {

        byte a=36, temp = 36;
        byte b = -3;
       // byte temp1 = (byte) (temp >>>3);
        //System.out.println(temp>>>1);
      //  System.out.println(Integer.toBinaryString(temp));
        System.out.println(toBinaryString(a ));

        System.out.println(Integer.toBinaryString(b & 0xFF));
        System.out.println(b);

    }

    public static String toBinaryString(int var0) {
        return toUnsignedString0(var0, 1);
    }

    private static String toUnsignedString0(int var0, int var1) {
        int var2 = 32 - numberOfLeadingZeros(var0);
        int var3 = Math.max((var2 + (var1 - 1)) / var1, 1);
        char[] var4 = new char[var3];
        formatUnsignedInt(var0, var1, var4, 0, var3);
        return new String(var4);
    }

    static int formatUnsignedInt(int var0, int var1, char[] var2, int var3, int var4) {
        int var5 = var4;
        int var6 = 1 << var1;
        int var7 = var6 - 1;

        do {
            --var5;
            var2[var3 + var5] = digits[var0 & var7];
            var0 >>>= var1;
        } while(var0 != 0 && var5 > 0);

        return var5;
    }


    public static int numberOfLeadingZeros(int var0) {
        if(var0 == 0) {
            return 32;
        } else {
            int var1 = 1;
            if(var0 >>> 16 == 0) {
                var1 += 16;
                var0 <<= 16;
            }

            if(var0 >>> 24 == 0) {
                var1 += 8;
                var0 <<= 8;
            }

            if(var0 >>> 28 == 0) {
                var1 += 4;
                var0 <<= 4;
            }

            if(var0 >>> 30 == 0) {
                var1 += 2;
                var0 <<= 2;
            }

            var1 -= var0 >>> 31;
            return var1;
        }
    }
}
