package com.nuc.zp.leetcode.item201_300;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * <p>
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] != 0) i++;
            while (j < nums.length && nums[j] == 0) j++;
            if (i >= nums.length || j >= nums.length) {
                break;
            }
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes283 moveZeroes283 = new MoveZeroes283();
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {1, 0, 1};
        moveZeroes283.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
