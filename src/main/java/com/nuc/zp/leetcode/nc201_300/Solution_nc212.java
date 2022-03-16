package com.nuc.zp.leetcode.nc201_300;

import java.util.Arrays;

/**
 * 描述
 * 给定一个包含红色，白色，蓝色，一同 n 个元素的数组，对其进行排序使得相同的颜色相邻并且按照 红色，白色，蓝色的顺序排序。
 * <p>
 * 数组中 0 代表红色，1 代表白色，2 代表蓝色。
 * <p>
 * 数据范围： 1 \le n \le 100 \1≤n≤100  ， 数组中只包含 0 1 2。
 * 示例1
 * 输入：
 * [0,2,1]
 * 复制
 * 返回值：
 * [0,1,2]
 * 复制
 * 示例2
 * 输入：
 * [0,0,2,0]
 * 复制
 * 返回值：
 * [0,0,0,2]
 */
public class Solution_nc212 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param colors int整型一维数组
     * @return int整型一维数组
     */
    public int[] sortColor(int[] colors) {
        // write code here
        if (colors == null || colors.length < 2) return colors;
        change(colors,1);
        quickSort(colors, 0, colors.length - 1);
        return colors;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left<right) {
            int[] partation = partation(arr, left, right);
            quickSort(arr, left, partation[0] - 1);
            quickSort(arr, partation[1] + 1, right);
        }
    }

    public int[] partation(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] > arr[right]) {
               swap(arr,left,--more);
            } else if (arr[left] < arr[right]) {
              swap(arr, ++less, left++);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less+1,more};
    }

    private void change(int[] arr, int val) {
        int right = arr.length - 1;
        for (int i = right; i >= 0; i--) {
            if (arr[i] == val) {
                swap(arr, i, right);
                break;
            }
        }
        System.out.println(Arrays.toString(arr));

    }


    private void swap(int[] arr, int left, int right) {
        if (left != right) {
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
        }
    }

    public static void main(String[] args) {
        Solution_nc212 solution_nc212 = new Solution_nc212();
       int[] arr = new int[]{2,1,0};
        solution_nc212.sortColor(arr);
        System.out.println(Arrays.toString(arr));
    }
}
