package com.nuc.zp.leetcode.bm1_100;

import java.util.*;

/**
 * 输入描述：
 * 输入一个字符串,长度不超过10,字符只包括大小写字母。
 * 示例1
 * 输入：
 * "ab"
 * 复制
 * 返回值：
 * ["ab","ba"]
 * 复制
 * 说明：
 * 返回["ba","ab"]也是正确的
 * 示例2
 * 输入：
 * "aab"
 * 复制
 * 返回值：
 * ["aab","aba","baa"]
 * 复制
 * 示例3
 * 输入：
 * "abc"
 * 复制
 * 返回值：
 * ["abc","acb","bac","bca","cab","cba"]
 * 复制
 * 示例4
 * 输入：
 * ""
 * 复制
 * 返回值：
 * []
 */
public class Solution_bm58 {

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length()==0) return res;
        String[] s = str.split("");
        StringBuilder builder = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        permutation(s,res,builder,map);
        return res;
    }

    void permutation( String[] s,ArrayList<String> res,StringBuilder builder,HashMap<Integer, String> map){
        if (builder.length()==s.length && !res.contains(builder.toString())){
            res.add(builder.toString());
            return;
        }
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(i)){
                builder.append(s[i]);
                map.put(i,s[i]);
                permutation(s, res, builder,map);
                builder.deleteCharAt(builder.length()-1);
                map.remove(i);
            }
        }
    }

    public static void main(String[] args) {
        Solution_bm58 solution_bm58 = new Solution_bm58();
        System.out.println(solution_bm58.Permutation("aa"));
    }
}
