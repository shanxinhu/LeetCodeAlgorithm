package com.shanxin.algorithm;

public class LC365_CanMeasureWater {

    /*

        https://leetcode.cn/problems/water-and-jug-problem/
        365. 水壶问题
            中等
            相关标签
            premium lock icon
            相关企业
            有两个水壶，容量分别为 x 和 y 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 target 升。

            你可以：

            装满任意一个水壶
            清空任意一个水壶
            将水从一个水壶倒入另一个水壶，直到接水壶已满，或倒水壶已空。


            示例 1:

            输入: x = 3,y = 5,target = 4
            输出: true
            解释：
            按照以下步骤操作，以达到总共 4 升水：
            1. 装满 5 升的水壶(0, 5)。
            2. 把 5 升的水壶倒进 3 升的水壶，留下 2 升(3, 2)。
            3. 倒空 3 升的水壶(0, 2)。
            4. 把 2 升水从 5 升的水壶转移到 3 升的水壶(2, 0)。
            5. 再次加满 5 升的水壶(2, 5)。
            6. 从 5 升的水壶向 3 升的水壶倒水直到 3 升的水壶倒满。5 升的水壶里留下了 4 升水(3, 4)。
            7. 倒空 3 升的水壶。现在，5 升的水壶里正好有 4 升水(0, 4)。
            参考：来自著名的 "Die Hard"
            示例 2:

            输入: x = 2, y = 6, target = 5
            输出: false
            示例 3:

            输入: x = 1, y = 2, target = 3
            输出: true
            解释：同时倒满两个水壶。现在两个水壶中水的总量等于 3。


            提示:

            1 <= x, y, target <= 103
     */


    public boolean canMeasureWater(int x, int y, int target) { // 判断是否能用两个水壶测量出目标水量
        // 时间复杂度：O(log(min(x, y)))，计算 GCD 的复杂度
        // 空间复杂度：O(1)，只使用了常数个额外变量
        return target <= x + y && target % gcd(x, y) == 0; // 目标不超过总容量且能被 GCD 整除即可测量
    }

    private int gcd(int a, int b) { // 计算两个数的最大公约数（欧几里得算法）
        return b == 0 ? a : gcd(b, a % b); // 递归计算：GCD(a,b) = GCD(b, a%b)，直到 b=0
    }
}
