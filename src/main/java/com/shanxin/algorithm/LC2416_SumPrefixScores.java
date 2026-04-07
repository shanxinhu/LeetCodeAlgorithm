package com.shanxin.algorithm;

import com.shanxin.algorithm.node.Node;

import java.util.ArrayList;

public class LC2416_SumPrefixScores {

    /*

        https://leetcode.cn/problems/sum-of-prefix-scores-of-strings/
         2416. 字符串的前缀分数和
            困难
            相关标签
            premium lock icon
            相关企业
            提示
            给你一个长度为 n 的数组 words ，该数组由 非空 字符串组成。

            定义字符串 term 的 分数 等于以 term 作为 前缀 的 words[i] 的数目。

            例如，如果 words = ["a", "ab", "abc", "cab"] ，那么 "ab" 的分数是 2 ，因为 "ab" 是 "ab" 和 "abc" 的一个前缀。
            返回一个长度为 n 的数组 answer ，其中 answer[i] 是 words[i] 的每个非空前缀的分数 总和 。

            注意：字符串视作它自身的一个前缀。



            示例 1：

            输入：words = ["abc","ab","bc","b"]
            输出：[5,4,3,2]
            解释：对应每个字符串的答案如下：
            - "abc" 有 3 个前缀："a"、"ab" 和 "abc" 。
            - 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" ，1 个字符串的前缀为 "abc" 。
            总计 answer[0] = 2 + 2 + 1 = 5 。
            - "ab" 有 2 个前缀："a" 和 "ab" 。
            - 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" 。
            总计 answer[1] = 2 + 2 = 4 。
            - "bc" 有 2 个前缀："b" 和 "bc" 。
            - 2 个字符串的前缀为 "b" ，1 个字符串的前缀为 "bc" 。
            总计 answer[2] = 2 + 1 = 3 。
            - "b" 有 1 个前缀："b"。
            - 2 个字符串的前缀为 "b" 。
            总计 answer[3] = 2 。
            示例 2：

            输入：words = ["abcd"]
            输出：[4]
            解释：
            "abcd" 有 4 个前缀 "a"、"ab"、"abc" 和 "abcd"。
            每个前缀的分数都是 1 ，总计 answer[0] = 1 + 1 + 1 + 1 = 4 。


            提示：

            1 <= words.length <= 1000
            1 <= words[i].length <= 1000
            words[i] 由小写英文字母组成
     */


    public int[] sumPrefixScores(String[] words) { // 计算每个字符串的所有前缀分数总和
        // 时间复杂度：O(n * m)，其中 n 是单词数量，m 是单词的平均长度
        // 空间复杂度：O(n * m)，Trie 树存储所有字符节点
        
        // 创建 Trie 树的根节点
        Node root = new Node();
        // 遍历每个单词，构建 Trie 树
        for (String word : words) {
            // 从根节点开始遍历
            Node cur = root;
            // 遍历当前单词的每个字符
            for (char c : word.toCharArray()) {
                // 如果当前字符对应的子节点不存在
                if (cur.son[c - 'a'] == null) {
                    // 创建新的子节点
                    cur.son[c - 'a'] = new Node(c);
                }
                // 移动到子节点
                cur = cur.son[c - 'a'];
                // 增加该节点的分数（表示有多少个单词经过此节点）
                cur.score++;
            }
        }

        // 创建结果数组，存储每个单词的前缀分数总和
        int[] res = new int[words.length];
        // 遍历每个单词，计算其前缀分数总和
        for (int i = 0; i < words.length; i++) {
            // 从根节点开始遍历
            Node cur = root;
            // 遍历当前单词的每个字符
            for (char c : words[i].toCharArray()) {
                // 移动到对应的子节点
                cur = cur.son[c - 'a'];
                // 累加当前节点的分数到结果中
                res[i] += cur.score;
            }
        }
        // 返回结果数组
        return res;
    }

}
