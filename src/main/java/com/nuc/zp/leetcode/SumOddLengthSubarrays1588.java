package com.nuc.zp.leetcode;

/**
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * <p>
 * 子数组 定义为原数组中的一个连续子序列。
 * <p>
 * 请你返回 arr 中 所有奇数长度子数组的和 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [10,11,12]
 * 输出：66
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOddLengthSubarrays1588 {


    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int maxOddNumber = arr.length % 2 == 0 ? arr.length - 1 : arr.length;
        for (int i = 1; i <= maxOddNumber; i += 2) {
            sum += sum(arr, i);
        }
        return sum;
    }

    private int sum(int[] arr, int len) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            if (i + len > arr.length) break;
            while (count < len) {
                sum += arr[i + count];
                count++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        SumOddLengthSubarrays1588 sumOddLengthSubarrays1588 = new SumOddLengthSubarrays1588();
        System.out.println(sumOddLengthSubarrays1588.sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
        System.out.println(sumOddLengthSubarrays1588.sumOddLengthSubarrays(new int[]{1, 2}));
        System.out.println(sumOddLengthSubarrays1588.sumOddLengthSubarrays(new int[]{10, 11, 12}));


    }
}
