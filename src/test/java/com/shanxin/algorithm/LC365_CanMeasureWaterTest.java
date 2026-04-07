package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC365_CanMeasureWaterTest {

    private final LC365_CanMeasureWater solution = new LC365_CanMeasureWater(); // 创建被测试的解决方案实例

    @Test
    public void testCanMeasureWater_Example1() {
        // 示例 1：x = 3, y = 5, target = 4
        // 输出：true
        int x = 3; // 第一个水壶容量
        int y = 5; // 第二个水壶容量
        int target = 4; // 目标水量
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("示例 1 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_Example2() {
        // 示例 2：x = 2, y = 6, target = 5
        // 输出：false
        int x = 2; // 第一个水壶容量
        int y = 6; // 第二个水壶容量
        int target = 5; // 目标水量
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("示例 2 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_Example3() {
        // 示例 3：x = 1, y = 2, target = 3
        // 输出：true
        int x = 1; // 第一个水壶容量
        int y = 2; // 第二个水壶容量
        int target = 3; // 目标水量
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true（同时倒满两个水壶）
        
        System.out.println("示例 3 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_TargetEqualsSum() {
        // 目标等于两壶容量之和
        // x = 3, y = 5, target = 8
        // 输出：true（同时倒满两个水壶）
        int x = 3; // 第一个水壶容量
        int y = 5; // 第二个水壶容量
        int target = 8; // 目标水量（等于 x + y）
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("目标和 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_TargetExceedsSum() {
        // 目标超过两壶容量之和
        // x = 3, y = 5, target = 9
        // 输出：false（不可能超过总容量）
        int x = 3; // 第一个水壶容量
        int y = 5; // 第二个水壶容量
        int target = 9; // 目标水量（超过 x + y）
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("超过总和 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_TargetZero() {
        // 目标为 0
        // x = 3, y = 5, target = 0
        // 输出：true（不需要任何水）
        int x = 3; // 第一个水壶容量
        int y = 5; // 第二个水壶容量
        int target = 0; // 目标水量为 0
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true（0 可以被任何数整除）
        
        System.out.println("目标为0 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_SingleJugTarget() {
        // 目标等于单个水壶容量
        // x = 3, y = 5, target = 3
        // 输出：true（直接装满第一个水壶）
        int x = 3; // 第一个水壶容量
        int y = 5; // 第二个水壶容量
        int target = 3; // 目标水量（等于 x）
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("单壶目标 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_EqualJugs() {
        // 两个水壶容量相等
        // x = 4, y = 4, target = 2
        // GCD(4,4) = 4，2 % 4 != 0
        // 输出：false
        int x = 4; // 第一个水壶容量
        int y = 4; // 第二个水壶容量（与 x 相等）
        int target = 2; // 目标水量
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("等容量壶 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_CoprimeJugs() {
        // 两个水壶容量互质
        // x = 7, y = 11, target = 5
        // GCD(7,11) = 1，5 % 1 == 0
        // 输出：true
        int x = 7; // 第一个水壶容量
        int y = 11; // 第二个水壶容量（与 x 互质）
        int target = 5; // 目标水量
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true（互质的壶可以测量任意整数水量）
        
        System.out.println("互质壶 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_LargeGCD() {
        // 两个水壶有较大的最大公约数
        // x = 6, y = 9, target = 3
        // GCD(6,9) = 3，3 % 3 == 0
        // 输出：true
        int x = 6; // 第一个水壶容量
        int y = 9; // 第二个水壶容量
        int target = 3; // 目标水量
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("大GCD - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_NotDivisibleByGCD() {
        // 目标不能被 GCD 整除
        // x = 6, y = 9, target = 4
        // GCD(6,9) = 3，4 % 3 != 0
        // 输出：false
        int x = 6; // 第一个水壶容量
        int y = 9; // 第二个水壶容量
        int target = 4; // 目标水量
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertFalse(result); // 验证结果为 false
        
        System.out.println("不可整除 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_MaximumConstraints() {
        // 最大值测试
        // x = 1000, y = 1000, target = 1000
        // 输出：true
        int x = 1000; // 第一个水壶容量（最大值）
        int y = 1000; // 第二个水壶容量（最大值）
        int target = 1000; // 目标水量（最大值）
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("最大值 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testCanMeasureWater_MinimumConstraints() {
        // 最小值测试
        // x = 1, y = 1, target = 1
        // 输出：true
        int x = 1; // 第一个水壶容量（最小值）
        int y = 1; // 第二个水壶容量（最小值）
        int target = 1; // 目标水量（最小值）
        
        boolean result = solution.canMeasureWater(x, y, target); // 调用方法判断是否能测量出目标水量
        
        assertTrue(result); // 验证结果为 true
        
        System.out.println("最小值 - 输入：x = " + x + ", y = " + y + ", target = " + target); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }
}
