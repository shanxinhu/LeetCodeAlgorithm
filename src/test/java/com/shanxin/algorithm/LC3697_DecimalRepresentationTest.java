package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LC3697_DecimalRepresentationTest {

    private final LC3697_DecimalRepresentation solution = new LC3697_DecimalRepresentation(); // 创建被测试的解决方案实例

    @Test
    public void testDecimalRepresentation_Example1() {
        // 示例 1：n = 537
        // 输出：[500, 30, 7]
        int n = 537; // 输入正整数
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertArrayEquals(new int[]{500, 30, 7}, result); // 验证结果数组内容
        
        System.out.println("示例 1 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_Example2() {
        // 示例 2：n = 102
        // 输出：[100, 2]
        int n = 102; // 输入正整数
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertArrayEquals(new int[]{100, 2}, result); // 验证结果数组内容
        
        System.out.println("示例 2 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_Example3() {
        // 示例 3：n = 6
        // 输出：[6]
        int n = 6; // 输入正整数（本身就是十进制分量）
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertArrayEquals(new int[]{6}, result); // 验证结果数组内容
        
        System.out.println("示例 3 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_SingleDigit() {
        // 边界情况：单个数字
        // n = 5
        // 输出：[5]
        int n = 5; // 单个数字
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.length); // 验证结果长度为 1
        assertArrayEquals(new int[]{5}, result); // 验证结果数组内容
        
        System.out.println("单个数字 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_PowerOfTen() {
        // 10 的幂次
        // n = 1000
        // 输出：[1000]
        int n = 1000; // 10 的幂次
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.length); // 验证结果长度为 1
        assertArrayEquals(new int[]{1000}, result); // 验证结果数组内容
        
        System.out.println("10的幂次 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_AllNonZeroDigits() {
        // 所有位都是非零数字
        // n = 1234
        // 输出：[1000, 200, 30, 4]
        int n = 1234; // 所有位都是非零
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(4, result.length); // 验证结果长度为 4
        assertArrayEquals(new int[]{1000, 200, 30, 4}, result); // 验证结果数组内容
        
        System.out.println("全非零位 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_WithZeros() {
        // 包含零位的数字
        // n = 1005
        // 输出：[1000, 5]（跳过中间的 0）
        int n = 1005; // 包含零位
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(2, result.length); // 验证结果长度为 2（跳过了两个 0）
        assertArrayEquals(new int[]{1000, 5}, result); // 验证结果数组内容
        
        System.out.println("含零位 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_TwoDigits() {
        // 两位数
        // n = 45
        // 输出：[40, 5]
        int n = 45; // 两位数
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(2, result.length); // 验证结果长度为 2
        assertArrayEquals(new int[]{40, 5}, result); // 验证结果数组内容
        
        System.out.println("两位数 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_LargeNumber() {
        // 大数测试
        // n = 987654321
        // 输出：[900000000, 80000000, 7000000, 600000, 50000, 4000, 300, 20, 1]
        int n = 987654321; // 大数
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(9, result.length); // 验证结果长度为 9（9 个非零位）
        assertArrayEquals(new int[]{900000000, 80000000, 7000000, 600000, 50000, 4000, 300, 20, 1}, result); // 验证结果数组内容
        
        System.out.println("大数 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_DescendingOrder() {
        // 验证结果按降序排列
        int n = 305070; // 包含多个零位的数字
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        
        // 验证数组按降序排列
        for (int i = 0; i < result.length - 1; i++) { // 遍历相邻元素
            assertTrue(result[i] > result[i + 1]); // 验证前一个元素大于后一个元素
        }
        
        System.out.println("降序验证 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result) + " (已按降序排列)"); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_SumEqualsOriginal() {
        // 验证所有分量的和等于原数
        int n = 40608; // 任意数字
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        
        int sum = 0; // 初始化总和
        for (int component : result) { // 遍历所有分量
            sum += component; // 累加分量值
        }
        
        assertEquals(n, sum); // 验证分量之和等于原数
        
        System.out.println("求和验证 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result) + "，总和 = " + sum); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_MaximumConstraint() {
        // 最大值测试：n = 10^9
        // 输出：[1000000000]
        int n = 1000000000; // 最大值
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.length); // 验证结果长度为 1
        assertArrayEquals(new int[]{1000000000}, result); // 验证结果数组内容
        
        System.out.println("最大值 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }

    @Test
    public void testDecimalRepresentation_MinimumConstraint() {
        // 最小值测试：n = 1
        // 输出：[1]
        int n = 1; // 最小值
        
        int[] result = solution.decimalRepresentation(n); // 调用方法分解为十进制分量
        
        assertNotNull(result); // 验证结果不为 null
        assertEquals(1, result.length); // 验证结果长度为 1
        assertArrayEquals(new int[]{1}, result); // 验证结果数组内容
        
        System.out.println("最小值 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + Arrays.toString(result)); // 打印输出结果
    }
}
