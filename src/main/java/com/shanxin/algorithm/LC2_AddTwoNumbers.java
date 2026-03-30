package com.shanxin.algorithm;

import com.shanxin.algorithm.node.ListNode;

import java.util.Arrays;
import java.util.HashMap;

public class LC2_AddTwoNumbers {

    /*
    https://leetcode.cn/problems/add-two-numbers/
    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode node2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(node1);
        System.out.println(node2);
        System.out.println(addTwoNumbers(node1, node2));

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode res = new ListNode();
        ListNode cur = res;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = carry + x + y;
            ListNode node = null;
            // 处理余数
            if (sum >= 10) {
                carry = 1;
                node = new ListNode(sum % 10);
            } else {
                carry = 0;
                node = new ListNode(sum);

            }
            cur.next = node;
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return res.next;
    }

}
