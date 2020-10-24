package com.nuc.zp.leetcode.item1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * intervals[i][0] <= intervals[i][1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
        //sort to get ordered array
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2)
            {   return o1[0] - o2[0];}
        });

        List<int[]> path = new ArrayList<>();
        int left = 0, right = 0;

        while(right < intervals.length)
        {
            int leftBound = intervals[left][0];
            int rightBound = intervals[right][1];

            while(right < intervals.length && intervals[right][0] <= rightBound)
            {
                rightBound = Math.max(intervals[right][1], rightBound);
                right++;
            }

            path.add(new int[]{leftBound, rightBound});
            left = right;
        }

        //copy the result to the array from List
        int[][] res = new int[path.size()][2];
        for(int i = 0; i < path.size(); i++)
        {
            res[i][0] = path.get(i)[0];
            res[i][1] = path.get(i)[1];
        }

        return res;
    }

}
