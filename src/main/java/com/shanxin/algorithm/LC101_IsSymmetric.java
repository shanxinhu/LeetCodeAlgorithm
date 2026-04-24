package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC101_IsSymmetric {

    /*

        https://leetcode.cn/problems/symmetric-tree/
       101. 对称二叉树
            简单
            相关标签
            premium lock icon
            相关企业
            给你一个二叉树的根节点 root ， 检查它是否轴对称。



            示例 1：


            输入：root = [1,2,2,3,4,4,3]
            输出：true
            示例 2：


            输入：root = [1,2,2,null,3,null,3]
            输出：false


            提示：

            树中节点数目在范围 [1, 1000] 内
            -100 <= Node.val <= 100


            进阶：你可以运用递归和迭代两种方法解决这个问题吗？

     */


    /**
     * 判断二叉树是否轴对称（递归实现）
     * 时间复杂度：O(n)，其中 n 是树的节点数，需要遍历所有节点
     * 空间复杂度：O(h)，其中 h 是树的高度，递归调用栈的深度
     *
     * @param root 二叉树的根节点
     * @return 如果二叉树轴对称返回 true，否则返回 false
     */
    public boolean isSymmetric(TreeNode root) {
        // 递归比较左右子树是否镜像对称
        return check(root.getLeft(), root.getRight());
    }

    /**
     * 递归检查两棵树是否镜像对称
     * 时间复杂度：O(min(m, n))，其中 m 和 n 分别是两棵树的节点数
     * 空间复杂度：O(min(h1, h2))，递归栈深度取决于较矮的树
     *
     * @param p 第一棵树的节点
     * @param q 第二棵树的节点（与 p 镜像对应）
     * @return 如果两棵树镜像对称返回 true，否则返回 false
     */
    private boolean check(TreeNode p, TreeNode q) {
        // 两个节点都为空，镜像对称
        if (p == null && q == null) {
            return true;
        }
        // 一个为空一个非空，不对称
        if (p == null || q == null) {
            return false;
        }
        // 值相同且左子树与右子树镜像、右子树与左子树镜像
        return p.getVal() == q.getVal() && check(p.getLeft(), q.getRight()) && check(p.getRight(), q.getLeft());
    }


    /**
     * 判断二叉树是否轴对称（迭代实现 - 广度优先搜索）
     * 时间复杂度：O(n)，其中 n 是树的节点数，需要遍历所有节点
     * 空间复杂度：O(n)，队列中最多存储一层的节点数
     *
     * @param root 二叉树的根节点
     * @return 如果二叉树轴对称返回 true，否则返回 false
     */
    public boolean isSymmetric2(TreeNode root) {
        // 将根节点入队两次，用于镜像比较
        return check2(root, root);
    }

    /**
     * 迭代检查两棵树是否镜像对称（使用队列）
     * 时间复杂度：O(n)，需要遍历所有节点
     * 空间复杂度：O(n)，队列存储待比较的节点对
     *
     * @param p 第一棵树的根节点
     * @param q 第二棵树的根节点（与 p 镜像对应）
     * @return 如果两棵树镜像对称返回 true，否则返回 false
     */
    private boolean check2(TreeNode p, TreeNode q) {
        // 创建队列存储待比较的节点对
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p); // 第一个节点入队
        queue.offer(q); // 第二个节点入队（镜像对应）
        
        // 当队列不为空时，逐对比较节点
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll(); // 取出第一棵树的节点
            TreeNode node2 = queue.poll(); // 取出第二棵树的节点（镜像对应）

            // 两个节点都为空，继续比较下一对
            if (node1 == null && node2 == null) {
                continue;
            }
            // 一个为空一个非空，或值不同，不对称
            if (node1 == null || node2 == null || node1.getVal() != node2.getVal()) {
                return false;
            }

            // 将镜像对应的子节点成对入队
            queue.offer(node1.getLeft());   // 第一棵树的左子节点
            queue.offer(node2.getRight());  // 第二棵树的右子节点（镜像）
            queue.offer(node1.getRight());  // 第一棵树的右子节点
            queue.offer(node2.getLeft());   // 第二棵树的左子节点（镜像）

        }

        // 所有节点都比较完毕且对称
        return true;
    }
}
