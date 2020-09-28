package com.nuc.zp.leetcode;

/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *  
 * <p>
 * 说明：
 * <p>
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPossibility665 {

    /**
     * 遍历整个数组如果出现不满足非递减的情况，并对每一次计数，第二次出现非递减时直接返回false。
     * 对于每一个非递减数列中的断点，可分为两种不同的情况
     * ①第i个元素是断点(nums[i]>nums[i+1])，i+1个元素小于i-1个元素，在只修改一个元素的情况下只能改变i+1的值才能保证是一个非递减数列，为了尽可能不影响后面的元素，nums[i+1]=min(满足条件的值)=nums[i];
     * ②第i个元素是断点，i+1个元素大于等于i-1个元素,在满足条件的情况下修改nums[i]=[nums[i-1],nums[i+1]]中任取一个值
     *
     * 作者：guard-2
     * 链接：https://leetcode-cn.com/problems/non-decreasing-array/solution/java-1ms-100-yi-ci-bian-li-by-guard-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int temp = Integer.MIN_VALUE, count = 0;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (count++ > 0) {
                    return false;
                }
                if (nums[i + 1] >= temp) {
                    nums[i] = temp;
                } else {
                    nums[i+1] = nums[i];
                }
            }
            //i-1
            temp = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        CheckPossibility665 checkPossibility665 = new CheckPossibility665();
        System.out.println(checkPossibility665.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility665.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(checkPossibility665.checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(checkPossibility665.checkPossibility(new int[]{-1, 4, 2, 3}));
        System.out.println(checkPossibility665.checkPossibility(new int[]{1, 4, 1, 2}));
    }
}
