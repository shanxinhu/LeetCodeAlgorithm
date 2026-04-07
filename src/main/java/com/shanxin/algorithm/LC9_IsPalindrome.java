package com.shanxin.algorithm;

import java.util.ArrayList;

public class LC9_IsPalindrome {

    /*

        https://leetcode.cn/problems/palindrome-number/
        9. 回文数
            简单
            相关标签
            premium lock icon
            相关企业
            提示
            给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。

            回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

            例如，121 是回文，而 123 不是。


            示例 1：

            输入：x = 121
            输出：true
            示例 2：

            输入：x = -121
            输出：false
            解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
            示例 3：

            输入：x = 10
            输出：false
            解释：从右向左读, 为 01 。因此它不是一个回文数。


            提示：

            -231 <= x <= 231 - 1


            进阶：你能不将整数转为字符串来解决这个问题吗？
     */


    public boolean isPalindrome(int x) {
        // 判断整数是否为回文数（不使用字符串转换）
        // 时间复杂度：O(log n)，其中 n 是输入值，需要处理数字的每一位
        // 空间复杂度：O(1)，只使用了常数个额外变量

        // 如果 x 是负数，或者 x 以 0 结尾但不是 0 本身，则不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // 初始化反转后的数字
        int revertedNumber = 0;
        // 当原始数字大于反转数字时继续循环（处理到一半位置）
        while (x > revertedNumber) {
            // 将当前位添加到反转数字的末尾
            revertedNumber = revertedNumber * 10 + x % 10;
            // 去掉原始数字的最后一位
            x /= 10;
        }
        // 如果数字长度为偶数，x 应该等于 revertedNumber
        // 如果数字长度为奇数，x 应该等于 revertedNumber / 10（去掉中间位）
        return x == revertedNumber || x == revertedNumber / 10;
    }

}
