package com.shanxin.algorithm;


import java.util.ArrayList;
import java.util.List;

public class LC188_Generate {

    /*
     https://leetcode.cn/problems/pascals-triangle/
     118. 杨辉三角
        简单
        相关标签
        premium lock icon
        相关企业
        给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。

        在「杨辉三角」中，每个数是它左上方和右上方的数的和。

        示例 1:

        输入: numRows = 5
        输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
        示例 2:

        输入: numRows = 1
        输出: [[1]]


        提示:

        1 <= numRows <= 30
     */

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> objects = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    objects.add(1);
                } else {
                    objects.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(objects);
        }
        return res; // Fixed return statement

    }
}
