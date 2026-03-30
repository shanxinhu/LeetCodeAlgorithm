package com.shanxin.algorithm;


import java.util.LinkedList;
import java.util.Queue;

public class LC4_FindMedianSortedArrays {

    /*

        https://leetcode.cn/problems/median-of-two-sorted-arrays/
        4. 寻找两个正序数组的中位数    困难

        给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

        算法的时间复杂度应该为 O(log (m+n)) 。


        示例 1：

        输入：nums1 = [1,3], nums2 = [2]
        输出：2.00000
        解释：合并数组 = [1,2,3] ，中位数 2
        示例 2：

        输入：nums1 = [1,2], nums2 = [3,4]
        输出：2.50000
        解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5




        提示：

        nums1.length == m
        nums2.length == n
        0 <= m <= 1000
        0 <= n <= 1000
        1 <= m + n <= 2000
        -106 <= nums1[i], nums2[i] <= 106
     */


    /**
     * 寻找两个正序数组的中位数
     * @param nums1 第一个正序数组
     * @param nums2 第二个正序数组
     * @return 两个数组合并后的中位数
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 获取两个数组的长度
        int m = nums1.length, n = nums2.length;
        // 计算左中位数的位置（向上取整）
        int l = (m + n + 1) / 2;
        // 计算右中位数的位置（向下取整）
        int r = (m + n + 2) / 2;
        // 找到第 l 小和第 r 小的数，求平均值作为中位数
        return (findKth(nums1, 0, nums2, 0, l) + findKth(nums1, 0, nums2, 0, r)) / 2.0;
    }

    /**
     * 在两个有序数组中找到第 k 小的数
     * @param a 第一个数组
     * @param i 第一个数组的起始索引
     * @param b 第二个数组
     * @param j 第二个数组的起始索引
     * @param k 要找的第 k 小的数
     * @return 第 k 小的数
     */
    private int findKth(int[] a, int i, int[] b, int j, int k) {
        // 如果数组 a 已经遍历完，直接返回数组 b 中的第 k 个数
        if (i >= a.length) return b[j + k - 1];
        // 如果数组 b 已经遍历完，直接返回数组 a 中的第 k 个数
        if (j >= b.length) return a[i + k - 1];
        // 如果只需要找第 1 小的数，返回两个数组当前元素的最小值
        if (k == 1) return Math.min(a[i], b[j]);

        // 计算数组 a 中第 k/2 个元素的值（如果超出范围则设为最大值）
        int midA = i + k/2 - 1 < a.length ? a[i + k/2 - 1] : Integer.MAX_VALUE;
        // 计算数组 b 中第 k/2 个元素的值（如果超出范围则设为最大值）
        int midB = j + k/2 - 1 < b.length ? b[j + k/2 - 1] : Integer.MAX_VALUE;

        // 如果数组 a 的中间元素较小，说明第 k 小的数不可能在 a 的前 k/2 个元素中
        if (midA < midB) {
            // 舍弃数组 a 的前 k/2 个元素，继续在剩余部分找第 k-k/2 小的数
            return findKth(a, i + k/2, b, j, k - k/2);
        } else {
            // 否则舍弃数组 b 的前 k/2 个元素，继续在剩余部分找第 k-k/2 小的数
            return findKth(a, i, b, j + k/2, k - k/2);
        }
    }
}
