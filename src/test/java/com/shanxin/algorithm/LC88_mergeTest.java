package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LC88_mergeTest {

    private final LC88_merge solution = new LC88_merge(); // 创建被测试的解决方案实例

    @Test
    public void testMerge_Example1() {
        // 示例 1：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        // 输出：[1,2,2,3,5,6]
        int[] nums1 = {1, 2, 3, 0, 0, 0}; // 第一个数组（包含预留空间）
        int m = 3; // nums1 中有效元素数量
        int[] nums2 = {2, 5, 6}; // 第二个数组
        int n = 3; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, nums1); // 验证合并结果
        
        System.out.println("示例 1 - 输入：nums1 = " + Arrays.toString(new int[]{1, 2, 3}) + 
                          ", m = " + m + ", nums2 = " + Arrays.toString(nums2) + ", n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_Example2() {
        // 示例 2：nums1 = [1], m = 1, nums2 = [], n = 0
        // 输出：[1]
        int[] nums1 = {1}; // 第一个数组
        int m = 1; // nums1 中有效元素数量
        int[] nums2 = {}; // 第二个数组（空）
        int n = 0; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1}, nums1); // 验证合并结果
        
        System.out.println("示例 2 - 输入：nums1 = [1], m = " + m + ", nums2 = [], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_Example3() {
        // 示例 3：nums1 = [0], m = 0, nums2 = [1], n = 1
        // 输出：[1]
        int[] nums1 = {0}; // 第一个数组（预留空间）
        int m = 0; // nums1 中有效元素数量（为空）
        int[] nums2 = {1}; // 第二个数组
        int n = 1; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1}, nums1); // 验证合并结果
        
        System.out.println("示例 3 - 输入：nums1 = [0], m = " + m + ", nums2 = [1], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_BothEmpty() {
        // 两个数组都为空
        // nums1 = [], m = 0, nums2 = [], n = 0
        // 输出：[]
        int[] nums1 = {}; // 第一个数组（空）
        int m = 0; // nums1 中有效元素数量
        int[] nums2 = {}; // 第二个数组（空）
        int n = 0; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertEquals(0, nums1.length); // 验证结果为空数组
        
        System.out.println("双空 - 输入：nums1 = [], m = " + m + ", nums2 = [], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_Num2Empty() {
        // nums2 为空
        // nums1 = [1,2,3], m = 3, nums2 = [], n = 0
        // 输出：[1,2,3]
        int[] nums1 = {1, 2, 3}; // 第一个数组
        int m = 3; // nums1 中有效元素数量
        int[] nums2 = {}; // 第二个数组（空）
        int n = 0; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1, 2, 3}, nums1); // 验证合并结果（无变化）
        
        System.out.println("nums2空 - 输入：nums1 = [1,2,3], m = " + m + ", nums2 = [], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_Num1Empty() {
        // nums1 为空
        // nums1 = [0,0,0], m = 0, nums2 = [1,2,3], n = 3
        // 输出：[1,2,3]
        int[] nums1 = {0, 0, 0}; // 第一个数组（预留空间）
        int m = 0; // nums1 中有效元素数量（为空）
        int[] nums2 = {1, 2, 3}; // 第二个数组
        int n = 3; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1, 2, 3}, nums1); // 验证合并结果
        
        System.out.println("nums1空 - 输入：nums1 = [0,0,0], m = " + m + ", nums2 = [1,2,3], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_NoOverlap() {
        // 两个数组没有重叠元素
        // nums1 = [1,2,3,0,0], m = 3, nums2 = [4,5], n = 2
        // 输出：[1,2,3,4,5]
        int[] nums1 = {1, 2, 3, 0, 0}; // 第一个数组
        int m = 3; // nums1 中有效元素数量
        int[] nums2 = {4, 5}; // 第二个数组
        int n = 2; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, nums1); // 验证合并结果
        
        System.out.println("无重叠 - 输入：nums1 = [1,2,3], m = " + m + ", nums2 = [4,5], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_AllOverlap() {
        // 两个数组完全重叠
        // nums1 = [1,1,1,0,0], m = 3, nums2 = [1,1], n = 2
        // 输出：[1,1,1,1,1]
        int[] nums1 = {1, 1, 1, 0, 0}; // 第一个数组
        int m = 3; // nums1 中有效元素数量
        int[] nums2 = {1, 1}; // 第二个数组
        int n = 2; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, nums1); // 验证合并结果
        
        System.out.println("全重叠 - 输入：nums1 = [1,1,1], m = " + m + ", nums2 = [1,1], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_NegativeNumbers() {
        // 包含负数
        // nums1 = [-3,-1,0,0,0], m = 3, nums2 = [-2,1], n = 2
        // 输出：[-3,-2,-1,0,1]
        int[] nums1 = {-3, -1, 0, 0, 0}; // 第一个数组（包含负数）
        int m = 3; // nums1 中有效元素数量
        int[] nums2 = {-2, 1}; // 第二个数组（包含负数）
        int n = 2; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{-3, -2, -1, 0, 1}, nums1); // 验证合并结果
        
        System.out.println("负数 - 输入：nums1 = [-3,-1,0], m = " + m + ", nums2 = [-2,1], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_LargeArrays() {
        // 较大数组测试
        // nums1 = [1,3,5,7,9,0,0,0,0,0], m = 5, nums2 = [2,4,6,8,10], n = 5
        // 输出：[1,2,3,4,5,6,7,8,9,10]
        int[] nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0}; // 第一个数组
        int m = 5; // nums1 中有效元素数量
        int[] nums2 = {2, 4, 6, 8, 10}; // 第二个数组
        int n = 5; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, nums1); // 验证合并结果
        
        System.out.println("大数组 - 输入：nums1 = [1,3,5,7,9], m = " + m + ", nums2 = [2,4,6,8,10], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_SingleElementEach() {
        // 每个数组只有一个元素
        // nums1 = [1,0], m = 1, nums2 = [2], n = 1
        // 输出：[1,2]
        int[] nums1 = {1, 0}; // 第一个数组
        int m = 1; // nums1 中有效元素数量
        int[] nums2 = {2}; // 第二个数组
        int n = 1; // nums2 中元素数量
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertArrayEquals(new int[]{1, 2}, nums1); // 验证合并结果
        
        System.out.println("单元素 - 输入：nums1 = [1], m = " + m + ", nums2 = [2], n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(nums1)); // 打印输出结果
    }

    @Test
    public void testMerge_MaximumSize() {
        // 最大尺寸测试：m + n = 200
        int m = 100; // nums1 中有效元素数量
        int n = 100; // nums2 中元素数量
        int[] nums1 = new int[m + n]; // 第一个数组
        int[] nums2 = new int[n]; // 第二个数组
        
        // 填充 nums1：1,3,5,...,199
        for (int i = 0; i < m; i++) {
            nums1[i] = 2 * i + 1;
        }
        
        // 填充 nums2：2,4,6,...,200
        for (int i = 0; i < n; i++) {
            nums2[i] = 2 * (i + 1);
        }
        
        solution.merge(nums1, m, nums2, n); // 调用方法合并数组
        
        assertNotNull(nums1); // 验证结果不为 null
        assertEquals(m + n, nums1.length); // 验证结果长度
        
        // 验证结果是有序的：1,2,3,4,...,200
        for (int i = 0; i < m + n; i++) {
            assertEquals(i + 1, nums1[i]); // 验证每个位置的值
        }
        
        System.out.println("最大尺寸 - 输入：m = " + m + ", n = " + n); // 打印输入信息
        System.out.println("输出：已验证为有序数组 [1,2,3,...,200]"); // 打印输出结果
    }
}
