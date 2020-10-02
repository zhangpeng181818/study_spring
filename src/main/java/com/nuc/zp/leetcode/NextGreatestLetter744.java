package com.nuc.zp.leetcode;

/**
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。
 * 另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 *  
 * <p>
 * 示例：
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * <p>
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 *  
 * <p>
 * 提示：
 * <p>
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreatestLetter744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int i = 0, j = letters.length - 1;
        int index = 0;
        while (i <= j) {
            int med = ((j - i) >> 1) + i;
            if (letters[med] <= target) {
                i = med + 1;
                index = med + 1;
            } else if (letters[med] > target) {
                j = med - 1;
                index = med;
            }
        }
        return index >= letters.length ? letters[0] : letters[index];
    }

    public static void main(String[] args) {
        NextGreatestLetter744 nextGreatestLetter744 = new NextGreatestLetter744();
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));//c
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));//f
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));//f
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));//j
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));//c
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));//c
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));//c
        System.out.println(nextGreatestLetter744.nextGreatestLetter(new char[]{'e','e','e','e','e','e','n','n','n','n'}, 'e'));//c


    }
}
