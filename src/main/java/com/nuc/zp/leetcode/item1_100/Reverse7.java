package com.nuc.zp.leetcode.item1_100;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse7 {
//    public int reverse(int x) {
//        String[] split = String.valueOf(x).split("");
//        int i = 0, j = split.length - 1;
//        if (split.length > 0 && "-".equals(split[0])) {
//            i++;
//        }
//        for (; i < j; i++, j--) {
//            String temp = split[i];
//            split[i] = split[j];
//            split[j] = temp;
//        }
//        return getNum(split);
//    }
//
//    int getNum(String[] split) {
//        String join = String.join("", split);
//        Long value = Long.valueOf(join);
//        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
//            return 0;
//        }
//        return value.intValue();
//    }

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
            System.out.println("n=" + n + " ,x=" + x);
        }
        return (int) n == n ? (int) n : 0;
    }


    public static void main(String[] args) {
        Reverse7 reverse7 = new Reverse7();
        System.out.println(reverse7.reverse(-125));
    }
}
