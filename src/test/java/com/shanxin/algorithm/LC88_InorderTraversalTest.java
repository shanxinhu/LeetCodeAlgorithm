package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LC88_InorderTraversalTest {

    private final LC88_InorderTraversal solution = new LC88_InorderTraversal();

    /** 辅助方法：创建 TreeNode 并用 setter 设置子节点 */
    private TreeNode node(int val) {
        return new TreeNode(val);
    }

    @Test
    public void testInorderTraversal_Example1() {
        // 示例 1：root = [1,null,2,3] → 中序：[1,3,2]
        //      1
        //       \
        //        2
        //       /
        //      3
        TreeNode root = node(1);
        TreeNode n2 = node(2);
        TreeNode n3 = node(3);
        root.setRight(n2);
        n2.setLeft(n3);

        List<Integer> result = solution.inorderTraversal(root);

        assertEquals(List.of(1, 3, 2), result);

        System.out.println("示例 1 - 输入：[1,null,2,3] → 输出：" + result);
    }

    @Test
    public void testInorderTraversal_Example2() {
        // 示例 2：root = [] → []
        List<Integer> result = solution.inorderTraversal(null);

        assertEquals(List.of(), result);

        System.out.println("示例 2 - 输入：[] → 输出：" + result);
    }

    @Test
    public void testInorderTraversal_Example3() {
        // 示例 3：root = [1] → [1]
        List<Integer> result = solution.inorderTraversal(node(1));

        assertEquals(List.of(1), result);

        System.out.println("示例 3 - 输入：[1] → 输出：" + result);
    }

    @Test
    public void testInorderTraversal_FullTree() {
        // 完全二叉树：
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        // 中序：[4,2,5,1,3]
        TreeNode n4 = node(4), n5 = node(5);
        TreeNode n2 = node(2); n2.setLeft(n4); n2.setRight(n5);
        TreeNode n3 = node(3);
        TreeNode root = node(1); root.setLeft(n2); root.setRight(n3);

        List<Integer> result = solution.inorderTraversal(root);

        assertEquals(List.of(4, 2, 5, 1, 3), result);

        System.out.println("完全二叉树 → 输出：" + result);
    }

    @Test
    public void testInorderTraversal_LeftSkewed() {
        // 左偏链状树：1 → 2 → 3
        // 中序：[3,2,1]
        TreeNode n3 = node(3);
        TreeNode n2 = node(2); n2.setLeft(n3);
        TreeNode root = node(1); root.setLeft(n2);

        List<Integer> result = solution.inorderTraversal(root);

        assertEquals(List.of(3, 2, 1), result);

        System.out.println("左偏链状 → 输出：" + result);
    }

    @Test
    public void testInorderTraversal_RightSkewed() {
        // 右偏链状树：1 → 2 → 3
        // 中序：[1,2,3]
        TreeNode n3 = node(3);
        TreeNode n2 = node(2); n2.setRight(n3);
        TreeNode root = node(1); root.setRight(n2);

        List<Integer> result = solution.inorderTraversal(root);

        assertEquals(List.of(1, 2, 3), result);

        System.out.println("右偏链状 → 输出：" + result);
    }

    @Test
    public void testInorderTraversal_NegativeValues() {
        // 含负数：
        //       -1
        //       / \
        //     -3   2
        // 中序：[-3,-1,2]
        TreeNode root = node(-1);
        root.setLeft(node(-3));
        root.setRight(node(2));

        List<Integer> result = solution.inorderTraversal(root);

        assertEquals(List.of(-3, -1, 2), result);

        System.out.println("含负数 → 输出：" + result);
    }

    /** ==================== inorderTraversal2 (迭代实现) 的测试 ==================== */

    @Test
    public void testInorderTraversal2_Example1() {
        // 示例 1：root = [1,null,2,3] → 中序：[1,3,2]
        //      1
        //       \
        //        2
        //       /
        //      3
        TreeNode root = node(1);
        TreeNode n2 = node(2);
        TreeNode n3 = node(3);
        root.setRight(n2);
        n2.setLeft(n3);

        List<Integer> result = solution.inorderTraversal2(root);

        assertEquals(List.of(1, 3, 2), result); // 验证迭代结果与预期一致
        assertEquals(solution.inorderTraversal(root), result); // 验证迭代与递归结果相同

        System.out.println("迭代-示例 1 - 输入：[1,null,2,3] → 输出：" + result);
    }

    @Test
    public void testInorderTraversal2_Example2() {
        // 示例 2：root = [] → []
        List<Integer> result = solution.inorderTraversal2(null);

        assertEquals(List.of(), result); // 空树返回空列表

        System.out.println("迭代-示例 2 - 输入：[] → 输出：" + result);
    }

    @Test
    public void testInorderTraversal2_Example3() {
        // 示例 3：root = [1] → [1]
        List<Integer> result = solution.inorderTraversal2(node(1));

        assertEquals(List.of(1), result); // 单节点树返回该节点值

        System.out.println("迭代-示例 3 - 输入：[1] → 输出：" + result);
    }

    @Test
    public void testInorderTraversal2_FullTree() {
        // 完全二叉树：
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        // 中序：[4,2,5,1,3]
        TreeNode n4 = node(4), n5 = node(5);
        TreeNode n2 = node(2); n2.setLeft(n4); n2.setRight(n5);
        TreeNode n3 = node(3);
        TreeNode root = node(1); root.setLeft(n2); root.setRight(n3);

        List<Integer> result = solution.inorderTraversal2(root);

        assertEquals(List.of(4, 2, 5, 1, 3), result); // 验证完整二叉树的中序遍历结果
        assertEquals(solution.inorderTraversal(root), result); // 验证迭代与递归结果相同

        System.out.println("迭代-完全二叉树 → 输出：" + result);
    }

    @Test
    public void testInorderTraversal2_LeftSkewed() {
        // 左偏链状树：1 → 2 → 3
        // 中序：[3,2,1]
        TreeNode n3 = node(3);
        TreeNode n2 = node(2); n2.setLeft(n3);
        TreeNode root = node(1); root.setLeft(n2);

        List<Integer> result = solution.inorderTraversal2(root);

        assertEquals(List.of(3, 2, 1), result); // 验证左偏树的遍历顺序（逆序）
        assertEquals(solution.inorderTraversal(root), result); // 验证迭代与递归结果相同

        System.out.println("迭代-左偏链状 → 输出：" + result);
    }

    @Test
    public void testInorderTraversal2_RightSkewed() {
        // 右偏链状树：1 → 2 → 3
        // 中序：[1,2,3]
        TreeNode n3 = node(3);
        TreeNode n2 = node(2); n2.setRight(n3);
        TreeNode root = node(1); root.setRight(n2);

        List<Integer> result = solution.inorderTraversal2(root);

        assertEquals(List.of(1, 2, 3), result); // 验证右偏树的遍历顺序（正序）
        assertEquals(solution.inorderTraversal(root), result); // 验证迭代与递归结果相同

        System.out.println("迭代-右偏链状 → 输出：" + result);
    }

    @Test
    public void testInorderTraversal2_NegativeValues() {
        // 含负数：
        //       -1
        //       / \
        //     -3   2
        // 中序：[-3,-1,2]
        TreeNode root = node(-1);
        root.setLeft(node(-3));
        root.setRight(node(2));

        List<Integer> result = solution.inorderTraversal2(root);

        assertEquals(List.of(-3, -1, 2), result); // 验证含负数节点的遍历结果正确
        assertEquals(solution.inorderTraversal(root), result); // 验证迭代与递归结果相同

        System.out.println("迭代-含负数 → 输出：" + result);
    }
}
