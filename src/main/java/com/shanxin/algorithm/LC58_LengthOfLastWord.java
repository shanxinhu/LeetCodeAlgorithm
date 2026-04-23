package com.shanxin.algorithm;

public class LC58_LengthOfLastWord {

    /*

     https://leetcode.cn/problems/length-of-last-word/
      58. 最后一个单词的长度
        简单
        相关标签
        premium lock icon
        相关企业
        给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。

        单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。



        示例 1：

        输入：s = "Hello World"
        输出：5
        解释：最后一个单词是“World”，长度为 5。
        示例 2：

        输入：s = "   fly me   to   the moon  "
        输出：4
        解释：最后一个单词是“moon”，长度为 4。
        示例 3：

        输入：s = "luffy is still joyboy"
        输出：6
        解释：最后一个单词是长度为 6 的“joyboy”。


        提示：

        1 <= s.length <= 104
        s 仅有英文字母和空格 ' ' 组成
        s 中至少存在一个单词

   */



    /**
     * 从后向前遍历，求最后一个单词的长度
     * 先跳过尾部空格，再逆向计数直到遇到空格或字符串开头。
     *
     * 时间复杂度：O(n)，其中 n 为字符串长度，最多遍历一次。
     * 空间复杂度：O(1)，仅使用常数级别的额外变量。
     */
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        // 跳过尾部的所有空格
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        // 逆向计数最后一个单词的字符数
        int count = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            count++;
            index--;
        }
        return count;
    }

}
