package com.shanxin.algorithm;

public class LC5_LongestPalindrome {

    /*

        https://leetcode.cn/problems/longest-palindromic-substring/description/
      5. 最长回文子串
        中等
        相关标签
        premium lock icon
        相关企业
        提示
        给你一个字符串 s，找到 s 中最长的 回文 子串。


        示例 1：

        输入：s = "babad"
        输出："bab"
        解释："aba" 同样是符合题意的答案。
        示例 2：

        输入：s = "cbbd"
        输出："bb"


        提示：

        1 <= s.length <= 1000
        s 仅由数字和英文字母组成
     */


    /**
     * 找到字符串中最长的回文子串
     * 使用中心扩展法：遍历每个字符作为中心，向两边扩展寻找回文
     *
     * @param s 输入字符串
     * @return 最长回文子串
     */
    public String longestPalindrome(String s) {
        // 处理边界情况：如果字符串为空或 null，直接返回空字符串
        if (s == null || s.isEmpty()) return "";

        // 获取字符串长度
        int strLen = s.length();
        // 记录最长回文子串的长度，初始值为 1（单个字符也是回文）
        int maxLength = 1;
        // 记录最长回文子串的起始位置
        int maxStart = 0;
        // 记录当前回文子串的长度
        int currentLength = 1;
        // 定义左右指针，用于从中心向两边扩展
        int left = 0, right = 0;
        // 遍历字符串的每个字符，将其作为回文中心
        for (int i = 0; i < strLen; i++) {
            // 重置当前回文长度为 1（中心字符本身）
            currentLength = 1;
            // 左指针指向中心字符的前一个位置
            left = i - 1;
            // 右指针指向中心字符的后一个位置
            right = i + 1;
            
            // 向左扩展：如果左指针有效且左边字符与中心字符相同，则继续向左扩展
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                // 当前回文长度加 1
                currentLength++;
                // 左指针继续向左移动
                left--;
            }

            // 向右扩展：如果右指针有效且右边字符与中心字符相同，则继续向右扩展
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                // 当前回文长度加 1
                currentLength++;
                // 右指针继续向右移动
                right++;
            }
            
            // 双向扩展：如果左右指针都有效且左右字符相同，则同时向两边扩展
            while (left >= 0 && right < strLen && s.charAt(left) == s.charAt(right)) {
                // 当前回文长度加 2（左右各一个字符）
                currentLength += 2;
                // 左指针向左移动
                left--;
                // 右指针向右移动
                right++;
            }
            
            // 如果当前回文长度大于已记录的最大长度，则更新最大长度和起始位置
            if (maxLength < currentLength) {
                // 更新最大回文长度
                maxLength = currentLength;
                // 更新最大回文子串的起始位置（left+1 是因为最后一次循环 left 又减了 1）
                maxStart = left + 1;
            }

        }

        // 返回最长回文子串（substring 方法包含起始索引，不包含结束索引）
        return s.substring(maxStart, maxStart + maxLength);

    }


}
