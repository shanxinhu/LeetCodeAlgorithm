package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC3251_CountOfPairsTest {

    private final LC3251_CountOfPairs solution = new LC3251_CountOfPairs();

    @Test
    public void testCountOfPairs_Example1() {
        // 示例 1：nums = [2,3,2]
        // 输出：4
        // 解释：单调数组对包括：
        // ([0, 1, 1], [2, 2, 1])
        // ([0, 1, 2], [2, 2, 0])
        // ([0, 2, 2], [2, 1, 0])
        // ([1, 2, 2], [1, 1, 0])
        int[] nums = {2, 3, 2};
        
        int result = solution.countOfPairs(nums);
        
        assertEquals(4, result);
        
        System.out.println("示例 1 - 输入：nums = [2,3,2]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_Example2() {
        // 示例 2：nums = [5,5,5,5]
        // 输出：126
        int[] nums = {5, 5, 5, 5};
        
        int result = solution.countOfPairs(nums);
        
        assertEquals(126, result);
        
        System.out.println("示例 2 - 输入：nums = [5,5,5,5]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_SingleElement() {
        // 边界情况：只有一个元素
        // nums = [1]
        // arr1[0] 可以取 0 或 1，对应的 arr2[0] 分别为 1 或 0
        // 输出：2
        int[] nums = {1};
        
        int result = solution.countOfPairs(nums);
        
        assertEquals(2, result);
        
        System.out.println("单元素 - 输入：nums = [1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_TwoElements() {
        // 两个元素的情况
        // nums = [1,2]
        // 可能的组合需要满足单调性
        int[] nums = {1, 2};
        
        int result = solution.countOfPairs(nums);
        
        // 验证结果非负
        assertTrue(result >= 0);
        
        System.out.println("两元素 - 输入：nums = [1,2]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_IncreasingSequence() {
        // 递增序列
        // nums = [1,2,3]
        int[] nums = {1, 2, 3};
        
        int result = solution.countOfPairs(nums);
        
        assertTrue(result > 0);
        
        System.out.println("递增序列 - 输入：nums = [1,2,3]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_DecreasingSequence() {
        // 递减序列
        // nums = [3,2,1]
        int[] nums = {3, 2, 1};
        
        int result = solution.countOfPairs(nums);
        
        assertTrue(result >= 0);
        
        System.out.println("递减序列 - 输入：nums = [3,2,1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_AllSameValues() {
        // 所有值都相同（较小的数）
        // nums = [2,2,2]
        int[] nums = {2, 2, 2};
        
        int result = solution.countOfPairs(nums);
        
        assertTrue(result > 0);
        
        System.out.println("全相同值 - 输入：nums = [2,2,2]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_LargerValues() {
        // 较大值的测试
        // nums = [10,10,10]
        int[] nums = {10, 10, 10};
        
        int result = solution.countOfPairs(nums);
        
        assertTrue(result > 0);
        
        System.out.println("较大值 - 输入：nums = [10,10,10]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_MixedValues() {
        // 混合不同大小的值
        // nums = [1,5,3,8,2]
        int[] nums = {1, 5, 3, 8, 2};
        
        int result = solution.countOfPairs(nums);
        
        assertTrue(result >= 0);
        
        System.out.println("混合值 - 输入：nums = [1,5,3,8,2]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_MinimumValue() {
        // 最小值测试（所有元素都是 1）
        // nums = [1,1,1,1]
        int[] nums = {1, 1, 1, 1};
        
        int result = solution.countOfPairs(nums);
        
        assertTrue(result > 0);
        
        System.out.println("最小值 - 输入：nums = [1,1,1,1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_LongArray() {
        // 较长数组测试
        // nums = [1,1,1,1,1,1,1,1,1,1] (10 个 1)
        int[] nums = new int[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = 1;
        }
        
        int result = solution.countOfPairs(nums);
        
        assertTrue(result > 0);
        
        System.out.println("长数组 - 输入：nums = [1,1,1,1,1,1,1,1,1,1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testCountOfPairs_ModuloCheck() {
        // 验证结果是否正确取模
        // nums = [100,100,100,100,100]
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = 100;
        }
        
        int result = solution.countOfPairs(nums);
        
        // 结果应该在 int 范围内且为正数
        assertTrue(result >= 0);
        assertTrue(result < 1_000_000_007);
        
        System.out.println("取模检查 - 输入：nums = [100,100,100,100,100]");
        System.out.println("输出：" + result);
    }
}
