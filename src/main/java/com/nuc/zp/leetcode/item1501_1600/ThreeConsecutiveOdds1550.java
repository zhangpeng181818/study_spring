package com.nuc.zp.leetcode.item1501_1600;

/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 */
public class ThreeConsecutiveOdds1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int oddNumCount = 0;
        for (int num : arr) {
            if (oddNumCount >= 3) return true;
            if (oddNumber(num)) {
                oddNumCount++;
            } else {
                oddNumCount = 0;
            }
        }
        return oddNumCount >= 3;
    }

    public boolean oddNumber(int num) {
        return num % 2 == 1;
    }


    public static void main(String[] args) {
        ThreeConsecutiveOdds1550 threeConsecutiveOdds1550 = new ThreeConsecutiveOdds1550();
        System.out.println(threeConsecutiveOdds1550.threeConsecutiveOdds(new int[]{2, 6, 4, 1}));
        System.out.println(threeConsecutiveOdds1550.threeConsecutiveOdds(new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12}));
        System.out.println(threeConsecutiveOdds1550.threeConsecutiveOdds(new int[]{1, 1, 1}));
    }
}
