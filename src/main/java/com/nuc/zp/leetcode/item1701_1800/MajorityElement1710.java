package com.nuc.zp.leetcode.item1701_1800;

import java.util.Arrays;

public class MajorityElement1710 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return nums[0] == nums[1] ? nums[0] : -1;
        return nums[nums.length / 2];
    }


}
