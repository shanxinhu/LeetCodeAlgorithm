package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC9_IsPalindromeTest {

    private final LC9_IsPalindrome solution = new LC9_IsPalindrome(); // 创建被测试的解决方案实例

    @Test
    public void testIsPalindrome_Example1() {
        // 示例 1：x = 121
        // 输出：true
        // 解释：121 正序和倒序读都一样
        int x = 121; // 输入整数
        
        boolean result = solution.isPalindrome(x); // 调用方法判断是否为回文数
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("示例 1 - 输入：121"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testIsPalindrome_Example2() {
        // 示例 2：x = -121
        // 输出：false
        // 解释：负数不是回文数
        int x = -121; // 输入负数
        
        boolean result = solution.isPalindrome(x); // 调用方法判断是否为回文数
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("示例 2 - 输入：-121"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testIsPalindrome_Example3() {
        // 示例 3：x = 10
        // 输出：false
        // 解释：从右向左读为 01，不是回文数
        int x = 10; // 输入以0结尾的数
        
        boolean result = solution.isPalindrome(x); // 调用方法判断是否为回文数
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("示例 3 - 输入：10"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testIsPalindrome_SingleDigit() {
        // 单个数字（0-9）都是回文数
        for (int i = 0; i <= 9; i++) {
            assertTrue(solution.isPalindrome(i), i + " 应该是回文数");
        }
        
        System.out.println("单个数字 - 0-9 都是回文数"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_Zero() {
        // 0 是回文数
        int x = 0; // 输入 0
        
        boolean result = solution.isPalindrome(x); // 调用方法判断是否为回文数
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("零 - 输入：0"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testIsPalindrome_NegativeNumbers() {
        // 所有负数都不是回文数
        int[] negativeNumbers = {-1, -121, -12321, -100, -999}; // 负数数组
        
        for (int num : negativeNumbers) {
            assertFalse(solution.isPalindrome(num), num + " 不应该是回文数");
        }
        
        System.out.println("负数 - 所有负数都不是回文数"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_EvenLengthPalindrome() {
        // 偶数位回文数
        int[] evenPalindromes = {11, 1221, 123321, 12344321}; // 偶数位回文数数组
        
        for (int num : evenPalindromes) {
            assertTrue(solution.isPalindrome(num), num + " 应该是回文数");
        }
        
        System.out.println("偶数位回文 - 测试通过"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_OddLengthPalindrome() {
        // 奇数位回文数
        int[] oddPalindromes = {121, 12321, 1234321, 123454321}; // 奇数位回文数数组
        
        for (int num : oddPalindromes) {
            assertTrue(solution.isPalindrome(num), num + " 应该是回文数");
        }
        
        System.out.println("奇数位回文 - 测试通过"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_NotPalindrome() {
        // 非回文数
        int[] notPalindromes = {123, 1234, 10, 100, 12345, 123456}; // 非回文数数组
        
        for (int num : notPalindromes) {
            assertFalse(solution.isPalindrome(num), num + " 不应该是回文数");
        }
        
        System.out.println("非回文数 - 测试通过"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_EndsWithZero() {
        // 以 0 结尾的非零数都不是回文数
        int[] endsWithZero = {10, 20, 100, 120, 1000, 1230}; // 以0结尾的数数组
        
        for (int num : endsWithZero) {
            assertFalse(solution.isPalindrome(num), num + " 不应该是回文数");
        }
        
        System.out.println("以0结尾 - 测试通过"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_LargePalindrome() {
        // 大回文数
        // 使用 int 范围内的较大回文数
        int largePalindrome = 2147447412; // 接近 Integer.MAX_VALUE 的回文数
        
        boolean result = solution.isPalindrome(largePalindrome); // 调用方法判断是否为回文数
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("大回文数 - 输入：2147447412"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testIsPalindrome_BoundaryValues() {
        // 边界值测试
        // Integer.MAX_VALUE = 2147483647 不是回文数
        assertFalse(solution.isPalindrome(Integer.MAX_VALUE));
        
        // Integer.MIN_VALUE = -2147483648 是负数，不是回文数
        assertFalse(solution.isPalindrome(Integer.MIN_VALUE));
        
        System.out.println("边界值 - 测试通过"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_RepeatedDigits() {
        // 重复数字的回文数
        int[] repeatedDigitPalindromes = {111, 2222, 33333, 444444}; // 重复数字回文数数组
        
        for (int num : repeatedDigitPalindromes) {
            assertTrue(solution.isPalindrome(num), num + " 应该是回文数");
        }
        
        System.out.println("重复数字回文 - 测试通过"); // 打印测试信息
    }

    @Test
    public void testIsPalindrome_TwoDigitNumbers() {
        // 两位数测试
        // 只有 11, 22, 33, ..., 99 是回文数
        for (int i = 10; i <= 99; i++) {
            int tens = i / 10; // 十位数
            int ones = i % 10; // 个位数
            if (tens == ones) {
                assertTrue(solution.isPalindrome(i), i + " 应该是回文数");
            } else {
                assertFalse(solution.isPalindrome(i), i + " 不应该是回文数");
            }
        }
        
        System.out.println("两位数 - 测试通过"); // 打印测试信息
    }
}
