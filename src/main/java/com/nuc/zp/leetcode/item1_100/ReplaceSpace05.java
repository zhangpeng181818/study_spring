package com.nuc.zp.leetcode.item1_100;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= s 的长度 <= 10000
 */
public class ReplaceSpace05 {

    public String replaceSpace(String s) {
        if (s==null||s.length()==0) return s;
        return s.replaceAll(" ","%20");
    }

    public static void main(String[] args) {
        ReplaceSpace05 replaceSpace05 = new ReplaceSpace05();
        System.out.println(replaceSpace05.replaceSpace("We are happy."));
    }
}
