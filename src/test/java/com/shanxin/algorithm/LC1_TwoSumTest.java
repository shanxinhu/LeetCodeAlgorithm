package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LC1_TwoSumTest {

    @Test
    public void testTwoSum_Example1() {
        // 示例 1：nums = [2,7,11,15], target = 9
        // 输出：[0,1]
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = LC1_TwoSum.twoSum(nums, target);
        
        assertNotNull(result);
        assertEquals(2, result.length);
        
        // 验证下标（顺序可能不同）
        assertTrue((result[0] == 0 && result[1] == 1) || (result[0] == 1 && result[1] == 0));
        
        // 验证结果正确性
        assertEquals(9, nums[result[0]] + nums[result[1]]);
        
        System.out.println("示例 1 - 输入: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("输出: " + Arrays.toString(result));
    }

    @Test
    public void testTwoSum_Example2() {
        // 示例 2：nums = [3,2,4], target = 6
        // 输出：[1,2]
        int[] nums = {3, 2, 4};
        int target = 6;
        
        int[] result = LC1_TwoSum.twoSum(nums, target);
        
        assertNotNull(result);
        assertEquals(2, result.length);
        
        // 验证下标
        assertTrue((result[0] == 1 && result[1] == 2) || (result[0] == 2 && result[1] == 1));
        
        // 验证结果正确性
        assertEquals(6, nums[result[0]] + nums[result[1]]);
        
        System.out.println("示例 2 - 输入: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("输出: " + Arrays.toString(result));
    }

    @Test
    public void testTwoSum_Example3() {
        // 示例 3：nums = [3,3], target = 6
        // 输出：[0,1]
        int[] nums = {3, 3};
        int target = 6;
        
        int[] result = LC1_TwoSum.twoSum(nums, target);
        
        assertNotNull(result);
        assertEquals(2, result.length);
        
        // 验证下标
        assertTrue((result[0] == 0 && result[1] == 1) || (result[0] == 1 && result[1] == 0));
        
        // 验证结果正确性
        assertEquals(6, nums[result[0]] + nums[result[1]]);
        
        System.out.println("示例 3 - 输入: nums = " + Arrays.toString(nums) + ", target = " + target);
        System.out.println("输出: " + Arrays.toString(result));
    }
}
