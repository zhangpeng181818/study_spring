package com.nuc.zp.leetcode.item201_300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 * 示例 3：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：["-1"]
 * 示例 5：
 * <p>
 * 输入：nums = [0]
 * 输出：["0"]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 20
 * -231 <= nums[i] <= 231 - 1
 * nums 中的所有值都 互不相同
 * nums 按升序排列
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SummaryRanges228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                count++;
            } else if (count != 0) {
                result.add(nums[i - count] + "->" + nums[i]);
                count = 0;
            } else {
                result.add("" + nums[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRanges228 summaryRanges228 = new SummaryRanges228();
        System.out.println(summaryRanges228.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges228.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges228.summaryRanges(new int[]{}));
        System.out.println(summaryRanges228.summaryRanges(new int[]{-1}));
        System.out.println(summaryRanges228.summaryRanges(new int[]{0}));

    }
}
