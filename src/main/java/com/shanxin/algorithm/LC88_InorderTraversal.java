package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC88_InorderTraversal {

    /*
  https://leetcode.cn/problems/binary-tree-inorder-traversal/
   94. 二叉树的中序遍历
            简单
            相关标签
            premium lock icon
            相关企业
            给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。



            示例 1：


            输入：root = [1,null,2,3]
            输出：[1,3,2]
            示例 2：

            输入：root = []
            输出：[]
            示例 3：

            输入：root = [1]
            输出：[1]


            提示：

            树中节点数目在范围 [0, 100] 内
            -100 <= Node.val <= 100


            进阶: 递归算法很简单，你可以通过迭代算法完成吗？

     */


    /**
     * 递归中序遍历二叉树：左子树 → 根节点 → 右子树
     *
     * 时间复杂度：O(n)，其中 n 为树的节点数，每个节点恰好被访问一次。
     * 空间复杂度：O(h)，其中 h 为树的高度，递归调用栈的深度。
     *             最坏情况（链状树）O(n)，最好情况（平衡树）O(log n)。
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.getLeft(), list);  // 遍历左子树
        list.add(node.getVal());        // 访问根节点
        inorder(node.getRight(), list); // 遍历右子树
    }

    /**
     * 迭代中序遍历二叉树：左子树 → 根节点 → 右子树（使用栈模拟递归）
     *
     * 算法思路：
     * 1. 持续将当前节点及其所有左子节点压入栈中，直到最左侧叶子节点。
     * 2. 弹出栈顶节点（当前最左未访问节点），将其值加入结果列表。
     * 3. 转向该节点的右子树，重复上述过程。
     *
     * 时间复杂度：O(n)，其中 n 为树的节点数，每个节点恰好被访问一次。
     * 空间复杂度：O(h)，其中 h 为树的高度，栈的最大深度。
     *             最坏情况（链状树）O(n)，最好情况（平衡树）O(log n)。
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>(); // 存储中序遍历结果
        Deque<TreeNode> stack = new ArrayDeque<>(); // 用栈模拟递归调用栈
        while (root != null || !stack.isEmpty()) { // 当还有未处理的节点或栈非空时继续循环
            while (root != null){ // 持续向左走，将所有左子节点压入栈中
                stack.push(root); // 将当前节点压入栈，等待后续处理
                root = root.getLeft(); // 移动到左子节点，继续深入左侧路径
            }
            root = stack.pop(); // 弹出栈顶节点（当前最左未访问节点）
            list.add(root.getVal()); // 访问该节点，将值加入结果列表（中序：左→根→右）
            root = root.getRight(); // 转向右子树，准备处理右子节点及其子树
                
        }
        return list; // 返回完整的中序遍历结果
    }

}
