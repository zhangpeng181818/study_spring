package com.nuc.zp.leetcode.item401_500;

/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，
 * 但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。
 * 计算这个岛屿的周长。
 * <p>
 *  
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IslandPerimeter463 {
    // 下个格子的x轴与y轴加的值，右下左上
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int islandPerimeter(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (grid[i][j] == 1) {
                    int cnt = 0;
                    for (int k = 0; k < 4; ++k) {
                        int tx = i + dx[k];
                        int ty = j + dy[k];
                        // tx < 0，已是左边界；tx >= n，已是右边界
                        // ty < 0，已是上边界；ty >= m，已是下边界
                        // grid[tx][ty] == 0，相邻格子是水域
                        if (tx < 0 || tx >= n || ty < 0 || ty >= m || grid[tx][ty] == 0) {
                            cnt += 1;
                        }
                    }
                    ans += cnt;
                }
            }
        }
        return ans;
    }

}
/**
 * const islandPerimeter = (grid) => {
 *   let land = 0; // 土地个数
 *   let border = 0; // 接壤边界的条数
 *
 *   for (let i = 0; i < grid.length; i++) {
 *     for (let j = 0; j < grid[0].length; j++) {
 *       if (grid[i][j] == 1) {
 *         land++;
 *         if (i < grid.length - 1 && grid[i + 1][j] == 1) {
 *           border++;
 *         }
 *         if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
 *           border++;
 *         }
 *       }
 *     }
 *   }
 *   return 4 * land - 2 * border;
 * };
 *
 * 作者：xiao_ben_zhu
 * 链接：https://leetcode-cn.com/problems/island-perimeter/solution/shou-hua-tu-jie-463-dao-yu-de-zhou-chang-by-xiao_b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

/**
 * const islandPerimeter = (grid) => {
 *   const dfs = (i, j) => {
 *     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
 *       return 1; // 当前正好越界，说明穿过了一个边界，周长+1
 *     }
 *     if (grid[i][j] == 0) { // 从土地来到了海水，说明穿过了一个边界，周长+1
 *       return 1;
 *     }
 *     if (grid[i][j] == 2) { // 之前访问过，直接返回，返回0，无周长收益
 *       return 0;
 *     }
 *     // 到此，当前点为1，将它改为2，代表已访问
 *     grid[i][j] = 2;
 *     // 继续往四个方向“扩散”，目标是遇到边界和海水，答案随着递归出栈向上返回，得出大的答案
 *     return dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1);
 *   };
 *
 *   for (let i = 0; i < grid.length; i++) {
 *     for (let j = 0; j < grid[0].length; j++) {
 *       if (grid[i][j] == 1) {
 *         return dfs(i, j);   // dfs的入口
 *       }
 *     }
 *   }
 *   return 0;
 * };
 *
 * 作者：xiao_ben_zhu
 * 链接：https://leetcode-cn.com/problems/island-perimeter/solution/shou-hua-tu-jie-463-dao-yu-de-zhou-chang-by-xiao_b/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 */