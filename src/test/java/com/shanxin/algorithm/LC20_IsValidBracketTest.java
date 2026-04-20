package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC20_IsValidBracketTest {

    @Test
    public void testIsValid_Example1() {
        // 示例 1：s = "()"
        // 输出：true
        LC20_IsValidBracket solution = new LC20_IsValidBracket();
        boolean result = solution.isValid("()");
        assertTrue(result);

        System.out.println("示例 1 - 输入: \"()\" 输出: " + result);
    }

    @Test
    public void testIsValid_Example2() {
        // 示例 2：s = "()[]{}"
        // 输出：true
        LC20_IsValidBracket solution = new LC20_IsValidBracket();
        boolean result = solution.isValid("()[]{}");
        assertTrue(result);

        System.out.println("示例 2 - 输入: \"()[]{}\" 输出: " + result);
    }

    @Test
    public void testIsValid_Example3() {
        // 示例 3：s = "(]"
        // 输出：false
        LC20_IsValidBracket solution = new LC20_IsValidBracket();
        boolean result = solution.isValid("(]");
        assertFalse(result);

        System.out.println("示例 3 - 输入: \"(]\" 输出: " + result);
    }

    @Test
    public void testIsValid_Example4() {
        // 示例 4：s = "([])"
        // 输出：true
        LC20_IsValidBracket solution = new LC20_IsValidBracket();
        boolean result = solution.isValid("([])");
        assertTrue(result);

        System.out.println("示例 4 - 输入: \"([])\" 输出: " + result);
    }

    @Test
    public void testIsValid_Example5() {
        // 示例 5：s = "([)]"
        // 输出：false
        LC20_IsValidBracket solution = new LC20_IsValidBracket();
        boolean result = solution.isValid("([)]");
        assertFalse(result);

        System.out.println("示例 5 - 输入: \"([)]\" 输出: " + result);
    }

    @Test
    public void testIsValid_OddLength() {
        // 奇数长度直接返回 false
        LC20_IsValidBracket solution = new LC20_IsValidBracket();
        assertFalse(solution.isValid("("));
        assertFalse(solution.isValid("({["));

        System.out.println("奇数长度 - 输入: \"(\" 和 \"({[\" 输出: false, false");
    }

    @Test
    public void testIsValid_Empty() {
        // 空字符串返回 true
        LC20_IsValidBracket solution = new LC20_IsValidBracket();
        assertTrue(solution.isValid(""));

        System.out.println("空字符串 - 输入: \"\" 输出: true");
    }
}
