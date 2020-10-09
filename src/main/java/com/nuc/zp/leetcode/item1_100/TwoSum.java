package com.nuc.zp.leetcode.item1_100;

import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * <p>
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
class TwoSum {

    //    O(n^2)
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }
// O(n)
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> numsMap = new HashMap<>(nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            if (!numsMap.containsKey(nums[i])) {
//                numsMap.put(nums[i], i);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int val = target - nums[i];
//            Integer index = numsMap.get(val);
//            if (index != null && index != i) {
//                return new int[]{i, index};
//            }
//        }
//        return null;
//    }

    //O(n)
    /**
     * 3:   0011
     * 2:   0010
     * 4:   0100
     */
    public int[] twoSum(int[] nums, int target) {
        //这里的volume是2048，取决于测试用例
        int volume = 2 << 10; //100000000000
        int bitMode = volume - 1;//011111111111
        int[] result = new int[volume];

        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (result[c] != 0) {
                return new int[]{result[c] - 1, i};
            }
            result[nums[i] & bitMode] = i + 1;
        }
        return null;
    }


    /**
     * [3,2,4]
     * 6
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
