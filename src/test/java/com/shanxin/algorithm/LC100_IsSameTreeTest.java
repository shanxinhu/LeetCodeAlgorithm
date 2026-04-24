package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC100_IsSameTreeTest {

    private final LC100_IsSameTree solution = new LC100_IsSameTree();

    /** 辅助方法：创建 TreeNode */
    private TreeNode node(int val) {
        return new TreeNode(val);
    }

    /** ==================== isSameTree (深度优先) 的测试 ==================== */

    @Test
    public void testIsSameTree_Example1() {
        // 示例 1：p = [1,2,3], q = [1,2,3] → true
        //      1         1
        //     / \       / \
        //    2   3     2   3
        TreeNode p = node(1);
        p.setLeft(node(2));
        p.setRight(node(3));

        TreeNode q = node(1);
        q.setLeft(node(2));
        q.setRight(node(3));

        assertTrue(solution.isSameTree(p, q)); // 两棵树结构和值完全相同

        System.out.println("示例 1 - 输入：[1,2,3] 和 [1,2,3] → 输出：true");
    }

    @Test
    public void testIsSameTree_Example2() {
        // 示例 2：p = [1,2], q = [1,null,2] → false
        //      1         1
        //     /           \
        //    2             2
        TreeNode p = node(1);
        p.setLeft(node(2));

        TreeNode q = node(1);
        q.setRight(node(2));

        assertFalse(solution.isSameTree(p, q)); // 结构不同（左子树 vs 右子树）

        System.out.println("示例 2 - 输入：[1,2] 和 [1,null,2] → 输出：false");
    }

    @Test
    public void testIsSameTree_Example3() {
        // 示例 3：p = [1,2,1], q = [1,1,2] → false
        //      1         1
        //     / \       / \
        //    2   1     1   2
        TreeNode p = node(1);
        p.setLeft(node(2));
        p.setRight(node(1));

        TreeNode q = node(1);
        q.setLeft(node(1));
        q.setRight(node(2));

        assertFalse(solution.isSameTree(p, q)); // 值的位置不同

        System.out.println("示例 3 - 输入：[1,2,1] 和 [1,1,2] → 输出：false");
    }

    @Test
    public void testIsSameTree_BothNull() {
        // 两棵空树 → true
        assertTrue(solution.isSameTree(null, null)); // 空树视为相同

        System.out.println("两棵空树 → 输出：true");
    }

    @Test
    public void testIsSameTree_OneNull() {
        // 一棵为空，一棵非空 → false
        TreeNode p = node(1);
        assertFalse(solution.isSameTree(p, null)); // p 非空，q 为空
        assertFalse(solution.isSameTree(null, p)); // p 为空，q 非空

        System.out.println("一棵为空 → 输出：false");
    }

    @Test
    public void testIsSameTree_SingleNode() {
        // 单节点树，值相同 → true
        assertTrue(solution.isSameTree(node(5), node(5))); // 值相同

        System.out.println("单节点相同 → 输出：true");
    }

    @Test
    public void testIsSameTree_SingleNodeDifferent() {
        // 单节点树，值不同 → false
        assertFalse(solution.isSameTree(node(5), node(6))); // 值不同

        System.out.println("单节点不同 → 输出：false");
    }

    @Test
    public void testIsSameTree_DeepTree() {
        // 深层树完全相同 → true
        //       1           1
        //      / \         / \
        //     2   3       2   3
        //    /           /
        //   4           4
        TreeNode p = node(1);
        TreeNode p2 = node(2);
        p.setLeft(p2);
        p.setRight(node(3));
        p2.setLeft(node(4));

        TreeNode q = node(1);
        TreeNode q2 = node(2);
        q.setLeft(q2);
        q.setRight(node(3));
        q2.setLeft(node(4));

        assertTrue(solution.isSameTree(p, q)); // 深层结构完全相同

        System.out.println("深层树相同 → 输出：true");
    }

    @Test
    public void testIsSameTree_DeepTreeDifferent() {
        // 深层树某处不同 → false
        //       1           1
        //      / \         / \
        //     2   3       2   3
        //    /           /
        //   4           5
        TreeNode p = node(1);
        TreeNode p2 = node(2);
        p.setLeft(p2);
        p.setRight(node(3));
        p2.setLeft(node(4));

        TreeNode q = node(1);
        TreeNode q2 = node(2);
        q.setLeft(q2);
        q.setRight(node(3));
        q2.setLeft(node(5)); // 叶子节点值不同

        assertFalse(solution.isSameTree(p, q)); // 叶子节点值不同

        System.out.println("深层树不同 → 输出：false");
    }

    @Test
    public void testIsSameTree_NegativeValues() {
        // 含负数节点，完全相同 → true
        //      -1          -1
        //      / \         / \
        //    -3   2      -3   2
        TreeNode p = node(-1);
        p.setLeft(node(-3));
        p.setRight(node(2));

        TreeNode q = node(-1);
        q.setLeft(node(-3));
        q.setRight(node(2));

        assertTrue(solution.isSameTree(p, q)); // 含负数的相同树

        System.out.println("含负数相同 → 输出：true");
    }

    @Test
    public void testIsSameTree_ComplexTree() {
        // 复杂二叉树完全相同 → true
        //        1             1
        //       / \           / \
        //      2   3         2   3
        //     / \   \       / \   \
        //    4   5   6     4   5   6
        TreeNode p = node(1);
        TreeNode p2 = node(2);
        TreeNode p3 = node(3);
        p.setLeft(p2);
        p.setRight(p3);
        p2.setLeft(node(4));
        p2.setRight(node(5));
        p3.setRight(node(6));

        TreeNode q = node(1);
        TreeNode q2 = node(2);
        TreeNode q3 = node(3);
        q.setLeft(q2);
        q.setRight(q3);
        q2.setLeft(node(4));
        q2.setRight(node(5));
        q3.setRight(node(6));

        assertTrue(solution.isSameTree(p, q)); // 复杂结构完全相同

        System.out.println("复杂树相同 → 输出：true");
    }

    /** ==================== isSameTree2 (广度优先) 的测试 ==================== */

    @Test
    public void testIsSameTree2_Example1() {
        // 示例 1：p = [1,2,3], q = [1,2,3] → true
        TreeNode p = node(1);
        p.setLeft(node(2));
        p.setRight(node(3));

        TreeNode q = node(1);
        q.setLeft(node(2));
        q.setRight(node(3));

        assertTrue(solution.isSameTree2(p, q)); // BFS 验证相同树
        assertEquals(solution.isSameTree(p, q), solution.isSameTree2(p, q)); // DFS 和 BFS 结果一致

        System.out.println("BFS-示例 1 - 输入：[1,2,3] 和 [1,2,3] → 输出：true");
    }

    @Test
    public void testIsSameTree2_Example2() {
        // 示例 2：p = [1,2], q = [1,null,2] → false
        TreeNode p = node(1);
        p.setLeft(node(2));

        TreeNode q = node(1);
        q.setRight(node(2));

        assertFalse(solution.isSameTree2(p, q)); // BFS 验证结构不同
        assertEquals(solution.isSameTree(p, q), solution.isSameTree2(p, q)); // DFS 和 BFS 结果一致

        System.out.println("BFS-示例 2 - 输入：[1,2] 和 [1,null,2] → 输出：false");
    }

    @Test
    public void testIsSameTree2_Example3() {
        // 示例 3：p = [1,2,1], q = [1,1,2] → false
        TreeNode p = node(1);
        p.setLeft(node(2));
        p.setRight(node(1));

        TreeNode q = node(1);
        q.setLeft(node(1));
        q.setRight(node(2));

        assertFalse(solution.isSameTree2(p, q)); // BFS 验证值位置不同
        assertEquals(solution.isSameTree(p, q), solution.isSameTree2(p, q)); // DFS 和 BFS 结果一致

        System.out.println("BFS-示例 3 - 输入：[1,2,1] 和 [1,1,2] → 输出：false");
    }

    @Test
    public void testIsSameTree2_BothNull() {
        // 两棵空树 → true
        assertTrue(solution.isSameTree2(null, null)); // BFS 处理空树

        System.out.println("BFS-两棵空树 → 输出：true");
    }

    @Test
    public void testIsSameTree2_OneNull() {
        // 一棵为空，一棵非空 → false
        TreeNode p = node(1);
        assertFalse(solution.isSameTree2(p, null)); // BFS 处理一空一非空
        assertFalse(solution.isSameTree2(null, p));

        System.out.println("BFS-一棵为空 → 输出：false");
    }

    @Test
    public void testIsSameTree2_SingleNode() {
        // 单节点树，值相同 → true
        assertTrue(solution.isSameTree2(node(5), node(5))); // BFS 验证单节点相同

        System.out.println("BFS-单节点相同 → 输出：true");
    }

    @Test
    public void testIsSameTree2_SingleNodeDifferent() {
        // 单节点树，值不同 → false
        assertFalse(solution.isSameTree2(node(5), node(6))); // BFS 验证单节点不同

        System.out.println("BFS-单节点不同 → 输出：false");
    }

    @Test
    public void testIsSameTree2_DeepTree() {
        // 深层树完全相同 → true
        TreeNode p = node(1);
        TreeNode p2 = node(2);
        p.setLeft(p2);
        p.setRight(node(3));
        p2.setLeft(node(4));

        TreeNode q = node(1);
        TreeNode q2 = node(2);
        q.setLeft(q2);
        q.setRight(node(3));
        q2.setLeft(node(4));

        assertTrue(solution.isSameTree2(p, q)); // BFS 验证深层树相同
        assertEquals(solution.isSameTree(p, q), solution.isSameTree2(p, q)); // DFS 和 BFS 结果一致

        System.out.println("BFS-深层树相同 → 输出：true");
    }

    @Test
    public void testIsSameTree2_DeepTreeDifferent() {
        // 深层树某处不同 → false
        TreeNode p = node(1);
        TreeNode p2 = node(2);
        p.setLeft(p2);
        p.setRight(node(3));
        p2.setLeft(node(4));

        TreeNode q = node(1);
        TreeNode q2 = node(2);
        q.setLeft(q2);
        q.setRight(node(3));
        q2.setLeft(node(5)); // 叶子节点值不同

        assertFalse(solution.isSameTree2(p, q)); // BFS 验证深层树不同
        assertEquals(solution.isSameTree(p, q), solution.isSameTree2(p, q)); // DFS 和 BFS 结果一致

        System.out.println("BFS-深层树不同 → 输出：false");
    }

    @Test
    public void testIsSameTree2_NegativeValues() {
        // 含负数节点，完全相同 → true
        TreeNode p = node(-1);
        p.setLeft(node(-3));
        p.setRight(node(2));

        TreeNode q = node(-1);
        q.setLeft(node(-3));
        q.setRight(node(2));

        assertTrue(solution.isSameTree2(p, q)); // BFS 验证含负数相同树
        assertEquals(solution.isSameTree(p, q), solution.isSameTree2(p, q)); // DFS 和 BFS 结果一致

        System.out.println("BFS-含负数相同 → 输出：true");
    }

    @Test
    public void testIsSameTree2_ComplexTree() {
        // 复杂二叉树完全相同 → true
        TreeNode p = node(1);
        TreeNode p2 = node(2);
        TreeNode p3 = node(3);
        p.setLeft(p2);
        p.setRight(p3);
        p2.setLeft(node(4));
        p2.setRight(node(5));
        p3.setRight(node(6));

        TreeNode q = node(1);
        TreeNode q2 = node(2);
        TreeNode q3 = node(3);
        q.setLeft(q2);
        q.setRight(q3);
        q2.setLeft(node(4));
        q2.setRight(node(5));
        q3.setRight(node(6));

        assertTrue(solution.isSameTree2(p, q)); // BFS 验证复杂树相同
        assertEquals(solution.isSameTree(p, q), solution.isSameTree2(p, q)); // DFS 和 BFS 结果一致

        System.out.println("BFS-复杂树相同 → 输出：true");
    }
}
