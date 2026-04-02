package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * LC796 旋转字符串 - 单元测试
 */
public class LC796_RotateStringTest {

    private final LC796_RotateString solution = new LC796_RotateString();

    /**
     * 测试示例 1: 基本旋转场景
     * 输入：s = "abcde", goal = "cdeab"
     * 输出：true
     */
    @Test
    public void testRotateString_Example1() {
        String s = "abcde";
        String goal = "cdeab";
        assertTrue(solution.rotateString(s, goal), 
            "应该返回 true，因为 abcde 旋转 2 次可以得到 cdeab");
    }

    /**
     * 测试示例 2: 无法匹配的场景
     * 输入：s = "abcde", goal = "abced"
     * 输出：false
     */
    @Test
    public void testRotateString_Example2() {
        String s = "abcde";
        String goal = "abced";
        assertFalse(solution.rotateString(s, goal), 
            "应该返回 false，因为 abcde 无法通过旋转得到 abced");
    }

    /**
     * 测试相同字符串
     */
    @Test
    public void testRotateString_SameString() {
        String s = "abc";
        String goal = "abc";
        assertTrue(solution.rotateString(s, goal), 
            "相同字符串应该返回 true");
    }

    /**
     * 测试单字符相同
     */
    @Test
    public void testRotateString_SingleCharacterSame() {
        String s = "a";
        String goal = "a";
        assertTrue(solution.rotateString(s, goal), 
            "单字符相同应该返回 true");
    }

    /**
     * 测试单字符不同
     */
    @Test
    public void testRotateString_SingleCharacterDifferent() {
        String s = "a";
        String goal = "b";
        assertFalse(solution.rotateString(s, goal), 
            "单字符不同应该返回 false");
    }

    /**
     * 测试长度不同的情况
     */
    @Test
    public void testRotateString_DifferentLength() {
        String s = "abc";
        String goal = "abcd";
        assertFalse(solution.rotateString(s, goal), 
            "长度不同应该直接返回 false");
    }

    /**
     * 测试空字符串边界（虽然题目限制最小长度为 1）
     */
    @Test
    public void testRotateString_EmptyString() {
        String s = "";
        String goal = "";
        assertTrue(solution.rotateString(s, goal), 
            "两个空字符串应该返回 true");
    }

    /**
     * 测试完全由相同字符组成的字符串
     */
    @Test
    public void testRotateString_AllSameCharacters() {
        String s = "aaaa";
        String goal = "aaaa";
        assertTrue(solution.rotateString(s, goal), 
            "全相同字符的旋转应该返回 true");
    }

    /**
     * 测试需要多次旋转才能匹配的情况
     */
    @Test
    public void testRotateString_MultipleRotations() {
        String s = "abcde";
        String goal = "deabc"; // 需要旋转 3 次
        assertTrue(solution.rotateString(s, goal), 
            "abcde 旋转 3 次应该得到 deabc");
    }

    /**
     * 测试旋转一次即可匹配的情况
     */
    @Test
    public void testRotateString_OneRotation() {
        String s = "abcde";
        String goal = "bcdea";
        assertTrue(solution.rotateString(s, goal), 
            "abcde 旋转 1 次应该得到 bcdea");
    }

    /**
     * 测试较长字符串
     */
    @Test
    public void testRotateString_LongString() {
        String s = "abcdefghijklmnopqrstuvwxyz";
        String goal = "mnopqrstuvwxyza bcdefghijkl"; // 错误的目标串
        assertFalse(solution.rotateString(s, goal), 
            "不匹配的长字符串应该返回 false");
    }

    /**
     * 测试包含重复模式的字符串
     */
    @Test
    public void testRotateString_RepeatedPattern() {
        String s = "abab";
        String goal = "baba";
        assertTrue(solution.rotateString(s, goal), 
            "abab 旋转应该能得到 baba");
    }

    /**
     * 测试 KMP 算法的回溯场景
     */
    @Test
    public void testRotateString_KMPBacktrackScenario() {
        String s = "aaacb";
        String goal = "aacba";
        // aaacb 旋转 1 次：aaacb -> aacba (将第一个'a'移到末尾)
        assertTrue(solution.rotateString(s, goal), 
            "aaacb 旋转 1 次可以得到 aacba");
    }

    /**
     * 测试回文串
     */
    @Test
    public void testRotateString_Palindrome() {
        String s = "aba";
        String goal = "aba";
        assertTrue(solution.rotateString(s, goal), 
            "回文串旋转自身应该返回 true");
    }

    /**
     * 测试所有字符都不同的情况
     */
    @Test
    public void testRotateString_AllUniqueCharacters() {
        String s = "abcdef";
        String goal = "defabc";
        assertTrue(solution.rotateString(s, goal), 
            "abcdef 旋转 3 次应该得到 defabc");
    }

    /**
     * 性能测试：最大长度字符串 (根据题目提示，最大长度 100)
     */
    @Test
    public void testRotateString_MaxLength() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append((char)('a' + (i % 26)));
        }
        String s = sb.toString();
        String goal = s.substring(50) + s.substring(0, 50); // 旋转 50 个字符
        
        assertTrue(solution.rotateString(s, goal), 
            "最大长度的旋转字符串应该能正确处理");
    }
}
