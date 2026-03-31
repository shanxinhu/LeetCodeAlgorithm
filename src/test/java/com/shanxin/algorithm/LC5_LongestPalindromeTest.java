package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC5_LongestPalindromeTest {

    private final LC5_LongestPalindrome solution = new LC5_LongestPalindrome();

    @Test
    public void testLongestPalindrome_Example1() {
        // 示例 1：s = "babad"
        // 输出："bab" 或 "aba"
        String s = "babad";
        
        String result = solution.longestPalindrome(s);
        
        assertTrue(result.equals("bab") || result.equals("aba"), 
            "结果应该是 'bab' 或 'aba'");
        assertEquals(3, result.length());
        
        System.out.println("示例 1 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_Example2() {
        // 示例 2：s = "cbbd"
        // 输出："bb"
        String s = "cbbd";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals("bb", result);
        
        System.out.println("示例 2 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_SingleCharacter() {
        // 边界情况：单个字符
        // s = "a"
        // 输出："a"
        String s = "a";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals("a", result);
        
        System.out.println("单个字符 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_AllSameCharacters() {
        // 所有字符都相同：s = "aaaa"
        // 输出："aaaa"
        String s = "aaaa";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals("aaaa", result);
        
        System.out.println("全相同字符 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_NoPalindrome() {
        // 无回文子串（除了单字符）：s = "abc"
        // 输出："a" 或 "b" 或 "c"
        String s = "abc";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals(1, result.length(), "最长回文子串长度应为 1");
        assertTrue(s.contains(result), "结果必须是原字符串的子串");
        
        System.out.println("无回文 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_EntireStringIsPalindrome() {
        // 整个字符串是回文：s = "racecar"
        // 输出："racecar"
        String s = "racecar";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals("racecar", result);
        
        System.out.println("整个字符串是回文 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_MixedNumbersAndLetters() {
        // 混合数字和字母：s = "a1b2b1a"
        // 输出："a1b2b1a"
        String s = "a1b2b1a";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals("a1b2b1a", result);
        
        System.out.println("混合数字字母 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_TwoCharacters() {
        // 两个字符：s = "ab"
        // 输出："a" 或 "b"
        String s = "ab";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals(1, result.length());
        assertTrue(s.contains(result));
        
        System.out.println("两个字符 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testLongestPalindrome_EvenLengthPalindrome() {
        // 偶数长度回文：s = "abba"
        // 输出："abba"
        String s = "abba";
        
        String result = solution.longestPalindrome(s);
        
        assertEquals("abba", result);
        
        System.out.println("偶数长度回文 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }
}
