package com.shanxin.algorithm;

import com.shanxin.algorithm.node.Node;

public class LC1784_CheckOnesSegment {

    /*

        https://leetcode.cn/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
         1784. 检查二进制字符串字段
            简单
            相关标签
            premium lock icon
            相关企业
            提示
            给你一个二进制字符串 s ，该字符串 不含前导零 。

            如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。



            示例 1：

            输入：s = "1001"
            输出：false
            解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
            示例 2：

            输入：s = "110"
            输出：true


            提示：

            1 <= s.length <= 100
            s[i] 为 '0' 或 '1'
            s[0] 为 '1'
     */


    public boolean checkOnesSegment(String s) { // 检查二进制字符串是否最多有一个连续的 '1' 字段
        // 时间复杂度：O(n)，其中 n 是字符串长度，indexOf 需要遍历字符串
        // 空间复杂度：O(1)，只使用了常数个额外变量
        return s.indexOf("01") == -1; // 如果不存在 "01" 子串，说明所有 '1' 都在前面，只有一个连续字段
    }

}
