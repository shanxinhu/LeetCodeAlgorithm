package com.shanxin.algorithm;

import com.shanxin.algorithm.node.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC21_MergeTwoListsTest {

    private final LC21_MergeTwoLists solution = new LC21_MergeTwoLists();

    /**
     * 辅助方法：用 int 数组快速构建链表
     */
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

    /**
     * 辅助方法：将链表转为 int 数组，便于断言
     */
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
    public void testMergeTwoLists_Example1() {
        // 示例 1：l1 = [1,2,4], l2 = [1,3,4] → [1,1,2,3,4,4]
        ListNode list1 = buildList(1, 2, 4);
        ListNode list2 = buildList(1, 3, 4);

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 4}, toArray(result));

        System.out.println("示例 1 - 输入：[1,2,4], [1,3,4]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMergeTwoLists_Example2() {
        // 示例 2：l1 = [], l2 = [] → []
        ListNode list1 = buildList();
        ListNode list2 = buildList();

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertNull(result);

        System.out.println("示例 2 - 输入：[], []");
        System.out.println("输出：null");
    }

    @Test
    public void testMergeTwoLists_Example3() {
        // 示例 3：l1 = [], l2 = [0] → [0]
        ListNode list1 = buildList();
        ListNode list2 = buildList(0);

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new int[]{0}, toArray(result));

        System.out.println("示例 3 - 输入：[], [0]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMergeTwoLists_OneListEmpty() {
        // l1 = [1,2,3], l2 = [] → [1,2,3]
        ListNode list1 = buildList(1, 2, 3);
        ListNode list2 = buildList();

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new int[]{1, 2, 3}, toArray(result));

        System.out.println("l1非空l2空 - 输入：[1,2,3], []");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMergeTwoLists_AllSameValues() {
        // l1 = [1,1,1], l2 = [1,1] → [1,1,1,1,1]
        ListNode list1 = buildList(1, 1, 1);
        ListNode list2 = buildList(1, 1);

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, toArray(result));

        System.out.println("全相同值 - 输入：[1,1,1], [1,1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMergeTwoLists_NoOverlap() {
        // l1 = [1,2,3], l2 = [4,5,6] → [1,2,3,4,5,6]
        ListNode list1 = buildList(1, 2, 3);
        ListNode list2 = buildList(4, 5, 6);

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, toArray(result));

        System.out.println("无重叠 - 输入：[1,2,3], [4,5,6]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMergeTwoLists_NegativeValues() {
        // l1 = [-3,-1,0], l2 = [-2,1,2] → [-3,-2,-1,0,1,2]
        ListNode list1 = buildList(-3, -1, 0);
        ListNode list2 = buildList(-2, 1, 2);

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new int[]{-3, -2, -1, 0, 1, 2}, toArray(result));

        System.out.println("含负数 - 输入：[-3,-1,0], [-2,1,2]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMergeTwoLists_SingleElementEach() {
        // l1 = [2], l2 = [1] → [1,2]
        ListNode list1 = buildList(2);
        ListNode list2 = buildList(1);

        ListNode result = solution.mergeTwoLists(list1, list2);

        assertArrayEquals(new int[]{1, 2}, toArray(result));

        System.out.println("单元素 - 输入：[2], [1]");
        System.out.println("输出：" + result);
    }
}
