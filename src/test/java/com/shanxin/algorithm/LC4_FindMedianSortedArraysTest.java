package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC4_FindMedianSortedArraysTest {

    private final LC4_FindMedianSortedArrays solution = new LC4_FindMedianSortedArrays();

    @Test
    public void testFindMedianSortedArrays_Example1() {
        // 示例 1：nums1 = [1,3], nums2 = [2]
        // 输出：2.00000
        // 解释：合并数组 = [1,2,3] ，中位数 2
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        
        double result = solution.findMedianSortedArrays(nums1, nums2);
        
        assertEquals(2.0, result, 0.00001);
        
        System.out.println("示例 1 - 输入: nums1 = " + java.util.Arrays.toString(nums1) + 
                          ", nums2 = " + java.util.Arrays.toString(nums2));
        System.out.println("输出: " + result);
    }

    @Test
    public void testFindMedianSortedArrays_Example2() {
        // 示例 2：nums1 = [1,2], nums2 = [3,4]
        // 输出：2.50000
        // 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        
        double result = solution.findMedianSortedArrays(nums1, nums2);
        
        assertEquals(2.5, result, 0.00001);
        
        System.out.println("示例 2 - 输入: nums1 = " + java.util.Arrays.toString(nums1) + 
                          ", nums2 = " + java.util.Arrays.toString(nums2));
        System.out.println("输出: " + result);
    }

    @Test
    public void testFindMedianSortedArrays_OneEmptyArray() {
        // 边界情况：一个数组为空
        // nums1 = [], nums2 = [1]
        // 输出：1.0
        int[] nums1 = {};
        int[] nums2 = {1};
        
        double result = solution.findMedianSortedArrays(nums1, nums2);
        
        assertEquals(1.0, result, 0.00001);
        
        System.out.println("一个空数组 - 输入: nums1 = " + java.util.Arrays.toString(nums1) + 
                          ", nums2 = " + java.util.Arrays.toString(nums2));
        System.out.println("输出: " + result);
    }

    @Test
    public void testFindMedianSortedArrays_DifferentLengths() {
        // 不同长度的数组：nums1 = [0,0], nums2 = [0,0,0,0]
        // 输出：0.0
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0, 0, 0};
        
        double result = solution.findMedianSortedArrays(nums1, nums2);
        
        assertEquals(0.0, result, 0.00001);
        
        System.out.println("不同长度 - 输入: nums1 = " + java.util.Arrays.toString(nums1) + 
                          ", nums2 = " + java.util.Arrays.toString(nums2));
        System.out.println("输出: " + result);
    }

    @Test
    public void testFindMedianSortedArrays_NegativeNumbers() {
        // 包含负数：nums1 = [-5, -2, 0], nums2 = [-4, -1, 3]
        // 合并后：[-5, -4, -2, -1, 0, 3]
        // 中位数：(-2 + -1) / 2 = -1.5
        int[] nums1 = {-5, -2, 0};
        int[] nums2 = {-4, -1, 3};
        
        double result = solution.findMedianSortedArrays(nums1, nums2);
        
        assertEquals(-1.5, result, 0.00001);
        
        System.out.println("包含负数 - 输入: nums1 = " + java.util.Arrays.toString(nums1) + 
                          ", nums2 = " + java.util.Arrays.toString(nums2));
        System.out.println("输出: " + result);
    }
}
