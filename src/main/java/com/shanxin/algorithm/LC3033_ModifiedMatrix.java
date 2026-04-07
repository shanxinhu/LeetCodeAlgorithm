package com.shanxin.algorithm;

public class LC3033_ModifiedMatrix {

    /*

        https://leetcode.cn/problems/modify-the-matrix/
        3033. 修改矩阵
            简单
            相关标签
            premium lock icon
            相关企业
            给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。

            返回矩阵 answer 。



            示例 1：


            输入：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
            输出：[[1,2,9],[4,8,6],[7,8,9]]
            解释：上图显示了发生替换的元素（蓝色区域）。
            - 将单元格 [1][1] 中的值替换为列 1 中的最大值 8 。
            - 将单元格 [0][2] 中的值替换为列 2 中的最大值 9 。
            示例 2：


            输入：matrix = [[3,-1],[5,2]]
            输出：[[3,2],[5,2]]
            解释：上图显示了发生替换的元素（蓝色区域）。


            提示：

            m == matrix.length
            n == matrix[i].length
            2 <= m, n <= 50
            -1 <= matrix[i][j] <= 100
            测试用例中生成的输入满足每列至少包含一个非负整数。
     */


    public int[][] modifiedMatrix(int[][] matrix) { // 将矩阵中的 -1 替换为所在列的最大元素
        // 时间复杂度：O(m * n)，其中 m 是行数，n 是列数，需要遍历矩阵两次
        // 空间复杂度：O(m * n)，存储结果矩阵
        int m = matrix.length; // 获取矩阵的行数
        int n = matrix[0].length; // 获取矩阵的列数
        int[][] ans = new int[m][n]; // 创建结果矩阵
        for (int i = 0; i < m; i++) { // 复制原矩阵到结果矩阵
            for (int j = 0; j < n; j++) { // 遍历每一列
                ans[i][j] = matrix[i][j]; // 复制元素
            }
        }
        for (int j = 0; j < n; j++) { // 遍历每一列
            int max = -1; // 初始化当前列的最大值为 -1
            for (int i = 0; i < m; i++) { // 遍历当前列的所有行
                max = Math.max(max, matrix[i][j]); // 更新当前列的最大值
            }
            for (int i = 0; i < m; i++) { // 再次遍历当前列的所有行
                if (matrix[i][j] == -1) { // 如果当前元素是 -1
                    ans[i][j] = max; // 替换为当前列的最大值
                }
            }
        }
        return ans; // 返回修改后的矩阵
    }


}
