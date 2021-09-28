package com.nuc.zp.sort;

/**
 * 冒泡排序
 * 时间复杂度：O(n^2)
 */
public class BundleSort {

    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
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
        BundleSort bundleSort = new BundleSort();
        int[] arr = new int[]{5, 4, 3, 2, 1};
        bundleSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
