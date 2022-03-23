package com.nuc.zp.leetcode.bm1_100;

import java.util.*;

/**
 * 描述
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())"
 *
 * 数据范围：0 \le n \le 100≤n≤10
 * 要求：空间复杂度 O(n!)O(n!)，时间复杂度 O(n!)O(n!)
 * 示例1
 * 输入：
 * 1
 * 复制
 * 返回值：
 * ["()"]
 * 复制
 * 示例2
 * 输入：
 * 2
 * 复制
 * 返回值：
 * ["(())","()()"]
 */
public class Solution_bm60 {

    /**
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
//    public ArrayList<String> generateParenthesis (int n) {
//        // write code here
//        ArrayList<String> res = new ArrayList<>();
//        if (n == 0) return res;
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < n; i++) {
//            builder.append("()");
//        }
//        String[] s = builder.toString().split("");
//        HashMap<Integer, String> map = new HashMap<>();
//        permutation(s,res,new StringBuilder(),map);
//        return res;
//    }
//
//    void permutation( String[] s,ArrayList<String> res,StringBuilder builder,HashMap<Integer, String> map){
//        if (builder.length()==s.length && !res.contains(builder.toString()) && check(builder.toString())){
//            res.add(builder.toString());
//            return;
//        }
//        for (int i = 0; i < s.length; i++) {
//            if (!map.containsKey(i)){
//                builder.append(s[i]);
//                map.put(i,s[i]);
////                if (builder.toString().length()%2==1||check(builder.toString())){
//                    permutation(s, res, builder,map);
////                }
//                builder.deleteCharAt(builder.length()-1);
//                map.remove(i);
//            }
//        }
//    }
//
//    public boolean check(String s){
//
//        if (s.startsWith(")")||s.endsWith("(") ) return false;
//
//        String[] split = s.split("");
//        Stack<String> stack = new Stack<>();
//        for (String str:split){
//            if (!stack.isEmpty()&&str.equals(")")&&stack.peek().equals("(")){
//                stack.pop();
//            }else {
//                stack.push(str);
//            }
//        }
//        return stack.isEmpty();
//    }

    /**
     * 回溯法
     * - 思路:
     * 1. 如果左括号数量不大于 n，我们可以放一个左括号。
     * 2. 如果右括号数量小于左括号的数量，我们可以放一个右括号.
     */
    ArrayList<String> ans;
    StringBuilder sb;

    public ArrayList<String> generateParenthesis(int n) {
        // write code here
        ans = new ArrayList<>();
        sb = new StringBuilder();
        dfs(0, 0, n);
        return ans;
    }

    private void dfs(int open, int close, int n) {
        if (close == n) {
            ans.add(sb.toString());
        }
        if (open < n) {
            sb.append('(');
            dfs(open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(')');
            dfs(open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        Solution_bm60 solution_bm60 = new Solution_bm60();
        long l = System.currentTimeMillis();
        System.out.println(solution_bm60.generateParenthesis(5));
        System.out.println(System.currentTimeMillis()-l);
    }
}
