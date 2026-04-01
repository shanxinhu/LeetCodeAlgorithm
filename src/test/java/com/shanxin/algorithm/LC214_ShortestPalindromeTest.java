package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC214_ShortestPalindromeTest {

    private final LC214_ShortestPalindrome solution = new LC214_ShortestPalindrome();

    @Test
    public void testShortestPalindrome_Example1() {
        // 示例 1：s = "aacecaaa"
        // 输出："aaacecaaa"
        String s = "aacecaaa";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("aaacecaaa", result);
        assertTrue(isPalindrome(result), "结果必须是回文串");
        assertTrue(result.endsWith(s), "结果必须以原字符串结尾");
        
        System.out.println("示例 1 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_Example2() {
        // 示例 2：s = "abcd"
        // 输出："dcbabcd"
        String s = "abcd";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("dcbabcd", result);
        assertTrue(isPalindrome(result), "结果必须是回文串");
        assertTrue(result.endsWith(s), "结果必须以原字符串结尾");
        
        System.out.println("示例 2 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_EmptyString() {
        // 边界情况：空字符串
        // s = ""
        // 输出：""
        String s = "";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("", result);
        
        System.out.println("空字符串 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_SingleCharacter() {
        // 边界情况：单个字符
        // s = "a"
        // 输出："a"
        String s = "a";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("a", result);
        assertTrue(isPalindrome(result));
        
        System.out.println("单个字符 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_AlreadyPalindrome() {
        // 整个字符串已经是回文：s = "racecar"
        // 输出："racecar"（不需要添加）
        String s = "racecar";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("racecar", result);
        assertTrue(isPalindrome(result));
        assertEquals(s.length(), result.length(), "如果原字符串是回文，结果长度应该相同");
        
        System.out.println("已是回文 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_AllSameCharacters() {
        // 所有字符都相同：s = "aaaa"
        // 输出："aaaa"
        String s = "aaaa";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("aaaa", result);
        assertTrue(isPalindrome(result));
        
        System.out.println("全相同字符 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_TwoCharacters() {
        // 两个不同字符：s = "ab"
        // 输出："bab"
        String s = "ab";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("bab", result);
        assertTrue(isPalindrome(result));
        
        System.out.println("两个字符 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_NoPrefixPalindrome() {
        // 没有前缀回文：s = "abcde"
        // 输出："edcbabcde"
        String s = "abcde";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("edcbabcde", result);
        assertTrue(isPalindrome(result));
        assertTrue(result.endsWith(s));
        
        System.out.println("无前缀回文 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_SingleCharPrefix() {
        // 只有单字符前缀回文：s = "abcd"
        // 输出："dcbabcd"
        String s = "abcd";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("dcbabcd", result);
        assertTrue(isPalindrome(result));
        
        System.out.println("单字符前缀回文 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_LongerString() {
        // 较长字符串：s = "aabba"
        // 输出："abbaaabba"
        String s = "aabba";
        
        String result = solution.shortestPalindrome(s);
        
        assertTrue(isPalindrome(result), "结果必须是回文串");
        assertTrue(result.endsWith(s), "结果必须以原字符串结尾");
        
        System.out.println("较长字符串 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testShortestPalindrome_PalindromePrefix() {
        // 有回文前缀：s = "abaac"
        // 输出："caabaac"
        String s = "abaac";
        
        String result = solution.shortestPalindrome(s);
        
        assertEquals("caabaac", result);
        assertTrue(isPalindrome(result));
        
        System.out.println("有回文前缀 - 输入：s = \"" + s + "\"");
        System.out.println("输出：" + result);
    }

    /**
     * 辅助方法：判断字符串是否为回文
     */
    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
