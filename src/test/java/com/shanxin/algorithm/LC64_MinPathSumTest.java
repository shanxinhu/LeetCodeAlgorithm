package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC64_MinPathSumTest {

    private final LC64_MinPathSum solution = new LC64_MinPathSum(); // 创建被测试的解决方案实例

    @Test
    public void testMinPathSum_Example1() {
        // 示例 1：grid = [[1,3,1],[1,5,1],[4,2,1]]
        // 输出：7
        // 路径：1→3→1→1→1 = 7
        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        }; // 输入网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(7, result); // 验证结果等于预期值 7
        
        System.out.println("示例 1 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_Example2() {
        // 示例 2：grid = [[1,2,3],[4,5,6]]
        // 输出：12
        // 路径：1→2→3→6 = 12
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6}
        }; // 输入网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(12, result); // 验证结果等于预期值 12
        
        System.out.println("示例 2 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_SingleCell() {
        // 边界情况：单单元格
        // grid = [[5]]
        // 输出：5
        int[][] grid = {{5}}; // 单单元格网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(5, result); // 验证结果等于 5
        
        System.out.println("单单元格 - 输入：[[5]]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_SingleRow() {
        // 单行网格
        // grid = [[1,2,3,4]]
        // 输出：10（只能向右走）
        int[][] grid = {{1, 2, 3, 4}}; // 单行网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(10, result); // 验证结果等于 1+2+3+4=10
        
        System.out.println("单行 - 输入：[[1,2,3,4]]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_SingleColumn() {
        // 单列网格
        // grid = [[1],[2],[3],[4]]
        // 输出：10（只能向下走）
        int[][] grid = {{1}, {2}, {3}, {4}}; // 单列网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(10, result); // 验证结果等于 1+2+3+4=10
        
        System.out.println("单列 - 输入：[[1],[2],[3],[4]]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_AllZeros() {
        // 全零网格
        // grid = [[0,0],[0,0]]
        // 输出：0
        int[][] grid = {
            {0, 0},
            {0, 0}
        }; // 全零网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(0, result); // 验证结果等于 0
        
        System.out.println("全零 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_AllSameValues() {
        // 所有元素相同
        // grid = [[2,2],[2,2]]
        // 输出：6（路径长度固定为 3 步，每步值为 2）
        int[][] grid = {
            {2, 2},
            {2, 2}
        }; // 所有元素相同
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(6, result); // 验证结果等于 2+2+2=6
        
        System.out.println("全相同 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_TwoByTwo() {
        // 2x2 网格
        // grid = [[1,2],[3,4]]
        // 路径1：1→2→4 = 7
        // 路径2：1→3→4 = 8
        // 输出：7
        int[][] grid = {
            {1, 2},
            {3, 4}
        }; // 2x2 网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(7, result); // 验证结果等于 7
        
        System.out.println("2x2 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_LargeGrid() {
        // 较大网格
        // grid = [[1,3,1,2],[1,5,1,3],[4,2,1,4]]
        // 需要动态规划计算
        int[][] grid = {
            {1, 3, 1, 2},
            {1, 5, 1, 3},
            {4, 2, 1, 4}
        }; // 3x4 网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        // 手动计算：
        // dp[0][0]=1, dp[0][1]=4, dp[0][2]=5, dp[0][3]=7
        // dp[1][0]=2, dp[1][1]=min(4,2)+5=7, dp[1][2]=min(5,7)+1=6, dp[1][3]=min(7,6)+3=9
        // dp[2][0]=6, dp[2][1]=min(7,6)+2=8, dp[2][2]=min(6,8)+1=7, dp[2][3]=min(9,7)+4=11
        assertEquals(11, result); // 验证结果等于 11
        
        System.out.println("大网格 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_MaximumValue() {
        // 包含最大值 200
        // grid = [[200,200],[200,200]]
        // 输出：600
        int[][] grid = {
            {200, 200},
            {200, 200}
        }; // 包含最大值
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(600, result); // 验证结果等于 200*3=600
        
        System.out.println("最大值 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_RectangularGrid() {
        // 非正方形网格（行数 > 列数）
        // grid = [[1,2],[3,4],[5,6]]
        // 路径：1→2→4→6 = 13 或 1→3→4→6 = 14 或 1→3→5→6 = 15
        // 输出：13
        int[][] grid = {
            {1, 2},
            {3, 4},
            {5, 6}
        }; // 3x2 网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(13, result); // 验证结果等于 13
        
        System.out.println("矩形(3x2) - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_RectangularGridWide() {
        // 非正方形网格（列数 > 行数）
        // grid = [[1,2,3,4,5]]
        // 输出：15（只能向右）
        int[][] grid = {{1, 2, 3, 4, 5}}; // 1x5 网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(15, result); // 验证结果等于 1+2+3+4+5=15
        
        System.out.println("矩形(1x5) - 输入：[[1,2,3,4,5]]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinPathSum_ComplexPath() {
        // 复杂路径选择
        // grid = [[1,100,100],[1,1,100],[100,1,1]]
        // 最优路径：1→1→1→1→1 = 5
        int[][] grid = {
            {1, 100, 100},
            {1, 1, 100},
            {100, 1, 1}
        }; // 复杂路径网格
        
        int result = solution.minPathSum(grid); // 调用方法计算最小路径和
        
        assertEquals(5, result); // 验证结果等于 5
        
        System.out.println("复杂路径 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("输出：" + result); // 打印输出结果
    }

    /**
     * 辅助方法：打印网格
     */
    private void printGrid(int[][] grid) {
        for (int[] row : grid) { // 遍历每一行
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
