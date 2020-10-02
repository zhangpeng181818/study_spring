package com.nuc.zp.leetcode;

import java.util.Arrays;

/**
 *  冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 现在，给出位于一条水平线上的房屋和供暖器的位置，找到可以覆盖所有房屋的最小加热半径。
 *
 * 所以，你的输入将会是房屋和供暖器的位置。你将输出供暖器的最小加热半径。
 *
 * 说明:
 *
 * 给出的房屋和供暖器的数目是非负数且不会超过 25000。
 * 给出的房屋和供暖器的位置均是非负数且不会超过10^9。
 * 只要房屋位于供暖器的半径内(包括在边缘上)，它就可以得到供暖。
 * 所有供暖器都遵循你的半径标准，加热的半径也一样。
 * 示例 1:
 *
 * 输入: [1,2,3],[2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 * 示例 2:
 *
 * 输入: [1,2,3,4],[1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/heaters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRadius475 {

    // 二分查找
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);

        int res = 0;

        for (int house : houses) {
            // 二分搜索当前 house 在 heaters 中的位置
            int index = binarySearch(heaters, house);

            if (index < 0) { // 说明没找到，index 等于当前的 house 应该在 heaters 的位置的负数
                // 计算出当前的 house 应该在 heaters 数组中的位置
                index = -(index + 1);
                // 计算当前 house 离左边最近的 heater 的距离
                int leftDist = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
                // 计算当前 house 离右边最近的 heater 的距离
                int rightDist = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;

                // 当前 house 需要的 heater 的半径取 leftDist 和 rightDist 的最小值
                res = Math.max(res, Math.min(leftDist, rightDist));
            }
        }

        return res;
    }

    private int binarySearch(int[] heaters, int house) {
        int low = 0;
        int hight = heaters.length - 1;
        while (low <= hight) {
            int mid = (low + hight) >>> 1;

            if (heaters[mid] < house) {
                low = mid + 1;
            } else if (heaters[mid] > house) {
                hight = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }
}
