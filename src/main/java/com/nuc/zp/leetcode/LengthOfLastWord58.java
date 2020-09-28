package com.nuc.zp.leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，
 * 那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLastWord58 {
//    public int lengthOfLastWord(String s) {
//        if (s== null || s.trim().equals("")) return 0;
//        String[] split = s.split(" ");
//        return split[split.length-1].length();
//    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().equals("")) return 0;
        int i = s.trim().length() - 1,j=0;
        while (i >= 0) {
            if (Character.isSpaceChar(s.trim().charAt(i))) {
                break;
            }
            j++;
            i--;
        }

        return j;
    }

    public static void main(String[] args) {
        LengthOfLastWord58 lengthOfLastWord58 = new LengthOfLastWord58();
        System.out.println(lengthOfLastWord58.lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord58.lengthOfLastWord("a "));
        System.out.println(lengthOfLastWord58.lengthOfLastWord(" a"));


    }
}
