package com.nuc.zp.leetcode.item201_300;

import java.util.Arrays;

public class FindKthLargest215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}
