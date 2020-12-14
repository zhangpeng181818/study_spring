package com.nuc.zp.leetcode.item1_100;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * 示例 2：
 * <p>
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= k < s.length <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLeftWords58 {
    public String reverseLeftWords(String s, int n) {
        if (n >= s.length()) return s;
        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        return s2 + s1;
    }

    public static void main(String[] args) {
        ReverseLeftWords58 reverseLeftWords58 = new ReverseLeftWords58();
        System.out.println(reverseLeftWords58.reverseLeftWords("abcdefg", 2));
    }
}
