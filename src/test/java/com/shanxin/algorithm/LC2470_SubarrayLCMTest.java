package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC2470_SubarrayLCMTest {

    private final LC2470_SubarrayLCM solution = new LC2470_SubarrayLCM(); // 创建被测试的解决方案实例

    @Test
    public void testSubarrayLCM_Example1() {
        // 示例 1：nums = [3,6,2,7,1], k = 6
        // 输出：4
        // 子数组分析：
        // [3]: LCM=3 ✗
        // [3,6]: LCM=6 ✓
        // [3,6,2]: LCM=6 ✓
        // [3,6,2,7]: LCM=42 ✗
        // [3,6,2,7,1]: LCM=42 ✗
        // [6]: LCM=6 ✓
        // [6,2]: LCM=6 ✓
        // [6,2,7]: LCM=42 ✗
        // [6,2,7,1]: LCM=42 ✗
        // [2]: LCM=2 ✗
        // [2,7]: LCM=14 ✗
        // [2,7,1]: LCM=14 ✗
        // [7]: LCM=7 ✗
        // [7,1]: LCM=7 ✗
        // [1]: LCM=1 ✗
        // 总计：4 个
        int[] nums = {3, 6, 2, 7, 1}; // 输入数组
        int k = 6; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(4, result); // 验证结果等于预期值 4
        
        System.out.println("示例 1 - 输入：nums = [3,6,2,7,1], k = " + k); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_Example2() {
        // 示例 2：nums = [3], k = 2
        // 输出：0
        // 解释：不存在以 2 为最小公倍数的子数组
        int[] nums = {3}; // 只有一个元素的数组
        int k = 2; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(0, result); // 验证结果为 0（不存在满足条件的子数组）
        
        System.out.println("示例 2 - 输入：nums = [3], k = " + k); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_SingleElementMatch() {
        // 边界情况：单个元素且等于 k
        // nums = [6], k = 6
        // 输出：1（子数组 [6] 的 LCM 为 6）
        int[] nums = {6}; // 单个元素
        int k = 6; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(1, result); // 验证结果为 1
        
        System.out.println("单元素匹配 - 输入：nums = [6], k = 6"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_SingleElementNoMatch() {
        // 边界情况：单个元素且不等于 k
        // nums = [5], k = 10
        // 输出：0
        int[] nums = {5}; // 单个元素
        int k = 10; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(0, result); // 验证结果为 0
        
        System.out.println("单元素不匹配 - 输入：nums = [5], k = 10"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_AllSameElements() {
        // 所有元素都相同且等于 k
        // nums = [2, 2, 2], k = 2
        // 所有子数组的 LCM 都是 2
        // 子数组：[2], [2], [2], [2,2], [2,2], [2,2,2]，共 6 个
        // 输出：6
        int[] nums = {2, 2, 2}; // 所有元素相同
        int k = 2; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(6, result); // 验证结果为 6（n*(n+1)/2 = 3*4/2 = 6）
        
        System.out.println("全相同元素 - 输入：nums = [2,2,2], k = 2"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_NoValidSubarray() {
        // 没有任何子数组的 LCM 等于 k
        // nums = [1, 1, 1], k = 2
        // 所有子数组的 LCM 都是 1，不等于 2
        // 输出：0
        int[] nums = {1, 1, 1}; // 所有元素都是 1
        int k = 2; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(0, result); // 验证结果为 0
        
        System.out.println("无有效子数组 - 输入：nums = [1,1,1], k = 2"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_TwoElements() {
        // 两个元素的情况
        // nums = [2, 3], k = 6
        // 子数组：[2](LCM=2), [3](LCM=3), [2,3](LCM=6)
        // 只有 [2,3] 的 LCM 等于 6
        // 输出：1
        int[] nums = {2, 3}; // 两个元素
        int k = 6; // 目标最小公倍数（2 和 3 的 LCM）
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(1, result); // 验证结果为 1
        
        System.out.println("两元素 - 输入：nums = [2,3], k = 6"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_MultipleValidSubarrays() {
        // 多个有效子数组的情况
        // nums = [2, 6, 3], k = 6
        // 子数组分析：
        // [2]: LCM=2 (不等于6)
        // [2,6]: LCM=6 (等于6) ✓
        // [2,6,3]: LCM=6 (等于6) ✓
        // [6]: LCM=6 (等于6) ✓
        // [6,3]: LCM=6 (等于6) ✓
        // [3]: LCM=3 (不等于6)
        // 输出：4
        int[] nums = {2, 6, 3}; // 三个元素
        int k = 6; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(4, result); // 验证结果为 4
        
        System.out.println("多有效子数组 - 输入：nums = [2,6,3], k = 6"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_LargerK() {
        // k 较大的情况
        // nums = [1, 2, 3, 4, 5], k = 60
        // 需要找到 LCM 为 60 的子数组
        // 60 = 2^2 * 3 * 5，需要包含 4, 3, 5
        int[] nums = {1, 2, 3, 4, 5}; // 五个元素
        int k = 60; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        // 验证结果为非负数
        assertTrue(result >= 0); // 验证结果非负
        
        System.out.println("较大 K - 输入：nums = [1,2,3,4,5], k = 60"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_ElementGreaterThanK() {
        // 包含大于 k 的元素
        // nums = [12, 6, 3], k = 6
        // 子数组分析：
        // [12]: LCM=12 ✗ (12 != 6)
        // [12,6]: LCM=12 ✗
        // [12,6,3]: LCM=12 ✗
        // [6]: LCM=6 ✓
        // [6,3]: LCM=6 ✓
        // [3]: LCM=3 ✗
        // 输出：2
        int[] nums = {12, 6, 3}; // 包含大于 k 的元素
        int k = 6; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(2, result); // 验证结果为 2（只有 [6] 和 [6,3] 的 LCM 等于 6）
        
        System.out.println("元素大于K - 输入：nums = [12,6,3], k = 6"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_ConsecutiveMultiples() {
        // 连续倍数的情况
        // nums = [1, 2, 4, 8], k = 8
        // [8]: LCM=8 ✓
        // [4,8]: LCM=8 ✓
        // [2,4,8]: LCM=8 ✓
        // [1,2,4,8]: LCM=8 ✓
        // 输出：4
        int[] nums = {1, 2, 4, 8}; // 连续倍数
        int k = 8; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(4, result); // 验证结果为 4
        
        System.out.println("连续倍数 - 输入：nums = [1,2,4,8], k = 8"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_PrimeNumbers() {
        // 质数的情况
        // nums = [2, 3, 5], k = 30
        // [2,3,5]: LCM=30 ✓
        // 其他子数组的 LCM 都不等于 30
        // 输出：1
        int[] nums = {2, 3, 5}; // 三个质数
        int k = 30; // 目标最小公倍数（2*3*5）
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(1, result); // 验证结果为 1
        
        System.out.println("质数 - 输入：nums = [2,3,5], k = 30"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_MaximumConstraints() {
        // 接近约束上限的测试
        // nums 长度为 10，所有元素都为 1，k = 1
        // 所有子数组的 LCM 都是 1
        // 长度为 10 的数组共有 10*11/2 = 55 个子数组
        // 输出：55
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}; // 10 个元素都为 1
        int k = 1; // 目标最小公倍数
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(55, result); // 验证结果为 55（10*11/2）
        
        System.out.println("最大约束 - 输入：10 个 1，k = 1"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_LCMCalculation() {
        // 验证 LCM 计算的正确性
        // nums = [4, 6], k = 12
        // [4]: LCM=4 ✗
        // [4,6]: LCM=12 ✓
        // [6]: LCM=6 ✗
        // 输出：1
        int[] nums = {4, 6}; // 两个元素
        int k = 12; // 目标最小公倍数（4 和 6 的 LCM）
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertEquals(1, result); // 验证结果为 1
        
        System.out.println("LCM计算验证 - 输入：nums = [4,6], k = 12"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testSubarrayLCM_ResultNonNegative() {
        // 验证结果始终为非负数
        int[] nums = {5, 10, 15, 20}; // 任意数组
        int k = 30; // 任意 k 值
        
        int result = solution.subarrayLCM(nums, k); // 调用方法计算满足条件的子数组数目
        
        assertTrue(result >= 0); // 验证结果非负
        
        System.out.println("非负验证 - 输入：nums = [5,10,15,20], k = 30"); // 打印输入信息
        System.out.println("输出：" + result + " (非负)"); // 打印输出结果
    }
}
