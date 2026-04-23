package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LC27_RemoveElementTest {

    private final LC27_RemoveElement solution = new LC27_RemoveElement();

    @Test
    public void testRemoveElement_Example1() {
        // 示例 1：nums = [3,2,2,3], val = 3 → 2, nums前2个为 [2,2]
        int[] nums = {3, 2, 2, 3};
        int k = solution.removeElement(nums, 3);

        assertEquals(2, k);
        assertArrayEquals(new int[]{2, 2}, Arrays.copyOf(nums, k));

        System.out.println("示例 1 - 输入：[3,2,2,3], val=3");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveElement_Example2() {
        // 示例 2：nums = [0,1,2,2,3,0,4,2], val = 2 → 5, nums前5个不含2
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int k = solution.removeElement(nums, 2);

        assertEquals(5, k);
        // 前5个元素中不应包含 val=2
        for (int i = 0; i < k; i++) {
            assertNotEquals(2, nums[i]);
        }

        System.out.println("示例 2 - 输入：[0,1,2,2,3,0,4,2], val=2");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveElement_EmptyArray() {
        // 空数组：nums = [], val = 1 → 0
        int[] nums = {};
        int k = solution.removeElement(nums, 1);

        assertEquals(0, k);

        System.out.println("空数组 - 输入：[], val=1");
        System.out.println("输出：k=0");
    }

    @Test
    public void testRemoveElement_NoMatch() {
        // 没有要移除的元素：nums = [1,2,3], val = 4 → 3
        int[] nums = {1, 2, 3};
        int k = solution.removeElement(nums, 4);

        assertEquals(3, k);
        assertArrayEquals(new int[]{1, 2, 3}, Arrays.copyOf(nums, k));

        System.out.println("无匹配 - 输入：[1,2,3], val=4");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveElement_AllMatch() {
        // 全部要移除：nums = [3,3,3], val = 3 → 0
        int[] nums = {3, 3, 3};
        int k = solution.removeElement(nums, 3);

        assertEquals(0, k);

        System.out.println("全匹配 - 输入：[3,3,3], val=3");
        System.out.println("输出：k=0");
    }

    @Test
    public void testRemoveElement_SingleElement() {
        // 单个元素且匹配：nums = [1], val = 1 → 0
        int[] nums = {1};
        int k = solution.removeElement(nums, 1);

        assertEquals(0, k);

        System.out.println("单元素匹配 - 输入：[1], val=1");
        System.out.println("输出：k=0");
    }

    @Test
    public void testRemoveElement_SingleElementNoMatch() {
        // 单个元素且不匹配：nums = [1], val = 2 → 1
        int[] nums = {1};
        int k = solution.removeElement(nums, 2);

        assertEquals(1, k);
        assertArrayEquals(new int[]{1}, Arrays.copyOf(nums, k));

        System.out.println("单元素不匹配 - 输入：[1], val=2");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }

    @Test
    public void testRemoveElement_AllZero() {
        // 全是零且移除零：nums = [0,0,0,0], val = 0 → 0
        int[] nums = {0, 0, 0, 0};
        int k = solution.removeElement(nums, 0);

        assertEquals(0, k);

        System.out.println("全零移除零 - 输入：[0,0,0,0], val=0");
        System.out.println("输出：k=0");
    }

    @Test
    public void testRemoveElement_RemoveZero() {
        // nums = [0,1,0,3,12], val = 0 → 3, nums前3个不含0
        int[] nums = {0, 1, 0, 3, 12};
        int k = solution.removeElement(nums, 0);

        assertEquals(3, k);
        for (int i = 0; i < k; i++) {
            assertNotEquals(0, nums[i]);
        }

        System.out.println("移除零 - 输入：[0,1,0,3,12], val=0");
        System.out.println("输出：k=" + k + ", nums前" + k + "个：" + Arrays.toString(Arrays.copyOf(nums, k)));
    }
}
