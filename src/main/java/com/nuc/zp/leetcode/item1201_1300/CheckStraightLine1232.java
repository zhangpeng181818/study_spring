package com.nuc.zp.leetcode.item1201_1300;

/**
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，
 * 其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 * <p>
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckStraightLine1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        int y = coordinates[1][1] - coordinates[0][1];
        int x = coordinates[1][0] - coordinates[0][0];
        for (int i = 1; i < coordinates.length - 1; i++) {
            if (!isStraightLine(coordinates[i], coordinates[i + 1], y, x)) return false;
        }
        return true;
    }

    public boolean isStraightLine(int[] t1, int[] t2, int y, int x) {
        int y1 = t2[1] - t1[1];
        int x1 = t2[0] - t1[0];

        if (x != 0 && x1 != 0 && (y*1.0 / x) != (y1*1.0 / x1)) {
            return false;
        }
        if ((x1 == 0 && x != 0) || (x1 != 0 && x == 0)) return false;
        return true;
    }


    public static void main(String[] args) {
        CheckStraightLine1232 checkStraightLine1232 = new CheckStraightLine1232();
        System.out.println(checkStraightLine1232.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
        System.out.println(checkStraightLine1232.checkStraightLine(new int[][]{{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
        System.out.println(checkStraightLine1232.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 5}}));
        System.out.println(checkStraightLine1232.checkStraightLine(new int[][]{{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}}))
        ;
    }


}
