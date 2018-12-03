package com.codility;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testSuccess() {
        String solution = new Solution().solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3});
        assertEquals("SUMMER", solution);
    }

    public void testSuccess1() {
        String solution = new Solution().solution(new int[]{2,-3,3, 1,10,8, 2,5,13,-5,3,-18});
        assertEquals("AUTUMN", solution);
    }

    public void testSuccess2() {
        String solution = new Solution().solution(new int[]{-3,-14, -5,42,8,42,8,3});
        assertEquals("SPRING", solution);
    }

    public void testSuccess3() {
        String solution = new Solution().solution(new int[]{52,-14, -5,7,8,42,8,52});
        assertEquals("WINTER", solution);
    }


    public void testSuccess4() {
        String solution = new Solution().solution(new int[]{2,-3,3,4, 1,10,8,22, 2,5,13,4, -5,3,-18,3});
        assertEquals("SPRING", solution);
    }



}
