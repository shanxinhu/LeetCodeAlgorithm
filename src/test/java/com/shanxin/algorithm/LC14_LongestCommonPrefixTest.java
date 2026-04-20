package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC14_LongestCommonPrefixTest {

    @Test
    public void testLongestCommonPrefix_Example1() {
        // 示例 1：strs = ["flower","flow","flight"]
        // 输出："fl"
        LC14_LongestCommonPrefix solution = new LC14_LongestCommonPrefix();
        String result = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        assertEquals("fl", result);

        System.out.println("示例 1 - 输入: [\"flower\",\"flow\",\"flight\"]");
        System.out.println("输出: \"" + result + "\"");
    }

    @Test
    public void testLongestCommonPrefix_Example2() {
        // 示例 2：strs = ["dog","racecar","car"]
        // 输出：""
        LC14_LongestCommonPrefix solution = new LC14_LongestCommonPrefix();
        String result = solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        assertEquals("", result);

        System.out.println("示例 2 - 输入: [\"dog\",\"racecar\",\"car\"]");
        System.out.println("输出: \"" + result + "\"");
    }

    @Test
    public void testLongestCommonPrefix_AllSame() {
        // 所有字符串相同
        LC14_LongestCommonPrefix solution = new LC14_LongestCommonPrefix();
        String result = solution.longestCommonPrefix(new String[]{"abc", "abc", "abc"});
        assertEquals("abc", result);

        System.out.println("全部相同 - 输入: [\"abc\",\"abc\",\"abc\"]");
        System.out.println("输出: \"" + result + "\"");
    }

    @Test
    public void testLongestCommonPrefix_SingleElement() {
        // 只有一个字符串
        LC14_LongestCommonPrefix solution = new LC14_LongestCommonPrefix();
        String result = solution.longestCommonPrefix(new String[]{"hello"});
        assertEquals("hello", result);

        System.out.println("单元素 - 输入: [\"hello\"]");
        System.out.println("输出: \"" + result + "\"");
    }

    @Test
    public void testLongestCommonPrefix_NoCommonPrefix() {
        // 首字符就不同
        LC14_LongestCommonPrefix solution = new LC14_LongestCommonPrefix();
        String result = solution.longestCommonPrefix(new String[]{"cat", "dog", "bird"});
        assertEquals("", result);

        System.out.println("无公共前缀 - 输入: [\"cat\",\"dog\",\"bird\"]");
        System.out.println("输出: \"" + result + "\"");
    }
}
