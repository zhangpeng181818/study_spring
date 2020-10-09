package com.nuc.zp.leetcode.item1_100;

/**
 * 统计一个数字在排序数组中出现的次数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 50000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Search53 {

    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int med = ((right - left) >> 1) + left;
            if (nums[med] == target) {
                count++;
                left = med + 1;
                right = med - 1;
                while (left < nums.length && nums[left++] == target) count++;
                while (right >= 0 && nums[right--] == target) count++;
                break;
            } else if (nums[med] < target) {
                left = med + 1;
            } else {
                right = med - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Search53 search53 = new Search53();
        System.out.println(search53.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
        System.out.println(search53.search(new int[]{1,1,1}, 8));
    }
}
