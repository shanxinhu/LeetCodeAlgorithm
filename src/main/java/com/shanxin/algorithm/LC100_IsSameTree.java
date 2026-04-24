package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LC100_IsSameTree {

    /*

        https://leetcode.cn/problems/same-tree/
         100. 相同的树
            简单
            相关标签
            premium lock icon
            相关企业
            给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

            如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。



            示例 1：


            输入：p = [1,2,3], q = [1,2,3]
            输出：true
            示例 2：


            输入：p = [1,2], q = [1,null,2]
            输出：false
            示例 3：


            输入：p = [1,2,1], q = [1,1,2]
            输出：false


            提示：

            两棵树上的节点数目都在范围 [0, 100] 内
            -104 <= Node.val <= 104

     */


    public boolean isSameTree(TreeNode p, TreeNode q) {

        // 深度优先
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else if (p.getVal() != q.getVal()) {
            return false;
        } else {
            return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
        }

    }


    public boolean isSameTree2(TreeNode p, TreeNode q) {

        // 广度优先
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.getVal() != node2.getVal()) {
                return false;
            }
            TreeNode left1 = node1.getLeft();
            TreeNode left2 = node2.getLeft();
            TreeNode right1 = node1.getRight();
            TreeNode right2 = node2.getRight();
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }

        }

        return queue1.isEmpty() && queue2.isEmpty();
    }
}
