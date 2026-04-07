package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC55_GetMinimumTimeTest {

    private final LC55_GetMinimumTime solution = new LC55_GetMinimumTime(); // 创建被测试的解决方案实例

    @Test
    public void testGetMinimumTime_Example1() {
        // 示例 1：time = [2,3,2], fruits = [[0,2],[1,4],[2,1]], limit = 3
        // 输出：10
        // 解释：第 0 批采集 2 颗类型 0 果实，需要 1 次，耗时 2*1=2
        //      第 1 批采集 4 颗类型 1 果实，需要 2 次，耗时 3*2=6
        //      第 2 批采集 1 颗类型 2 果实，需要 1 次，耗时 2*1=2
        //      总耗时 2+6+2=10
        int[] time = {2, 3, 2}; // 每种类型果实的单次采集时间
        int[][] fruits = {{0, 2}, {1, 4}, {2, 1}}; // 每批果实的类型和数量
        int limit = 3; // 单次最多采集的果实数量
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(10, result); // 验证结果等于预期值 10
        
        System.out.println("示例 1 - 输入：time = [2,3,2], fruits = [[0,2],[1,4],[2,1]], limit = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_Example2() {
        // 示例 2：time = [1], fruits = [[0,3],[0,5]], limit = 2
        // 输出：5
        // 解释：第 0 批采集 3 颗类型 0 果实，需要 2 次，耗时 1*2=2
        //      第 1 批采集 5 颗类型 0 果实，需要 3 次，耗时 1*3=3
        //      总耗时 2+3=5
        int[] time = {1}; // 只有一种类型果实，单次采集时间为 1
        int[][] fruits = {{0, 3}, {0, 5}}; // 两批都是类型 0 的果实
        int limit = 2; // 单次最多采集 2 颗
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(5, result); // 验证结果等于预期值 5
        
        System.out.println("示例 2 - 输入：time = [1], fruits = [[0,3],[0,5]], limit = 2"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_SingleBatch() {
        // 边界情况：只有一批果实
        // time = [5], fruits = [[0,10]], limit = 3
        // 输出：20（需要采集 4 次，每次 5 秒，共 20 秒）
        int[] time = {5}; // 类型 0 的单次采集时间为 5
        int[][] fruits = {{0, 10}}; // 只有一批，需要采集 10 颗
        int limit = 3; // 单次最多采集 3 颗
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(20, result); // 验证结果：向上取整(10/3)=4 次，4*5=20
        
        System.out.println("单批 - 输入：time = [5], fruits = [[0,10]], limit = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_ExactlyDivisible() {
        // 所有批次都能被 limit 整除的情况
        // time = [2,3], fruits = [[0,6],[1,9]], limit = 3
        // 输出：15（类型 0 需 2 次耗时 4，类型 1 需 3 次耗时 9，总计 13）
        int[] time = {2, 3}; // 两种类型的单次采集时间
        int[][] fruits = {{0, 6}, {1, 9}}; // 两批果实，数量都能被 3 整除
        int limit = 3; // 单次最多采集 3 颗
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(13, result); // 验证结果：6/3=2 次*2=4，9/3=3 次*3=9，总计 13
        
        System.out.println("整除情况 - 输入：time = [2,3], fruits = [[0,6],[1,9]], limit = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_MinimumLimit() {
        // limit = 1 的极端情况（每次只能采集 1 颗）
        // time = [1,2], fruits = [[0,3],[1,2]], limit = 1
        // 输出：7（类型 0 需 3 次耗时 3，类型 1 需 2 次耗时 4，总计 7）
        int[] time = {1, 2}; // 两种类型的单次采集时间
        int[][] fruits = {{0, 3}, {1, 2}}; // 两批果实
        int limit = 1; // 单次最多采集 1 颗（最慢情况）
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(7, result); // 验证结果：3/1=3 次*1=3，2/1=2 次*2=4，总计 7
        
        System.out.println("最小 limit - 输入：time = [1,2], fruits = [[0,3],[1,2]], limit = 1"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_LargeLimit() {
        // limit 很大的情况（一次可以采集很多）
        // time = [5,10], fruits = [[0,1],[1,1]], limit = 100
        // 输出：15（每批都只需 1 次，5+10=15）
        int[] time = {5, 10}; // 两种类型的单次采集时间
        int[][] fruits = {{0, 1}, {1, 1}}; // 两批果实，每批只要 1 颗
        int limit = 100; // 单次最多采集 100 颗（远大于需求）
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(15, result); // 验证结果：每批都只需 1 次，1*5+1*10=15
        
        System.out.println("大 limit - 输入：time = [5,10], fruits = [[0,1],[1,1]], limit = 100"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_MultipleTypesMixed() {
        // 多种类型混合，不同批次使用不同类型
        // time = [1,2,3,4], fruits = [[0,5],[2,7],[1,3],[3,10]], limit = 3
        // 输出：38（类型 0:2 次*1=2，类型 2:3 次*3=9，类型 1:1 次*2=2，类型 3:4 次*4=16，总计 29）
        int[] time = {1, 2, 3, 4}; // 四种类型的单次采集时间
        int[][] fruits = {{0, 5}, {2, 7}, {1, 3}, {3, 10}}; // 四批不同类型的果实
        int limit = 3; // 单次最多采集 3 颗
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(29, result); // 验证结果：2*1+3*3+1*2+4*4=2+9+2+16=29
        
        System.out.println("多类型混合 - 输入：time = [1,2,3,4], fruits = [[0,5],[2,7],[1,3],[3,10]], limit = 3"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_SameTypeMultipleBatches() {
        // 同一类型出现在多个批次中
        // time = [3], fruits = [[0,2],[0,3],[0,4]], limit = 2
        // 输出：15（第 1 批 1 次*3=3，第 2 批 2 次*3=6，第 3 批 2 次*3=6，总计 15）
        int[] time = {3}; // 只有一种类型
        int[][] fruits = {{0, 2}, {0, 3}, {0, 4}}; // 三批都是类型 0
        int limit = 2; // 单次最多采集 2 颗
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(15, result); // 验证结果：1*3+2*3+2*3=3+6+6=15
        
        System.out.println("同类型多批 - 输入：time = [3], fruits = [[0,2],[0,3],[0,4]], limit = 2"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_MaximumConstraints() {
        // 接近约束上限的测试
        // time 长度 100，fruits 长度较大，数值接近上限
        int[] time = new int[100]; // 创建 100 种类型的数组
        for (int i = 0; i < 100; i++) { // 遍历所有类型
            time[i] = 100; // 每种类型的采集时间都是最大值 100
        }
        int[][] fruits = {{0, 999}, {50, 999}, {99, 999}}; // 三批果实，数量接近上限 1000
        int limit = 1; // 最小 limit，使采集次数最大化
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(299700, result); // 验证结果：每批需 999 次，3*999*100=299700
        
        System.out.println("最大约束 - 输入：100 种类型，3 批各 999 颗，limit=1"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testGetMinimumTime_UpwardRounding() {
        // 测试向上取整逻辑的正确性
        // time = [10], fruits = [[0,1],[0,11],[0,20]], limit = 10
        // 输出：30（1 颗需 1 次，11 颗需 2 次，20 颗需 2 次，总计 5 次*10=50）
        int[] time = {10}; // 单次采集时间为 10
        int[][] fruits = {{0, 1}, {0, 11}, {0, 20}}; // 三批数量分别为 1、11、20
        int limit = 10; // 单次最多采集 10 颗
        
        int result = solution.getMinimumTime(time, fruits, limit); // 调用方法计算最少时间
        
        assertEquals(50, result); // 验证结果：向上取整(1/10)=1，向上取整(11/10)=2，向上取整(20/10)=2，总计 5*10=50
        
        System.out.println("向上取整 - 输入：time = [10], fruits = [[0,1],[0,11],[0,20]], limit = 10"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }
}
