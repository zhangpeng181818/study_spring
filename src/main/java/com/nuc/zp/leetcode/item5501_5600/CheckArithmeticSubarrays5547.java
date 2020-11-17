package com.nuc.zp.leetcode.item5501_5600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckArithmeticSubarrays5547 {

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> booleanList = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            booleanList.add(judge(l[i], r[i], nums));
        }
        return booleanList;
    }

    public boolean judge(int i, int j, int[] nums) {
        if (j - i < 2) return true;
        int[] temp = new int[j - i+1];

        System.arraycopy(nums, i, temp, 0, temp.length);
        Arrays.sort(temp);
        int val = temp[1] - temp[0];
        for (int k = 1; k < temp.length; k++) {
            if (val != temp[k] - temp[k - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckArithmeticSubarrays5547 checkArithmeticSubarrays5547 = new CheckArithmeticSubarrays5547();
        System.out.println(checkArithmeticSubarrays5547.checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }
}
