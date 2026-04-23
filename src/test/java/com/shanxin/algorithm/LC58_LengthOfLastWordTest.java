package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC58_LengthOfLastWordTest {

    private final LC58_LengthOfLastWord solution = new LC58_LengthOfLastWord();

    @Test
    public void testLengthOfLastWord_Example1() {
        // 示例 1：s = "Hello World" → 5
        assertEquals(5, solution.lengthOfLastWord("Hello World"));

        System.out.println("示例 1 - 输入：\"Hello World\" → 输出：5");
    }

    @Test
    public void testLengthOfLastWord_Example2() {
        // 示例 2：s = "   fly me   to   the moon  " → 4
        assertEquals(4, solution.lengthOfLastWord("   fly me   to   the moon  "));

        System.out.println("示例 2 - 输入：\"   fly me   to   the moon  \" → 输出：4");
    }

    @Test
    public void testLengthOfLastWord_Example3() {
        // 示例 3：s = "luffy is still joyboy" → 6
        assertEquals(6, solution.lengthOfLastWord("luffy is still joyboy"));

        System.out.println("示例 3 - 输入：\"luffy is still joyboy\" → 输出：6");
    }

    @Test
    public void testLengthOfLastWord_SingleWord() {
        // 单个单词：s = "Hello" → 5
        assertEquals(5, solution.lengthOfLastWord("Hello"));

        System.out.println("单词 - 输入：\"Hello\" → 输出：5");
    }

    @Test
    public void testLengthOfLastWord_TrailingSpaces() {
        // 尾部空格：s = "day   " → 3
        assertEquals(3, solution.lengthOfLastWord("day   "));

        System.out.println("尾部空格 - 输入：\"day   \" → 输出：3");
    }

    @Test
    public void testLengthOfLastWord_LeadingSpaces() {
        // 前导空格：s = "   code" → 4
        assertEquals(4, solution.lengthOfLastWord("   code"));

        System.out.println("前导空格 - 输入：\"   code\" → 输出：4");
    }

    @Test
    public void testLengthOfLastWord_SingleChar() {
        // 单个字符：s = "a" → 1
        assertEquals(1, solution.lengthOfLastWord("a"));

        System.out.println("单字符 - 输入：\"a\" → 输出：1");
    }

    @Test
    public void testLengthOfLastWord_SingleCharWithSpaces() {
        // 单字符带空格：s = "  b  " → 1
        assertEquals(1, solution.lengthOfLastWord("  b  "));

        System.out.println("单字符带空格 - 输入：\"  b  \" → 输出：1");
    }
}
