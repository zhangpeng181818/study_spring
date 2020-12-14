package com.nuc.zp.leetcode.item901_1000;

import java.util.Arrays;

/**
 * 给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："ab-cd"
 * 输出："dc-ba"
 * 示例 2：
 * <p>
 * 输入："a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * 示例 3：
 * <p>
 * 输入："Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 *  
 * <p>
 * 提示：
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S 中不包含 \ or "
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-only-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseOnlyLetters917 {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!valid(chars[i])) {
                i++;
                continue;
            }
            if (!valid(chars[j])) {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public boolean valid(char c) {
        return Character.isLowerCase(c) || Character.isUpperCase(c);
    }

    public static void main(String[] args) {
        ReverseOnlyLetters917 reverseOnlyLetters917 = new ReverseOnlyLetters917();
        System.out.println(reverseOnlyLetters917.reverseOnlyLetters("ab-cd"));
        System.out.println(reverseOnlyLetters917.reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters917.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
