package com.nuc.zp.leetcode.item1401_1500;

public class Average1491 {

    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for (int num : salary) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            sum += num;
        }
        return (sum - max - min) / (salary.length - 2);
    }


}
