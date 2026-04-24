package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC104_MaxDepthTest {

    private final LC104_MaxDepth solution = new LC104_MaxDepth();

    /** 辅助方法：创建 TreeNode */
    private TreeNode node(int val) {
        return new TreeNode(val);
    }

    /** ==================== maxDepth (深度优先) 的测试 ==================== */

    @Test
    public void testMaxDepth_Example1() {
        // 示例 1：root = [3,9,20,null,null,15,7] → 3
        //       3
        //      / \
        //     9   20
        //        /  \
        //       15   7
        TreeNode root = node(3);
        root.setLeft(node(9));
        TreeNode right = node(20);
        root.setRight(right);
        right.setLeft(node(15));
        right.setRight(node(7));

        assertEquals(3, solution.maxDepth(root)); // 最大深度为 3

        System.out.println("示例 1 - 输入：[3,9,20,null,null,15,7] → 输出：3");
    }

    @Test
    public void testMaxDepth_Example2() {
        // 示例 2：root = [1,null,2] → 2
        //    1
        //     \
        //      2
        TreeNode root = node(1);
        root.setRight(node(2));

        assertEquals(2, solution.maxDepth(root)); // 最大深度为 2

        System.out.println("示例 2 - 输入：[1,null,2] → 输出：2");
    }

    @Test
    public void testMaxDepth_EmptyTree() {
        // 空树 → 0
        assertEquals(0, solution.maxDepth(null)); // 空树深度为 0

        System.out.println("空树 → 输出：0");
    }

    @Test
    public void testMaxDepth_SingleNode() {
        // 单节点树 → 1
        assertEquals(1, solution.maxDepth(node(1))); // 单节点深度为 1

        System.out.println("单节点 → 输出：1");
    }

    @Test
    public void testMaxDepth_LeftSkewed() {
        // 左斜树：[1,2,3,4] → 4
        //    1
        //   /
        //  2
        // /
        // 3
        // /
        // 4
        TreeNode root = node(1);
        TreeNode n2 = node(2);
        TreeNode n3 = node(3);
        root.setLeft(n2);
        n2.setLeft(n3);
        n3.setLeft(node(4));

        assertEquals(4, solution.maxDepth(root)); // 左斜树深度为 4

        System.out.println("左斜树 → 输出：4");
    }

    @Test
    public void testMaxDepth_RightSkewed() {
        // 右斜树：[1,null,2,null,3,null,4] → 4
        // 1
        //  \
        //   2
        //    \
        //     3
        //      \
        //       4
        TreeNode root = node(1);
        TreeNode n2 = node(2);
        TreeNode n3 = node(3);
        root.setRight(n2);
        n2.setRight(n3);
        n3.setRight(node(4));

        assertEquals(4, solution.maxDepth(root)); // 右斜树深度为 4

        System.out.println("右斜树 → 输出：4");
    }

    @Test
    public void testMaxDepth_BalancedTree() {
        // 平衡二叉树：[1,2,3,4,5,6,7] → 3
        //       1
        //      / \
        //     2   3
        //    / \ / \
        //   4  5 6  7
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(3);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(4));
        left.setRight(node(5));
        right.setLeft(node(6));
        right.setRight(node(7));

        assertEquals(3, solution.maxDepth(root)); // 平衡树深度为 3

        System.out.println("平衡树 → 输出：3");
    }

    @Test
    public void testMaxDepth_ComplexTree() {
        // 复杂树结构 → 4
        //        1
        //       / \
        //      2   3
        //     /   / \
        //    4   5   6
        //   /
        //  7
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(3);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(4));
        right.setLeft(node(5));
        right.setRight(node(6));
        left.getLeft().setLeft(node(7));

        assertEquals(4, solution.maxDepth(root)); // 复杂树深度为 4

        System.out.println("复杂树 → 输出：4");
    }

    @Test
    public void testMaxDepth_NegativeValues() {
        // 含负数节点的树 → 3
        //      -1
        //      / \
        //    -3   2
        //    /
        //  -5
        TreeNode root = node(-1);
        TreeNode left = node(-3);
        root.setLeft(left);
        root.setRight(node(2));
        left.setLeft(node(-5));

        assertEquals(3, solution.maxDepth(root)); // 含负数树的深度为 3

        System.out.println("含负数树 → 输出：3");
    }

    /** ==================== maxDepth2 (广度优先) 的测试 ==================== */

    @Test
    public void testMaxDepth2_Example1() {
        // 示例 1：root = [3,9,20,null,null,15,7] → 3
        TreeNode root = node(3);
        root.setLeft(node(9));
        TreeNode right = node(20);
        root.setRight(right);
        right.setLeft(node(15));
        right.setRight(node(7));

        assertEquals(3, solution.maxDepth2(root)); // BFS 验证最大深度为 3
        assertEquals(solution.maxDepth(root), solution.maxDepth2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-示例 1 - 输入：[3,9,20,null,null,15,7] → 输出：3");
    }

    @Test
    public void testMaxDepth2_Example2() {
        // 示例 2：root = [1,null,2] → 2
        TreeNode root = node(1);
        root.setRight(node(2));

        assertEquals(2, solution.maxDepth2(root)); // BFS 验证最大深度为 2
        assertEquals(solution.maxDepth(root), solution.maxDepth2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-示例 2 - 输入：[1,null,2] → 输出：2");
    }

    @Test
    public void testMaxDepth2_EmptyTree() {
        // 空树 → 0
        assertEquals(0, solution.maxDepth2(null)); // BFS 处理空树

        System.out.println("BFS-空树 → 输出：0");
    }

    @Test
    public void testMaxDepth2_SingleNode() {
        // 单节点树 → 1
        assertEquals(1, solution.maxDepth2(node(1))); // BFS 验证单节点深度为 1

        System.out.println("BFS-单节点 → 输出：1");
    }

    @Test
    public void testMaxDepth2_LeftSkewed() {
        // 左斜树：[1,2,3,4] → 4
        TreeNode root = node(1);
        TreeNode n2 = node(2);
        TreeNode n3 = node(3);
        root.setLeft(n2);
        n2.setLeft(n3);
        n3.setLeft(node(4));

        assertEquals(4, solution.maxDepth2(root)); // BFS 验证左斜树深度为 4
        assertEquals(solution.maxDepth(root), solution.maxDepth2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-左斜树 → 输出：4");
    }

    @Test
    public void testMaxDepth2_RightSkewed() {
        // 右斜树：[1,null,2,null,3,null,4] → 4
        TreeNode root = node(1);
        TreeNode n2 = node(2);
        TreeNode n3 = node(3);
        root.setRight(n2);
        n2.setRight(n3);
        n3.setRight(node(4));

        assertEquals(4, solution.maxDepth2(root)); // BFS 验证右斜树深度为 4
        assertEquals(solution.maxDepth(root), solution.maxDepth2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-右斜树 → 输出：4");
    }

    @Test
    public void testMaxDepth2_BalancedTree() {
        // 平衡二叉树：[1,2,3,4,5,6,7] → 3
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(3);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(4));
        left.setRight(node(5));
        right.setLeft(node(6));
        right.setRight(node(7));

        assertEquals(3, solution.maxDepth2(root)); // BFS 验证平衡树深度为 3
        assertEquals(solution.maxDepth(root), solution.maxDepth2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-平衡树 → 输出：3");
    }

    @Test
    public void testMaxDepth2_ComplexTree() {
        // 复杂树结构 → 4
        TreeNode root = node(1);
        TreeNode left = node(2);
        TreeNode right = node(3);
        root.setLeft(left);
        root.setRight(right);
        left.setLeft(node(4));
        right.setLeft(node(5));
        right.setRight(node(6));
        left.getLeft().setLeft(node(7));

        assertEquals(4, solution.maxDepth2(root)); // BFS 验证复杂树深度为 4
        assertEquals(solution.maxDepth(root), solution.maxDepth2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-复杂树 → 输出：4");
    }

    @Test
    public void testMaxDepth2_NegativeValues() {
        // 含负数节点的树 → 3
        TreeNode root = node(-1);
        TreeNode left = node(-3);
        root.setLeft(left);
        root.setRight(node(2));
        left.setLeft(node(-5));

        assertEquals(3, solution.maxDepth2(root)); // BFS 验证含负数树的深度为 3
        assertEquals(solution.maxDepth(root), solution.maxDepth2(root)); // DFS 和 BFS 结果一致

        System.out.println("BFS-含负数树 → 输出：3");
    }
}
