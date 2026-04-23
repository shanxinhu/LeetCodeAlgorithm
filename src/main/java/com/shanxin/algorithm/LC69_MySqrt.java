package com.shanxin.algorithm;

public class LC69_MySqrt {

    /*
   https://leetcode.cn/problems/sqrtx/
   69. x 的平方根
            简单
            相关标签
            premium lock icon
            相关企业
            提示
            给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

            由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

            注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。



            示例 1：

            输入：x = 4
            输出：2
            示例 2：

            输入：x = 8
            输出：2
            解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。


            提示：

            0 <= x <= 231 - 1
     */



    /**
     * 牛顿迭代法求平方根的整数部分
     * 迭代公式：x = (x + a/x) / 2，初始值 x = a。
     * 当 x^2 <= a 时停止迭代，x 即为答案。
     * 使用 long 防止 x*x 在大数时溢出 int 范围。
     *
     * 时间复杂度：O(log x)，每次迭代近似将有效位数翻倍，收敛速度极快。
     * 空间复杂度：O(1)，仅使用常数级别的额外变量。
     */
    public int mySqrt(int a) {
        long x = a;
        // 迭代逼近：当 x^2 > a 时，用牛顿法更新 x
        while (x * x > a) x = (x + a / x) / 2;
        return (int) x;
    }

}
