package com.nuc.zp.leetcode.item601_700;

import java.util.*;

/**
 * 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * 示例 2：
 * <p>
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 *  
 * <p>
 * 提示：
 * <p>
 * nums.length 在1到 50,000 区间范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/degree-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindShortestSubArray697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }
        int max = Integer.MIN_VALUE;
        int length = 0;
        int val = -1;

        for (Integer key : map.keySet()) {
            List<Integer> list = map.get(key);
            list.sort(Integer::compareTo);
            int len = list.get(list.size() - 1) - list.get(0) + 1;
            if (list.size() > max) {
                max = list.size();
                length = len;
                val = key;
            } else if (list.size() == max && (key < val || len < length)) {
                length = len;
                val = key;
            }
        }
        return length;
    }


    public static void main(String[] args) {
        FindShortestSubArray697 findShortestSubArray697 = new FindShortestSubArray697();
        System.out.println(findShortestSubArray697.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray697.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(findShortestSubArray697.findShortestSubArray(new int[]{1, 3, 2, 2, 3, 1}));
    }
}
