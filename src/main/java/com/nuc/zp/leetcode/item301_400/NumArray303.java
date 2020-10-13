package com.nuc.zp.leetcode.item301_400;

/**
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * <p>
 * 示例：
 * <p>
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 * <p>
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 * <p>
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumArray303 {

    class NumArray {

        int[] opt;
        int[] data;

        public NumArray(int[] nums) {
            if (nums.length == 0) return;
            data = nums;
            opt = new int[nums.length];
            opt[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                opt[i] = opt[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (opt == null || data == null) return 0;
            return opt[j] - opt[i] + data[i];
        }
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray303().new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));//1
        System.out.println(numArray.sumRange(2, 5));//-1
        System.out.println(numArray.sumRange(0, 5));//3
    }

}
