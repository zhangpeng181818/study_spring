package com.nuc.zp.leetcode.item601_700;

import java.util.Arrays;

public class MaximumProduct628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return sum(nums);
    }

    public int sum(int[] nums) {
        int sum = 1;
        if (nums.length <= 3) {
            for (int num : nums) {
                sum *= num;
            }
        } else {
            sum = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
            int max = Math.max(nums[0] * nums[1] * nums[nums.length - 1], sum);
            max = Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3], max);
            return Math.max(max, nums[0] * nums[1] * nums[2]);
        }
        return sum;
    }

    public static void main(String[] args) {
        MaximumProduct628 maximumProduct628 = new MaximumProduct628();
        System.out.println(maximumProduct628.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(maximumProduct628.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(maximumProduct628.maximumProduct(new int[]{1, 2, 3, 4}));
        System.out.println(maximumProduct628.maximumProduct(new int[]{-1, -2, -3}));
        System.out.println(maximumProduct628.maximumProduct(new int[]{-1, -2, -3, 4}));
        System.out.println(maximumProduct628.maximumProduct(new int[]{-1, -2, -3, 0, 2, 4}));
    }
}
