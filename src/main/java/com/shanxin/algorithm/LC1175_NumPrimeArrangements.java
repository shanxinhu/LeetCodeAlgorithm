package com.shanxin.algorithm;


import static com.shanxin.algorithm.common.Constant.MOD;

public class LC1175_NumPrimeArrangements {

    /*
     https://leetcode.cn/problems/prime-arrangements/
        1175. 质数排列
        简单
        相关标签
        premium lock icon
        相关企业
        提示
        请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
        让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
        由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。


        示例 1：

        输入：n = 5
        输出：12
        解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，
        因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
        示例 2：

        输入：n = 100
        输出：682289015


        提示：

        1 <= n <= 100
     */

    public int numPrimeArrangements(int n) {
        //「所有质数都放在质数索引上的方案数」×「所有合数都放在合数索引上的方案数」
        int numPrimes = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                numPrimes++;
            }
        }
        return (int) (factorial(numPrimes) * factorial(n - numPrimes) % MOD);
    }


    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            res %= MOD;
        }
        return res;
    }
}
