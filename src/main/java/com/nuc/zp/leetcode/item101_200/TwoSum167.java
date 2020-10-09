package com.nuc.zp.leetcode.item101_200;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum167 {

//    public int[] twoSum(int[] numbers, int target) {
//
//        int left = 0, right = numbers.length - 1;
//
//        while (left <= right) {
//            if (numbers[left] + numbers[right] == target) {
//                return new int[]{left + 1, right + 1};
//            } else if (numbers[left] + numbers[right] > target) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return new int[]{-1, -1};
//    }

    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }



    public static void main(String[] args) {
        TwoSum167 twoSum167 = new TwoSum167();
        System.out.println(Arrays.toString(twoSum167.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
