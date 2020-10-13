package com.nuc.zp.leetcode.item401_500;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 示例 1:
 * <p>
 * 输入: [1, 5, 11, 5]
 * <p>
 * 输出: true
 * <p>
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1, 2, 3, 5]
 * <p>
 * 输出: false
 * <p>
 * 解释: 数组不能分割成两个元素和相等的子集.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartition416 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        if (sum % 2 == 1 || max > (sum >> 1)) {
            return false;
        }
        sum >>= 1;
        int target = sum;


        boolean[][] opt = new boolean[nums.length][sum + 1];

        opt[0][nums[0]] = true;
        for (int i = 0; i < nums.length; i++) {
            opt[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < opt[i].length; j++) {
                if (nums[i] > j) {
                    opt[i][j] = opt[i - 1][j];
                } else {
                    boolean A = opt[i - 1][j];
                    boolean B = opt[i - 1][j - nums[i]];
                    opt[i][j] = A | B;
                }
            }
        }
        return opt[nums.length - 1][target];
    }

    public static void main(String[] args) {

        CanPartition416 canPartition416 = new CanPartition416();
        System.out.println(canPartition416.canPartition(new int[]{1, 5, 11, 5}));
    }
}
