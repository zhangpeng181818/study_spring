package com.nuc.zp.leetcode.mt1_100;


import java.util.*;
import java.util.regex.Pattern;

public class Mt28 {

    static HashMap<String, List<String>> phoneMap = new HashMap<>();

    static {
        phoneMap.put("China Telecom", Arrays.asList("133", "153", "180", "181", "189"));
        phoneMap.put("China Unicom", Arrays.asList("130", "131", "155", "185", "186"));
        phoneMap.put("China Mobile Communications", Arrays.asList("135", "136", "150", "182", "188"));
    }



    public static String isTelPhone(String number) {
        String phone = "-1";

        if (number.length() != 11) {
            return phone;
        }
        final String numberRegexp = "^([0-9]+)$";
        Pattern pattern = Pattern.compile(numberRegexp);
        if (!pattern.matcher(number.trim()).find()) {
            return phone;
        }
        boolean flag = false;
        String substring = number.substring(0, 3);
        for (Map.Entry<String, List<String>> entry : phoneMap.entrySet()) {
            if (entry.getValue().contains(substring)) {
                flag = true;
                phone = entry.getKey();
                break;
            }
        }
        if (!flag) {
            return phone;
        }

        return phone;
    }


}
