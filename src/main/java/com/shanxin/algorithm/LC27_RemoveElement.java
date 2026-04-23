package com.shanxin.algorithm;

public class LC27_RemoveElement {

    /*

      https://leetcode.cn/problems/remove-element/
   27. 移除元素
            简单
            相关标签
            premium lock icon
            相关企业
            提示
            给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。

            假设 nums 中不等于 val 的元素数量为 k，要通过此题，您需要执行以下操作：

            更改 nums 数组，使 nums 的前 k 个元素包含不等于 val 的元素。nums 的其余元素和 nums 的大小并不重要。
            返回 k。
            用户评测：

            评测机将使用以下代码测试您的解决方案：

            int[] nums = [...]; // 输入数组
            int val = ...; // 要移除的值
            int[] expectedNums = [...]; // 长度正确的预期答案。
                                        // 它以不等于 val 的值排序。

            int k = removeElement(nums, val); // 调用你的实现

            assert k == expectedNums.length;
            sort(nums, 0, k); // 排序 nums 的前 k 个元素
            for (int i = 0; i < actualLength; i++) {
                assert nums[i] == expectedNums[i];
            }
            如果所有的断言都通过，你的解决方案将会 通过。



            示例 1：

            输入：nums = [3,2,2,3], val = 3
            输出：2, nums = [2,2,_,_]
            解释：你的函数应该返回 k = 2, 并且 nums 中的前两个元素均为 2。
            你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。
            示例 2：

            输入：nums = [0,1,2,2,3,0,4,2], val = 2
            输出：5, nums = [0,1,4,0,3,_,_,_]
            解释：你的函数应该返回 k = 5，并且 nums 中的前五个元素为 0,0,1,3,4。
            注意这五个元素可以任意顺序返回。
            你在返回的 k 个元素之外留下了什么并不重要（因此它们并不计入评测）。


            提示：

            0 <= nums.length <= 100
            0 <= nums[i] <= 50
            0 <= val <= 100

   */


    /**
     * 左右双指针移除元素
     * start 从左往右寻找等于 val 的元素，用 end 指向的元素覆盖它，
     * 这样减少不必要的写操作（相比快慢指针法）。
     *
     * 时间复杂度：O(n)，其中 n 为数组长度，start 和 end 最多各遍历一次数组。
     * 空间复杂度：O(1)，仅使用常数级别的额外变量。
     */
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // start：左指针，从左查找要移除的元素；end：右指针，指向待交换的尾部元素
        int start = 0, end = len - 1;

        // 3 2 2 3  3
        while (start < end) {
            if (nums[start] == val) {
                // 用尾部元素覆盖当前 val 元素
                nums[start] = nums[end];
                end--;
            } else {
                start++;
            }
        }

        // 循环结束时 start == end，需检查该位置是否为有效元素
        if (nums[start] != val) {
            start++;
        }

        return start;
    }

}
