package com.shanxin.algorithm;

import com.shanxin.algorithm.node.ListNode;

public class LC80_DeleteDuplicates {

    /*
  https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
      83. 删除排序链表中的重复元素
            简单
            相关标签
            premium lock icon
            相关企业
            给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。



            示例 1：


            输入：head = [1,1,2]
            输出：[1,2]
            示例 2：


            输入：head = [1,1,2,3,3]
            输出：[1,2,3]


            提示：

            链表中节点数目在范围 [0, 300] 内
            -100 <= Node.val <= 100
            题目数据保证链表已经按升序 排列

     */




    /**
     * 原地删除排序链表中的重复元素，使每个元素只出现一次
     * 用 cur 指针遍历链表，比较当前节点与下一节点的值：
     * 相同则跳过下一节点（删除重复），不同则前进一步。
     *
     * 时间复杂度：O(n)，其中 n 为链表长度，每个节点恰好被访问一次。
     * 空间复杂度：O(1)，仅使用 cur 一个指针变量。
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                // 当前节点与下一节点值相同，删除下一节点
                cur.next = cur.next.next;
            } else {
                // 值不同，cur 前进一步
                cur = cur.next;
            }
        }
        return head;
    }

}
