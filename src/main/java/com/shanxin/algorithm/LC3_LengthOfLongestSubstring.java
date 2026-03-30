package com.shanxin.algorithm;


import java.util.LinkedList;
import java.util.Queue;

public class LC3_LengthOfLongestSubstring {

    /*
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。

        示例 1:
        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
        示例 2:
        输入: s = "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:
        输入: s = "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

     */


    public int lengthOfLongestSubstring(String s) {

        Queue<Character> queue = new LinkedList<Character>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!queue.contains(c)) {
                queue.add(c);
            } else {
                maxLength = Math.max(maxLength, queue.size());

                while (queue.peek() != c) {
                    queue.poll();
                }
                queue.poll();
                queue.add(c);
            }
        }
        maxLength = Math.max(maxLength, queue.size());
        return maxLength;
    }
}
