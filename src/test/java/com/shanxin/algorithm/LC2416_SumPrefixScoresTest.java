package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LC2416_SumPrefixScoresTest {

    private final LC2416_SumPrefixScores solution = new LC2416_SumPrefixScores(); // 创建被测试的解决方案实例

    @Test
    public void testSumPrefixScores_Example1() {
        // 示例 1：words = ["abc","ab","bc","b"]
        // 输出：[5,4,3,2]
        // 解释：
        // - "abc" 的前缀："a"(2个)、"ab"(2个)、"abc"(1个)，总和=5
        // - "ab" 的前缀："a"(2个)、"ab"(2个)，总和=4
        // - "bc" 的前缀："b"(2个)、"bc"(1个)，总和=3
        // - "b" 的前缀："b"(2个)，总和=2
        String[] words = {"abc", "ab", "bc", "b"}; // 输入字符串数组
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(4, result.length); // 验证结果长度等于输入数组长度
        assertArrayEquals(new int[]{5, 4, 3, 2}, result); // 验证结果数组内容
        
        System.out.println("示例 1 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_Example2() {
        // 示例 2：words = ["abcd"]
        // 输出：[4]
        // 解释："abcd" 有 4 个前缀，每个前缀只出现 1 次，总和=4
        String[] words = {"abcd"}; // 只有一个字符串的数组
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.length); // 验证结果长度为 1
        assertArrayEquals(new int[]{4}, result); // 验证结果为 [4]
        
        System.out.println("示例 2 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_SingleCharacterStrings() {
        // 边界情况：所有字符串都是单字符
        // words = ["a", "b", "c"]
        // 每个字符串只有 1 个前缀，且都只出现 1 次
        // 输出：[1, 1, 1]
        String[] words = {"a", "b", "c"}; // 三个单字符字符串
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(3, result.length); // 验证结果长度为 3
        assertArrayEquals(new int[]{1, 1, 1}, result); // 验证每个字符串的前缀分数和都是 1
        
        System.out.println("单字符 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_AllSameStrings() {
        // 所有字符串都相同
        // words = ["abc", "abc", "abc"]
        // 每个前缀都出现 3 次
        // "abc" 的前缀："a"(3次)、"ab"(3次)、"abc"(3次)，总和=9
        // 输出：[9, 9, 9]
        String[] words = {"abc", "abc", "abc"}; // 三个相同的字符串
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(3, result.length); // 验证结果长度为 3
        assertArrayEquals(new int[]{9, 9, 9}, result); // 验证每个字符串的前缀分数和都是 9
        
        System.out.println("全相同 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_NoCommonPrefix() {
        // 没有公共前缀的情况
        // words = ["abc", "def", "ghi"]
        // 每个前缀都只出现 1 次
        // "abc" 有 3 个前缀，每个出现 1 次，总和=3
        // "def" 有 3 个前缀，每个出现 1 次，总和=3
        // "ghi" 有 3 个前缀，每个出现 1 次，总和=3
        // 输出：[3, 3, 3]
        String[] words = {"abc", "def", "ghi"}; // 三个完全不同前缀的字符串
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(3, result.length); // 验证结果长度为 3
        assertArrayEquals(new int[]{3, 3, 3}, result); // 验证每个字符串的前缀分数和都是 3
        
        System.out.println("无公共前缀 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_OneIsPrefixOfAnother() {
        // 一个字符串是另一个的前缀
        // words = ["a", "ab", "abc", "abcd"]
        // "a" 出现 4 次，"ab" 出现 3 次，"abc" 出现 2 次，"abcd" 出现 1 次
        // "a" 的前缀："a"(4次)，总和=4
        // "ab" 的前缀："a"(4次)、"ab"(3次)，总和=7
        // "abc" 的前缀："a"(4次)、"ab"(3次)、"abc"(2次)，总和=9
        // "abcd" 的前缀："a"(4次)、"ab"(3次)、"abc"(2次)、"abcd"(1次)，总和=10
        // 输出：[4, 7, 9, 10]
        String[] words = {"a", "ab", "abc", "abcd"}; // 递增前缀的字符串数组
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(4, result.length); // 验证结果长度为 4
        assertArrayEquals(new int[]{4, 7, 9, 10}, result); // 验证结果数组
        
        System.out.println("前缀关系 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_MixedLengths() {
        // 混合不同长度的字符串
        // words = ["apple", "app", "application"]
        // 共同前缀统计：
        // "a" 出现 3 次（所有字符串都以 a 开头）
        // "ap" 出现 3 次
        // "app" 出现 3 次
        // "appl" 出现 2 次（apple 和 application）
        // "apple" 出现 1 次
        // "applic" 出现 1 次
        // "applica" 出现 1 次
        // "applicat" 出现 1 次
        // "applicati" 出现 1 次
        // "applicatio" 出现 1 次
        // "application" 出现 1 次
        // "apple" 的前缀分数："a"(3) + "ap"(3) + "app"(3) + "appl"(2) + "apple"(1) = 12
        // "app" 的前缀分数："a"(3) + "ap"(3) + "app"(3) = 9
        // "application" 的前缀分数："a"(3) + "ap"(3) + "app"(3) + "appl"(2) + "applic"(1) + "applica"(1) + "applicat"(1) + "applicati"(1) + "applicatio"(1) + "application"(1) = 18
        // 输出：[12, 9, 18]
        String[] words = {"apple", "app", "application"}; // 不同长度但有共同前缀
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(3, result.length); // 验证结果长度为 3
        assertArrayEquals(new int[]{12, 9, 18}, result); // 验证结果数组
        
        System.out.println("混合长度 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_TwoStrings() {
        // 只有两个字符串的情况
        // words = ["abc", "abd"]
        // "a" 出现 2 次，"ab" 出现 2 次，"abc" 出现 1 次，"abd" 出现 1 次
        // "abc" 的前缀："a"(2)、"ab"(2)、"abc"(1)，总和=5
        // "abd" 的前缀："a"(2)、"ab"(2)、"abd"(1)，总和=5
        // 输出：[5, 5]
        String[] words = {"abc", "abd"}; // 两个有共同前缀的字符串
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(2, result.length); // 验证结果长度为 2
        assertArrayEquals(new int[]{5, 5}, result); // 验证结果数组
        
        System.out.println("两字符串 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_LongString() {
        // 长字符串测试
        // words = ["abcdefghij"]
        // 10 个前缀，每个出现 1 次，总和=10
        String[] words = {"abcdefghij"}; // 长度为 10 的字符串
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.length); // 验证结果长度为 1
        assertArrayEquals(new int[]{10}, result); // 验证结果为字符串长度
        
        System.out.println("长字符串 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_ResultArrayLength() {
        // 验证结果数组长度始终等于输入数组长度
        String[] words = {"alpha", "beta", "gamma", "delta", "epsilon"}; // 5 个纯字母字符串
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(words.length, result.length); // 验证结果数组长度等于输入数组长度
        
        System.out.println("数组长度验证 - 输入长度：" + words.length + "，输出长度：" + result.length); // 打印验证信息
    }

    @Test
    public void testSumPrefixScores_AllResultsPositive() {
        // 验证所有结果都是正数（因为每个字符串至少有 1 个前缀，且至少出现 1 次）
        String[] words = {"a", "ab", "abc", "abcd", "abcde"}; // 5 个递增前缀的字符串
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        
        // 验证每个结果都是正数
        for (int score : result) { // 遍历每个分数
            assertTrue(score > 0); // 验证分数大于 0
        }
        
        System.out.println("正数验证 - 所有结果都为正数：" + Arrays.toString(result)); // 打印验证信息
    }

    @Test
    public void testSumPrefixScores_ComplexCase() {
        // 复杂情况：多个字符串有不同层次的前缀关系
        // words = ["a", "aa", "aaa", "aaaa", "b", "bb"]
        // "a" 出现 4 次，"aa" 出现 3 次，"aaa" 出现 2 次，"aaaa" 出现 1 次
        // "b" 出现 2 次，"bb" 出现 1 次
        // "a": "a"(4) = 4
        // "aa": "a"(4) + "aa"(3) = 7
        // "aaa": "a"(4) + "aa"(3) + "aaa"(2) = 9
        // "aaaa": "a"(4) + "aa"(3) + "aaa"(2) + "aaaa"(1) = 10
        // "b": "b"(2) = 2
        // "bb": "b"(2) + "bb"(1) = 3
        // 输出：[4, 7, 9, 10, 2, 3]
        String[] words = {"a", "aa", "aaa", "aaaa", "b", "bb"}; // 多组前缀关系
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(6, result.length); // 验证结果长度为 6
        assertArrayEquals(new int[]{4, 7, 9, 10, 2, 3}, result); // 验证结果数组
        
        System.out.println("复杂情况 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testSumPrefixScores_ScoreAccumulation() {
        // 验证分数累加的正确性
        // 对于每个字符串，其答案应该等于所有前缀的 score 之和
        String[] words = {"abc", "ab", "a"}; // 递减前缀的字符串数组
        
        int[] result = solution.sumPrefixScores(words); // 调用方法计算前缀分数和
        
        assertNotNull(result); // 验证结果不为 null
        
        // "a" 出现 3 次，"ab" 出现 2 次，"abc" 出现 1 次
        // "abc": "a"(3) + "ab"(2) + "abc"(1) = 6
        // "ab": "a"(3) + "ab"(2) = 5
        // "a": "a"(3) = 3
        assertArrayEquals(new int[]{6, 5, 3}, result); // 验证分数累加正确
        
        System.out.println("分数累加验证 - 输入：words = " + Arrays.toString(words)); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }
}
