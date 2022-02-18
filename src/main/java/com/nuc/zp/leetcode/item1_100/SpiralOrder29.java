package com.nuc.zp.leetcode.item1_100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder29 {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[]{};
        int flag = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (matrix[i][j] != Integer.MIN_VALUE) {
            list.add(matrix[i][j]);
            matrix[i][j] = flag;
            if ((i == 0 || matrix[i - 1][j] == flag) && j + 1 < matrix[i].length && matrix[i][j + 1] != flag) {
                j++;
            } else if (i + 1 < matrix.length && matrix[i + 1][j] != flag) {
                i++;
            } else if (j - 1 >= 0 && matrix[i][j - 1] != flag) {
                j--;
            } else if (i - 1 >= 0 && matrix[i - 1][j] != flag) {
                i--;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        SpiralOrder29 spiralOrder29 = new SpiralOrder29();
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(Arrays.toString(spiralOrder29.spiralOrder(matrix)));
//
//        int[][] matrix2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        System.out.println(Arrays.toString(spiralOrder29.spiralOrder(matrix2)));

        int[][] matrix3 = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        System.out.println(Arrays.toString(spiralOrder29.spiralOrder(matrix3)));

    }
}
