package com.nuc.zp.leetcode.item1501_1600;

public class ModifyString1576 {

    public String modifyString(String s) {
        if (s.length() == 1 && "?".equals(s)) return "a";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ("?".equals(s.substring(i, i + 1))) {
                if (i == 0) {
                    stringBuilder.append(get(s.substring(i, i + 1), s.substring(i + 1, i + 2)));
                } else if (i == s.length() - 1) {
                    stringBuilder.append(get(stringBuilder.substring(i - 1, i), "0"));
                } else {
                    stringBuilder.append(get(stringBuilder.substring(i - 1, i), s.substring(i + 1, i + 2)));
                }
            } else {
                stringBuilder.append(s.substring(i, i + 1));
            }
        }
        return stringBuilder.toString();
    }

    public String get(String before, String after) {

        for (int i = 0; i < 23; i++) {
            int i1 = 'a' + i;
            if (before.charAt(0) == i1 || after.charAt(0) == i1) {
                continue;
            }
            return Character.toString((char) i1);
        }
        return "";
    }

    public static void main(String[] args) {
        ModifyString1576 modifyString1576 = new ModifyString1576();
//        System.out.println(modifyString1576.get("a", "b"));
        System.out.println(modifyString1576.modifyString("??"));
        System.out.println(modifyString1576.modifyString("?zs"));
        System.out.println(modifyString1576.modifyString("ubv?w"));
        System.out.println(modifyString1576.modifyString("j?qg??b"));
        System.out.println(modifyString1576.modifyString("?a?ub???w?b"));
    }
}
