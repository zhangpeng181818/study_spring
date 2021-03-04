package com.nuc.zp.leetcode.item801_900;

import java.util.Arrays;

/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * <p>
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * <p>
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 * 然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 * <p>
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 * 然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlipAndInvertImage832 {

    int[] nums = {1, 0};

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int length = (image[i].length - 1) / 2;
            for (int j = 0; j <= length; j++) {
                if (image[i][j] == image[i][image[i].length - j - 1]) {
                    image[i][j] = nums[image[i][j]];
                    if (j != image[i].length - 1 - j) {
                        image[i][image[i].length - j - 1] = nums[image[i][image[i].length - j - 1]];

                    }
                }
            }
        }
            return image;
        }

        public static void main (String[]args){
            FlipAndInvertImage832 flipAndInvertImage832 = new FlipAndInvertImage832();
            flipAndInvertImage832.print(flipAndInvertImage832.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));
            flipAndInvertImage832.print(flipAndInvertImage832.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}));
        }

        public void print ( int[][] image){
            for (int i = 0; i < image.length; i++) {
                for (int j = 0; j < image[i].length; j++) {
                    System.out.print(image[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
