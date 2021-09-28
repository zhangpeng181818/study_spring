package com.nuc.zp.leetcode.item1701_1800;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 * <p>
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。
 * 例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 * <p>
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 * 示例 2：
 * <p>
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s[i] 是 '0' 或 '1'
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-changes-to-make-alternating-binary-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinOperations1758 {
    public int minOperations(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('0', '1');
        charMap.put('1', '0');
        char[] chars = s.toCharArray();
        return Math.min(count('0', chars, charMap), count('1', chars, charMap));
    }

    public int count(char charAt, char[] chars, Map<Character, Character> charMap) {
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != charAt) {
                charAt = chars[i];
            } else {
                count++;
                charAt = charMap.get(chars[i]);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        MinOperations1758 minOperations1758 = new MinOperations1758();
        System.out.println(minOperations1758.minOperations("0100"));
        System.out.println(minOperations1758.minOperations("1111"));
        System.out.println(minOperations1758.minOperations("10"));
        System.out.println(minOperations1758.minOperations("10010100"));

    }
}
