package com.nuc.zp.leetcode;

import java.util.Arrays;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirdMax414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int thirdMax = Integer.MAX_VALUE;
        int count = 0;
        int i = nums.length - 1;
        while (i >= 0) {
            if (count > 2) break;
            if (nums[i] < thirdMax) {
                thirdMax = nums[i];
                count++;
            }
            i--;
        }

        if (count <= 2) {
             return nums[nums.length - 1];
        }

        return thirdMax;
    }

    public static void main(String[] args) {
        ThirdMax414 thirdMax414 = new ThirdMax414();
        System.out.println(thirdMax414.thirdMax(new int[]{3, 2, 1}));
        System.out.println(thirdMax414.thirdMax(new int[]{1, 2}));
        System.out.println(thirdMax414.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(thirdMax414.thirdMax(new int[]{1, 1,2}));
    }
}
