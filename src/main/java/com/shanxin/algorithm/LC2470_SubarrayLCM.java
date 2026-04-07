package com.shanxin.algorithm;

import com.shanxin.algorithm.common.Utils;
import com.shanxin.algorithm.node.Node;

public class LC2470_SubarrayLCM {

    /*

        https://leetcode.cn/problems/number-of-subarrays-with-lcm-equal-to-k/
        2470. 最小公倍数等于 K 的子数组数目
        中等
        相关标签
        premium lock icon
        相关企业
        提示
        给你一个整数数组 nums 和一个整数 k ，请你统计并返回 nums 的 子数组 中满足 元素最小公倍数为 k 的子数组数目。

        子数组 是数组中一个连续非空的元素序列。

        数组的最小公倍数 是可被所有数组元素整除的最小正整数。



        示例 1 ：

        输入：nums = [3,6,2,7,1], k = 6
        输出：4
        解释：以 6 为最小公倍数的子数组是：
        - [3,6,2,7,1]
        - [3,6,2,7,1]
        - [3,6,2,7,1]
        - [3,6,2,7,1]
        示例 2 ：

        输入：nums = [3], k = 2
        输出：0
        解释：不存在以 2 为最小公倍数的子数组。


        提示：

        1 <= nums.length <= 1000
        1 <= nums[i], k <= 1000
     */


    public int subarrayLCM(int[] nums, int k) {
        // 统计最小公倍数等于 k 的子数组数目
        // 时间复杂度：O(n^2 * log(max(nums)))，其中 n 是数组长度，log(max(nums)) 是计算 GCD 的复杂度
        // 空间复杂度：O(1)，只使用了常数个额外变量
        
        // 初始化结果计数器
        int res = 0;
        // 遍历每个起始位置
        for (int i = 0; i < nums.length; i++) {
            // 初始化当前子数组的 LCM 为起始元素
            int lcm = nums[i];
            // 从起始位置扩展到结束位置
            for (int j = i; j < nums.length; j++) {
                // 更新当前子数组 [i,j] 的最小公倍数
                lcm = Utils.lcm(lcm, nums[j]);
                // 如果当前 LCM 等于 k
                if (lcm == k) {
                    // 计数器加 1
                    res++;
                }
            }
        }
        // 返回满足条件的子数组数目
        return res;
    }
    

    

}
