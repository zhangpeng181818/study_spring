package com.nuc.zp.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt69 {

//    public int mySqrt(int x) {
//        return (int)Math.sqrt(x);
//    }

    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int med = ((right - left) >> 1) + left;
            if (med * med > x) {
                right = med - 1;
            } else {
                left = med + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        MySqrt69 mySqrt69 = new MySqrt69();
        System.out.println(mySqrt69.mySqrt(15));
    }
}
