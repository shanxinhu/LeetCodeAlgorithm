package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC1784_CheckOnesSegmentTest {

    private final LC1784_CheckOnesSegment solution = new LC1784_CheckOnesSegment(); // 创建被测试的解决方案实例

    @Test
    public void testCheckOnesSegment_Example1() {
        // 示例 1：s = "1001"
        // 输出：false
        // 解释：有两个连续的 '1' 字段（位置 0 和位置 3）
        String s = "1001"; // 输入二进制字符串
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertFalse(result); // 验证结果为 false（有两个 '1' 字段）
        
        System.out.println("示例 1 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_Example2() {
        // 示例 2：s = "110"
        // 输出：true
        // 解释：只有一个连续的 '1' 字段（位置 0-1）
        String s = "110"; // 输入二进制字符串
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertTrue(result); // 验证结果为 true（只有一个 '1' 字段）
        
        System.out.println("示例 2 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_SingleOne() {
        // 边界情况：单个 '1'
        // s = "1"
        // 输出：true
        String s = "1"; // 单个字符
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertTrue(result); // 验证结果为 true（只有一个 '1'）
        
        System.out.println("单个1 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_AllOnes() {
        // 所有字符都是 '1'
        // s = "1111"
        // 输出：true（只有一个连续的 '1' 字段）
        String s = "1111"; // 全为 '1'
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("全1 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_OnesFollowedByZeros() {
        // '1' 后面跟着 '0'
        // s = "11100"
        // 输出：true（只有一个连续的 '1' 字段）
        String s = "11100"; // '1' 后跟 '0'
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("1后跟0 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_TwoSegments() {
        // 两个分离的 '1' 字段
        // s = "101"
        // 输出：false（有两个 '1' 字段）
        String s = "101"; // 两个分离的 '1'
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("两个字段 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_MultipleSegments() {
        // 多个分离的 '1' 字段
        // s = "10101"
        // 输出：false（有三个 '1' 字段）
        String s = "10101"; // 三个分离的 '1'
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("多个字段 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_OneThenZeroThenMultipleOnes() {
        // 一个 '1'，然后 '0'，然后多个 '1'
        // s = "1011"
        // 输出：false（有两个 '1' 字段）
        String s = "1011"; // 两个 '1' 字段
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("1-0-11 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_MultipleOnesThenZeroThenOne() {
        // 多个 '1'，然后 '0'，然后一个 '1'
        // s = "11101"
        // 输出：false（有两个 '1' 字段）
        String s = "11101"; // 两个 '1' 字段
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("111-0-1 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_LongSingleSegment() {
        // 长的单一 '1' 字段
        // s = "11111111110"
        // 输出：true
        String s = "11111111110"; // 长单一字段
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("长单一字段 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_NoZeroAfterOnes() {
        // 没有 '0' 出现在 '1' 之后
        // s = "10"
        // 输出：true（只有一个 '1' 字段）
        String s = "10"; // 最简单的情况
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("最简单 - 输入：s = \"" + s + "\""); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCheckOnesSegment_MaximumLength() {
        // 最大长度测试
        // s = "1" + "0".repeat(99)
        // 输出：true
        StringBuilder sb = new StringBuilder(); // 构建字符串
        sb.append("1"); // 添加第一个 '1'
        for (int i = 0; i < 99; i++) { // 添加 99 个 '0'
            sb.append("0");
        }
        String s = sb.toString(); // 最大长度的字符串
        
        boolean result = solution.checkOnesSegment(s); // 调用方法检查是否最多有一个连续的 '1' 字段
        
        assertTrue(result); // 验证结果为 true（只有一个 '1'）
        
        System.out.println("最大长度 - 输入长度：" + s.length()); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }
}
