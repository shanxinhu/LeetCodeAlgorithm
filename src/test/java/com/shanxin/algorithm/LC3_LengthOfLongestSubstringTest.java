package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC3_LengthOfLongestSubstringTest {

    private final LC3_LengthOfLongestSubstring solution = new LC3_LengthOfLongestSubstring();

    @Test
    public void testLengthOfLongestSubstring_Example1() {
        // 示例 1: s = "abcabcbb"
        // 输出: 3
        // 解释: 无重复字符的最长子串是 "abc"
        String s = "abcabcbb";
        
        int result = solution.lengthOfLongestSubstring(s);
        
        assertEquals(3, result);
        
        System.out.println("示例 1 - 输入: s = \"" + s + "\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testLengthOfLongestSubstring_Example2() {
        // 示例 2: s = "bbbbb"
        // 输出: 1
        // 解释: 无重复字符的最长子串是 "b"
        String s = "bbbbb";
        
        int result = solution.lengthOfLongestSubstring(s);
        
        assertEquals(1, result);
        
        System.out.println("示例 2 - 输入: s = \"" + s + "\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testLengthOfLongestSubstring_Example3() {
        // 示例 3: s = "pwwkew"
        // 输出: 3
        // 解释: 无重复字符的最长子串是 "wke"
        String s = "pwwkew";
        
        int result = solution.lengthOfLongestSubstring(s);
        
        assertEquals(3, result);
        
        System.out.println("示例 3 - 输入: s = \"" + s + "\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testLengthOfLongestSubstring_EmptyString() {
        // 边界情况：空字符串
        String s = "";
        
        int result = solution.lengthOfLongestSubstring(s);
        
        assertEquals(0, result);
        
        System.out.println("空字符串 - 输入: s = \"" + s + "\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testLengthOfLongestSubstring_AllUnique() {
        // 所有字符都不重复
        String s = "abcdef";
        
        int result = solution.lengthOfLongestSubstring(s);
        
        assertEquals(6, result);
        
        System.out.println("全不重复 - 输入: s = \"" + s + "\"");
        System.out.println("输出: " + result);
    }
}
