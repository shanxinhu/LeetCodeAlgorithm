package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaxDepth {

    /*

      https://leetcode.cn/problems/maximum-depth-of-binary-tree/
            104. 二叉树的最大深度
            简单
            相关标签
            premium lock icon
            相关企业
            给定一个二叉树 root ，返回其最大深度。

            二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。



            示例 1：





            输入：root = [3,9,20,null,null,15,7]
            输出：3
            示例 2：

            输入：root = [1,null,2]
            输出：2


            提示：

            树中节点的数量在 [0, 104] 区间内。
            -100 <= Node.val <= 100

   */



    /**
     * 深度优先搜索（DFS）计算二叉树的最大深度
     * 思路：递归计算左右子树的最大深度，取较大值加 1（当前节点）
     *
     * @param root 二叉树的根节点
     * @return 二叉树的最大深度（节点数）
     * 
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数，每个节点访问一次
     * 空间复杂度：O(h)，其中 h 是二叉树的高度，递归调用栈的深度
     *           最坏情况（斜树）：O(n)，平均情况（平衡树）：O(log n)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // 空节点返回深度 0（递归终止条件）
        return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1; // 左右子树最大深度 + 1（当前节点）
    }

    /**
     * 广度优先搜索（BFS）计算二叉树的最大深度（层序遍历）
     * 思路：逐层遍历二叉树，每遍历完一层，深度加 1
     *
     * @param root 二叉树的根节点
     * @return 二叉树的最大深度（层数）
     * 
     * 时间复杂度：O(n)，其中 n 是二叉树的节点数，每个节点入队出队各一次
     * 空间复杂度：O(w)，其中 w 是二叉树的最大宽度，队列最多存储一层的节点
     *           最坏情况（完全二叉树最后一层）：O(n/2) = O(n)
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0; // 空树返回深度 0
        int depth = 0; // 初始化深度为 0
        Queue<TreeNode> queue = new LinkedList<>(); // 创建队列用于层序遍历
        queue.offer(root); // 根节点入队
        while (!queue.isEmpty()) { // 当队列不为空时继续遍历
            int size = queue.size(); // 记录当前层的节点数
            while (size > 0){ // 遍历当前层的所有节点
                TreeNode node = queue.poll(); // 取出队首节点
                if (node.getLeft() != null) { // 如果左子节点存在
                    queue.offer(node.getLeft()); // 左子节点入队
                }
                if (node.getRight() != null) { // 如果右子节点存在
                    queue.offer(node.getRight()); // 右子节点入队
                }
                size--; // 当前层节点数减 1
            }
            depth++; // 遍历完一层，深度加 1
        }
        return depth; // 返回最大深度
     }


}
