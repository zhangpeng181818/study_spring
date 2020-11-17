package com.nuc.zp.leetcode.item1001_1100;

public class RemoveDuplicates1047 {
    public String removeDuplicates(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int retIndex = -1;
        for (int i = 0; i < S.length(); i++) {
            if (stringBuilder.length() > 0 && S.charAt(i) == stringBuilder.charAt(retIndex)) {
                stringBuilder.deleteCharAt(retIndex);
                retIndex--;
            } else {
                stringBuilder.append(S.charAt(i));
                retIndex++;

            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates1047 removeDuplicates1047 = new RemoveDuplicates1047();
        System.out.println(removeDuplicates1047.removeDuplicates("abbaca"));
    }
}
