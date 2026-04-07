package com.shanxin.algorithm;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LC2150_FindLonely {

    /*
     https://leetcode.cn/problems/find-all-lonely-numbers-in-the-array/
        2150. 找出数组中的所有孤独数字
        中等
        相关标签
        premium lock icon
        相关企业
        提示
        给你一个整数数组 nums 。如果数字 x 在数组中仅出现 一次 ，且没有 相邻 数字（即，x + 1 和 x - 1）出现在数组中，则认为数字 x 是 孤独数字 。

        返回 nums 中的 所有 孤独数字。你可以按 任何顺序 返回答案。



        示例 1：

        输入：nums = [10,6,5,8]
        输出：[10,8]
        解释：
        - 10 是一个孤独数字，因为它只出现一次，并且 9 和 11 没有在 nums 中出现。
        - 8 是一个孤独数字，因为它只出现一次，并且 7 和 9 没有在 nums 中出现。
        - 5 不是一个孤独数字，因为 6 出现在 nums 中，反之亦然。
        因此，nums 中的孤独数字是 [10, 8] 。
        注意，也可以返回 [8, 10] 。
        示例 2：

        输入：nums = [1,3,5,3]
        输出：[1,5]
        解释：
        - 1 是一个孤独数字，因为它只出现一次，并且 0 和 2 没有在 nums 中出现。
        - 5 是一个孤独数字，因为它只出现一次，并且 4 和 6 没有在 nums 中出现。
        - 3 不是一个孤独数字，因为它出现两次。
        因此，nums 中的孤独数字是 [1, 5] 。
        注意，也可以返回 [5, 1] 。


        提示：

        1 <= nums.length <= 105
        0 <= nums[i] <= 106
     */

    public List<Integer> findLonely(int[] nums) {
        // 找出数组中的所有孤独数字
        // 时间复杂度：O(n)，其中 n 是数组长度，需要遍历数组两次
        // 空间复杂度：O(n)，使用 HashMap 存储每个数字的频率
        
        // 创建 HashMap 统计每个数字的出现次数
        Map<Integer, Integer> map = new HashMap<>();
        // 第一次遍历：统计所有数字的频率
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // 创建结果列表
        List<Integer> res = new ArrayList<>();
        // 第二次遍历：检查每个数字是否是孤独数字
        for (int num : nums){
            // 获取当前数字的出现次数
            int count = map.get(num);
            // 如果只出现一次，且没有相邻数字
            if (count == 1 && !map.containsKey(num - 1) && !map.containsKey(num + 1)){
                // 添加到结果列表
                res.add(num);
            }
        }
        // 返回结果列表
        return res;
    }
}
