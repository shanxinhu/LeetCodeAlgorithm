package com.shanxin.algorithm;

import com.shanxin.algorithm.node.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC2807_InsertGreatestCommonDivisorsTest {

    private final LC2807_InsertGreatestCommonDivisors solution = new LC2807_InsertGreatestCommonDivisors(); // 创建被测试的解决方案实例

    @Test
    public void testInsertGCD_Example1() {
        // 示例 1：head = [18,6,10,3]
        // 输出：[18,6,6,2,10,1,3]
        // 解释：
        // - 18 和 6 的 GCD = 6，插入到它们之间
        // - 6 和 10 的 GCD = 2，插入到它们之间
        // - 10 和 3 的 GCD = 1，插入到它们之间
        ListNode head = createLinkedList(new int[]{18, 6, 10, 3}); // 创建输入链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法插入 GCD 节点
        
        // 验证结果链表
        int[] expected = {18, 6, 6, 2, 10, 1, 3}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("示例 1 - 输入：[18,6,10,3]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_SingleNode() {
        // 示例 2：head = [7]
        // 输出：[7]
        // 解释：只有一个节点，没有相邻节点，不需要插入
        ListNode head = createLinkedList(new int[]{7}); // 创建单节点链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表不变
        int[] expected = {7}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("单节点 - 输入：[7]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_TwoNodes() {
        // 两个节点的情况
        // head = [12, 8]
        // GCD(12, 8) = 4
        // 输出：[12, 4, 8]
        ListNode head = createLinkedList(new int[]{12, 8}); // 创建两节点链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {12, 4, 8}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("两节点 - 输入：[12,8]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_AllSameValues() {
        // 所有节点值相同
        // head = [5, 5, 5]
        // GCD(5, 5) = 5
        // 输出：[5, 5, 5, 5, 5]
        ListNode head = createLinkedList(new int[]{5, 5, 5}); // 创建全相同值的链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {5, 5, 5, 5, 5}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("全相同 - 输入：[5,5,5]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_CoprimeNumbers() {
        // 互质的数（GCD = 1）
        // head = [7, 11, 13]
        // GCD(7, 11) = 1, GCD(11, 13) = 1
        // 输出：[7, 1, 11, 1, 13]
        ListNode head = createLinkedList(new int[]{7, 11, 13}); // 创建互质数链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {7, 1, 11, 1, 13}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("互质数 - 输入：[7,11,13]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_Multiples() {
        // 倍数关系
        // head = [2, 4, 8, 16]
        // GCD(2, 4) = 2, GCD(4, 8) = 4, GCD(8, 16) = 8
        // 输出：[2, 2, 4, 4, 8, 8, 16]
        ListNode head = createLinkedList(new int[]{2, 4, 8, 16}); // 创建倍数关系链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {2, 2, 4, 4, 8, 8, 16}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("倍数关系 - 输入：[2,4,8,16]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_LargeValues() {
        // 大数值测试
        // head = [1000, 999]
        // GCD(1000, 999) = 1
        // 输出：[1000, 1, 999]
        ListNode head = createLinkedList(new int[]{1000, 999}); // 创建大数值链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {1000, 1, 999}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("大数值 - 输入：[1000,999]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_PrimeNumbers() {
        // 质数序列
        // head = [2, 3, 5, 7]
        // GCD(2, 3) = 1, GCD(3, 5) = 1, GCD(5, 7) = 1
        // 输出：[2, 1, 3, 1, 5, 1, 7]
        ListNode head = createLinkedList(new int[]{2, 3, 5, 7}); // 创建质数链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {2, 1, 3, 1, 5, 1, 7}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("质数序列 - 输入：[2,3,5,7]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_ComplexCase() {
        // 复杂情况：混合不同类型的数
        // head = [18, 6, 10, 3, 15]
        // GCD(18, 6) = 6, GCD(6, 10) = 2, GCD(10, 3) = 1, GCD(3, 15) = 3
        // 输出：[18, 6, 6, 2, 10, 1, 3, 3, 15]
        ListNode head = createLinkedList(new int[]{18, 6, 10, 3, 15}); // 创建复杂链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {18, 6, 6, 2, 10, 1, 3, 3, 15}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("复杂情况 - 输入：[18,6,10,3,15]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    @Test
    public void testInsertGCD_NullHead() {
        // 空链表测试
        ListNode head = null; // 空链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        assertNull(result); // 验证结果为 null
        
        System.out.println("空链表 - 输入：null"); // 打印输入信息
        System.out.println("输出：null"); // 打印输出结果
    }

    @Test
    public void testInsertGCD_LongChain() {
        // 较长链表测试
        // head = [12, 18, 24, 30, 36]
        // GCD(12, 18) = 6, GCD(18, 24) = 6, GCD(24, 30) = 6, GCD(30, 36) = 6
        // 输出：[12, 6, 18, 6, 24, 6, 30, 6, 36]
        ListNode head = createLinkedList(new int[]{12, 18, 24, 30, 36}); // 创建较长链表
        
        ListNode result = solution.insertGreatestCommonDivisors(head); // 调用方法
        
        // 验证结果链表
        int[] expected = {12, 6, 18, 6, 24, 6, 30, 6, 36}; // 期望的输出
        assertLinkedListEquals(expected, result); // 断言链表相等
        
        System.out.println("较长链表 - 输入：[12,18,24,30,36]"); // 打印输入信息
        System.out.println("输出：" + linkedListToString(result)); // 打印输出结果
    }

    /**
     * 辅助方法：从数组创建链表
     */
    private ListNode createLinkedList(int[] values) {
        if (values == null || values.length == 0) { // 如果数组为空
            return null; // 返回 null
        }
        ListNode head = new ListNode(values[0]); // 创建头节点
        ListNode current = head; // 当前节点指针
        for (int i = 1; i < values.length; i++) { // 遍历剩余元素
            current.next = new ListNode(values[i]); // 创建新节点并链接
            current = current.next; // 移动指针
        }
        return head; // 返回链表头
    }

    /**
     * 辅助方法：验证链表是否等于期望数组
     */
    private void assertLinkedListEquals(int[] expected, ListNode actual) {
        ListNode current = actual; // 当前节点指针
        for (int value : expected) { // 遍历期望值数组
            assertNotNull(current); // 验证当前节点不为 null
            assertEquals(value, current.val); // 验证节点值相等
            current = current.next; // 移动到下一个节点
        }
        assertNull(current); // 验证链表已结束
    }

    /**
     * 辅助方法：将链表转换为字符串表示
     */
    private String linkedListToString(ListNode head) {
        StringBuilder sb = new StringBuilder(); // 创建字符串构建器
        sb.append("["); // 添加左括号
        ListNode current = head; // 当前节点指针
        while (current != null) { // 遍历链表
            sb.append(current.val); // 添加节点值
            if (current.next != null) { // 如果不是最后一个节点
                sb.append(", "); // 添加逗号分隔符
            }
            current = current.next; // 移动到下一个节点
        }
        sb.append("]"); // 添加右括号
        return sb.toString(); // 返回字符串
    }
}
