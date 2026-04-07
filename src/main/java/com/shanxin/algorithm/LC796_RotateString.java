package com.shanxin.algorithm; // 定义包名

// 旋转字符串解决方案类
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

    public boolean rotateString(String s, String goal) { // 定义公共方法 rotateString，接收两个字符串参数
        // 首先检查两个字符串长度是否相等，不相等则直接返回 false
        if (s.length() != goal.length()) { // 判断 s 的长度是否不等于 goal 的长度
            return false; // 长度不等，直接返回 false
        }
        // 将 s 与自身拼接，这样所有可能的旋转结果都会成为拼接后字符串的子串
        // 然后使用 KMP 算法检查 goal 是否是 s+s 的子串
        return kmpSearch(s + s, goal); // 调用 KMP 搜索方法，在 s+s 中查找 goal
    }

    /**
     * KMP 算法实现字符串匹配，时间复杂度 O(n)
     */
    private boolean kmpSearch(String text, String pattern) { // 定义私有方法 kmpSearch，使用 KMP 算法进行字符串匹配
        // 如果模式串为空，直接返回 true（空串是任何字符串的子串）
        if (pattern.isEmpty()) return true; // 处理空模式串的特殊情况
        // 计算模式串的 LPS（最长公共前后缀）数组
        int[] lps = computeLPS(pattern); // 调用 computeLPS 方法获取 LPS 数组
        // 初始化两个指针：i 指向文本串，j 指向模式串
        int i = 0, j = 0; // i 是 text 的索引，j 是 pattern 的索引
        // 当 i 小于文本串长度时继续循环
        while (i < text.length()) { // 遍历文本串
            // 如果当前字符匹配成功
            if (text.charAt(i) == pattern.charAt(j)) { // 比较 text[i] 和 pattern[j] 是否相等
                // 两个指针都向前移动
                i++; // text 索引后移
                j++; // pattern 索引后移
                // 如果 j 达到了模式串的长度，说明完全匹配
                if (j == pattern.length()) return true; // pattern 全部匹配完成，返回 true
            } else {
                // 如果字符不匹配
                if (j > 0) { // 如果 j 大于 0，说明已经有部分匹配
                    // 利用 LPS 数组回退 j 到前一个可能匹配的位置
                    j = lps[j - 1]; // 根据 LPS 数组回退 pattern 的索引
                } else {
                    // 如果 j 已经是 0，说明从当前位置无法匹配，i 向后移动
                    i++; // text 索引后移，从下一个位置重新开始匹配
                }
            }
        }
        // 如果循环结束仍未找到匹配，返回 false
        return false; // 未找到匹配的子串，返回 false
    }

    /**
     * 计算最长公共前后缀数组 (LPS)
     */
    private int[] computeLPS(String pattern) { // 定义私有方法 computeLPS，计算 LPS 数组
        // 创建 LPS 数组，长度等于模式串长度
        int[] lps = new int[pattern.length()]; // 初始化 LPS 数组
        // len 记录当前最长公共前后缀的长度，初始为 0
        int len = 0; // len 表示前一个位置的 LPS 值
        // i 从 1 开始遍历模式串（lps[0] 始终为 0）
        int i = 1; // i 是当前要计算 LPS 值的位置
        // 当 i 小于模式串长度时继续循环
        while (i < pattern.length()) { // 遍历 pattern 的每个位置
            // 如果 pattern[i] 和 pattern[len] 相等
            if (pattern.charAt(i) == pattern.charAt(len)) { // 比较 pattern[i] 和 pattern[len]
                // 说明可以扩展当前的公共前后缀
                len++; // 最长公共前后缀长度加 1
                lps[i] = len; // 将当前位置的 LPS 值设为 len
                i++; // 移动到下一个位置
            } else {
                // 如果不相等
                if (len > 0) { // 如果 len 大于 0
                    // 回退 len 到前一个 LPS 值对应的位置
                    len = lps[len - 1]; // 根据 LPS 数组回退 len
                } else {
                    // 如果 len 已经是 0，说明当前位置没有公共前后缀
                    lps[i] = 0; // 当前位置的 LPS 值为 0
                    i++; // 移动到下一个位置
                }
            }
        }
        // 返回计算好的 LPS 数组
        return lps; // 返回完整的 LPS 数组
    }
}
