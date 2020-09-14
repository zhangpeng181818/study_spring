package com.nuc.zp.leetcode;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class IsPalindrome9 {

//    public boolean isPalindrome(int x) {
//        String[] split = String.valueOf(x).split("");
//        int i = 0, j = split.length - 1;
//        while (i < j) {
//            if (!split[i].equals(split[j])) {
//                return false;
//            }
//            i++;
//            j--;
//        }
//        return true;
//    }

//    public boolean isPalindrome(int x) {
//        StringBuilder reverse = new StringBuilder(x+"").reverse();
//        return String.valueOf(x).equals(reverse.toString());
//    }

    /**
     * 通过取整和取余操作获取整数中对应的数字进行比较。
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //边界判断
        if (x < 0) return false;
        int div = 1;
        //
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }

//    直观上来看待回文数的话，就感觉像是将数字进行对折后看能否一一对应。
//
//    所以这个解法的操作就是 取出后半段数字进行翻转。
//
//    这里需要注意的一个点就是由于回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数（除以 10 并取整）。
//
//    具体做法如下：
//
//    每次进行取余操作 （ %10），取出最低的数字：y = x % 10
//    将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
//    每取一个最低位数字，x 都要自除以 10
//    判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
//    最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。

//    public boolean isPalindrome(int x) {
//        //思考：这里大家可以思考一下，为什么末尾为 0 就可以直接返回 false
//        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
//        int revertedNumber = 0;
//        while (x > revertedNumber) {
//            revertedNumber = revertedNumber * 10 + x % 10;
//            x /= 10;
//        }
//        return x == revertedNumber || x == revertedNumber / 10;
//    }




    public static void main(String[] args) {
        IsPalindrome9 isPalindrome9 = new IsPalindrome9();
        System.out.println(isPalindrome9.isPalindrome(121));
        System.out.println(isPalindrome9.isPalindrome(-121));
        System.out.println(isPalindrome9.isPalindrome(10));
    }
}
