package com.nuc.zp.list;

import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class Test {

    public static void main(String[] args) {
//        String reg = reg("mdzl30 -");
//        System.out.println(reg);

        System.out.println(0.005 + 0.001);
        System.out.println(add(0.005, 0.001));

        double d = 3.1415926d;
        String str2 = String.format("%.3f", d);
        double e = Double.valueOf(str2);
        System.out.println(keep2decimal(d, 3));

    }

    /**
     * 小数点保留两位
     */
    public static double keep2decimal(double d, int digit) {
        if (d > 0) {
            d = new BigDecimal(d).setScale(digit, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return d;
    }

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    public static String reg(String source) {
        if (StringUtils.isEmpty(source)) {
            return "";
        }
        if (source.length() > 8) {
            source = source.substring(0, 8);
        }
        source = source.replaceAll("-[0-9]*$", "");
        return source.trim();
    }
}
