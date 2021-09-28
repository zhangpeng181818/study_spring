package com.nuc.zp.leetcode.item1501_1600;

/**
 * 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
 * <p>
 * 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
 * <p>
 * 0 <= i < j < k < arr.length
 * |arr[i] - arr[j]| <= a
 * |arr[j] - arr[k]| <= b
 * |arr[i] - arr[k]| <= c
 * 其中 |x| 表示 x 的绝对值。
 * <p>
 * 返回 好三元组的数量 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
 * 输出：4
 * 解释：一共有 4 个好三元组：[(3,0,1), (3,0,1), (3,1,1), (0,1,1)] 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,2,2,3], a = 0, b = 0, c = 1
 * 输出：0
 * 解释：不存在满足所有条件的三元组。
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= arr.length <= 100
 * 0 <= arr[i] <= 1000
 * 0 <= a, b, c <= 1000
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-triplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountGoodTriplets1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int i = 0, count = 0;
        for (; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (isThree(arr[i], arr[j], arr[k], a, b, c)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean isThree(int i, int j, int k, int a, int b, int c) {
        return Math.abs(i - j) <= a &&
                Math.abs(j - k) <= b &&
                Math.abs(i - k) <= c;
    }

    public static void main(String[] args) {
        CountGoodTriplets1534 countGoodTriplets1534 = new CountGoodTriplets1534();
        System.out.println(countGoodTriplets1534.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
        System.out.println(countGoodTriplets1534.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }
}
