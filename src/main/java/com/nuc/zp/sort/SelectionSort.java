package com.nuc.zp.sort;

/**
 * 选择排序
 * 时间复杂度：O(n^2)
 */
public class SelectionSort {

    public void sort(int[] arr) {
        int n = arr.length;
        while (n > 1) {
            int max = arr[0];
            int maxPos = 0;
            for (int i = 1; i < n; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxPos = i;
                }
            }
            if (maxPos < n - 1) {
                swap(arr, maxPos, n - 1);
            }
            n--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }


    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        selectionSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
