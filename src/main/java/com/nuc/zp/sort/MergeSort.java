package com.nuc.zp.sort;

import java.util.Arrays;

public class MergeSort {


    public void mergeSort(int[] arr, int l, int r) {
        if (l != r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m+1, r);
        }

    }

    public void merge(int[] arr, int l, int m, int r) {
        int[] left = new int[m - l];
        int[] right = new int[r - m + 1];

        for (int i = l; i < m; i++) {
            left[i - l] = arr[i];
        }

        for (int i = m; i <= r; i++) {
            right[i - m] = arr[i];
        }

        int i = 0, j = 0, k = l;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            arr[k] = left[i];
            k++;
            i++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            k++;
            j++;
        }
    }

    private void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7, 8, 1, 10, 1, 2, 10, 4, 5, 6};
        int[] arr2 = new int[]{97, 110, 97, 103, 114, 97, 109, 1};
        MergeSort mergeSort = new MergeSort();
//        mergeSort.merge(arr, 0, 4, arr.length - 1);
        mergeSort.mergeSort(arr2, 0, arr2.length - 1);
        mergeSort.print(arr2);
    }
}
