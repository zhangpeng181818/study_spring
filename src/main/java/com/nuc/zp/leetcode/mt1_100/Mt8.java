package com.nuc.zp.leetcode.mt1_100;

import java.util.ArrayList;

public class Mt8 {

    public static void main(String[] args) {
        Mt8 mt8 = new Mt8();
        System.out.println(mt8.res(500));
    }

    public int res(int n){
        int[] res = new int[n+1];
        for (int i = 0; i < res.length; i++) {
            res[i] = i;
        }
        return filter(res)[0];
    }

    public int[] filter(int[] res){
        if (res.length ==1){
            return res;
        }
        ArrayList<Integer> objects = new ArrayList<>();
        for (int i = 0; i < res.length; i++) {
            if (i%2==1){
                objects.add(res[i] );
            }
        }
        int[] resp = objects.stream().mapToInt(Integer::intValue).toArray();
        return filter(resp);
    }
}
