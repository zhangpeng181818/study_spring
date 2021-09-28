package com.nuc.zp.leetcode.item1501_1600;

/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,3,4,7,11], k = 5
 * 输出：9
 * 解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,3,4], k = 2
 * 输出：6
 * 解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * 1 <= k <= 1000
 * 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-missing-positive-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindKthPositive1539 {
    public int findKthPositive(int[] arr, int k) {
        int length = arr.length;
        if (arr[length - 1] - length < k) {
            length += k;
        } else {
            length = arr[length - 1];
        }
        int[] nums = new int[length];
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i] - 1] = 1;
        }
        int j = 0;
        while (k > 0) {
            if (nums[j] == 0) {
                k--;
            }
            j++;
        }
        return j ;
    }

    public static void main(String[] args) {
        FindKthPositive1539 findKthPositive1539 = new FindKthPositive1539();
        System.out.println(findKthPositive1539.findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));
        System.out.println(findKthPositive1539.findKthPositive(new int[]{1, 2, 3, 4}, 2));
    }
}
