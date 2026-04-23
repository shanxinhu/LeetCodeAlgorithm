package com.shanxin.algorithm;

import com.shanxin.algorithm.common.Utils;

public class LC28_StrStr {

    /*

      https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
        28. 找出字符串中第一个匹配项的下标
            简单
            相关标签
            premium lock icon
            相关企业
            给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。



            示例 1：

            输入：haystack = "sadbutsad", needle = "sad"
            输出：0
            解释："sad" 在下标 0 和 6 处匹配。
            第一个匹配项的下标是 0 ，所以返回 0 。
            示例 2：

            输入：haystack = "leetcode", needle = "leeto"
            输出：-1
            解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。


            提示：

            1 <= haystack.length, needle.length <= 104
            haystack 和 needle 仅由小写英文字符组成

   */


    /**
     * KMP 算法在 haystack 中查找 needle 第一次出现的位置
     * 先用 getNext 计算 needle 的前缀表，再用双指针匹配：
     * i 遍历 haystack，j 跟踪 needle 中已匹配的字符数，
     * 失配时利用前缀表回退 j，避免重复比较。
     *
     * 时间复杂度：O(n + m)，其中 n 为 haystack 长度，m 为 needle 长度。
     *             构建前缀表 O(m)，匹配过程 O(n)。
     * 空间复杂度：O(m)，存储前缀表数组。
     */
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.isEmpty() || needle.isEmpty()) {
            return -1;
        }

        int[] next = Utils.getNext(needle); // 构建前缀表

        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        // i 遍历 haystack，j 跟踪 needle 中已匹配的长度
        for (int i = 0, j = 0; i < haystackChars.length; i++) {
            // 失配时，根据前缀表回退 j 到上一个可能匹配的位置
            while (j > 0 && haystackChars[i] != needleChars[j]) {
                j = next[j - 1];
            }
            // 当前字符匹配，j 前进一步
            if (haystackChars[i] == needleChars[j]) {
                j++;
            }
            // j 达到 needle 长度，说明完全匹配
            if (j == needleChars.length) {
                return i - j + 1;
            }
        }

        return -1;
    }
}
