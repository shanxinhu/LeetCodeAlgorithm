package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LC26_RemoveDuplicatesTest {

    private final LC26_RemoveDuplicates solution = new LC26_RemoveDuplicates();

    @Test
    public void testRemoveDuplicates_Example1() {
        // 示例 1：nums = [1,1,2] → 2, nums前两个为 [1,2]
        int[] nums = {1, 1, 2};
        int k = solution.removeDuplicates(nums);

        assertEquals(2, k);
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, k));

        System.out.println("示例 1 - 输入：[1,1,2]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveDuplicates_Example2() {
        // 示例 2：nums = [0,0,1,1,1,2,2,3,3,4] → 5, nums前5个为 [0,1,2,3,4]
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = solution.removeDuplicates(nums);

        assertEquals(5, k);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4}, Arrays.copyOf(nums, k));

        System.out.println("示例 2 - 输入：[0,0,1,1,1,2,2,3,3,4]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveDuplicates_NoDuplicates() {
        // 无重复元素：nums = [1,2,3,4,5] → 5
        int[] nums = {1, 2, 3, 4, 5};
        int k = solution.removeDuplicates(nums);

        assertEquals(5, k);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Arrays.copyOf(nums, k));

        System.out.println("无重复 - 输入：[1,2,3,4,5]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveDuplicates_AllSame() {
        // 全部相同：nums = [3,3,3,3] → 1
        int[] nums = {3, 3, 3, 3};
        int k = solution.removeDuplicates(nums);

        assertEquals(1, k);
        assertArrayEquals(new int[]{3}, Arrays.copyOf(nums, k));

        System.out.println("全相同 - 输入：[3,3,3,3]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveDuplicates_NegativeValues() {
        // 包含负数：nums = [-3,-3,-1,0,0,2] → 4, nums前4个为 [-3,-1,0,2]
        int[] nums = {-3, -3, -1, 0, 0, 2};
        int k = solution.removeDuplicates(nums);

        assertEquals(4, k);
        assertArrayEquals(new int[]{-3, -1, 0, 2}, Arrays.copyOf(nums, k));

        System.out.println("含负数 - 输入：[-3,-3,-1,0,0,2]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveDuplicates_TwoElements() {
        // 两个不同元素：nums = [1,2] → 2
        int[] nums = {1, 2};
        int k = solution.removeDuplicates(nums);

        assertEquals(2, k);
        assertArrayEquals(new int[]{1, 2}, Arrays.copyOf(nums, k));

        System.out.println("两元素 - 输入：[1,2]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveDuplicates_TwoSameElements() {
        // 两个相同元素：nums = [5,5] → 1
        int[] nums = {5, 5};
        int k = solution.removeDuplicates(nums);

        assertEquals(1, k);
        assertArrayEquals(new int[]{5}, Arrays.copyOf(nums, k));

        System.out.println("两相同 - 输入：[5,5]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveDuplicates_AlternatingDuplicates() {
        // 交替重复：nums = [1,1,2,2,3,3,4,4] → 4, nums前4个为 [1,2,3,4]
        int[] nums = {1, 1, 2, 2, 3, 3, 4, 4};
        int k = solution.removeDuplicates(nums);

        assertEquals(4, k);
        assertArrayEquals(new int[]{1, 2, 3, 4}, Arrays.copyOf(nums, k));

        System.out.println("交替重复 - 输入：[1,1,2,2,3,3,4,4]");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
