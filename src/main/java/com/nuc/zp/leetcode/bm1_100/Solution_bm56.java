package com.nuc.zp.leetcode.bm1_100;

import java.util.*;

public class Solution_bm56 {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(num.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        permute(num,res, new ArrayList<>(),map);
        res.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                Integer val1 = o1.get(i);
                Integer val2 = o2.get(i);
                if (val1.equals(val2)){
                    continue;
                }
                return val1.compareTo(val2);
            }
            return 0;
        });
        return res;
    }


    void permute(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> list,HashMap<Integer, Integer> map){

        if (list.size() == num.length && !res.contains(list)) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (map.get(i)==null) {
                list.add(num[i]);
                map.put(i,num[i]);
                permute(num, res, list,map);
                list.remove(list.size() - 1);
                map.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution_bm56 solution_bm56 = new Solution_bm56();
        System.out.println(solution_bm56.permuteUnique(new int[]{1, 2, 1}));
    }
}
