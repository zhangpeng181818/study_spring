package com.nuc.zp.leetcode.item1001_1100;

/**
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 */
public class Merge1001 {
    public void merge(int[] A, int m, int[] B, int n) {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            while (A[i] <= B[j] && i < m + j) i++;
            System.arraycopy(A, i, A, i + 1, A.length - i - 1);
            A[i] = B[j];
            j++;
        }
    }


    public static void main(String[] args) {
        Merge1001 merge1001 = new Merge1001();
        int[] A = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] B = {2, 5, 6};
        int n = 3;
        merge1001.merge(A, m, B, n);
        for (int num : A) {
            System.out.print(num + " ");
        }

//        int[] A = {4, 5, 6, 0, 0, 0};
//        int m = 3;
//        int[] B = {1, 2, 3};
//        int n = 3;
//        merge1001.merge(A, m, B, n);
//        for (int num : A) {
//            System.out.print(num + " ");
//        }
        System.out.println();

        int[] arr3A = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int[] arr3B = {1, 2, 2};
        merge1001.merge(arr3A, 6, arr3B, arr3B.length);
        for (int num : arr3A) {
            System.out.print(num + " ");
        }

    }
}
