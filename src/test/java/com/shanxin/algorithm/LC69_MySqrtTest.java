package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC69_MySqrtTest {

    private final LC69_MySqrt solution = new LC69_MySqrt();

    @Test
    public void testMySqrt_Example1() {
        // 示例 1：x = 4 → 2
        assertEquals(2, solution.mySqrt(4));

        System.out.println("示例 1 - 输入：4 → 输出：" + solution.mySqrt(4));
    }

    @Test
    public void testMySqrt_Example2() {
        // 示例 2：x = 8 → 2（2.82842... 舍去小数）
        assertEquals(2, solution.mySqrt(8));

        System.out.println("示例 2 - 输入：8 → 输出：" + solution.mySqrt(8));
    }

    @Test
    public void testMySqrt_Zero() {
        // x = 0 → 0
        assertEquals(0, solution.mySqrt(0));

        System.out.println("零 - 输入：0 → 输出：" + solution.mySqrt(0));
    }

    @Test
    public void testMySqrt_One() {
        // x = 1 → 1
        assertEquals(1, solution.mySqrt(1));

        System.out.println("一 - 输入：1 → 输出：" + solution.mySqrt(1));
    }

    @Test
    public void testMySqrt_Two() {
        // x = 2 → 1（1.414... 舍去小数）
        assertEquals(1, solution.mySqrt(2));

        System.out.println("二 - 输入：2 → 输出：" + solution.mySqrt(2));
    }

    @Test
    public void testMySqrt_PerfectSquare() {
        // x = 9 → 3（完全平方数）
        assertEquals(3, solution.mySqrt(9));

        System.out.println("完全平方 - 输入：9 → 输出：" + solution.mySqrt(9));
    }

    @Test
    public void testMySqrt_LargeNumber() {
        // x = 2147395599（46339^2 = 2147395600 - 1，刚好不是完全平方数）→ 46339
        assertEquals(46339, solution.mySqrt(2147395599));

        System.out.println("大数 - 输入：2147395599 → 输出：" + solution.mySqrt(2147395599));
    }

    @Test
    public void testMySqrt_LargePerfectSquare() {
        // x = 46340^2 = 2147395600 → 46340
        assertEquals(46340, solution.mySqrt(2147395600));

        System.out.println("大完全平方 - 输入：2147395600 → 输出：" + solution.mySqrt(2147395600));
    }

    @Test
    public void testMySqrt_MaxInt() {
        // x = 2147483647（Integer.MAX_VALUE）→ 46340
        assertEquals(46340, solution.mySqrt(2147483647));

        System.out.println("最大int - 输入：2147483647 → 输出：" + solution.mySqrt(2147483647));
    }
}
