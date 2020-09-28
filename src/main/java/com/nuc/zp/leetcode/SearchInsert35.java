package com.nuc.zp.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsert35 {

    //O(n)
    public int searchInsert2(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                break;
            } else if (nums[i] > target && (i != 0 && nums[i - 1] < target)) {
                index = i;
                break;
            } else if (nums[i] < target && i == nums.length - 1) {
                index = i + 1;
                break;
            }
        }
        return index;
    }

    //
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int ret = nums.length;
        while (i <= j) {
            int med = ((j - i) >> 1) + i;

            if (nums[med] >= target) {
                ret = med;
                j = med - 1;
            } else {
                i = med + 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        SearchInsert35 searchInsert35 = new SearchInsert35();
        System.out.println(searchInsert35.searchInsert(new int[]{1, 3, 5, 6}, 5));//2
        System.out.println(searchInsert35.searchInsert(new int[]{1, 3, 5, 6}, 2));//1
        System.out.println(searchInsert35.searchInsert(new int[]{1, 3, 5, 6}, 7));//4
        System.out.println(searchInsert35.searchInsert(new int[]{1, 3, 5, 6}, 0));//0
        System.out.println(searchInsert35.searchInsert(new int[]{1, 3}, 2));//1
        System.out.println(searchInsert35.searchInsert(new int[]{1, 3}, 0));//0
        System.out.println(searchInsert35.searchInsert(new int[]{1, 3}, 1));//0
        System.out.println(searchInsert35.searchInsert(new int[]{1}, 2));//1
        System.out.println(searchInsert35.searchInsert(new int[]{1}, 0));//0

    }
}
