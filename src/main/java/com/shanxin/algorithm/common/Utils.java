package com.shanxin.algorithm.common;

public class Utils {

    // 计算两个数的最大公约数（欧几里得算法）
    // 递归计算：GCD(a,b) = GCD(b, a%b)，直到 b=0
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    // 计算两个数的最小公倍数


    public static int lcm(int a, int b) {
        // 利用公式：LCM(a,b) = a*b / GCD(a,b)
        return a * b / gcd(a, b);
    }

}
