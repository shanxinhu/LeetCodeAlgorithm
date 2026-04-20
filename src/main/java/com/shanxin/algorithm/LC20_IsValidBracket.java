package com.shanxin.algorithm;

import java.util.Stack;

public class LC20_IsValidBracket {

    /*

      https://leetcode.cn/problems/valid-parentheses/
      20. 有效的括号
            简单
            相关标签
            premium lock icon
            相关企业
            提示
            给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

            有效字符串需满足：

            左括号必须用相同类型的右括号闭合。
            左括号必须以正确的顺序闭合。
            每个右括号都有一个对应的相同类型的左括号。


            示例 1：

            输入：s = "()"

            输出：true

            示例 2：

            输入：s = "()[]{}"

            输出：true

            示例 3：

            输入：s = "(]"

            输出：false

            示例 4：

            输入：s = "([])"

            输出：true

            示例 5：

            输入：s = "([)]"

            输出：false



            提示：

            1 <= s.length <= 104
            s 仅由括号 '()[]{}' 组成

   */



    /**
     * 时间复杂度：O(n)，n 为字符串长度，每个字符最多入栈出栈各一次
     * 空间复杂度：O(n)，最坏情况下所有字符都是左括号，栈大小为 n
     */
    public boolean isValid(String s) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        // 奇数长度不可能有效
        if (len % 2 != 0) {
            return false;
        }
        // 用栈匹配括号：遇到左括号入栈，遇到右括号出栈校验
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            } else {
                // 右括号：出栈并校验是否与当前括号匹配
                if (stack.isEmpty()) {
                    return false;
                }
                char left = stack.pop();
                if (!isMatch(left, chars[i])) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    // 判断左右括号是否匹配
    private boolean isMatch(char left, char right) {
        return (left == '(' && right == ')')
            || (left == '[' && right == ']')
            || (left == '{' && right == '}');
    }

}
