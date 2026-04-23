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


    /**
     * 计算 KMP 算法中的 next（前缀表）数组
     * next[i] 表示 pattern[0..i] 子串中，最长相等前后缀的长度
     *
     * 时间复杂度：O(m)，其中 m 为模式串长度，每个字符最多被回退比较一次
     * 空间复杂度：O(m)，存储 next 数组
     *
     * @param pattern 模式串
     * @return next 前缀表数组
     */
    public static int[] getNext(String pattern) {
        int m = pattern.length();
        int[] next = new int[m];
        int j = 0; // j：当前最长前缀末尾的下标（即最长相等前后缀长度）
        int i = 1; // i：后缀末尾的下标，从 1 开始（单字符无前后缀）

        next[0] = 0; // 单字符的最长相等前后缀长度为 0
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                // 前后缀匹配，最长前后缀长度 +1
                j++;
                next[i] = j;
                i++;
            } else {
                if (j == 0) {
                    // 无法回退，当前字符的最长相等前后缀长度为 0
                    next[i] = 0;
                    i++;
                } else {
                    // 失配时回退到前一个最长前缀位置
                    j = next[j - 1];
                }
            }
        }
        return next;
    }


}
