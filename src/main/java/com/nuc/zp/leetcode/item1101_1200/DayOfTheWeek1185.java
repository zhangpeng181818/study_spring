package com.nuc.zp.leetcode.item1101_1200;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 *  
 * <p>
 * 提示：
 * <p>
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DayOfTheWeek1185 {

//    public String dayOfTheWeek(int day, int month, int year) {
//        return LocalDate.of(year, month, day).getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CANADA);
//    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] weekStr = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int sum = 4;
        if (year > 1971)
            for (int i = 1971; i < year; i++) {
                sum += 365;
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) sum++;
            }
        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) sum += months[i];
        if (month >= 3 && (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)) sum++;
        sum += day;
        return weekStr[sum % 7];
    }


    public static void main(String[] args) {
        DayOfTheWeek1185 dayOfTheWeek1185 = new DayOfTheWeek1185();
        System.out.println(dayOfTheWeek1185.dayOfTheWeek(31, 8, 2019));
        System.out.println(dayOfTheWeek1185.dayOfTheWeek(18, 7, 1999));
        System.out.println(dayOfTheWeek1185.dayOfTheWeek(15, 8, 1993));
    }
}
