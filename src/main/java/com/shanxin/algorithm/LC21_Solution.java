package com.shanxin.algorithm;

import com.shanxin.algorithm.node.ListNode;

public class LC21_Solution {

    /*

      https://leetcode.cn/problems/merge-two-sorted-lists/
    21. 合并两个有序链表
        简单
        相关标签
        premium lock icon
        相关企业
        将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



        示例 1：


        输入：l1 = [1,2,4], l2 = [1,3,4]
        输出：[1,1,2,3,4,4]
        示例 2：

        输入：l1 = [], l2 = []
        输出：[]
        示例 3：

        输入：l1 = [], l2 = [0]
        输出：[0]


        提示：

        两个链表的节点数目范围是 [0, 50]
        -100 <= Node.val <= 100
        l1 和 l2 均按 非递减顺序 排列

   */



    /**
     * 递归合并两个有序链表
     * 每次比较两个链表头节点的值，将较小的节点作为合并后的头节点，
     * 然后递归合并剩余部分。
     *
     * 时间复杂度：O(m + n)，其中 m 和 n 分别为两个链表的长度。
     *             每个节点恰好被访问一次。
     * 空间复杂度：O(m + n)，递归调用栈的深度，最坏情况为一个链表全部小于另一个。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 基线条件：如果其中一个链表为空，直接返回另一个链表
        if (list1 == null) {return list2;}
        if (list2 == null) {return list1;}
        // 取较小值的节点作为头，递归合并剩余部分
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

}
