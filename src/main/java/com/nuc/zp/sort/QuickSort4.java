package com.nuc.zp.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 *  [i]< num ,[i]和 <=区的下一个数交换，<=区向右扩,i++
 *  [i]> num,[i]和>区的前一个数交换，>区左扩，i不变
 *  [i]==num,i++
 *
 */
public class QuickSort4 {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
            int[] p = partation(arr, left, right);
            quickSort(arr, left, p[0] - 1); // < 区
            quickSort(arr, p[1] + 1, right); // > 区
        }
    }

    public static void swap(int[] arr, int left, int right) {
        if (left == right) return;
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];
    }

    private static int[] partation(int[] arr, int left, int right) {
        int less = left - 1;// <区右边界
        int more = right; // >区左边界
        while (left < more) { //left表示当前数的位置
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(10);
        }
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
