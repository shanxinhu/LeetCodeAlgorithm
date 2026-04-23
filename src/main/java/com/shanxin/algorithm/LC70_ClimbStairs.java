package com.shanxin.algorithm;

public class LC70_ClimbStairs {

    /*
  https://leetcode.cn/problems/climbing-stairs/
       70. 爬楼梯
        简单
        相关标签
        premium lock icon
        相关企业
        提示
        假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？



        示例 1：

        输入：n = 2
        输出：2
        解释：有两种方法可以爬到楼顶。
        1. 1 阶 + 1 阶
        2. 2 阶
        示例 2：

        输入：n = 3
        输出：3
        解释：有三种方法可以爬到楼顶。
        1. 1 阶 + 1 阶 + 1 阶
        2. 1 阶 + 2 阶
        3. 2 阶 + 1 阶

     */




    /**
     * 递归求解爬楼梯（斐波那契数列）
     * 到达第 n 阶的方法数 = 从第 n-1 阶跨 1 步 + 从第 n-2 阶跨 2 步。
     *
     * 时间复杂度：O(2^n)，每个调用分裂为两个子调用，存在大量重复计算。
     *             注意：n > 40 时会明显变慢，生产环境建议用动态规划 O(n) 优化。
     * 空间复杂度：O(n)，递归调用栈的最大深度。
     */
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 迭代滚动变量求解爬楼梯（动态规划空间优化版）
     * 用 a、b 两个变量滚动保存前两个状态，避免递归的重复计算。
     * a = f(i-2)，b = f(i-1)，每次迭代更新为 a = f(i-1)，b = f(i)。
     *
     * 时间复杂度：O(n)，单次遍历 1 到 n-1，无重复计算。
     * 空间复杂度：O(1)，仅使用 a、b、sum 三个变量。
     */
    public int climbStairs2(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n - 1; i++) {
            sum = a + b; // f(i) = f(i-1) + f(i-2)
            a = b;       // a 后移，变为 f(i-1)
            b = sum;     // b 后移，变为 f(i)
        }
        return b;
    }

}
