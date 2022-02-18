package com.nuc.zp.test;

public class Test2 {

    public static void main(String[] args) {
        int[] nums = {5, 7, 5, 7, 3, 4};
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }
        int rightOne = eor & (~eor + 1);
        int eor_ = 0;
        for (int num : nums) {
            if ((num & rightOne) == 1) {
                eor_ ^= num;
            }
        }
        System.out.println(eor_ + "-----" + (eor ^ eor_));

    }
}
