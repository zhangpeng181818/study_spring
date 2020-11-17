package com.nuc.zp.leetcode.item1501_1600;

import java.util.Stack;

public class MakeGood1544 {

    public String makeGood(String s) {
        StringBuffer ret = new StringBuffer();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Character.toLowerCase(ret.charAt(retIndex)) == Character.toLowerCase(ch)
                    && ret.charAt(retIndex) != ch) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();
    }


    public static void main(String[] args) {
        MakeGood1544 makeGood1544 = new MakeGood1544();
        System.out.println(makeGood1544.makeGood("leEeetcode"));
        System.out.println(makeGood1544.makeGood("abBAcC"));
        System.out.println(makeGood1544.makeGood("s"));
    }
}
