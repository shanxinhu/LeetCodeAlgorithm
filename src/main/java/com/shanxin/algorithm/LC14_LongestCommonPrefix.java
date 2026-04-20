package com.shanxin.algorithm;

import java.util.Arrays;
import java.util.Map;

public class LC14_LongestCommonPrefix {

    /*

       https://leetcode.cn/problems/longest-common-prefix/description/
       14. 最长公共前缀
            简单
            相关标签
            premium lock icon
            相关企业
            编写一个函数来查找字符串数组中的最长公共前缀。

            如果不存在公共前缀，返回空字符串 ""。



            示例 1：

            输入：strs = ["flower","flow","flight"]
            输出："fl"
            示例 2：

            输入：strs = ["dog","racecar","car"]
            输出：""
            解释：输入不存在公共前缀。


            提示：

            1 <= strs.length <= 200
            0 <= strs[i].length <= 200
            strs[i] 如果非空，则仅由小写英文字母组成

   */


    /**
     * 时间复杂度：O(S * log n)，其中 S 为所有字符串中字符的总数，n 为字符串数量。
     *   - 排序耗时 O(n * m * log n)，m 为字符串平均长度
     *   - 遍历比较耗时 O(n * m)（最坏情况需比较所有字符）
     * 空间复杂度：O(log n)，Java 双轴快排的递归调用栈深度
     */
    public String longestCommonPrefix(String[] strs) {

        // 排序后，字典序最小和最大的两个字符串的差异最大，只需比较它们即可确定公共前缀的边界
        Arrays.sort(strs);
        String first = strs[0];
        // 逐字符遍历第一个字符串
        for (int i = 0; i < first.length(); i++) {
            char cFirst = first.charAt(i);
            // 逐个与后续字符串的同一位置字符比较
            for (int j = 1; j < strs.length; j++) {
                // 发现不匹配字符时，返回之前已匹配的前缀
                if (cFirst != strs[j].charAt(i)) {
                    return first.substring(0, i);
                }
            }
        }
        // 所有字符都匹配，整个 first 即为公共前缀
        return first;
    }

}
