package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC3033_ModifiedMatrixTest {

    private final LC3033_ModifiedMatrix solution = new LC3033_ModifiedMatrix(); // 创建被测试的解决方案实例

    @Test
    public void testModifiedMatrix_Example1() {
        // 示例 1：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
        // 输出：[[1,2,9],[4,8,6],[7,8,9]]
        int[][] matrix = {
            {1, 2, -1},
            {4, -1, 6},
            {7, 8, 9}
        }; // 输入矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(3, result.length); // 验证结果为 3 行
        assertEquals(3, result[0].length); // 验证结果为 3 列
        
        // 验证每个元素的值
        assertArrayEquals(new int[]{1, 2, 9}, result[0]); // 第 0 行：-1 替换为列 2 的最大值 9
        assertArrayEquals(new int[]{4, 8, 6}, result[1]); // 第 1 行：-1 替换为列 1 的最大值 8
        assertArrayEquals(new int[]{7, 8, 9}, result[2]); // 第 2 行：无变化
        
        System.out.println("示例 1 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_Example2() {
        // 示例 2：matrix = [[3,-1],[5,2]]
        // 输出：[[3,2],[5,2]]
        int[][] matrix = {
            {3, -1},
            {5, 2}
        }; // 输入矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(2, result.length); // 验证结果为 2 行
        assertEquals(2, result[0].length); // 验证结果为 2 列
        
        // 验证每个元素的值
        assertArrayEquals(new int[]{3, 2}, result[0]); // 第 0 行：-1 替换为列 1 的最大值 2
        assertArrayEquals(new int[]{5, 2}, result[1]); // 第 1 行：无变化
        
        System.out.println("示例 2 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_NoNegativeOne() {
        // 没有 -1 的情况
        // matrix = [[1,2],[3,4]]
        // 输出：[[1,2],[3,4]]（无变化）
        int[][] matrix = {
            {1, 2},
            {3, 4}
        }; // 输入矩阵（没有 -1）
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        
        // 验证结果与原矩阵相同
        assertArrayEquals(new int[]{1, 2}, result[0]); // 第 0 行无变化
        assertArrayEquals(new int[]{3, 4}, result[1]); // 第 1 行无变化
        
        System.out.println("无-1 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_AllNegativeOneInColumn() {
        // 某一列全是 -1（但题目保证每列至少有一个非负整数，所以这种情况不会出现）
        // 测试某列只有一个非负数的情况
        // matrix = [[1,-1],[2,-1],[3,5]]
        // 列 1 的最大值是 5
        // 输出：[[1,5],[2,5],[3,5]]
        int[][] matrix = {
            {1, -1},
            {2, -1},
            {3, 5}
        }; // 输入矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        
        // 验证每个元素的值
        assertArrayEquals(new int[]{1, 5}, result[0]); // 第 0 行：-1 替换为列 1 的最大值 5
        assertArrayEquals(new int[]{2, 5}, result[1]); // 第 1 行：-1 替换为列 1 的最大值 5
        assertArrayEquals(new int[]{3, 5}, result[2]); // 第 2 行：无变化
        
        System.out.println("多-1同列 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_SingleRow() {
        // 单行矩阵
        // matrix = [[1,-1,3]]
        // 输出：[[1,3,3]]（-1 替换为列 1 的最大值 3，但只有一行，所以就是它自己）
        // 实际上列 1 只有一个元素 -1，但题目保证每列至少有一个非负整数
        // 改为：matrix = [[1,2,3]]
        // 输出：[[1,2,3]]（无变化）
        int[][] matrix = {
            {1, 2, 3}
        }; // 单行矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.length); // 验证结果为 1 行
        
        assertArrayEquals(new int[]{1, 2, 3}, result[0]); // 无变化
        
        System.out.println("单行 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_SingleColumn() {
        // 单列矩阵
        // matrix = [[1],[-1],[3]]
        // 列 0 的最大值是 3
        // 输出：[[1],[3],[3]]
        int[][] matrix = {
            {1},
            {-1},
            {3}
        }; // 单列矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(3, result.length); // 验证结果为 3 行
        assertEquals(1, result[0].length); // 验证结果为 1 列
        
        // 验证每个元素的值
        assertEquals(1, result[0][0]); // 第 0 行无变化
        assertEquals(3, result[1][0]); // 第 1 行：-1 替换为列 0 的最大值 3
        assertEquals(3, result[2][0]); // 第 2 行无变化
        
        System.out.println("单列 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_MultipleColumnsWithNegativeOne() {
        // 多列都有 -1
        // matrix = [[-1,2,-1],[4,-1,6],[-1,8,-1]]
        // 列 0 最大值：4，列 1 最大值：8，列 2 最大值：6
        // 输出：[[4,2,6],[4,8,6],[4,8,6]]
        int[][] matrix = {
            {-1, 2, -1},
            {4, -1, 6},
            {-1, 8, -1}
        }; // 输入矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        
        // 验证每个元素的值
        assertArrayEquals(new int[]{4, 2, 6}, result[0]); // 第 0 行：-1 替换为对应列的最大值
        assertArrayEquals(new int[]{4, 8, 6}, result[1]); // 第 1 行：-1 替换为对应列的最大值
        assertArrayEquals(new int[]{4, 8, 6}, result[2]); // 第 2 行：-1 替换为对应列的最大值
        
        System.out.println("多列-1 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_MaximumSize() {
        // 最大尺寸测试：50x50
        int m = 50; // 行数
        int n = 50; // 列数
        int[][] matrix = new int[m][n]; // 创建最大尺寸的矩阵
        
        // 填充矩阵，每列最后一个元素为该列索引 + 1（确保非负）
        for (int i = 0; i < m; i++) { // 遍历每一行
            for (int j = 0; j < n; j++) { // 遍历每一列
                if (i == m - 1) { // 最后一行
                    matrix[i][j] = j + 1; // 设置为非负数
                } else { // 其他行
                    matrix[i][j] = -1; // 设置为 -1
                }
            }
        }
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(m, result.length); // 验证结果为 50 行
        assertEquals(n, result[0].length); // 验证结果为 50 列
        
        // 验证最后一行不变，其他行的 -1 被替换为对应列的最大值
        for (int j = 0; j < n; j++) { // 遍历每一列
            for (int i = 0; i < m; i++) { // 遍历每一行
                assertEquals(j + 1, result[i][j]); // 所有元素都应该等于该列的最大值
            }
        }
        
        System.out.println("最大尺寸 - 输入：" + m + "x" + n + " 矩阵"); // 打印输入信息
        System.out.println("输出：所有元素已替换为对应列的最大值"); // 打印输出结果
    }

    @Test
    public void testModifiedMatrix_MinimumSize() {
        // 最小尺寸测试：2x2
        // matrix = [[-1,1],[2,3]]
        // 列 0 最大值：2，列 1 最大值：3
        // 输出：[[2,1],[2,3]]
        int[][] matrix = {
            {-1, 1},
            {2, 3}
        }; // 最小尺寸矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(2, result.length); // 验证结果为 2 行
        assertEquals(2, result[0].length); // 验证结果为 2 列
        
        // 验证每个元素的值
        assertArrayEquals(new int[]{2, 1}, result[0]); // 第 0 行：-1 替换为列 0 的最大值 2
        assertArrayEquals(new int[]{2, 3}, result[1]); // 第 1 行：无变化
        
        System.out.println("最小尺寸 - 输入："); // 打印输入信息
        printMatrix(matrix);
        System.out.println("输出："); // 打印输出结果
        printMatrix(result);
    }

    @Test
    public void testModifiedMatrix_ResultNotSameObject() {
        // 验证返回的是新矩阵，不是原矩阵的引用
        int[][] matrix = {
            {1, -1},
            {2, 3}
        }; // 输入矩阵
        
        int[][] result = solution.modifiedMatrix(matrix); // 调用方法修改矩阵
        
        assertNotNull(result); // 验证结果不为 null
        assertNotSame(matrix, result); // 验证结果不是原矩阵的引用
        
        System.out.println("对象独立性 - 验证返回新矩阵对象"); // 打印输入信息
    }

    /**
     * 辅助方法：打印矩阵
     */
    private void printMatrix(int[][] matrix) {
        for (int[] row : matrix) { // 遍历每一行
            System.out.print("[");
            for (int i = 0; i < row.length; i++) { // 遍历每一列
                System.out.print(row[i]);
                if (i < row.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
