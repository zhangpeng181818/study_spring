package com.nuc.zp.leetcode.item1_100;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class MinArray11 {
//    public int minArray(int[] numbers) {
//        Arrays.sort(numbers);
//       return numbers[0];
//    }

//    public int minArray(int[] numbers) {
//        int min = numbers[0];
//        for (int i = 1; i < numbers.length; i++) {
//            if (min > numbers[i]) {
//                min = numbers[i];
//                break;
//            }
//        }
//        return min;
//    }

    public int minArray(int[] numbers) {
        int min = numbers[0];
        int i = 0, j = numbers.length - 1;
        while (i <= j) {
            int med = ((j - i) >> 1) + i;
            if (numbers[i] < numbers[j] && min > numbers[i]) {
                min = numbers[i];
                break;
            }

            if (numbers[med] > min) {
                i = med + 1;
            } else if (numbers[med] < min) {
                j = med - 1;
                min = numbers[med];
            } else {
                i++;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        MinArray11 minArray11 = new MinArray11();
        System.out.println(minArray11.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(minArray11.minArray(new int[]{2, 2, 2, 0, 1}));
        System.out.println(minArray11.minArray(new int[]{10, 1, 10, 10, 10}));
        System.out.println(minArray11.minArray(new int[]{1, 2, 0, 0, 1}));
    }
}
