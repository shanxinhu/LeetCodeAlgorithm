package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC3651_MinCostTest {

    private final LC3651_MinCost solution = new LC3651_MinCost(); // 创建被测试的解决方案实例

    @Test
    public void testMinCost_Example1() {
        // 示例 1：grid = [[1,3,3],[2,5,4],[4,3,5]], k = 2
        // 输出：7
        // 路径：(0,0)→(1,0)→(1,1)→传送至(2,2)，总成本 = 0+2+5+0 = 7
        int[][] grid = {
            {1, 3, 3},
            {2, 5, 4},
            {4, 3, 5}
        }; // 输入网格
        int k = 2; // 最大传送次数
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertEquals(7, result); // 验证结果等于预期值 7
        
        System.out.println("示例 1 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_Example2() {
        // 示例 2：grid = [[1,2],[2,3],[3,4]], k = 1
        // 输出：9
        // 路径：(0,0)→(1,0)→(1,1)→(2,1)，总成本 = 0+2+3+4 = 9
        int[][] grid = {
            {1, 2},
            {2, 3},
            {3, 4}
        }; // 输入网格
        int k = 1; // 最大传送次数
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertEquals(9, result); // 验证结果等于预期值 9
        
        System.out.println("示例 2 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_NoTeleportation() {
        // k = 0，不能使用传送
        // grid = [[1,2],[3,4]]
        // 只能普通移动，最优路径：(0,0)→(0,1)→(1,1) = 0+2+4 = 6
        // 或 (0,0)→(1,0)→(1,1) = 0+3+4 = 7
        // 输出：6
        int[][] grid = {
            {1, 2},
            {3, 4}
        }; // 输入网格
        int k = 0; // 不能传送
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertEquals(6, result); // 验证结果等于 6
        
        System.out.println("无传送 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_SmallGrid() {
        // 最小网格 2x2
        // grid = [[1,1],[1,1]]
        // 所有值相同，可以传送
        // 输出：0（起点成本为0，传送到终点成本为0）
        int[][] grid = {
            {1, 1},
            {1, 1}
        }; // 全1网格
        int k = 1; // 可以传送1次
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertEquals(0, result); // 验证结果等于 0
        
        System.out.println("小网格 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_LargeK() {
        // k 较大，可以充分使用传送
        // grid = [[5,3,1],[4,2,6],[7,8,9]]
        // k = 10（远大于需要）
        // 可以从起点传送到值最小的位置，再传送到终点
        int[][] grid = {
            {5, 3, 1},
            {4, 2, 6},
            {7, 8, 9}
        }; // 输入网格
        int k = 10; // 大量传送次数
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        // 最优策略：从(0,0)移动到(0,2)成本=1，然后传送到(1,1)成本=0，再移动到(2,2)
        // 或者找到更优路径
        assertTrue(result >= 0); // 验证结果非负
        assertTrue(result <= 20); // 验证结果合理
        
        System.out.println("大K - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_AllZeros() {
        // 全零网格
        // grid = [[0,0],[0,0]]
        // 输出：0
        int[][] grid = {
            {0, 0},
            {0, 0}
        }; // 全零网格
        int k = 1; // 可以传送
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertEquals(0, result); // 验证结果等于 0
        
        System.out.println("全零 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_IncreasingValues() {
        // 递增值网格
        // grid = [[1,2,3],[4,5,6],[7,8,9]]
        // k = 1
        // 无法有效利用传送（因为只能传送到值更小或相等的位置）
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        }; // 递增网格
        int k = 1; // 可以传送1次
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        // 最优路径应该是普通移动
        assertTrue(result > 0); // 验证结果为正数
        
        System.out.println("递增 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_DecreasingValues() {
        // 递减值网格
        // grid = [[9,8,7],[6,5,4],[3,2,1]]
        // k = 2
        // 可以利用传送从高值区域跳到低值区域
        int[][] grid = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        }; // 递减网格
        int k = 2; // 可以传送2次
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertTrue(result >= 0); // 验证结果非负
        
        System.out.println("递减 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_SingleRow() {
        // 单行网格
        // grid = [[1,2,3,4]]
        // 只能向右移动
        // 输出：2+3+4 = 9
        int[][] grid = {{1, 2, 3, 4}}; // 单行网格
        int k = 1; // 可以传送1次
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertEquals(9, result); // 验证结果等于 9
        
        System.out.println("单行 - 输入：[[1,2,3,4]]"); // 打印输入信息
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_SingleColumn() {
        // 单列网格
        // grid = [[1],[2],[3],[4]]
        // 只能向下移动
        // 输出：2+3+4 = 9
        int[][] grid = {{1}, {2}, {3}, {4}}; // 单列网格
        int k = 1; // 可以传送1次
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertEquals(9, result); // 验证结果等于 9
        
        System.out.println("单列 - 输入：[[1],[2],[3],[4]]"); // 打印输入信息
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_MaximumSize() {
        // 最大尺寸测试：80x80
        int m = 80; // 行数
        int n = 80; // 列数
        int[][] grid = new int[m][n]; // 创建最大尺寸的网格
        
        // 填充网格，使用简单模式
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = (i + j) % 10; // 值在 0-9 之间
            }
        }
        int k = 10; // 最大传送次数
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertTrue(result >= 0); // 验证结果非负
        
        System.out.println("最大尺寸 - 输入：" + m + "x" + n + " 网格"); // 打印输入信息
        System.out.println("k = " + k);
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testMinCost_ComplexPattern() {
        // 复杂模式网格
        // grid = [[10,1,10],[1,10,1],[10,1,10]]
        // k = 2
        // 可以利用传送避开高值区域
        int[][] grid = {
            {10, 1, 10},
            {1, 10, 1},
            {10, 1, 10}
        }; // 棋盘式网格
        int k = 2; // 可以传送2次
        
        int result = solution.minCost(grid, k); // 调用方法计算最小成本
        
        assertTrue(result >= 0); // 验证结果非负
        assertTrue(result < 30); // 验证结果合理（应该能通过传送优化）
        
        System.out.println("复杂模式 - 输入："); // 打印输入信息
        printGrid(grid);
        System.out.println("k = " + k);
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
