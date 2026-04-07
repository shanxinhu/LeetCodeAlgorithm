package com.shanxin.algorithm;

import java.util.Arrays;

import static com.shanxin.algorithm.Constant.MOD;

public class LC3251_CountOfPairs {

    /*

     https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-ii/
   3251. 单调数组对的数目 II
        困难

        给你一个长度为 n 的 正 整数数组 nums 。

        如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对：

        两个数组的长度都是 n 。
        arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。
        arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。
        对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。
        请你返回所有 单调 数组对的数目。

        由于答案可能很大，请你将它对 109 + 7 取余 后返回。

        示例 1：

        输入：nums = [2,3,2]

        输出：4

        解释：

        单调数组对包括：

        ([0, 1, 1], [2, 2, 1])
        ([0, 1, 2], [2, 2, 0])
        ([0, 2, 2], [2, 1, 0])
        ([1, 2, 2], [1, 1, 0])
        示例 2：

        输入：nums = [5,5,5,5]

        输出：126



        提示：

        1 <= n == nums.length <= 2000
        1 <= nums[i] <= 1000
     */


    /**
     * 计算所有单调数组对的数目
     * 使用动态规划 + 前缀和优化
     * 
     * @param nums 长度为 n 的正整数数组
     * @return 单调数组对的数目，对 10^9 + 7 取余
     */
    public int countOfPairs(int[] nums) {


        // 获取数组 nums 的长度
        int n = nums.length;
            
        // m 表示最后一个位置 arr2[i] 可能的最大值（即 nums[n-1]）
        // 因为 arr1[i] >= 0，所以 arr2[i] <= nums[i]
        int m = nums[n - 1];
            
        // f[j] 表示当前位置 arr2[i] = j 时的方案数
        // 数组大小为 m+1，因为 arr2[i] 的取值范围是 [0, nums[i]]
        int[] f = new int[m + 1];
            
        // 初始化第一个位置的 f 数组
        // 对于 i=0，arr1[0] 可以取 [0, nums[0]] 的任意值
        // 对应的 arr2[0] = nums[0] - arr1[0]，也可以取 [0, nums[0]]
        // 但不超过 m，所以用 Math.min(nums[0], m)
        // 将 f[0] 到 f[min(nums[0], m)] 都初始化为 1
        Arrays.fill(f, 0, Math.min(nums[0], m) + 1, 1);
    
        // 从第二个位置开始动态规划
        for (int i = 1; i < n; i++) {
            // 计算 j0：arr2[i] 的最小可能值
            // 由于 arr2 非递增，arr2[i] <= arr2[i-1]
            // 由于 arr1 非递减，arr1[i] >= arr1[i-1]
            // 由 arr1[i] + arr2[i] = nums[i] 和 arr1[i-1] + arr2[i-1] = nums[i-1]
            // 可得：arr2[i] >= nums[i] - nums[i-1]
            // 同时 arr2[i] >= 0，所以取 max(nums[i] - nums[i-1], 0)
            int j0 = Math.max(nums[i] - nums[i - 1], 0);
                
            // m2 表示当前位置 arr2[i] 的最大可能值
            // arr2[i] <= nums[i]（因为 arr1[i] >= 0）
            // 且不能超过之前定义的最大值 m
            int m2 = Math.min(nums[i], m);
                
            // 如果最小值大于最大值，说明无解，直接返回 0
            if (j0 > m2) {
                return 0;
            }
                
            // 使用前缀和优化计算新的 f 数组
            // 对于新的位置 i，arr2[i] = j 时：
            // arr2[i-1] 可以取 [j, m2] 的任意值（因为 arr2 非递增）
            // 所以 f_new[j] = sum(f_old[k])，其中 k >= j
            // 通过原地计算前缀和：f[j] = f[j] + f[j-1]
            for (int j = 1; j <= m2 - j0; j++) {
                f[j] = (f[j] + f[j - 1]) % MOD; // 计算前缀和
            }
                
            // 将计算好的前缀和向后移动 j0 位
            // 因为 arr2[i] 的最小值是 j0，所以 f[j0...m2-j0] 对应原来的 f[0...m2-j0]
            System.arraycopy(f, 0, f, j0, m2 - j0 + 1);
                
            // 将 j0 之前的位置填充为 0
            // 因为这些位置的 arr2[i] < j0，不满足约束条件
            Arrays.fill(f, 0, j0, 0);
        }
    
        // 统计最终结果的总方案数
        // 将所有可能的 arr2[n-1] 取值对应的方案数累加
        long ans = 0;
        for (int v : f) {
            ans += v;
        }
            
        // 返回结果并对 MOD 取余
        return (int) (ans % MOD);
    
     
    }
}
