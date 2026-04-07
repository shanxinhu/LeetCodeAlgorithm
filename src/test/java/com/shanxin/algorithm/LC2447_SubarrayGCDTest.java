package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC2447_SubarrayGCDTest {

    private final LC2447_SubarrayGCD solution = new LC2447_SubarrayGCD(); // 创建被测试的解决方案实例

    @Test
    public void testSubarrayGCD_Example1() {
        // 示例 1：nums = [9,3,1,2,6,3], k = 3
        // 输出：4
        int[] nums = {9, 3, 1, 2, 6, 3}; // 输入数组
        int k = 3; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(4, result); // 验证结果等于预期值 4
        
        System.out.println("示例 1 - 输入：nums = [9,3,1,2,6,3], k = " + k); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_Example2() {
        // 示例 2：nums = [4], k = 7
        // 输出：0
        int[] nums = {4}; // 只有一个元素的数组
        int k = 7; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(0, result); // 验证结果为 0（不存在满足条件的子数组）
        
        System.out.println("示例 2 - 输入：nums = [4], k = " + k); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_SingleElementMatch() {
        // 边界情况：单个元素且等于 k
        // nums = [5], k = 5
        // 输出：1
        int[] nums = {5}; // 单个元素
        int k = 5; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(1, result); // 验证结果为 1
        
        System.out.println("单元素匹配 - 输入：nums = [5], k = 5"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_SingleElementNoMatch() {
        // 边界情况：单个元素且不等于 k
        // nums = [6], k = 3
        // GCD(6) = 6 != 3
        // 输出：0
        int[] nums = {6}; // 单个元素
        int k = 3; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(0, result); // 验证结果为 0
        
        System.out.println("单元素不匹配 - 输入：nums = [6], k = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_AllSameElements() {
        // 所有元素都相同且等于 k
        // nums = [3, 3, 3], k = 3
        // 所有子数组的 GCD 都是 3
        // 子数组数量：3*(3+1)/2 = 6
        // 输出：6
        int[] nums = {3, 3, 3}; // 所有元素相同
        int k = 3; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(6, result); // 验证结果为 6
        
        System.out.println("全相同元素 - 输入：nums = [3,3,3], k = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_NoValidSubarray() {
        // 没有任何子数组的 GCD 等于 k
        // nums = [2, 4, 6], k = 3
        // 所有元素都是偶数，GCD 也是偶数，不可能等于 3
        // 输出：0
        int[] nums = {2, 4, 6}; // 所有元素都是偶数
        int k = 3; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(0, result); // 验证结果为 0
        
        System.out.println("无有效子数组 - 输入：nums = [2,4,6], k = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_TwoElements() {
        // 两个元素的情况
        // nums = [6, 9], k = 3
        // [6]: GCD=6 ✗
        // [6,9]: GCD=3 ✓
        // [9]: GCD=9 ✗
        // 输出：1
        int[] nums = {6, 9}; // 两个元素
        int k = 3; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(1, result); // 验证结果为 1
        
        System.out.println("两元素 - 输入：nums = [6,9], k = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_MultipleValidSubarrays() {
        // 多个有效子数组的情况
        // nums = [3, 6, 9], k = 3
        // [3]: GCD=3 ✓
        // [3,6]: GCD=3 ✓
        // [3,6,9]: GCD=3 ✓
        // [6]: GCD=6 ✗
        // [6,9]: GCD=3 ✓
        // [9]: GCD=9 ✗
        // 输出：4
        int[] nums = {3, 6, 9}; // 三个元素
        int k = 3; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(4, result); // 验证结果为 4
        
        System.out.println("多有效子数组 - 输入：nums = [3,6,9], k = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_ElementNotDivisibleByK() {
        // 包含不能被 k 整除的元素
        // nums = [5, 10, 15], k = 5
        // [5]: GCD=5 ✓
        // [5,10]: GCD=5 ✓
        // [5,10,15]: GCD=5 ✓
        // [10]: GCD=10 ✗
        // [10,15]: GCD=5 ✓
        // [15]: GCD=15 ✗
        // 输出：4
        int[] nums = {5, 10, 15}; // 包含不能被 k 整除的元素
        int k = 5; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(4, result); // 验证结果为 4
        
        System.out.println("元素不可被K整除 - 输入：nums = [5,10,15], k = 5"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_LargeNumbers() {
        // 大数情况
        // nums = [12, 18, 24], k = 6
        // [12]: GCD=12 ✗
        // [12,18]: GCD=6 ✓
        // [12,18,24]: GCD=6 ✓
        // [18]: GCD=18 ✗
        // [18,24]: GCD=6 ✓
        // [24]: GCD=24 ✗
        // 输出：3
        int[] nums = {12, 18, 24}; // 较大的数
        int k = 6; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(3, result); // 验证结果为 3
        
        System.out.println("大数 - 输入：nums = [12,18,24], k = 6"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_PrimeNumbers() {
        // 质数的情况
        // nums = [2, 3, 5], k = 1
        // 任意两个不同质数的 GCD 都是 1
        // [2]: GCD=2 ✗
        // [2,3]: GCD=1 ✓
        // [2,3,5]: GCD=1 ✓
        // [3]: GCD=3 ✗
        // [3,5]: GCD=1 ✓
        // [5]: GCD=5 ✗
        // 输出：3
        int[] nums = {2, 3, 5}; // 三个质数
        int k = 1; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(3, result); // 验证结果为 3
        
        System.out.println("质数 - 输入：nums = [2,3,5], k = 1"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_ResultNonNegative() {
        // 验证结果始终为非负数
        int[] nums = {7, 14, 21, 28}; // 任意数组
        int k = 7; // 任意 k 值
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertTrue(result >= 0); // 验证结果非负
        
        System.out.println("非负验证 - 输入：nums = [7,14,21,28], k = 7"); // 打印输入信息
        System.out.println("输出：" + result + " (非负)"); // 打印输出结果
    }

    @Test
    public void testSubarrayGCD_GCDCalculation() {
        // 验证 GCD 计算的正确性
        // nums = [8, 12], k = 4
        // [8]: GCD=8 ✗
        // [8,12]: GCD=4 ✓
        // [12]: GCD=12 ✗
        // 输出：1
        int[] nums = {8, 12}; // 两个元素
        int k = 4; // 目标最大公因数
        
        int result = solution.subarrayGCD(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(1, result); // 验证结果为 1
        
        System.out.println("GCD计算验证 - 输入：nums = [8,12], k = 4"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }
}
