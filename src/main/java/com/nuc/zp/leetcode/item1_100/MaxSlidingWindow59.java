package com.nuc.zp.leetcode.item1_100;

import java.util.Arrays;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 * <p>
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow59 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] opt = new int[nums.length];
        if (k <= 1) return nums;
        for (int i = 0; i < nums.length; i++) {
            if (i + k > nums.length) {
                break;
            }
            int j = 0;
            int max = Integer.MIN_VALUE;
            while (j < k) {
                max = Integer.max(max, nums[i + j]);
                j++;
            }
            opt[i] = max;
        }
        return Arrays.copyOfRange(opt, 0, opt.length-k+1);
    }

    public static void main(String[] args) {
        MaxSlidingWindow59 maxSlidingWindow59 = new MaxSlidingWindow59();
        System.out.println(Arrays.toString(maxSlidingWindow59.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow59.maxSlidingWindow(new int[]{7, 2, 4}, 2)));
    }
}
