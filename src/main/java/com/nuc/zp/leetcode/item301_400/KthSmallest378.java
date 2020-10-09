package com.nuc.zp.leetcode.item301_400;

/**
 * 378. 有序矩阵中第K小的元素
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * 返回 13。
 * <p>
 * <p>
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 */
public class KthSmallest378 {

    public int kthSmallest(int[][] matrix, int k) {
        return 0;
            }

    public static void main(String[] args) {
        KthSmallest378 kthSmallest378 = new KthSmallest378();
        System.out.println(kthSmallest378.kthSmallest(new int[][]{
                {1,  5,  8,  9},
                {10, 11, 12, 13},
                {11, 12, 13, 15},
                {12, 13, 15, 17}
        }, 5));
    }
}
