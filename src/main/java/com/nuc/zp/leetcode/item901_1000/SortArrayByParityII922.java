package com.nuc.zp.leetcode.item901_1000;

import java.util.Stack;

/**
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * <p>
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * <p>
 * 你可以返回任何满足上述条件的数组作为答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class SortArrayByParityII922 {
    public int[] sortArrayByParityII(int[] A) {
        Stack<Integer> oddStack = new Stack<>();
        Stack<Integer> evenStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                if (i % 2 != 0) {
                    evenStack.push(i);
                }
            } else {
                if (i % 2 == 0) {
                    oddStack.push(i);
                }
            }
        }

        while (!oddStack.isEmpty() && !evenStack.isEmpty()) {
            Integer i = oddStack.pop();
            Integer j = evenStack.pop();

            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        return A;
    }
}
