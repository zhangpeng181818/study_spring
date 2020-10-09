package com.nuc.zp.leetcode.item1_100;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * 通过次数411,594
 * <p>
 * (([]){})
 * true
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid20 {

    public boolean isValid(String s) {
        if (s == null || "".equals(s)) return true;
        if (s.length() % 2 != 0) return false;

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }


        return stack.isEmpty();
    }


    private boolean judge(char prev, char next) {
        return (prev == '(' && next == ')') || (prev == '[' && next == ']') || (prev == '{' && next == '}');
    }

    public static void main(String[] args) {
        IsValid20 isValid20 = new IsValid20();
        System.out.println(isValid20.isValid(""));
        System.out.println(isValid20.isValid("()"));
        System.out.println(isValid20.isValid("()[]{}"));
        System.out.println(isValid20.isValid("(]"));
        System.out.println(isValid20.isValid("([)]"));
        System.out.println(isValid20.isValid("{[]}"));
        System.out.println(isValid20.isValid("(([]){})"));
        System.out.println(isValid20.isValid("(){}}{"));
    }
}
