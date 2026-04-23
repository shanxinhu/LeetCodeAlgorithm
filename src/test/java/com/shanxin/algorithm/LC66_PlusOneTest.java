package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LC66_PlusOneTest {

    private final LC66_PlusOne solution = new LC66_PlusOne();

    @Test
    public void testPlusOne_Example1() {
        // 示例 1：digits = [1,2,3] → [1,2,4]
        assertArrayEquals(new int[]{1, 2, 4}, solution.plusOne(new int[]{1, 2, 3}));

        System.out.println("示例 1 - 输入：[1,2,3] → 输出：" + Arrays.toString(solution.plusOne(new int[]{1, 2, 3})));
    }

    @Test
    public void testPlusOne_Example2() {
        // 示例 2：digits = [4,3,2,1] → [4,3,2,2]
        assertArrayEquals(new int[]{4, 3, 2, 2}, solution.plusOne(new int[]{4, 3, 2, 1}));

        System.out.println("示例 2 - 输入：[4,3,2,1] → 输出：" + Arrays.toString(solution.plusOne(new int[]{4, 3, 2, 1})));
    }

    @Test
    public void testPlusOne_Example3() {
        // 示例 3：digits = [9] → [1,0]
        assertArrayEquals(new int[]{1, 0}, solution.plusOne(new int[]{9}));

        System.out.println("示例 3 - 输入：[9] → 输出：" + Arrays.toString(solution.plusOne(new int[]{9})));
    }

    @Test
    public void testPlusOne_AllNines() {
        // 全为9：digits = [9,9,9] → [1,0,0,0]
        assertArrayEquals(new int[]{1, 0, 0, 0}, solution.plusOne(new int[]{9, 9, 9}));

        System.out.println("全9 - 输入：[9,9,9] → 输出：" + Arrays.toString(solution.plusOne(new int[]{9, 9, 9})));
    }

    @Test
    public void testPlusOne_NoCarry() {
        // 无进位：digits = [1,2,9] → [1,3,0]
        assertArrayEquals(new int[]{1, 3, 0}, solution.plusOne(new int[]{1, 2, 9}));

        System.out.println("部分进位 - 输入：[1,2,9] → 输出：" + Arrays.toString(solution.plusOne(new int[]{1, 2, 9})));
    }

    @Test
    public void testPlusOne_SingleDigit() {
        // 单位非9：digits = [0] → [1]
        assertArrayEquals(new int[]{1}, solution.plusOne(new int[]{0}));

        System.out.println("单数字 - 输入：[0] → 输出：" + Arrays.toString(solution.plusOne(new int[]{0})));
    }

    @Test
    public void testPlusOne_CascadeCarry() {
        // 级联进位：digits = [1,9,9,9] → [2,0,0,0]
        assertArrayEquals(new int[]{2, 0, 0, 0}, solution.plusOne(new int[]{1, 9, 9, 9}));

        System.out.println("级联进位 - 输入：[1,9,9,9] → 输出：" + Arrays.toString(solution.plusOne(new int[]{1, 9, 9, 9})));
    }

    @Test
    public void testPlusOne_ZeroAtEnd() {
        // 末尾为0：digits = [2,3,0] → [2,3,1]
        assertArrayEquals(new int[]{2, 3, 1}, solution.plusOne(new int[]{2, 3, 0}));

        System.out.println("末尾0 - 输入：[2,3,0] → 输出：" + Arrays.toString(solution.plusOne(new int[]{2, 3, 0})));
    }
}
