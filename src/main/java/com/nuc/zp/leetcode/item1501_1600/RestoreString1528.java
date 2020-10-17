package com.nuc.zp.leetcode.item1501_1600;

public class RestoreString1528 {

    public String restoreString(String s, int[] indices) {
        int[] index = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            index[indices[i]] = i;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            stringBuilder.append(s.substring(index[i], index[i] + 1));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RestoreString1528 restoreString1528 = new RestoreString1528();
        System.out.println(restoreString1528.restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
    }
}
