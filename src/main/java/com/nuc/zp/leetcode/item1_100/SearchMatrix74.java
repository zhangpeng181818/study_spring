package com.nuc.zp.leetcode.item1_100;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int search = search(0, matrix.length - 1, matrix, target);
        if (search == -1) return false;
        int i = 0, j = matrix[search].length - 1;
        while (i <= j) {
            int med = i + (j - i) / 2;
            if (matrix[search][med] > target) {
                j = med - 1;
            } else if (matrix[search][med] < target) {
                i = med + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public int search(int i, int j, int[][] matrix, int target) {
        int res = -1;
        while (i <= j) {
            int med = i + (j - i) / 2;
            if (matrix[med][0] == target) {
                res = med;
                break;
            } else if (matrix[med][0] < target) {
                i = med + 1;
                res = med;
            } else {
                j = med - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SearchMatrix74 searchMatrix74 = new SearchMatrix74();
//        System.out.println(searchMatrix74.searchMatrix(new int[][]{
//                {1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}
//        }, 20));

//        System.out.println(searchMatrix74.searchMatrix(new int[][]{{1}}, 1));
        System.out.println(searchMatrix74.searchMatrix(new int[][]{{1}, {3}, {5}}, 3));
    }
}
