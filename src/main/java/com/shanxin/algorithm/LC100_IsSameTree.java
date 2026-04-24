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


    /**
     * 判断两棵二叉树是否相同（深度优先搜索）
     * 时间复杂度：O(min(m, n))，其中 m 和 n 分别是两棵树的节点数
     * 空间复杂度：O(min(m, n))，递归调用栈的深度取决于较矮的树的高度
     *
     * @param p 第一棵树的根节点
     * @param q 第二棵树的根节点
     * @return 如果两棵树结构和值都相同返回 true，否则返回 false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 两棵树都为空，视为相同
        if (p == null && q == null) {
            return true;
        // 一棵为空一棵非空，结构不同
        } else if (p == null || q == null) {
            return false;
        // 节点值不同
        } else if (p.getVal() != q.getVal()) {
            return false;
        // 递归比较左右子树
        } else {
            return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
        }

    }


    /**
     * 判断两棵二叉树是否相同（广度优先搜索）
     * 时间复杂度：O(min(m, n))，其中 m 和 n 分别是两棵树的节点数
     * 空间复杂度：O(min(m, n))，队列中最多存储较矮树一层的节点数
     *
     * @param p 第一棵树的根节点
     * @param q 第二棵树的根节点
     * @return 如果两棵树结构和值都相同返回 true，否则返回 false
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        // 两棵树都为空，视为相同
        if (p == null && q == null) {
            return true;
        // 一棵为空一棵非空，结构不同
        } else if (p == null || q == null) {
            return false;
        }

        // 创建两个队列分别存储两棵树的节点
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p); // 将第一棵树的根节点入队
        queue2.offer(q); // 将第二棵树的根节点入队
        
        // 当两个队列都不为空时，逐层比较节点
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll(); // 取出第一棵树的当前节点
            TreeNode node2 = queue2.poll(); // 取出第二棵树的当前节点
            
            // 比较节点值
            if (node1.getVal() != node2.getVal()) {
                return false;
            }
            
            // 获取左右子节点
            TreeNode left1 = node1.getLeft();
            TreeNode left2 = node2.getLeft();
            TreeNode right1 = node1.getRight();
            TreeNode right2 = node2.getRight();
            
            // 异或判断：一个为空一个非空，结构不同
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            
            // 左子节点都不为空，加入队列
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            
            // 右子节点都不为空，加入队列
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }

        }
        
        // 两个队列都为空说明所有节点都比较完毕且相同
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
