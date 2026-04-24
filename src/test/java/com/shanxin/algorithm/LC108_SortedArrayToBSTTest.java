package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

public class LC108_SortedArrayToBSTTest {

    private final LC108_SortedArrayToBST solution = new LC108_SortedArrayToBST();

    /** 辅助方法：验证二叉搜索树的性质 */
    private boolean isValidBST(TreeNode node, Long min, Long max) {
        if (node == null) return true; // 空节点是有效的 BST
        int val = node.getVal(); // 获取当前节点值
        if (val <= min || val >= max) return false; // 违反 BST 性质
        // 递归验证左右子树，左子树上界为当前节点值，右子树下界为当前节点值
        return isValidBST(node.getLeft(), min, (long) val) && 
               isValidBST(node.getRight(), (long) val, max);
    }

    /** 辅助方法：验证是否为有效的二叉搜索树 */
    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /** 辅助方法：计算树的高度 */
    private int getHeight(TreeNode node) {
        if (node == null) return 0; // 空节点高度为 0
        return Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1; // 左右子树最大高度 + 1
    }

    /** 辅助方法：验证是否为平衡二叉树 */
    private boolean isBalanced(TreeNode node) {
        if (node == null) return true; // 空节点是平衡的
        int leftHeight = getHeight(node.getLeft()); // 左子树高度
        int rightHeight = getHeight(node.getRight()); // 右子树高度
        if (Math.abs(leftHeight - rightHeight) > 1) return false; // 高度差超过 1，不平衡
        return isBalanced(node.getLeft()) && isBalanced(node.getRight()); // 递归验证左右子树
    }

    /** 辅助方法：层序遍历输出树结构（用于调试） */
    private String levelOrder(TreeNode root) {
        if (root == null) return "[]"; // 空树返回空字符串
        StringBuilder sb = new StringBuilder(); // 构建结果字符串
        Queue<TreeNode> queue = new java.util.LinkedList<>(); // 创建队列
        queue.offer(root); // 根节点入队
        sb.append("[").append(root.getVal()); // 添加根节点值
        while (!queue.isEmpty()) { // 当队列不为空时继续遍历
            TreeNode node = queue.poll(); // 取出队首节点
            if (node.getLeft() != null) { // 如果左子节点存在
                queue.offer(node.getLeft()); // 左子节点入队
                sb.append(",").append(node.getLeft().getVal()); // 添加左子节点值
            } else {
                sb.append(",null"); // 左子节点为空
            }
            if (node.getRight() != null) { // 如果右子节点存在
                queue.offer(node.getRight()); // 右子节点入队
                sb.append(",").append(node.getRight().getVal()); // 添加右子节点值
            } else {
                sb.append(",null"); // 右子节点为空
            }
        }
        sb.append("]"); // 闭合括号
        return sb.toString(); // 返回层序遍历结果
    }

    @Test
    public void testSortedArrayToBST_Example1() {
        // 示例 1：nums = [-10,-3,0,5,9] → [0,-3,9,-10,null,5] 或 [0,-10,5,null,-3,null,9]
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树
        assertEquals(0, root.getVal()); // 根节点应为中间元素 0

        System.out.println("示例 1 - 输入：[-10,-3,0,5,9]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_Example2() {
        // 示例 2：nums = [1,3] → [3,1] 或 [1,null,3]
        int[] nums = {1, 3};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n示例 2 - 输入：[1,3]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_SingleElement() {
        // 单元素数组：nums = [1] → [1]
        int[] nums = {1};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertEquals(1, root.getVal()); // 根节点值为 1
        assertNull(root.getLeft()); // 左子节点为空
        assertNull(root.getRight()); // 右子节点为空
        assertTrue(isValidBST(root)); // 验证是有效的 BST

        System.out.println("\n单元素 - 输入：[1]");
        System.out.println("输出：[1]");
        System.out.println("是否为有效 BST：" + isValidBST(root));
    }

    @Test
    public void testSortedArrayToBST_TwoElements() {
        // 两个元素：nums = [1,2] → [1,null,2] 或 [2,1]
        int[] nums = {1, 2};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n两元素 - 输入：[1,2]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_ThreeElements() {
        // 三个元素：nums = [1,2,3] → [2,1,3]
        int[] nums = {1, 2, 3};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertEquals(2, root.getVal()); // 根节点应为中间元素 2
        assertEquals(1, root.getLeft().getVal()); // 左子节点为 1
        assertEquals(3, root.getRight().getVal()); // 右子节点为 3
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n三元素 - 输入：[1,2,3]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_NegativeNumbers() {
        // 含负数：nums = [-5,-3,-1] → [-3,-5,-1]
        int[] nums = {-5, -3, -1};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertEquals(-3, root.getVal()); // 根节点应为中间元素 -3
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n含负数 - 输入：[-5,-3,-1]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_MixedNumbers() {
        // 混合正负数：nums = [-10,-3,0,5,9,15,20]
        int[] nums = {-10, -3, 0, 5, 9, 15, 20};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertEquals(5, root.getVal()); // 根节点应为中间元素 5
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n混合正负数 - 输入：[-10,-3,0,5,9,15,20]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_LargeArray() {
        // 较大数组：nums = [1,2,3,4,5,6,7,8,9,10]
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n较大数组 - 输入：[1,2,3,4,5,6,7,8,9,10]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_EvenLengthArray() {
        // 偶数长度数组：nums = [1,2,3,4,5,6]
        int[] nums = {1, 2, 3, 4, 5, 6};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n偶数长度 - 输入：[1,2,3,4,5,6]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_PowerOfTwo() {
        // 2 的幂次长度：nums = [1,2,3,4,5,6,7,8]
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树
        assertEquals(4, getHeight(root)); // 高度应为 4（8 个节点的平衡树高度）

        System.out.println("\n2的幂次长度 - 输入：[1,2,3,4,5,6,7,8]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("树高度：" + getHeight(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }

    @Test
    public void testSortedArrayToBST_BoundaryValues() {
        // 边界值：nums = [-10000, 0, 10000]
        int[] nums = {-10000, 0, 10000};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertEquals(0, root.getVal()); // 根节点应为 0
        assertEquals(-10000, root.getLeft().getVal()); // 左子节点为 -10000
        assertEquals(10000, root.getRight().getVal()); // 右子节点为 10000
        assertTrue(isValidBST(root)); // 验证是有效的 BST

        System.out.println("\n边界值 - 输入：[-10000,0,10000]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
    }

    @Test
    public void testSortedArrayToBST_ConsecutiveNumbers() {
        // 连续数字：nums = [0,1,2,3,4,5,6,7,8,9,10]
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        TreeNode root = solution.sortedArrayToBST(nums);

        assertNotNull(root); // 根节点不为空
        assertEquals(5, root.getVal()); // 根节点应为中间元素 5
        assertTrue(isValidBST(root)); // 验证是有效的 BST
        assertTrue(isBalanced(root)); // 验证是平衡二叉树

        System.out.println("\n连续数字 - 输入：[0,1,2,3,4,5,6,7,8,9,10]");
        System.out.println("输出：" + levelOrder(root));
        System.out.println("是否为有效 BST：" + isValidBST(root));
        System.out.println("是否为平衡树：" + isBalanced(root));
    }
}
