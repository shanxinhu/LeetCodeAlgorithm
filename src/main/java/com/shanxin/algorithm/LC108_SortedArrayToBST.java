package com.shanxin.algorithm;

import com.shanxin.algorithm.node.TreeNode;

public class LC108_SortedArrayToBST {

    /*

      https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
           108. 将有序数组转换为二叉搜索树
            简单
            相关标签
            premium lock icon
            相关企业
            给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 平衡 二叉搜索树。



            示例 1：


            输入：nums = [-10,-3,0,5,9]
            输出：[0,-3,9,-10,null,5]
            解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：

            示例 2：


            输入：nums = [1,3]
            输出：[3,1]
            解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。


            提示：

            1 <= nums.length <= 104
            -104 <= nums[i] <= 104
            nums 按 严格递增 顺序排列

   */



    /**
     * 将有序数组转换为高度平衡的二叉搜索树
     * 思路：选择数组中间元素作为根节点，递归构建左右子树
     *
     * @param nums 升序排列的整数数组
     * @return 平衡二叉搜索树的根节点
     * 
     * 时间复杂度：O(n)，其中 n 是数组长度，每个元素创建为一个节点
     * 空间复杂度：O(log n)，递归调用栈的深度为树的高度，平衡树高度为 log n
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1); // 调用递归方法构建 BST
    }

    /**
     * 递归构建平衡二叉搜索树
     * 思路：选择区间中间元素作为根，左半部分构建左子树，右半部分构建右子树
     *
     * @param nums  升序数组
     * @param left  当前区间的左边界
     * @param right 当前区间的右边界
     * @return 当前子树的根节点
     */
    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) { // 递归终止条件：区间无效
            return null; // 返回空节点
        }
        int mid = (left + right) / 2; // 计算中间位置（向下取整）
        TreeNode root = new TreeNode(nums[mid]); // 以中间元素创建根节点
        root.setLeft(buildTree(nums, left, mid - 1)); // 递归构建左子树（左半部分）
        root.setRight(buildTree(nums, mid + 1, right)); // 递归构建右子树（右半部分）
        return root; // 返回当前子树的根节点
    }


}
