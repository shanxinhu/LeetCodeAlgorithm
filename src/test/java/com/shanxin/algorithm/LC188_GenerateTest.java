package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LC188_GenerateTest {

    private final LC188_Generate solution = new LC188_Generate(); // 创建被测试的解决方案实例

    @Test
    public void testGenerate_Example1() {
        // 示例 1：numRows = 5
        // 输出：[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        int numRows = 5; // 生成杨辉三角的前 5 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(5, result.size()); // 验证生成了 5 行
        
        // 验证每一行的内容
        assertEquals(Arrays.asList(1), result.get(0)); // 第 1 行：[1]
        assertEquals(Arrays.asList(1, 1), result.get(1)); // 第 2 行：[1,1]
        assertEquals(Arrays.asList(1, 2, 1), result.get(2)); // 第 3 行：[1,2,1]
        assertEquals(Arrays.asList(1, 3, 3, 1), result.get(3)); // 第 4 行：[1,3,3,1]
        assertEquals(Arrays.asList(1, 4, 6, 4, 1), result.get(4)); // 第 5 行：[1,4,6,4,1]
        
        System.out.println("示例 1 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGenerate_Example2() {
        // 示例 2：numRows = 1
        // 输出：[[1]]
        int numRows = 1; // 生成杨辉三角的前 1 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.size()); // 验证生成了 1 行
        assertEquals(Arrays.asList(1), result.get(0)); // 验证第 1 行内容为 [1]
        
        System.out.println("示例 2 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGenerate_TwoRows() {
        // 边界情况：numRows = 2
        // 输出：[[1],[1,1]]
        int numRows = 2; // 生成杨辉三角的前 2 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(2, result.size()); // 验证生成了 2 行
        assertEquals(Arrays.asList(1), result.get(0)); // 验证第 1 行内容为 [1]
        assertEquals(Arrays.asList(1, 1), result.get(1)); // 验证第 2 行内容为 [1,1]
        
        System.out.println("两行 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGenerate_ThreeRows() {
        // 测试三行情况，验证中间元素的计算逻辑
        // 输出：[[1],[1,1],[1,2,1]]
        int numRows = 3; // 生成杨辉三角的前 3 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(3, result.size()); // 验证生成了 3 行
        assertEquals(Arrays.asList(1), result.get(0)); // 验证第 1 行内容为 [1]
        assertEquals(Arrays.asList(1, 1), result.get(1)); // 验证第 2 行内容为 [1,1]
        assertEquals(Arrays.asList(1, 2, 1), result.get(2)); // 验证第 3 行内容为 [1,2,1]
        
        System.out.println("三行 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGenerate_MaximumRows() {
        // 最大值测试：numRows = 30（题目约束上限）
        int numRows = 30; // 生成杨辉三角的前 30 行（最大值）
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(30, result.size()); // 验证生成了 30 行
        
        // 验证第 1 行和第 2 行
        assertEquals(Arrays.asList(1), result.get(0)); // 验证第 1 行内容为 [1]
        assertEquals(Arrays.asList(1, 1), result.get(1)); // 验证第 2 行内容为 [1,1]
        
        // 验证最后一行的首尾元素都是 1
        List<Integer> lastRow = result.get(29); // 获取最后一行（索引 29）
        assertEquals(1, lastRow.get(0)); // 验证最后一行第一个元素为 1
        assertEquals(1, lastRow.get(lastRow.size() - 1)); // 验证最后一行最后一个元素为 1
        assertEquals(30, lastRow.size()); // 验证最后一行有 30 个元素
        
        System.out.println("最大行数 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出行数：" + result.size()); // 打印输出行数
        System.out.println("最后一行元素个数：" + lastRow.size()); // 打印最后一行元素个数
    }

    @Test
    public void testGenerate_RowLengthIncrement() {
        // 验证每一行的长度递增规律
        // 第 i 行应该有 i 个元素（i 从 1 开始）
        int numRows = 10; // 生成杨辉三角的前 10 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(10, result.size()); // 验证生成了 10 行
        
        // 验证每一行的长度
        for (int i = 0; i < numRows; i++) { // 遍历每一行
            assertEquals(i + 1, result.get(i).size()); // 验证第 i+1 行有 i+1 个元素
        }
        
        System.out.println("行长度递增 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：共 " + result.size() + " 行，每行长度符合递增规律"); // 打印验证结果
    }

    @Test
    public void testGenerate_SymmetryProperty() {
        // 验证杨辉三角的对称性：每行从左到右和从右到左读应该相同
        int numRows = 8; // 生成杨辉三角的前 8 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        
        // 验证每一行的对称性
        for (int i = 0; i < numRows; i++) { // 遍历每一行
            List<Integer> row = result.get(i); // 获取当前行
            int size = row.size(); // 获取当前行的长度
            
            // 验证对称性：row[j] == row[size-1-j]
            for (int j = 0; j < size / 2; j++) { // 只检查前半部分
                assertEquals(row.get(j), row.get(size - 1 - j)); // 验证对称位置元素相等
            }
        }
        
        System.out.println("对称性验证 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：所有行都满足对称性"); // 打印验证结果
    }

    @Test
    public void testGenerate_EdgeElementsAreOne() {
        // 验证每行的首尾元素都是 1
        int numRows = 15; // 生成杨辉三角的前 15 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        
        // 验证每一行的首尾元素
        for (int i = 0; i < numRows; i++) { // 遍历每一行
            List<Integer> row = result.get(i); // 获取当前行
            
            assertEquals(1, row.get(0)); // 验证每行第一个元素为 1
            assertEquals(1, row.get(row.size() - 1)); // 验证每行最后一个元素为 1
        }
        
        System.out.println("边缘元素验证 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：所有行的首尾元素都为 1"); // 打印验证结果
    }

    @Test
    public void testGenerate_MiddleElementCalculation() {
        // 验证中间元素的计算：每个数等于左上方和右上方的数之和
        int numRows = 6; // 生成杨辉三角的前 6 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        
        // 从第 3 行开始验证（前两行没有中间元素）
        for (int i = 2; i < numRows; i++) { // 遍历第 3 行及以后的行
            List<Integer> currentRow = result.get(i); // 获取当前行
            List<Integer> previousRow = result.get(i - 1); // 获取上一行
            
            // 验证中间元素（排除首尾）
            for (int j = 1; j < currentRow.size() - 1; j++) { // 遍历当前行的中间元素
                int expected = previousRow.get(j - 1) + previousRow.get(j); // 计算期望值：左上+右上
                assertEquals(expected, currentRow.get(j)); // 验证当前元素等于左上和右上之和
            }
        }
        
        System.out.println("中间元素计算验证 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：所有中间元素都符合杨辉三角计算规则"); // 打印验证结果
    }

    @Test
    public void testGenerate_FourRows() {
        // 测试四行情况，进一步验证计算逻辑
        // 输出：[[1],[1,1],[1,2,1],[1,3,3,1]]
        int numRows = 4; // 生成杨辉三角的前 4 行
        
        List<List<Integer>> result = solution.generate(numRows); // 调用方法生成杨辉三角
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(4, result.size()); // 验证生成了 4 行
        assertEquals(Arrays.asList(1), result.get(0)); // 验证第 1 行内容为 [1]
        assertEquals(Arrays.asList(1, 1), result.get(1)); // 验证第 2 行内容为 [1,1]
        assertEquals(Arrays.asList(1, 2, 1), result.get(2)); // 验证第 3 行内容为 [1,2,1]
        assertEquals(Arrays.asList(1, 3, 3, 1), result.get(3)); // 验证第 4 行内容为 [1,3,3,1]
        
        System.out.println("四行 - 输入：numRows = " + numRows); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }
}
