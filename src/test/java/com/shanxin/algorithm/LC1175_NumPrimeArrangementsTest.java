package com.shanxin.algorithm;

import com.shanxin.algorithm.common.Constant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC1175_NumPrimeArrangementsTest {

    private final LC1175_NumPrimeArrangements solution = new LC1175_NumPrimeArrangements(); // 创建被测试的解决方案实例

    @Test
    public void testNumPrimeArrangements_Example1() {
        // 示例 1：n = 5
        // 输出：12
        // 解释：1-5 中有 3 个质数（2,3,5），2 个非质数（1,4）
        //      质数排列数：3! = 6，非质数排列数：2! = 2
        //      总方案数：6 * 2 = 12
        int n = 5; // 从 1 到 5 的数字
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        assertEquals(12, result); // 验证结果等于预期值 12
        
        System.out.println("示例 1 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_Example2() {
        // 示例 2：n = 100
        // 输出：682289015
        // 解释：1-100 中有 25 个质数，75 个非质数
        //      需要对 10^9+7 取模
        int n = 100; // 从 1 到 100 的数字（最大值）
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        assertEquals(682289015, result); // 验证结果等于预期值 682289015
        
        System.out.println("示例 2 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_MinimumN() {
        // 边界情况：n = 1（最小值）
        // 1 不是质数，所以有 0 个质数，1 个非质数
        // 0! * 1! = 1 * 1 = 1
        int n = 1; // 最小的 n 值
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        assertEquals(1, result); // 验证结果：只有 [1] 一种排列
        
        System.out.println("最小值 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_NEquals2() {
        // n = 2
        // 1-2 中有 1 个质数（2），1 个非质数（1）
        // 1! * 1! = 1 * 1 = 1
        // 有效排列：[1,2]（质数 2 在索引 2）
        int n = 2; // 从 1 到 2 的数字
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        assertEquals(1, result); // 验证结果：只有 1 种有效排列
        
        System.out.println("n=2 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_NEquals3() {
        // n = 3
        // 1-3 中有 2 个质数（2,3），1 个非质数（1）
        // 2! * 1! = 2 * 1 = 2
        // 有效排列：[1,2,3] 和 [1,3,2]
        int n = 3; // 从 1 到 3 的数字
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        assertEquals(2, result); // 验证结果：有 2 种有效排列
        
        System.out.println("n=3 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_NEquals4() {
        // n = 4
        // 1-4 中有 2 个质数（2,3），2 个非质数（1,4）
        // 2! * 2! = 2 * 2 = 4
        int n = 4; // 从 1 到 4 的数字
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        assertEquals(4, result); // 验证结果：有 4 种有效排列
        
        System.out.println("n=4 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_NEquals10() {
        // n = 10
        // 1-10 中有 4 个质数（2,3,5,7），6 个非质数（1,4,6,8,9,10）
        // 4! * 6! = 24 * 720 = 17280
        int n = 10; // 从 1 到 10 的数字
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        assertEquals(17280, result); // 验证结果：4!*6!=17280
        
        System.out.println("n=10 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_NEquals50() {
        // n = 50
        // 1-50 中有 15 个质数，35 个非质数
        // 需要验证取模运算的正确性
        int n = 50; // 从 1 到 50 的数字
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        // 验证结果为正数且小于 MOD
        assertTrue(result > 0); // 验证结果大于 0
        assertTrue(result < Constant.MOD); // 验证结果小于模数
        
        System.out.println("n=50 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testNumPrimeArrangements_ModuloOperation() {
        // 验证取模运算：当阶乘结果很大时，应该正确取模
        // n = 100 时结果已经很大，需要取模
        int n = 100; // 使用最大值触发取模
        
        int result = solution.numPrimeArrangements(n); // 调用方法计算质数排列方案数
        
        // 验证结果在合理范围内（已取模）
        assertTrue(result >= 0); // 验证结果非负
        assertTrue(result < Constant.MOD); // 验证结果小于模数 10^9+7
        assertEquals(682289015, result); // 验证具体值
        
        System.out.println("取模验证 - 输入：n = " + n); // 打印输入信息
        System.out.println("输出：" + result + " (已对 10^9+7 取模)"); // 打印输出结果
    }

    @Test
    public void testIsPrime_NumberOne() {
        // 测试 isPrime 方法：1 不是质数
        boolean result = solution.isPrime(1); // 检查 1 是否为质数
        
        assertFalse(result); // 验证 1 不是质数
        
        System.out.println("isPrime(1) = " + result); // 打印测试结果
    }

    @Test
    public void testIsPrime_PrimeNumbers() {
        // 测试 isPrime 方法：验证一些已知的质数
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}; // 前 10 个质数
        
        for (int prime : primes) { // 遍历每个质数
            assertTrue(solution.isPrime(prime)); // 验证每个数都是质数
        }
        
        System.out.println("质数测试：2,3,5,7,11,13,17,19,23,29 都正确识别为质数"); // 打印测试结果
    }

    @Test
    public void testIsPrime_NonPrimeNumbers() {
        // 测试 isPrime 方法：验证一些已知的非质数
        int[] nonPrimes = {1, 4, 6, 8, 9, 10, 12, 15, 20, 25}; // 一些非质数
        
        for (int nonPrime : nonPrimes) { // 遍历每个非质数
            assertFalse(solution.isPrime(nonPrime)); // 验证每个数都不是质数
        }
        
        System.out.println("非质数测试：1,4,6,8,9,10,12,15,20,25 都正确识别为非质数"); // 打印测试结果
    }

    @Test
    public void testFactorial_Zero() {
        // 测试 factorial 方法：0! = 1
        long result = solution.factorial(0); // 计算 0 的阶乘
        
        assertEquals(1, result); // 验证 0! = 1
        
        System.out.println("factorial(0) = " + result); // 打印测试结果
    }

    @Test
    public void testFactorial_SmallValues() {
        // 测试 factorial 方法：小值的阶乘
        assertEquals(1, solution.factorial(1)); // 验证 1! = 1
        assertEquals(2, solution.factorial(2)); // 验证 2! = 2
        assertEquals(6, solution.factorial(3)); // 验证 3! = 6
        assertEquals(24, solution.factorial(4)); // 验证 4! = 24
        assertEquals(120, solution.factorial(5)); // 验证 5! = 120
        
        System.out.println("小值阶乘测试：1!=1, 2!=2, 3!=6, 4!=24, 5!=120 都正确"); // 打印测试结果
    }

    @Test
    public void testFactorial_ModuloEffect() {
        // 测试 factorial 方法：验证大值时的取模效果
        // 25! 非常大，需要取模
        long result = solution.factorial(25); // 计算 25 的阶乘（会取模）
        
        // 验证结果已取模（小于 MOD）
        assertTrue(result < Constant.MOD); // 验证结果小于模数
        assertTrue(result > 0); // 验证结果为正数
        
        System.out.println("factorial(25) = " + result + " (已取模)"); // 打印测试结果
    }

    @Test
    public void testNumPrimeArrangements_PrimeCountVerification() {
        // 验证不同 n 值下的质数计数是否正确
        // n=1: 0 个质数
        // n=2: 1 个质数 (2)
        // n=3: 2 个质数 (2,3)
        // n=4: 2 个质数 (2,3)
        // n=5: 3 个质数 (2,3,5)
        // n=10: 4 个质数 (2,3,5,7)
        
        // 通过结果反推质数数量是否正确
        assertEquals(1, solution.numPrimeArrangements(1)); // 0!*1!=1
        assertEquals(1, solution.numPrimeArrangements(2)); // 1!*1!=1
        assertEquals(2, solution.numPrimeArrangements(3)); // 2!*1!=2
        assertEquals(4, solution.numPrimeArrangements(4)); // 2!*2!=4
        assertEquals(12, solution.numPrimeArrangements(5)); // 3!*2!=12
        assertEquals(17280, solution.numPrimeArrangements(10)); // 4!*6!=17280
        
        System.out.println("质数计数验证：各 n 值的质数数量计算正确"); // 打印测试结果
    }
}
