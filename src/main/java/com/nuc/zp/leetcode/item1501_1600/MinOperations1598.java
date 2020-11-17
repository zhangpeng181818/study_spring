package com.nuc.zp.leetcode.item1501_1600;

public class MinOperations1598 {

    public int minOperations(String[] logs) {
        int i = 0;
        for (String log : logs) {
            if ("../".equals(log)) {
                i = Math.max(--i, 0);
            } else if ("./".equals(log)) {
                i += 0;
            } else {
                i++;
            }
        }
        return Math.max(i, 0);
    }

    public static void main(String[] args) {
        MinOperations1598 minOperations1598 = new MinOperations1598();
        System.out.println(minOperations1598.minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"}));
        System.out.println(minOperations1598.minOperations(new String[]{"d1/", "d2/", "./", "d3/", "../", "d31/"}));
        System.out.println(minOperations1598.minOperations(new String[]{"d1/", "../", "../", "../"}));
        System.out.println(minOperations1598.minOperations(new String[]{"./", "wz4/", "../", "mj2/", "../", "../", "ik0/", "il7/"}));
    }
}
