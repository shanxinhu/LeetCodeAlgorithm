package com.shanxin.algorithm;


import com.shanxin.algorithm.common.Utils;
import com.shanxin.algorithm.node.ListNode;

import java.util.ArrayList;
import java.util.List;

public class LC2807_InsertGreatestCommonDivisors {

    /*
     https://leetcode.cn/problems/insert-greatest-common-divisors-in-linked-list/
    2807. 在链表中插入最大公约数
        中等
        相关标签
        premium lock icon
        相关企业
        给你一个链表的头 head ，每个结点包含一个整数值。

        在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。

        请你返回插入之后的链表。

        两个数的 最大公约数 是可以被两个数字整除的最大正整数。



        示例 1：



        输入：head = [18,6,10,3]
        输出：[18,6,6,2,10,1,3]
        解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
        - 18 和 6 的最大公约数为 6 ，插入第一和第二个结点之间。
        - 6 和 10 的最大公约数为 2 ，插入第二和第三个结点之间。
        - 10 和 3 的最大公约数为 1 ，插入第三和第四个结点之间。
        所有相邻结点之间都插入完毕，返回链表。
        示例 2：



        输入：head = [7]
        输出：[7]
        解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
        没有相邻结点，所以返回初始链表。


        提示：

        链表中结点数目在 [1, 5000] 之间。
        1 <= Node.val <= 1000
     */

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // 在链表相邻节点之间插入最大公约数节点
        // 时间复杂度：O(n * log(max(val)))，其中 n 是链表长度，log(max(val)) 是计算 GCD 的复杂度
        // 空间复杂度：O(1)，只使用了常数个额外变量（不计新创建的节点）
        
        // 如果链表为空，直接返回 null
        if (head == null) {
            return null;
        }
        
        // 初始化当前指针指向头节点
        ListNode cur = head;
        // 遍历链表，直到最后一个节点
        while (cur.next != null) {
            // 获取当前节点的值
            int a = cur.val;
            // 获取下一个节点的值
            int b = cur.next.val;
            // 计算两个值的最大公约数
            int gcd = Utils.gcd(a, b);
            // 创建新的 GCD 节点
            ListNode node = new ListNode(gcd);
            // 将新节点的 next 指向原下一个节点
            node.next = cur.next;
            // 将当前节点的 next 指向新节点（插入操作）
            cur.next = node;
            // 移动当前指针到原下一个节点（现在是新节点的下一个）
            cur = node.next;
        }

        // 返回修改后的链表头
        return head;
    }


}
