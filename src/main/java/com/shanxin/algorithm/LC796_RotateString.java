package com.shanxin.algorithm;


public class LC796_RotateString {

    /*
     https://leetcode.cn/problems/rotate-string/description/
          796. 旋转字符串
            简单
            相关标签
            premium lock icon
            相关企业
            给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
            s 的 旋转操作 就是将 s 最左边的字符移动到最右边。

            例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。

            示例 1:
            输入: s = "abcde", goal = "cdeab"
            输出: true

            示例 2:
            输入: s = "abcde", goal = "abced"
            输出: false


            提示:
            1 <= s.length, goal.length <= 100
            s 和 goal 由小写英文字母组成
     */

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        return kmpSearch(s + s, goal);
    }

    /**
     * KMP 算法实现字符串匹配，时间复杂度 O(n)
     */
    private boolean kmpSearch(String text, String pattern) {
        if (pattern.isEmpty()) return true;
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return true;
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    /**
     * 计算最长公共前后缀数组 (LPS)
     */
    private int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else {
                len = len > 0 ? lps[len - 1] : i++;
            }
        }
        return lps;
    }
}
