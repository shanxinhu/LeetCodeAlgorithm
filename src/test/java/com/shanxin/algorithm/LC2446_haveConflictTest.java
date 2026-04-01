package com.shanxin.algorithm;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LC2446_haveConflictTest {

    private final LC2446_haveConflict solution = new LC2446_haveConflict();

    @Test
    public void testHaveConflict_Example1() {
        // 示例 1：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
        // 输出：true
        // 解释：两个事件在 2:00 出现交集（端点相交）
        String[] event1 = {"01:15", "02:00"};
        String[] event2 = {"02:00", "03:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("示例 1 - 输入：event1 = [\"01:15\",\"02:00\"], event2 = [\"02:00\",\"03:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_Example2() {
        // 示例 2：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
        // 输出：true
        // 解释：两个事件的交集从 01:20 开始，到 02:00 结束
        String[] event1 = {"01:00", "02:00"};
        String[] event2 = {"01:20", "03:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("示例 2 - 输入：event1 = [\"01:00\",\"02:00\"], event2 = [\"01:20\",\"03:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_Example3() {
        // 示例 3：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
        // 输出：false
        // 解释：两个事件不存在交集
        String[] event1 = {"10:00", "11:00"};
        String[] event2 = {"14:00", "15:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertFalse(result);
        
        System.out.println("示例 3 - 输入：event1 = [\"10:00\",\"11:00\"], event2 = [\"14:00\",\"15:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_CompleteOverlap() {
        // 完全重叠：event2 完全在 event1 内部
        // event1 = ["09:00","17:00"], event2 = ["10:00","15:00"]
        // 输出：true
        String[] event1 = {"09:00", "17:00"};
        String[] event2 = {"10:00", "15:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("完全重叠 - 输入：event1 = [\"09:00\",\"17:00\"], event2 = [\"10:00\",\"15:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_SameStart() {
        // 相同开始时间：event1 和 event2 同时开始
        // event1 = ["08:00","10:00"], event2 = ["08:00","09:00"]
        // 输出：true
        String[] event1 = {"08:00", "10:00"};
        String[] event2 = {"08:00", "09:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("相同开始 - 输入：event1 = [\"08:00\",\"10:00\"], event2 = [\"08:00\",\"09:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_SameEnd() {
        // 相同结束时间：event1 和 event2 同时结束
        // event1 = ["14:00","18:00"], event2 = ["15:00","18:00"]
        // 输出：true
        String[] event1 = {"14:00", "18:00"};
        String[] event2 = {"15:00", "18:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("相同结束 - 输入：event1 = [\"14:00\",\"18:00\"], event2 = [\"15:00\",\"18:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_IdenticalEvents() {
        // 完全相同的事件
        // event1 = ["12:00","13:00"], event2 = ["12:00","13:00"]
        // 输出：true
        String[] event1 = {"12:00", "13:00"};
        String[] event2 = {"12:00", "13:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("相同事件 - 输入：event1 = [\"12:00\",\"13:00\"], event2 = [\"12:00\",\"13:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_NoOverlap_MorningAfternoon() {
        // 无重叠：一个在上午，一个在下午
        // event1 = ["08:00","09:00"], event2 = ["13:00","14:00"]
        // 输出：false
        String[] event1 = {"08:00", "09:00"};
        String[] event2 = {"13:00", "14:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertFalse(result);
        
        System.out.println("无重叠上下午 - 输入：event1 = [\"08:00\",\"09:00\"], event2 = [\"13:00\",\"14:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_NoOverlap_Adjacent() {
        // 无重叠：相邻但不相交（中间有间隙）
        // event1 = ["10:00","11:00"], event2 = ["11:01","12:00"]
        // 输出：false
        String[] event1 = {"10:00", "11:00"};
        String[] event2 = {"11:01", "12:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertFalse(result);
        
        System.out.println("无重叠相邻 - 输入：event1 = [\"10:00\",\"11:00\"], event2 = [\"11:01\",\"12:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_Event2BeforeEvent1() {
        // event2 在 event1 之前
        // event1 = ["15:00","16:00"], event2 = ["09:00","10:00"]
        // 输出：false
        String[] event1 = {"15:00", "16:00"};
        String[] event2 = {"09:00", "10:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertFalse(result);
        
        System.out.println("event2 在前 - 输入：event1 = [\"15:00\",\"16:00\"], event2 = [\"09:00\",\"10:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_PartialOverlap_Start() {
        // 部分重叠：event2 的开始在 event1 中间
        // event1 = ["09:00","12:00"], event2 = ["10:00","11:00"]
        // 输出：true
        String[] event1 = {"09:00", "12:00"};
        String[] event2 = {"10:00", "11:00"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("部分重叠开始 - 输入：event1 = [\"09:00\",\"12:00\"], event2 = [\"10:00\",\"11:00\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_EarlyMorningLateNight() {
        // 清晨和深夜：一天的最早和最晚时间
        // event1 = ["00:00","01:00"], event2 = ["23:00","23:59"]
        // 输出：false
        String[] event1 = {"00:00", "01:00"};
        String[] event2 = {"23:00", "23:59"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertFalse(result);
        
        System.out.println("清晨深夜 - 输入：event1 = [\"00:00\",\"01:00\"], event2 = [\"23:00\",\"23:59\"]");
        System.out.println("输出：" + result);
    }

    @Test
    public void testHaveConflict_MidnightBoundary() {
        // 跨午夜边界测试
        // event1 = ["23:30","23:59"], event2 = ["23:45","23:59"]
        // 输出：true
        String[] event1 = {"23:30", "23:59"};
        String[] event2 = {"23:45", "23:59"};
        
        boolean result = solution.haveConflict(event1, event2);
        
        assertTrue(result);
        
        System.out.println("午夜边界 - 输入：event1 = [\"23:30\",\"23:59\"], event2 = [\"23:45\",\"23:59\"]");
        System.out.println("输出：" + result);
    }
}
