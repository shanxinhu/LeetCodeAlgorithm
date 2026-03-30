package com.shanxin.algorithm;

import com.shanxin.algorithm.node.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC2_AddTwoNumbersTest {

    @Test
    public void testAddTwoNumbers_LargeNumbers() {
        // 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        // 输出：[8,9,9,9,0,0,0,1]
        
        ListNode l1 = new ListNode(9, 
            new ListNode(9, 
                new ListNode(9, 
                    new ListNode(9, 
                        new ListNode(9, 
                            new ListNode(9, 
                                new ListNode(9)))))));
        
        ListNode l2 = new ListNode(9, 
            new ListNode(9, 
                new ListNode(9, 
                    new ListNode(9))));
        
        ListNode result = LC2_AddTwoNumbers.addTwoNumbers(l1, l2);
        
        // 验证结果链表
        assertNotNull(result);
        
        // 验证每一位的值
        assertEquals(8, result.val);
        assertEquals(9, result.next.val);
        assertEquals(9, result.next.next.val);
        assertEquals(9, result.next.next.next.val);
        assertEquals(0, result.next.next.next.next.val);
        assertEquals(0, result.next.next.next.next.next.val);
        assertEquals(0, result.next.next.next.next.next.next.val);
        assertEquals(1, result.next.next.next.next.next.next.next.val);
        assertNull(result.next.next.next.next.next.next.next.next);
        
        System.out.println("Input l1: " + l1);
        System.out.println("Input l2: " + l2);
        System.out.println("Output: " + result);
    }
    
    @Test
    public void testAddTwoNumbers_OriginalExample() {
        // 原始示例：l1 = [2,4,3], l2 = [5,6,4]
        // 输出：[7,0,8]
        
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        
        ListNode result = LC2_AddTwoNumbers.addTwoNumbers(l1, l2);
        
        assertNotNull(result);
        assertEquals(7, result.val);
        assertEquals(0, result.next.val);
        assertEquals(8, result.next.next.val);
        assertNull(result.next.next.next);
        
        System.out.println("Input l1: " + l1);
        System.out.println("Input l2: " + l2);
        System.out.println("Output: " + result);
    }
}
