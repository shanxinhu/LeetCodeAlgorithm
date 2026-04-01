package com.shanxin.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class LC214_ShortestPalindrome {

    /*

     https://leetcode.cn/problems/shortest-palindrome/description/
     214. 最短回文串
        困难
        相关标签
        premium lock icon
        相关企业
        给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
        示例 1：

        输入：s = "aacecaaa"
        输出："aaacecaaa"
        示例 2：

        输入：s = "abcd"
        输出："dcbabcd"


        提示：

        0 <= s.length <= 5 * 104
        s 仅由小写英文字母组成
     */

    public static void main(String[] args) {
        LC214_ShortestPalindrome lc214ShortestPalindrome = new LC214_ShortestPalindrome();
        System.out.println(lc214ShortestPalindrome.shortestPalindrome("abcabac"));
        System.out.println(lc214ShortestPalindrome.shortestPalindrome("abcabc"));
    }



    /**
     * 找到并返回可以通过在字符串前面添加字符转换的最短回文串
     * 使用 KMP 算法的失败函数来找到最长的回文前缀
     * @param s 输入字符串
     * @return 最短回文串
     */
    public String shortestPalindrome(String s) {

        // 获取字符串 s 的长度
        int n = s.length();
        
        // 创建失败数组 fail，用于存储 KMP 算法中的部分匹配值
        // fail[i] 表示以 i 结尾的子串的最长相等前后缀的长度减 1
        int[] fail = new int[n];

        // 初始化失败数组，所有元素设为 -1（表示没有匹配的前缀）
        Arrays.fill(fail, -1);
        
        // 第一次遍历：构建失败数组（KMP 的 failure function）
        // 从索引 1 开始，计算每个位置的最长相等前后缀长度
        for (int i = 1; i < n; i++) {
             // j 初始化为前一个位置的失败值
             int j = fail[i - 1];
             
             // 当 j 不为 -1 且当前字符与 j+1 位置的字符不匹配时
             // 回溯到 j 的失败位置继续尝试匹配
             while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                 j = fail[j];
             }
             
             // 如果当前字符与 j+1 位置的字符匹配
             // 则更新 fail[i] 为 j + 1
             if (s.charAt(j + 1) == s.charAt(i)) {
                 fail[i] = j + 1;
             }
        }
        System.out.println("fail:" + Arrays.toString(fail));

        // best 用于记录从末尾开始匹配的最长回文前缀的最后一个字符位置
        // 初始值为 -1，表示还没有匹配任何字符
        int best = -1;
        
        // 第二次遍历：从字符串末尾向前扫描
        // 利用之前计算的 fail 数组找到最长的回文前缀
        for (int i = n - 1; i >= 0; i--) {
            // 当 best 不为 -1 且当前位置的字符与 best+1 位置的字符不匹配时
            // 根据 fail 数组回溯到之前的位置
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            
            // 如果当前位置的字符与 best+1 位置的字符匹配
            // 则 best 向前移动一位
            if (s.charAt(best + 1) == s.charAt(i)) {
                best++;
            }

        }
        System.out.println("best:" + best);
        
        // 计算需要添加的字符串
        // 如果 best 等于 n-1，说明整个字符串已经是回文，不需要添加任何字符
        // 否则，需要从 best+1 位置到末尾的子串，并将其反转后添加到原字符串前面
        String add =  best == n -1  ? "" : s.substring(best + 1);
        
        // 创建 StringBuffer 对象，将需要添加的字符串反转
        StringBuffer ans = new StringBuffer(add).reverse() ;
        
        // 将反转后的字符串与原字符串拼接，形成最短回文串并返回
        return ans.append(s).toString();
    }

}
