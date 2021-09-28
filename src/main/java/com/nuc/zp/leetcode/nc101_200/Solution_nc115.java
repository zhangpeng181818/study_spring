package com.nuc.zp.leetcode.nc101_200;

import java.util.Arrays;
import java.util.Stack;

public class Solution_nc115 {

    /**
     * 栈排序
     *
     * @param a int整型一维数组 描述入栈顺序
     * @return int整型一维数组
     */
    public int[] solve(int[] a) {
        // write code here
        int[] nums = new int[a.length];
        int j = 0;
        int n = a.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < a.length; ) {
            while (stack.contains(n)&&stack.peek()!=n){
                n--;
            }
            if (stack.empty()) {
                stack.push(a[i++]);
            } else if (a[i] == n) {
                n--;
                nums[j++] = a[i++];
            } else if (!stack.isEmpty() && stack.peek() == n) {
                n = stack.pop() - 1;
                nums[j++] = n + 1;
            } else if (!stack.isEmpty() && stack.peek() <= a[i]) {
                stack.push(a[i++]);
            } else {
                stack.push(a[i++]);
            }
        }
        while (!stack.isEmpty()) {
            int b = (int) stack.pop();
            nums[j++] = b;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution_nc115 solution_nc115 = new Solution_nc115();
//        int[] solve = solution_nc115.solve(new int[]{14,11,19,38,29,9,23,33,15,5,18,28,34,31,20,32,36,21,27,13,35,7,16,8,1,6,39,24,37,12,4,25,22,30,3,17,2,26,10});
//        System.out.println(Arrays.toString(solve));
        int[] solve = solution_nc115.solve(new int[]{5,8,9,6,7,1,3,2,4});
        System.out.println(Arrays.toString(solve));

    }
}
