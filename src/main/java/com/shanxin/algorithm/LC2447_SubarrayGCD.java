package com.shanxin.algorithm;

import com.shanxin.algorithm.common.Utils;

public class LC2447_SubarrayGCD {

    /*

        https://leetcode.cn/problems/number-of-subarrays-with-gcd-equal-to-k/description/
      2447. 最大公因数等于 K 的子数组数目
            中等
            相关标签
            premium lock icon
            相关企业
            提示
            给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的子数组中元素的最大公因数等于 k 的子数组数目。

            子数组 是数组中一个连续的非空序列。

            数组的最大公因数 是能整除数组中所有元素的最大整数。



            示例 1：

            输入：nums = [9,3,1,2,6,3], k = 3
            输出：4
            解释：nums 的子数组中，以 3 作为最大公因数的子数组如下：
            - [9,3,1,2,6,3]
            - [9,3,1,2,6,3]
            - [9,3,1,2,6,3]
            - [9,3,1,2,6,3]
            示例 2：

            输入：nums = [4], k = 7
            输出：0
            解释：不存在以 7 作为最大公因数的子数组。


            提示：

            1 <= nums.length <= 1000
            1 <= nums[i], k <= 109


     */


    public int subarrayGCD(int[] nums, int k) {
        // 统计最大公因数等于 k 的子数组数目
        // 时间复杂度：O(n^3 * log(max(nums)))，其中 n 是数组长度，三重循环，每次计算 GCD 的复杂度为 O(log(max(nums)))
        // 空间复杂度：O(1)，只使用了常数个额外变量
        
        // 初始化结果计数器
        int res = 0;
        // 遍历每个起始位置
        for (int i = 0; i < nums.length; i++){
            // 从起始位置扩展到结束位置
            for (int j = i; j < nums.length; j++){
                // 初始化当前子数组的 GCD 为起始元素
                int gcd = nums[i];
                // 遍历子数组 [i,j] 的所有元素
                for (int m = i; m <= j; m++){
                    // 更新当前子数组的最大公因数
                    gcd = Utils.gcd(gcd, nums[m]);
                }
                // 如果当前 GCD 等于 k
                if (gcd == k){
                    // 计数器加 1
                    res++;
                }
            }
        }
        // 返回满足条件的子数组数目
        return res;
    }

}
