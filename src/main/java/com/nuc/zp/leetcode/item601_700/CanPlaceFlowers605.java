package com.nuc.zp.leetcode.item601_700;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 3
 * 输出：false
 * <p>
 * 输入：flowerbed = [1,0,0,1], n = 2
 * 输出：false
 * <p>
 * 输入：flowerbed = [1,0,1], n = 1
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 */
public class CanPlaceFlowers605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
            } else if ((flowerbed[i] == 0 && i + 1 < flowerbed.length && flowerbed[i + 1] != 1)) {
                n--;
                i++;
            } else if (i + 1 == flowerbed.length) {
                n--;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        CanPlaceFlowers605 canPlaceFlowers605 = new CanPlaceFlowers605();
        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));

        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 1}, 2));

        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 3));
        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 0, 1}, 2));
        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 0, 1}, 1));
        System.out.println(canPlaceFlowers605.canPlaceFlowers(new int[]{1, 0, 1}, 1));
    }
}
