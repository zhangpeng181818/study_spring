package com.nuc.zp.leetcode.item301_400;


/**
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 *  
 * <p>
 * 提示：
 * <p>
 * 元音字母不包含字母 "y" 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowels345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < chars.length && !isVowel(chars[i]) && i <= j) i++;
            while (j < chars.length && !isVowel(chars[j]) && i <= j) j--;
            if (i >= chars.length || j >= chars.length) break;
            if (i > j) break;
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return new String(chars);
    }

    public boolean isVowel(char c) {
        return ('a' == c) || ('e' == c) || ('i' == c) || ('o' == c) || ('u' == c)
                || ('A' == c) || ('E' == c) || ('I' == c) || ('O' == c) || ('U' == c);
    }

    public static void main(String[] args) {
        ReverseVowels345 reverseVowels345 = new ReverseVowels345();
        System.out.println(reverseVowels345.reverseVowels("hello"));
        System.out.println(reverseVowels345.reverseVowels("leetcode"));
        System.out.println(reverseVowels345.reverseVowels("aA"));
        System.out.println(reverseVowels345.reverseVowels(".,"));

    }
}
