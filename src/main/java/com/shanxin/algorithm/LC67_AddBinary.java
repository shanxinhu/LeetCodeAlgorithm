package com.shanxin.algorithm;

public class LC67_AddBinary {

    /*
   https://leetcode.cn/problems/add-binary/
   67. 二进制求和
        简单
        相关标签
        premium lock icon
        相关企业
        给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。



        示例 1：

        输入:a = "11", b = "1"
        输出："100"
        示例 2：

        输入：a = "1010", b = "1011"
        输出："10101"


        提示：

        1 <= a.length, b.length <= 104
        a 和 b 仅由字符 '0' 或 '1' 组成
        字符串如果不是 "0" ，就不含前导零
     */


    /**
     * 模拟竖式加法，从最低位逐位相加并处理进位
     * carry 同时累加两位的和，carry % 2 为当前位结果，carry /= 2 为进位。
     * 最后逆序得到正确结果。
     *
     * 时间复杂度：O(max(n, m))，其中 n 和 m 分别为两个字符串的长度，遍历最长字符串的每一位。
     * 空间复杂度：O(max(n, m))，存储结果的 StringBuffer，最多 max(n,m)+1 位。
     */
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; i++) {
            // 从最低位取 a 的当前位（若 a 较短则补 0）
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            // 从最低位取 b 的当前位（若 b 较短则补 0）
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            // 当前位 = carry 对 2 取余，进位 = carry 除以 2
            sb.append((char) (carry % 2 + '0'));
            carry /= 2;
        }
        // 处理最高位的进位
        if (carry > 0)
            sb.append('1');
        // 逆序得到正确结果
        sb.reverse();
        return sb.toString();
    }

}
