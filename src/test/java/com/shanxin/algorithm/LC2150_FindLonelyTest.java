package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LC2150_FindLonelyTest {

    private final LC2150_FindLonely solution = new LC2150_FindLonely(); // 创建被测试的解决方案实例

    @Test
    public void testFindLonely_Example1() {
        // 示例 1：nums = [10,6,5,8]
        // 输出：[10,8]（顺序可以是 [8,10]）
        // 解释：
        // - 10 出现1次，9和11都不在数组中 → 孤独
        // - 6 出现1次，但5在数组中 → 不孤独
        // - 5 出现1次，但6在数组中 → 不孤独
        // - 8 出现1次，7和9都不在数组中 → 孤独
        int[] nums = {10, 6, 5, 8}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果包含 10 和 8
        assertEquals(2, result.size()); // 验证结果大小为 2
        assertTrue(result.contains(10)); // 验证包含 10
        assertTrue(result.contains(8)); // 验证包含 8
        
        System.out.println("示例 1 - 输入：[10,6,5,8]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_Example2() {
        // 示例 2：nums = [1,3,5,3]
        // 输出：[1,5]（顺序可以是 [5,1]）
        // 解释：
        // - 1 出现1次，0和2都不在数组中 → 孤独
        // - 3 出现2次 → 不孤独
        // - 5 出现1次，4和6都不在数组中 → 孤独
        int[] nums = {1, 3, 5, 3}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果包含 1 和 5
        assertEquals(2, result.size()); // 验证结果大小为 2
        assertTrue(result.contains(1)); // 验证包含 1
        assertTrue(result.contains(5)); // 验证包含 5
        
        System.out.println("示例 2 - 输入：[1,3,5,3]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_AllLonely() {
        // 所有数字都是孤独的
        // nums = [1, 5, 10]
        // 每个数字都出现1次，且没有相邻数字
        // 输出：[1, 5, 10]
        int[] nums = {1, 5, 10}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果包含所有数字
        assertEquals(3, result.size()); // 验证结果大小为 3
        assertTrue(result.contains(1)); // 验证包含 1
        assertTrue(result.contains(5)); // 验证包含 5
        assertTrue(result.contains(10)); // 验证包含 10
        
        System.out.println("全孤独 - 输入：[1,5,10]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_NoLonely() {
        // 没有孤独数字
        // nums = [1, 2, 3]
        // 1 有相邻的 2，2 有相邻的 1 和 3，3 有相邻的 2
        // 输出：[]
        int[] nums = {1, 2, 3}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果为空
        assertEquals(0, result.size()); // 验证结果大小为 0
        
        System.out.println("无孤独 - 输入：[1,2,3]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_SingleElement() {
        // 单个元素
        // nums = [42]
        // 42 出现1次，41和43都不在数组中 → 孤独
        // 输出：[42]
        int[] nums = {42}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果
        assertEquals(1, result.size()); // 验证结果大小为 1
        assertEquals(42, result.get(0)); // 验证结果为 42
        
        System.out.println("单元素 - 输入：[42]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_Duplicates() {
        // 重复元素
        // nums = [1, 1, 1, 1]
        // 1 出现4次 → 不孤独
        // 输出：[]
        int[] nums = {1, 1, 1, 1}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果为空
        assertEquals(0, result.size()); // 验证结果大小为 0
        
        System.out.println("重复元素 - 输入：[1,1,1,1]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_MixedCase() {
        // 混合情况
        // nums = [1, 2, 4, 6, 8, 10]
        // 1 有相邻的 2 → 不孤独
        // 2 有相邻的 1 → 不孤独
        // 4 出现1次，3和5都不在 → 孤独
        // 6 出现1次，5和7都不在 → 孤独
        // 8 出现1次，7和9都不在 → 孤独
        // 10 出现1次，9和11都不在 → 孤独
        // 输出：[4, 6, 8, 10]
        int[] nums = {1, 2, 4, 6, 8, 10}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果
        assertEquals(4, result.size()); // 验证结果大小为 4
        assertTrue(result.contains(4)); // 验证包含 4
        assertTrue(result.contains(6)); // 验证包含 6
        assertTrue(result.contains(8)); // 验证包含 8
        assertTrue(result.contains(10)); // 验证包含 10
        assertFalse(result.contains(1)); // 验证不包含 1
        assertFalse(result.contains(2)); // 验证不包含 2
        
        System.out.println("混合情况 - 输入：[1,2,4,6,8,10]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_AdjacentPairs() {
        // 相邻对
        // nums = [1, 2, 5, 6, 9, 10]
        // 1 有相邻的 2 → 不孤独
        // 2 有相邻的 1 → 不孤独
        // 5 有相邻的 6 → 不孤独
        // 6 有相邻的 5 → 不孤独
        // 9 有相邻的 10 → 不孤独
        // 10 有相邻的 9 → 不孤独
        // 输出：[]
        int[] nums = {1, 2, 5, 6, 9, 10}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果为空
        assertEquals(0, result.size()); // 验证结果大小为 0
        
        System.out.println("相邻对 - 输入：[1,2,5,6,9,10]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_ZeroValue() {
        // 包含零值
        // nums = [0, 2, 4]
        // 0 出现1次，-1和1都不在 → 孤独
        // 2 出现1次，1和3都不在 → 孤独
        // 4 出现1次，3和5都不在 → 孤独
        // 输出：[0, 2, 4]
        int[] nums = {0, 2, 4}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果
        assertEquals(3, result.size()); // 验证结果大小为 3
        assertTrue(result.contains(0)); // 验证包含 0
        assertTrue(result.contains(2)); // 验证包含 2
        assertTrue(result.contains(4)); // 验证包含 4
        
        System.out.println("包含零 - 输入：[0,2,4]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_LargeValues() {
        // 大数值测试
        // nums = [1000000, 999998, 999996]
        // 每个数字都出现1次，且没有相邻数字
        // 输出：[1000000, 999998, 999996]
        int[] nums = {1000000, 999998, 999996}; // 输入数组
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果
        assertEquals(3, result.size()); // 验证结果大小为 3
        assertTrue(result.contains(1000000)); // 验证包含 1000000
        assertTrue(result.contains(999998)); // 验证包含 999998
        assertTrue(result.contains(999996)); // 验证包含 999996
        
        System.out.println("大数值 - 输入：[1000000,999998,999996]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }

    @Test
    public void testFindLonely_ComplexScenario() {
        // 复杂场景：需要验证处理顺序不影响结果
        // nums = [8, 10, 5, 6]
        // 与示例1相同，只是顺序不同
        // 输出：[8, 10]
        int[] nums = {8, 10, 5, 6}; // 输入数组（顺序不同）
        
        List<Integer> result = solution.findLonely(nums); // 调用方法查找孤独数字
        
        // 验证结果
        assertEquals(2, result.size()); // 验证结果大小为 2
        assertTrue(result.contains(8)); // 验证包含 8
        assertTrue(result.contains(10)); // 验证包含 10
        
        System.out.println("复杂场景 - 输入：[8,10,5,6]"); // 打印输入信息
        System.out.println("输出：" + result); // 打印输出结果
    }
}
