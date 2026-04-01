package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LCP6_MinCountTest {

    private final LCP6_MinCount solution = new LCP6_MinCount();

    @Test
    public void testMinCount_Example1() {
        // 示例 1：coins = [4,2,1]
        // 输出：4
        // 解释：第一堆拿 2 次，第二堆拿 1 次，第三堆拿 1 次，总共 4 次
        int[] coins = {4, 2, 1};
        
        int result = solution.minCount(coins);
        
        assertEquals(4, result);
        
        System.out.println("示例 1 - 输入：coins = [4,2,1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_Example2() {
        // 示例 2：coins = [2,3,10]
        // 输出：8
        // 解释：第一堆拿 1 次，第二堆拿 2 次，第三堆拿 5 次，总共 8 次
        int[] coins = {2, 3, 10};
        
        int result = solution.minCount(coins);
        
        assertEquals(8, result);
        
        System.out.println("示例 2 - 输入：coins = [2,3,10]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_SinglePile() {
        // 边界情况：只有一堆
        // coins = [5]
        // 输出：3（拿 2 次两枚，1 次一枚）
        int[] coins = {5};
        
        int result = solution.minCount(coins);
        
        assertEquals(3, result);
        
        System.out.println("单堆 - 输入：coins = [5]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_AllOnes() {
        // 所有堆都是 1 枚硬币
        // coins = [1,1,1,1]
        // 输出：4
        int[] coins = {1, 1, 1, 1};
        
        int result = solution.minCount(coins);
        
        assertEquals(4, result);
        
        System.out.println("全为 1 - 输入：coins = [1,1,1,1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_AllEven() {
        // 所有堆都是偶数
        // coins = [2,4,6,8]
        // 输出：1+2+3+4 = 10
        int[] coins = {2, 4, 6, 8};
        
        int result = solution.minCount(coins);
        
        assertEquals(10, result);
        
        System.out.println("全为偶数 - 输入：coins = [2,4,6,8]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_AllOdd() {
        // 所有堆都是奇数
        // coins = [1,3,5,7,9]
        // 输出：1+2+3+4+5 = 15
        int[] coins = {1, 3, 5, 7, 9};
        
        int result = solution.minCount(coins);
        
        assertEquals(15, result);
        
        System.out.println("全为奇数 - 输入：coins = [1,3,5,7,9]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_MixedValues() {
        // 混合不同大小的值
        // coins = [1,2,3,4,5,6,7,8,9,10]
        // 输出：1+1+2+2+3+3+4+4+5+5 = 30
        int[] coins = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        
        int result = solution.minCount(coins);
        
        assertEquals(30, result);
        
        System.out.println("混合值 - 输入：coins = [1,2,3,4,5,6,7,8,9,10]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_MinimumValue() {
        // 最小值测试（每堆最少 1 枚）
        // coins = [1]
        // 输出：1
        int[] coins = {1};
        
        int result = solution.minCount(coins);
        
        assertEquals(1, result);
        
        System.out.println("最小值 - 输入：coins = [1]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_MaximumValue() {
        // 最大值测试（每堆最多 10 枚）
        // coins = [10,10,10,10]
        // 输出：5+5+5+5 = 20
        int[] coins = {10, 10, 10, 10};
        
        int result = solution.minCount(coins);
        
        assertEquals(20, result);
        
        System.out.println("最大值 - 输入：coins = [10,10,10,10]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testMinCount_PowerOfTwo() {
        // 2 的幂次
        // coins = [2,4,8]
        // 输出：1+2+4 = 7
        int[] coins = {2, 4, 8};
        
        int result = solution.minCount(coins);
        
        assertEquals(7, result);
        
        System.out.println("2 的幂次 - 输入：coins = [2,4,8]");
        System.out.println("输出：" + result);
    }
}
