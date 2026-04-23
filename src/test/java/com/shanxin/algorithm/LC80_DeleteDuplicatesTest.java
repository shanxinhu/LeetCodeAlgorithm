package com.shanxin.algorithm;

import com.shanxin.algorithm.node.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC80_DeleteDuplicatesTest {

    private final LC80_DeleteDuplicates solution = new LC80_DeleteDuplicates();

    private ListNode buildList(int... vals) {
        if (vals.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : vals) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    private int[] toArray(ListNode head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testDeleteDuplicates_Example1() {
        // 示例 1：head = [1,1,2] → [1,2]
        ListNode head = buildList(1, 1, 2);
        head = solution.deleteDuplicates(head);

        assertArrayEquals(new int[]{1, 2}, toArray(head));

        System.out.println("示例 1 - 输入：[1,1,2] → 输出：" + head);
    }

    @Test
    public void testDeleteDuplicates_Example2() {
        // 示例 2：head = [1,1,2,3,3] → [1,2,3]
        ListNode head = buildList(1, 1, 2, 3, 3);
        head = solution.deleteDuplicates(head);

        assertArrayEquals(new int[]{1, 2, 3}, toArray(head));

        System.out.println("示例 2 - 输入：[1,1,2,3,3] → 输出：" + head);
    }

    @Test
    public void testDeleteDuplicates_Null() {
        // 空链表：head = null → null
        ListNode head = solution.deleteDuplicates(null);

        assertNull(head);

        System.out.println("空链表 - 输入：null → 输出：null");
    }

    @Test
    public void testDeleteDuplicates_SingleNode() {
        // 单节点：head = [1] → [1]
        ListNode head = buildList(1);
        head = solution.deleteDuplicates(head);

        assertArrayEquals(new int[]{1}, toArray(head));

        System.out.println("单节点 - 输入：[1] → 输出：" + head);
    }

    @Test
    public void testDeleteDuplicates_NoDuplicates() {
        // 无重复：head = [1,2,3] → [1,2,3]
        ListNode head = buildList(1, 2, 3);
        head = solution.deleteDuplicates(head);

        assertArrayEquals(new int[]{1, 2, 3}, toArray(head));

        System.out.println("无重复 - 输入：[1,2,3] → 输出：" + head);
    }

    @Test
    public void testDeleteDuplicates_AllSame() {
        // 全相同：head = [2,2,2,2] → [2]
        ListNode head = buildList(2, 2, 2, 2);
        head = solution.deleteDuplicates(head);

        assertArrayEquals(new int[]{2}, toArray(head));

        System.out.println("全相同 - 输入：[2,2,2,2] → 输出：" + head);
    }

    @Test
    public void testDeleteDuplicates_NegativeValues() {
        // 含负数：head = [-3,-3,-1,0,0,2] → [-3,-1,0,2]
        ListNode head = buildList(-3, -3, -1, 0, 0, 2);
        head = solution.deleteDuplicates(head);

        assertArrayEquals(new int[]{-3, -1, 0, 2}, toArray(head));

        System.out.println("含负数 - 输入：[-3,-3,-1,0,0,2] → 输出：" + head);
    }

    @Test
    public void testDeleteDuplicates_AllDuplicatesAtTail() {
        // 尾部全重复：head = [1,2,3,3,3] → [1,2,3]
        ListNode head = buildList(1, 2, 3, 3, 3);
        head = solution.deleteDuplicates(head);

        assertArrayEquals(new int[]{1, 2, 3}, toArray(head));

        System.out.println("尾部重复 - 输入：[1,2,3,3,3] → 输出：" + head);
    }
}
