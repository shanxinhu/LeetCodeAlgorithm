package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC101_IsSymmetricTest {

    private final LC101_IsSymmetric solution = new LC101_IsSymmetric();

    /** 辅助方法：创建 TreeNode */
    private TreeNode node(int val) {
        return new TreeNode(val);
    }

    /** ==================== isSymmetric (递归实现) 的测试 ==================== */

    @Test
    public void testIsSymmetric_Example1() {
        // 示例 1：root = [1,2,2,3,4,4,3] → true
        //       1
        //      / \
        //     2   2
        //    / \ / \
        //   3  4 4  3
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(3));
        left.setRight(node(4));
        right.setLeft(node(4));
        right.setRight(node(3));

        assertTrue(solution.isSymmetric(root)); // 轴对称二叉树

        System.out.println("示例 1 - 输入：[1,2,2,3,4,4,3] → 输出：true");
    }

    @Test
    public void testIsSymmetric_Example2() {
        // 示例 2：root = [1,2,2,null,3,null,3] → false
        //       1
        //      / \
        //     2   2
        //      \   \
        //      3    3
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);
        left.setRight(node(3));
        right.setRight(node(3));

        assertFalse(solution.isSymmetric(root)); // 不对称（左子树缺左节点，右子树缺左节点）

        System.out.println("示例 2 - 输入：[1,2,2,null,3,null,3] → 输出：false");
    }

    @Test
    public void testIsSymmetric_SingleNode() {
        // 单节点树 → true
        TreeNode root = node(1);

        assertTrue(solution.isSymmetric(root)); // 单节点视为对称

        System.out.println("单节点 → 输出：true");
    }

    @Test
    public void testIsSymmetric_TwoLevelSymmetric() {
        // 两层对称树：[1,2,2] → true
        //     1
        //    / \
        //   2   2
        TreeNode root = node(1);
        root.setLeft(node(2));
        root.setRight(node(2));

        assertTrue(solution.isSymmetric(root)); // 左右子节点值相同，对称

        System.out.println("两层对称 → 输出：true");
    }

    @Test
    public void testIsSymmetric_TwoLevelAsymmetric() {
        // 两层不对称树：[1,2,3] → false
        //     1
        //    / \
        //   2   3
        TreeNode root = node(1);
        root.setLeft(node(2));
        root.setRight(node(3));

        assertFalse(solution.isSymmetric(root)); // 左右子节点值不同，不对称

        System.out.println("两层不对称 → 输出：false");
    }

    @Test
    public void testIsSymmetric_LeftSkewed() {
        // 左偏树：[1,2,null,3] → false
        //     1
        //    /
        //   2
        //  /
        // 3
        TreeNode root = node(1);
        TreeNode left = node(2);
        root.setLeft(left);
        left.setLeft(node(3));

        assertFalse(solution.isSymmetric(root)); // 只有左子树，不对称

        System.out.println("左偏树 → 输出：false");
    }

    @Test
    public void testIsSymmetric_RightSkewed() {
        // 右偏树：[1,null,2,null,3] → false
        //     1
        //      \
        //       2
        //        \
        //         3
        TreeNode root = node(1);
        TreeNode right = node(2);
        root.setRight(right);
        right.setRight(node(3));

        assertFalse(solution.isSymmetric(root)); // 只有右子树，不对称

        System.out.println("右偏树 → 输出：false");
    }

    @Test
    public void testIsSymmetric_ComplexSymmetric() {
        // 复杂对称树：[1,2,2,3,4,4,3,5,6,7,8,8,7,6,5] → true
        //           1
        //         /   \
        //        2     2
        //       / \   / \
        //      3   4 4   3
        //     / \ / \/ \ / \
        //    5  6 7 8 8 7 6 5
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);

        TreeNode l3 = node(3), l4 = node(4);
        TreeNode r4 = node(4), r3 = node(3);
        left.setLeft(l3);
        left.setRight(l4);
        right.setLeft(r4);
        right.setRight(r3);

        l3.setLeft(node(5));
        l3.setRight(node(6));
        l4.setLeft(node(7));
        l4.setRight(node(8));
        r4.setLeft(node(8));
        r4.setRight(node(7));
        r3.setLeft(node(6));
        r3.setRight(node(5));

        assertTrue(solution.isSymmetric(root)); // 复杂结构完全对称

        System.out.println("复杂对称树 → 输出：true");
    }

    @Test
    public void testIsSymmetric_NegativeValues() {
        // 含负数的对称树：[1,-2,-2,-3,4,4,-3] → true
        //       1
        //      / \
        //    -2  -2
        //    / \ / \
        //  -3  4 4 -3
        TreeNode root = node(1);
        TreeNode left = node(-2);
        TreeNode right = node(-2);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(-3));
        left.setRight(node(4));
        right.setLeft(node(4));
        right.setRight(node(-3));

        assertTrue(solution.isSymmetric(root)); // 含负数的对称树

        System.out.println("含负数对称 → 输出：true");
    }

    @Test
    public void testIsSymmetric_ValueAsymmetric() {
        // 结构对称但值不对称：[1,2,2,3,4,3,4] → false
        //       1
        //      / \
        //     2   2
        //    / \ / \
        //   3  4 3  4
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(3));
        left.setRight(node(4));
        right.setLeft(node(3));
        right.setRight(node(4));

        assertFalse(solution.isSymmetric(root)); // 镜像位置值不匹配（4 vs 3）

        System.out.println("值不对称 → 输出：false");
    }

    /** ==================== isSymmetric2 (迭代实现) 的测试 ==================== */

    @Test
    public void testIsSymmetric2_Example1() {
        // 示例 1：root = [1,2,2,3,4,4,3] → true
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(3));
        left.setRight(node(4));
        right.setLeft(node(4));
        right.setRight(node(3));

        assertTrue(solution.isSymmetric2(root)); // BFS 验证对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-示例 1 - 输入：[1,2,2,3,4,4,3] → 输出：true");
    }

    @Test
    public void testIsSymmetric2_Example2() {
        // 示例 2：root = [1,2,2,null,3,null,3] → false
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);
        left.setRight(node(3));
        right.setRight(node(3));

        assertFalse(solution.isSymmetric2(root)); // BFS 验证不对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-示例 2 - 输入：[1,2,2,null,3,null,3] → 输出：false");
    }

    @Test
    public void testIsSymmetric2_SingleNode() {
        // 单节点树 → true
        TreeNode root = node(1);

        assertTrue(solution.isSymmetric2(root)); // BFS 验证单节点对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-单节点 → 输出：true");
    }

    @Test
    public void testIsSymmetric2_TwoLevelSymmetric() {
        // 两层对称树：[1,2,2] → true
        TreeNode root = node(1);
        root.setLeft(node(2));
        root.setRight(node(2));

        assertTrue(solution.isSymmetric2(root)); // BFS 验证两层对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-两层对称 → 输出：true");
    }

    @Test
    public void testIsSymmetric2_TwoLevelAsymmetric() {
        // 两层不对称树：[1,2,3] → false
        TreeNode root = node(1);
        root.setLeft(node(2));
        root.setRight(node(3));

        assertFalse(solution.isSymmetric2(root)); // BFS 验证两层不对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-两层不对称 → 输出：false");
    }

    @Test
    public void testIsSymmetric2_LeftSkewed() {
        // 左偏树：[1,2,null,3] → false
        TreeNode root = node(1);
        TreeNode left = node(2);
        root.setLeft(left);
        left.setLeft(node(3));

        assertFalse(solution.isSymmetric2(root)); // BFS 验证左偏不对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-左偏树 → 输出：false");
    }

    @Test
    public void testIsSymmetric2_RightSkewed() {
        // 右偏树：[1,null,2,null,3] → false
        TreeNode root = node(1);
        TreeNode right = node(2);
        root.setRight(right);
        right.setRight(node(3));

        assertFalse(solution.isSymmetric2(root)); // BFS 验证右偏不对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-右偏树 → 输出：false");
    }

    @Test
    public void testIsSymmetric2_ComplexSymmetric() {
        // 复杂对称树：[1,2,2,3,4,4,3,5,6,7,8,8,7,6,5] → true
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);

        TreeNode l3 = node(3), l4 = node(4);
        TreeNode r4 = node(4), r3 = node(3);
        left.setLeft(l3);
        left.setRight(l4);
        right.setLeft(r4);
        right.setRight(r3);

        l3.setLeft(node(5));
        l3.setRight(node(6));
        l4.setLeft(node(7));
        l4.setRight(node(8));
        r4.setLeft(node(8));
        r4.setRight(node(7));
        r3.setLeft(node(6));
        r3.setRight(node(5));

        assertTrue(solution.isSymmetric2(root)); // BFS 验证复杂对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-复杂对称树 → 输出：true");
    }

    @Test
    public void testIsSymmetric2_NegativeValues() {
        // 含负数的对称树：[1,-2,-2,-3,4,4,-3] → true
        TreeNode root = node(1);
        TreeNode left = node(-2);
        TreeNode right = node(-2);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(-3));
        left.setRight(node(4));
        right.setLeft(node(4));
        right.setRight(node(-3));

        assertTrue(solution.isSymmetric2(root)); // BFS 验证含负数对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-含负数对称 → 输出：true");
    }

    @Test
    public void testIsSymmetric2_ValueAsymmetric() {
        // 结构对称但值不对称：[1,2,2,3,4,3,4] → false
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(2);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(3));
        left.setRight(node(4));
        right.setLeft(node(3));
        right.setRight(node(4));

        assertFalse(solution.isSymmetric2(root)); // BFS 验证值不对称
        assertEquals(solution.isSymmetric(root), solution.isSymmetric2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-值不对称 → 输出：false");
    }
}
