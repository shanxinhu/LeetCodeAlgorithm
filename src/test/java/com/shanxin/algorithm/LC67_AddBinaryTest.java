package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC67_AddBinaryTest {

    private final LC67_AddBinary solution = new LC67_AddBinary();

    @Test
    public void testAddBinary_Example1() {
        // 示例 1：a = "11", b = "1" → "100"
        assertEquals("100", solution.addBinary("11", "1"));

        System.out.println("示例 1 - 输入：\"11\", \"1\" → 输出：" + solution.addBinary("11", "1"));
    }

    @Test
    public void testAddBinary_Example2() {
        // 示例 2：a = "1010", b = "1011" → "10101"
        assertEquals("10101", solution.addBinary("1010", "1011"));

        System.out.println("示例 2 - 输入：\"1010\", \"1011\" → 输出：" + solution.addBinary("1010", "1011"));
    }

    @Test
    public void testAddBinary_BothZero() {
        // a = "0", b = "0" → "0"
        assertEquals("0", solution.addBinary("0", "0"));

        System.out.println("双零 - 输入：\"0\", \"0\" → 输出：" + solution.addBinary("0", "0"));
    }

    @Test
    public void testAddBinary_CarryOnly() {
        // 1 + 1 = 10：a = "1", b = "1" → "10"
        assertEquals("10", solution.addBinary("1", "1"));

        System.out.println("进位 - 输入：\"1\", \"1\" → 输出：" + solution.addBinary("1", "1"));
    }

    @Test
    public void testAddBinary_DifferentLength() {
        // a = "1111", b = "1" → "10000"
        assertEquals("10000", solution.addBinary("1111", "1"));

        System.out.println("不等长 - 输入：\"1111\", \"1\" → 输出：" + solution.addBinary("1111", "1"));
    }

    @Test
    public void testAddBinary_NoCarry() {
        // 无进位：a = "101", b = "010" → "111"
        assertEquals("111", solution.addBinary("101", "010"));

        System.out.println("无进位 - 输入：\"101\", \"010\" → 输出：" + solution.addBinary("101", "010"));
    }

    @Test
    public void testAddBinary_AllOnes() {
        // 111 + 111 = 1110：a = "111", b = "111" → "1110"
        assertEquals("1110", solution.addBinary("111", "111"));

        System.out.println("全1 - 输入：\"111\", \"111\" → 输出：" + solution.addBinary("111", "111"));
    }

    @Test
    public void testAddBinary_ZeroAndNumber() {
        // a = "0", b = "101" → "101"
        assertEquals("101", solution.addBinary("0", "101"));

        System.out.println("零加数 - 输入：\"0\", \"101\" → 输出：" + solution.addBinary("0", "101"));
    }
}
