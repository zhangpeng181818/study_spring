package com.nuc.zp.leetcode.item101_200;

/**
 * 定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome125 {

    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) return true;
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c = s.charAt(i);
            char c1 = s.charAt(j);
            if (!valid(c)) {
                i++;
                continue;
            }
            if (!valid(c1)) {
                j--;
                continue;
            }
            if (c != c1) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean valid(char c) {
        if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
            return true;
        }
        return Character.isDigit(c);
    }


    public static void main(String[] args) {
        IsPalindrome125 isPalindrome125 = new IsPalindrome125();
        System.out.println(isPalindrome125.isPalindrome("race a car"));
        System.out.println(isPalindrome125.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome125.isPalindrome(""));
        System.out.println(isPalindrome125.isPalindrome("A"));
        System.out.println(isPalindrome125.isPalindrome("0P"));
    }
}
