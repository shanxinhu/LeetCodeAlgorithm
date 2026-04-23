package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC35_SearchInsertTest {

    private final LC35_SearchInsert solution = new LC35_SearchInsert();

    @Test
    public void testSearchInsert_Example1() {
        // 示例 1：nums = [1,3,5,6], target = 5 → 2
        int[] nums = {1, 3, 5, 6};

        assertEquals(2, solution.searchInsert(nums, 5));

        System.out.println("示例 1 - 输入：[1,3,5,6], target=5 → 输出：" + solution.searchInsert(nums, 5));
    }

    @Test
    public void testSearchInsert_Example2() {
        // 示例 2：nums = [1,3,5,6], target = 2 → 1
        int[] nums = {1, 3, 5, 6};

        assertEquals(1, solution.searchInsert(nums, 2));

        System.out.println("示例 2 - 输入：[1,3,5,6], target=2 → 输出：" + solution.searchInsert(nums, 2));
    }

    @Test
    public void testSearchInsert_Example3() {
        // 示例 3：nums = [1,3,5,6], target = 7 → 4
        int[] nums = {1, 3, 5, 6};

        assertEquals(4, solution.searchInsert(nums, 7));

        System.out.println("示例 3 - 输入：[1,3,5,6], target=7 → 输出：" + solution.searchInsert(nums, 7));
    }

    @Test
    public void testSearchInsert_InsertAtHead() {
        // 插入到头部：nums = [1,3,5,6], target = 0 → 0
        int[] nums = {1, 3, 5, 6};

        assertEquals(0, solution.searchInsert(nums, 0));

        System.out.println("插入头部 - 输入：[1,3,5,6], target=0 → 输出：" + solution.searchInsert(nums, 0));
    }

    @Test
    public void testSearchInsert_SingleElement() {
        // 单元素：nums = [1], target = 1 → 0
        int[] nums = {1};

        assertEquals(0, solution.searchInsert(nums, 1));

        System.out.println("单元素命中 - 输入：[1], target=1 → 输出：" + solution.searchInsert(nums, 1));
    }

    @Test
    public void testSearchInsert_SingleElementInsertAfter() {
        // 单元素插入后面：nums = [1], target = 2 → 1
        int[] nums = {1};

        assertEquals(1, solution.searchInsert(nums, 2));

        System.out.println("单元素插入后 - 输入：[1], target=2 → 输出：" + solution.searchInsert(nums, 2));
    }

    @Test
    public void testSearchInsert_NegativeValues() {
        // 包含负数：nums = [-5,-3,0,2,4], target = -4 → 1
        int[] nums = {-5, -3, 0, 2, 4};

        assertEquals(1, solution.searchInsert(nums, -4));

        System.out.println("含负数 - 输入：[-5,-3,0,2,4], target=-4 → 输出：" + solution.searchInsert(nums, -4));
    }

    @Test
    public void testSearchInsert_FindFirst() {
        // 查找第一个元素：nums = [1,3,5,6], target = 1 → 0
        int[] nums = {1, 3, 5, 6};

        assertEquals(0, solution.searchInsert(nums, 1));

        System.out.println("查找首个 - 输入：[1,3,5,6], target=1 → 输出：" + solution.searchInsert(nums, 1));
    }

    @Test
    public void testSearchInsert_FindLast() {
        // 查找最后一个元素：nums = [1,3,5,6], target = 6 → 3
        int[] nums = {1, 3, 5, 6};

        assertEquals(3, solution.searchInsert(nums, 6));

        System.out.println("查找末尾 - 输入：[1,3,5,6], target=6 → 输出：" + solution.searchInsert(nums, 6));
    }
}
