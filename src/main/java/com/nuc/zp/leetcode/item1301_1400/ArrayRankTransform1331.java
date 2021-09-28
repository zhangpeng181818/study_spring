package com.nuc.zp.leetcode.item1301_1400;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * 示例 2：
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * 示例 3：
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rank-transform-of-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayRankTransform1331 {

    public int[] arrayRankTransform(int[] arr) {
        int[] bakArr = new int[arr.length];
        System.arraycopy(arr, 0, bakArr, 0, arr.length);
        Arrays.sort(bakArr);
        int index = 0;
        int val = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < bakArr.length; i++) {
            if (val == bakArr[i]) continue;
            val = bakArr[i];
            index++;
            map.put(bakArr[i], index);
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayRankTransform1331 arrayRankTransform1331 = new ArrayRankTransform1331();
        System.out.println(Arrays.toString(arrayRankTransform1331.arrayRankTransform(new int[]{40, 10, 20, 30})));
        System.out.println(Arrays.toString(arrayRankTransform1331.arrayRankTransform(new int[]{100, 100, 100})));
        System.out.println(Arrays.toString(arrayRankTransform1331.arrayRankTransform(new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12})));
    }
}
