package com.shanxin.algorithm;

import java.util.ArrayList;
import java.util.List;

public class LC3697_DecimalRepresentation {

    /*

       https://leetcode.cn/problems/compute-decimal-representation/
      3697. 计算十进制表示
        简单
        相关标签
        premium lock icon
        相关企业
        提示
        给你一个 正整数 n。

        如果一个正整数可以表示为 1 到 9 的单个数字和 10 的非负整数次幂的乘积，则称这个整数是一个 10 进制分量。例如，500、30 和 7 是 10 进制分量 ，而 537、102 和 11 则不是。

        请将 n 表示为若干 仅由 10 进制分量组成的和，且使用的 10 进制分量个数 最少 。

        返回一个包含这些 10 进制分量 的数组，并按分量大小 降序 排列。



        示例 1：

        输入：n = 537

        输出：[500,30,7]

        解释：

        我们可以将 537 表示为500 + 30 + 7。无法用少于 3 个 10 进制分量表示 537。

        示例 2：

        输入：n = 102

        输出：[100,2]

        解释：

        我们可以将 102 表示为100 + 2。102 不是一个 10 进制分量，因此需要 2 个 10 进制分量。

        示例 3：

        输入：n = 6

        输出：[6]

        解释：

        6 是一个 10 进制分量。



        提示：

        1 <= n <= 109


     */


    public int[] decimalRepresentation(int n) { // 将正整数分解为最少数量的十进制分量
        // 时间复杂度：O(log n)，其中 log n 是数字 n 的位数
        // 空间复杂度：O(log n)，存储分解后的十进制分量
        List<Integer> factors = new ArrayList<>(); // 创建列表存储十进制分量
        int multiplier = 1; // 初始化位权值为 1（个位）
        while (n > 0) { // 当 n 大于 0 时继续分解
            int digit = n % 10; // 提取当前最低位数字
            if (digit != 0) { // 如果当前位数字不为 0
                factors.add(digit * multiplier); // 添加十进制分量（数字 * 位权）
            }
            n /= 10; // 去掉最低位
            multiplier *= 10; // 位权值乘以 10（进位）
        }
        int[] result = new int[factors.size()]; // 创建结果数组
        for (int i = 0; i < factors.size(); i++) { // 反转列表（从大到小排序）
            result[i] = factors.get(factors.size() - 1 - i); // 逆序填充结果数组
        }
        return result; // 返回按降序排列的十进制分量数组
    }
}
