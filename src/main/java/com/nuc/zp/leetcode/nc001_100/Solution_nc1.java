package com.nuc.zp.leetcode.nc001_100;

public class Solution_nc1 {
    public String solve (String s, String t) {
        // write code here
        int i = s.length()-1;
        int j = t.length()-1;
        StringBuilder buffer = new StringBuilder();
        int shifenwei =0,gewei=0;
        while(i>=0 || j>=0){
            int a = i<0? 0: (int)(s.charAt(i)-'0');
            int b = j<0? 0: (int)(t.charAt(j)-'0');
            gewei = (a + b + shifenwei)%10;
            shifenwei = (a + b + shifenwei)/10;
            buffer.append((char)(gewei+'0'));
            i--;
            j--;
        }
        if(shifenwei != 0){
            buffer.append((char)(shifenwei+'0'));
        }
        return buffer.reverse().toString();

    }

    public static void main(String[] args) {
        Solution_nc1 solution_nc1 = new Solution_nc1();
        System.out.println(solution_nc1.solve("1","99"));
    }
}
