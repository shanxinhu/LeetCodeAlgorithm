package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC70_ClimbStairsTest {

    private final LC70_ClimbStairs solution = new LC70_ClimbStairs();

    @Test
    public void testClimbStairs_Example1() {
        // 示例 1：n = 2 → 2（1+1, 2）
        assertEquals(2, solution.climbStairs(2));

        System.out.println("示例 1 - 输入：n=2 → 输出：" + solution.climbStairs(2));
    }

    @Test
    public void testClimbStairs_Example2() {
        // 示例 2：n = 3 → 3（1+1+1, 1+2, 2+1）
        assertEquals(3, solution.climbStairs(3));

        System.out.println("示例 2 - 输入：n=3 → 输出：" + solution.climbStairs(3));
    }

    @Test
    public void testClimbStairs_One() {
        // n = 1 → 1
        assertEquals(1, solution.climbStairs(1));

        System.out.println("n=1 → 输出：" + solution.climbStairs(1));
    }

    @Test
    public void testClimbStairs_Four() {
        // n = 4 → 5（1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2）
        assertEquals(5, solution.climbStairs(4));

        System.out.println("n=4 → 输出：" + solution.climbStairs(4));
    }

    @Test
    public void testClimbStairs_Five() {
        // n = 5 → 8
        assertEquals(8, solution.climbStairs(5));

        System.out.println("n=5 → 输出：" + solution.climbStairs(5));
    }

    @Test
    public void testClimbStairs_Ten() {
        // n = 10 → 89
        assertEquals(89, solution.climbStairs(10));

        System.out.println("n=10 → 输出：" + solution.climbStairs(10));
    }

    @Test
    public void testClimbStairs_Fibonacci() {
        // 验证符合斐波那契数列规律：f(n) = f(n-1) + f(n-2)
        // n=6 → 13, n=7 → 21, n=8 → 34
        assertEquals(13, solution.climbStairs(6));
        assertEquals(21, solution.climbStairs(7));
        assertEquals(34, solution.climbStairs(8));

        System.out.println("斐波那契验证：6→13, 7→21, 8→34");
    }

    // ========== climbStairs2（迭代滚动变量法）测试 ==========

    @Test
    public void testClimbStairs2_Example1() {
        // 示例 1：n = 2 → 2
        assertEquals(2, solution.climbStairs2(2));

        System.out.println("迭代-示例1 - 输入：n=2 → 输出：" + solution.climbStairs2(2));
    }

    @Test
    public void testClimbStairs2_Example2() {
        // 示例 2：n = 3 → 3
        assertEquals(3, solution.climbStairs2(3));

        System.out.println("迭代-示例2 - 输入：n=3 → 输出：" + solution.climbStairs2(3));
    }

    @Test
    public void testClimbStairs2_One() {
        // n = 1 → 1
        assertEquals(1, solution.climbStairs2(1));

        System.out.println("迭代-n=1 → 输出：" + solution.climbStairs2(1));
    }

    @Test
    public void testClimbStairs2_Four() {
        // n = 4 → 5
        assertEquals(5, solution.climbStairs2(4));

        System.out.println("迭代-n=4 → 输出：" + solution.climbStairs2(4));
    }

    @Test
    public void testClimbStairs2_Ten() {
        // n = 10 → 89
        assertEquals(89, solution.climbStairs2(10));

        System.out.println("迭代-n=10 → 输出：" + solution.climbStairs2(10));
    }

    @Test
    public void testClimbStairs2_FortyFive() {
        // n = 45 → 1836311903（大数验证，递归版会超时，迭代版秒出）
        assertEquals(1836311903, solution.climbStairs2(45));

        System.out.println("迭代-n=45 → 输出：" + solution.climbStairs2(45));
    }

    @Test
    public void testClimbStairs2_Fibonacci() {
        // 斐波那契验证
        assertEquals(13, solution.climbStairs2(6));
        assertEquals(21, solution.climbStairs2(7));
        assertEquals(34, solution.climbStairs2(8));

        System.out.println("迭代-斐波那契验证：6→13, 7→21, 8→34");
    }

    @Test
    public void testClimbStairs2_ConsistentWithRecursive() {
        // 与递归版结果一致性验证
        for (int i = 1; i <= 10; i++) {
            assertEquals(solution.climbStairs(i), solution.climbStairs2(i),
                    "n=" + i + " 时两种方法结果不一致");
        }

        System.out.println("一致性验证：n=1~10 两种方法结果完全一致");
    }
}
