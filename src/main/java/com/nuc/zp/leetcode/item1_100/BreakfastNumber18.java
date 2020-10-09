package com.nuc.zp.leetcode.item1_100;

import java.util.Arrays;

/**
 * 小扣在秋日市集选择了一家早餐摊位，一维整型数组 staple 中记录了每种主食的价格，
 * 一维整型数组 drinks 中记录了每种饮料的价格。小扣的计划选择一份主食和一款饮料，且花费不超过 x 元。请返回小扣共有多少种购买方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * <p>
 * 示例 1：
 * <p>
 * 输入：staple = [10,20,5], drinks = [5,5,2], x = 15
 * 5 5  2
 * 10  15  15 12
 * 20  25  25 22
 * 5  10   10  7
 * 2   5    5
 * 5   7   10    10
 * 10   12  15   15
 * 20  22
 *
 * <p>
 * 输出：6
 * <p>
 * 解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
 * 第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
 * 第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
 * 第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
 * 第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
 * 第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
 * <p>
 * 示例 2：
 * <p>
 * 输入：staple = [2,1,1], drinks = [8,9,5,1], x = 9
 * <p>
 * 输出：8
 * <p>
 * 解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
 * 第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
 * 第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
 * 第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
 * 第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
 * 第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
 * 第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
 * 第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
 * 第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
 * <p>
 * 提示：
 * <p>
 * 1 <= staple.length <= 10^5
 * 1 <= drinks.length <= 10^5
 * 1 <= staple[i],drinks[i] <= 10^5
 * 1 <= x <= 2*10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/2vYnGI
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BreakfastNumber18 {

    //超时
//    public int breakfastNumber(int[] staple, int[] drinks, int x) {
//        int count = 0;
//        for (int i = 0; i < staple.length; i++) {
//            for (int j = 0; j < drinks.length; j++) {
//                if (staple[i] + drinks[j] <= x) {
//                    count++;
//                }
//            }
//        }
//        return count % 1000000007;
//    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        Arrays.sort(staple);
        Arrays.sort(drinks);
        long count = 0;
        for (int i = 0; i < staple.length; i++) {
            if (staple[i] >= x) break;
            count += index(staple[i], drinks, x) + 1;
        }
        return (int)(count % 1000000007L);
    }

    private int index(int staple, int[] drinks, int x) {
        int left = 0, right = drinks.length - 1;
        while (left <= right) {
            int med = ((right - left) >> 1) + left;
            if (staple + drinks[med] > x) {
                right = med - 1;
            } else {
                left = med + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        BreakfastNumber18 breakfastNumber18 = new BreakfastNumber18();
        System.out.println(breakfastNumber18.breakfastNumber(new int[]{10, 20, 5}, new int[]{5, 5, 2}, 15));
        System.out.println(breakfastNumber18.breakfastNumber(new int[]{2, 1, 1}, new int[]{8, 9, 5, 1}, 9));

    }
}
