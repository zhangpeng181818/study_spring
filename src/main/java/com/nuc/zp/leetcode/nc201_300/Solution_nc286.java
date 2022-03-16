package com.nuc.zp.leetcode.nc201_300;

/**
 * 描述
 * 输入一个长度为 n 整数数组，数组里面可能含有相同的元素，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，对奇数和奇数，偶数和偶数之间的相对位置不做要求，但是时间复杂度和空间复杂度必须如下要求。
 * <p>
 * 数据范围：0 \le n \le 500000≤n≤50000，数组中每个数的值 0 \le val \le 100000≤val≤10000
 * 要求：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)
 * 示例1
 * 输入：
 * [1,2,3,4]
 * 复制
 * 返回值：
 * [1,3,2,4]
 * 复制
 * 说明：
 * [3,1,2,4]或者[3,1,4,2]也是正确答案
 * 示例2
 * 输入：
 * [1,3,5,6,7]
 * 复制
 * 返回值：
 * [1,3,5,7,6]
 * 复制
 * 说明：
 * [3,1,5,7,6]等也是正确答案
 * 示例3
 * 输入：
 * [1,4,4,3]
 * 复制
 * 返回值：
 * [1,3,4,4]
 */
public class Solution_nc286 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArrayTwo(int[] array) {
        // write code here
        int i = 0, j = array.length - 1;
        while (i < j) {
            while (i < j && !isOdd(array[i])) {
                i++;
            }
            while (i < j && isOdd(array[j])) {
                j--;
            }
            if (i < j) {
                swap(array, i, j);
            }
        }
        return array;
    }

    private boolean isOdd(int num) {
        return num % 2 == 0;
    }

    private void swap(int[] arr, int left, int right) {
        if (left != right) {
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
        }
    }
}
