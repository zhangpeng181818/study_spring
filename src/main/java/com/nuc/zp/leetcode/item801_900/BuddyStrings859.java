package com.nuc.zp.leetcode.item801_900;

import java.util.Stack;

/**
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，
 * 就返回 true ；否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入： A = "ab", B = "ba"
 * 输出： true
 * 示例 2：
 * <p>
 * 输入： A = "ab", B = "ab"
 * 输出： false
 * 示例 3:
 * <p>
 * 输入： A = "aa", B = "aa"
 * 输出： true
 * 示例 4：
 * <p>
 * 输入： A = "aaaaaaabc", B = "aaaaaaacb"
 * 输出： true
 * 示例 5：
 * <p>
 * 输入： A = "", B = "aa"
 * 输出： false
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A 和 B 仅由小写字母构成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuddyStrings859 {

    public boolean buddyStrings(String A, String B) {
        if ("".equals(A) || "".equals(B) || A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c : count)
                if (c > 1) return true;
            return false;
        }
        Stack<String> aStack = new Stack<>();
        Stack<String> bStack = new Stack<>();

        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if (a != b) {
                if (aStack.size() > 2) {
                    return false;
                } else {
                    aStack.push(a + "");
                    bStack.push(b + "");
                }
            }

        }

        if (!(aStack.size() == 2) || !(bStack.size() == 2)) return false;

        return aStack.get(0).equals(bStack.get(1)) && aStack.get(1).equals(bStack.get(0));
    }

    public static void main(String[] args) {
        BuddyStrings859 buddyStrings859 = new BuddyStrings859();
        System.out.println(buddyStrings859.buddyStrings("ab", "ba"));
        System.out.println(buddyStrings859.buddyStrings("ab", "ab"));
        System.out.println(buddyStrings859.buddyStrings("aa", "aa"));
        System.out.println(buddyStrings859.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(buddyStrings859.buddyStrings("", "aa"));
        System.out.println(buddyStrings859.buddyStrings("", ""));
        System.out.println(buddyStrings859.buddyStrings("abab", "abab"));


    }

}
