package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC28_StrStrTest {

    private final LC28_StrStr solution = new LC28_StrStr();

    @Test
    public void testStrStr_Example1() {
        // 示例 1：haystack = "sadbutsad", needle = "sad" → 0
        int result = solution.strStr("sadbutsad", "sad");

        assertEquals(0, result);

        System.out.println("示例 1 - 输入：haystack=\"sadbutsad\", needle=\"sad\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testStrStr_Example2() {
        // 示例 2：haystack = "leetcode", needle = "leeto" → -1
        int result = solution.strStr("leetcode", "leeto");

        assertEquals(-1, result);

        System.out.println("示例 2 - 输入：haystack=\"leetcode\", needle=\"leeto\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testStrStr_EqualStrings() {
        // haystack == needle：haystack = "abc", needle = "abc" → 0
        int result = solution.strStr("abc", "abc");

        assertEquals(0, result);

        System.out.println("相等 - 输入：haystack=\"abc\", needle=\"abc\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testStrStr_SingleCharMatch() {
        // haystack = "a", needle = "a" → 0
        int result = solution.strStr("a", "a");

        assertEquals(0, result);

        System.out.println("单字符匹配 - 输入：haystack=\"a\", needle=\"a\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testStrStr_SingleCharNoMatch() {
        // haystack = "a", needle = "b" → -1
        int result = solution.strStr("a", "b");

        assertEquals(-1, result);

        System.out.println("单字符不匹配 - 输入：haystack=\"a\", needle=\"b\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testStrStr_MatchInMiddle() {
        // haystack = "mississippi", needle = "issip" → 4
        int result = solution.strStr("mississippi", "issip");

        assertEquals(4, result);

        System.out.println("中间匹配 - 输入：haystack=\"mississippi\", needle=\"issip\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testStrStr_PartialPrefixMatch() {
        // haystack = "aaaaa", needle = "bba" → -1
        int result = solution.strStr("aaaaa", "bba");

        assertEquals(-1, result);

        System.out.println("部分前缀不匹配 - 输入：haystack=\"aaaaa\", needle=\"bba\"");
        System.out.println("输出：" + result);
    }

    @Test
    public void testStrStr_RepeatedPattern() {
        // haystack = "abcabcabc", needle = "abcabc" → 0
        int result = solution.strStr("abcabcabc", "abcabc");

        assertEquals(0, result);

        System.out.println("重复模式 - 输入：haystack=\"abcabcabc\", needle=\"abcabc\"");
        System.out.println("输出：" + result);
    }
}
