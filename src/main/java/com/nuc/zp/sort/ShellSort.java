package com.nuc.zp.sort;

/**
 * 希尔排序(插入排序的改进)
 */
public class ShellSort {

    public void sort(int[] arr) {
        int h = 1;
        while (h < arr.length >> 1) {
            h = h * 2 + 1;
        }
        while (h >= 1) {
            for (int i = h; i < arr.length; i++) {

                for (int j = i; j >= h; j = j - h) {
                    if (arr[j] < arr[j - h]) {
                        swap(arr, j, j - h);
                    }
                }
            }
            h >>= 1;
        }
    }


    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }


    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int[] arr = new int[]{3, 4, 1, 2, 1, 8, 6, 5};
        shellSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
