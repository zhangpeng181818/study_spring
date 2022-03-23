package com.nuc.zp.leetcode.bm1_100;

import java.util.*;

/**
 * 描述
 * 给出一组数字，返回该组数字的所有排列
 * 例如：
 * [1,2,3]的所有排列如下
 * [1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], [3,2,1].
 * （以数字在数组中的位置靠前为优先级，按字典序排列输出。）
 *
 * 数据范围：数字个数 0 < n \le 60<n≤6
 * 要求：空间复杂度 O(n!)O(n!) ，时间复杂度 O(n!）O(n!）
 * 示例1
 * 输入：
 * [1,2,3]
 * 复制
 * 返回值：
 * [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 复制
 * 示例2
 * 输入：
 * [1]
 * 复制
 * 返回值：
 * [[1]]
 */
public class Solution_bm55 {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(num.length);
        permute(num,res,new ArrayList<Integer>());
        return res;
    }

    void permute(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list){

        if (list.size() == num.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int val : num) {
            if (!list.contains(val)) {
                list.add(val);
                permute(num, res, list);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        Solution_bm55 solution_bm55 = new Solution_bm55();
        System.out.println(solution_bm55.permute(new int[]{1, 2, 3}));
    }
}
