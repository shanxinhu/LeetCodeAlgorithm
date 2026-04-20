package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC13_RomanToIntTest {

    @Test
    public void testRomanToInt_Example1() {
        // 示例 1：s = "III"
        // 输出：3
        LC13_RomanToInt solution = new LC13_RomanToInt();
        int result = solution.romanToInt("III");
        assertEquals(3, result);

        System.out.println("示例 1 - 输入: s = \"III\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testRomanToInt_Example2() {
        // 示例 2：s = "IV"
        // 输出：4
        LC13_RomanToInt solution = new LC13_RomanToInt();
        int result = solution.romanToInt("IV");
        assertEquals(4, result);

        System.out.println("示例 2 - 输入: s = \"IV\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testRomanToInt_Example3() {
        // 示例 3：s = "IX"
        // 输出：9
        LC13_RomanToInt solution = new LC13_RomanToInt();
        int result = solution.romanToInt("IX");
        assertEquals(9, result);

        System.out.println("示例 3 - 输入: s = \"IX\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testRomanToInt_Example4() {
        // 示例 4：s = "LVIII"
        // 输出：58（L = 50, V = 5, III = 3）
        LC13_RomanToInt solution = new LC13_RomanToInt();
        int result = solution.romanToInt("LVIII");
        assertEquals(58, result);

        System.out.println("示例 4 - 输入: s = \"LVIII\"");
        System.out.println("输出: " + result);
    }

    @Test
    public void testRomanToInt_Example5() {
        // 示例 5：s = "MCMXCIV"
        // 输出：1994（M = 1000, CM = 900, XC = 90, IV = 4）
        LC13_RomanToInt solution = new LC13_RomanToInt();
        int result = solution.romanToInt("MCMXCIV");
        assertEquals(1994, result);

        System.out.println("示例 5 - 输入: s = \"MCMXCIV\"");
        System.out.println("输出: " + result);
    }
}
