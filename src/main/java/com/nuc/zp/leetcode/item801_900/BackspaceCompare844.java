package com.nuc.zp.leetcode.item801_900;

import java.util.Stack;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackspaceCompare844 {

    public boolean backspaceCompare(String S, String T) {
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        String[] sSplit = S.split("");
        String[] tSplit = T.split("");
        for (String str : sSplit) {
            if (!stack.isEmpty() && "#".equals(str)) {
                stack.pop();
            } else if (!"#".equals(str)) {
                stack.push(str);
            }
        }
        for (String str : tSplit) {
            if (!stack2.isEmpty() && "#".equals(str)) {
                stack2.pop();
            } else if (!"#".equals(str)) {
                stack2.push(str);
            }
        }
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        while (!stack.isEmpty()) s.append(stack.pop());
        while (!stack2.isEmpty()) t.append(stack2.pop());
        return s.toString().equals(t.toString());
    }

    public static void main(String[] args) {
        BackspaceCompare844 backspaceCompare844 = new BackspaceCompare844();
        System.out.println(backspaceCompare844.backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare844.backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare844.backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare844.backspaceCompare("a#c", "b"));
    }
}
