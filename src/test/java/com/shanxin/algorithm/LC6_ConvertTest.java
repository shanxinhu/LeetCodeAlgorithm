package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC6_ConvertTest {

    private final LC6_Convert solution = new LC6_Convert();

    @Test
    public void testConvert_Example1() {
        // 示例 1：s = "PAYPALISHIRING", numRows = 3
        // 输出："PAHNAPLSIIGYIR"
        String s = "PAYPALISHIRING";
        int numRows = 3;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("PAHNAPLSIIGYIR", result);
        
        System.out.println("示例 1 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_Example2() {
        // 示例 2：s = "PAYPALISHIRING", numRows = 4
        // 输出："PINALSIGYAHRPI"
        String s = "PAYPALISHIRING";
        int numRows = 4;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("PINALSIGYAHRPI", result);
        
        System.out.println("示例 2 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_Example3() {
        // 示例 3：s = "A", numRows = 1
        // 输出："A"
        String s = "A";
        int numRows = 1;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("A", result);
        
        System.out.println("示例 3 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_SingleRow() {
        // 边界情况：行数为 1，直接返回原字符串
        String s = "HELLO";
        int numRows = 1;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("HELLO", result);
        
        System.out.println("单行 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_SingleCharacter() {
        // 边界情况：单个字符
        String s = "X";
        int numRows = 2;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("X", result);
        
        System.out.println("单个字符 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_RowNumberEqualsStringLength() {
        // 行数等于字符串长度：每个字符占一行
        String s = "ABC";
        int numRows = 3;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("ABC", result);
        
        System.out.println("行数等于长度 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_RowNumberGreaterThanStringLength() {
        // 行数大于字符串长度
        String s = "AB";
        int numRows = 5;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("AB", result);
        
        System.out.println("行数大于长度 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_TwoRows() {
        // 两行的情况：s = "ABCDEFG", numRows = 2
        // A C E G
        // B D F
        // 输出："ACEGBDF"
        String s = "ABCDEFG";
        int numRows = 2;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("ACEGBDF", result);
        
        System.out.println("两行 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_WithSpecialCharacters() {
        // 包含特殊字符：s = "A,B.C", numRows = 2
        String s = "A,B.C";
        int numRows = 2;
        
        String result = solution.convert(s, numRows);
        
        // A . ,
        //   B C
        // 输出："ABC,."
        assertEquals("ABC,.", result);
        
        System.out.println("特殊字符 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_MixedCaseLetters() {
        // 混合大小写字母：s = "HelloWorld", numRows = 3
        String s = "HelloWorld";
        int numRows = 3;
        
        String result = solution.convert(s, numRows);
        
        // H     o     d
        // e   l W   r l
        // l     o
        // 输出："HolelWrdlo"
        assertEquals("HolelWrdlo", result);
        
        System.out.println("混合大小写 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }

    @Test
    public void testConvert_FiveRows() {
        // 5 行的情况：s = "ABCDEFGHIJ", numRows = 5
        // A       I
        // B     H J
        // C   G
        // D F
        // E
        // 输出："AIBHJCGDFE"
        String s = "ABCDEFGHIJ";
        int numRows = 5;
        
        String result = solution.convert(s, numRows);
        
        assertEquals("AIBHJCGDFE", result);
        
        System.out.println("五行 - 输入：s = \"" + s + "\", numRows = " + numRows);
        System.out.println("输出：" + result);
    }
}
