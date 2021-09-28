package com.nuc.zp.sort;

/**
 * 插入排序()
 * 时间复杂度：O(n^2)
 */
public class InsertSort {


    public void sort(int[] arr) {
        int i = 1;
        while (i < arr.length) {
            insertSort(arr, i);
            i++;
        }
    }

    public void insertSort(int[] arr, int n) {
        for (int i = n; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                swap(arr, i, i - 1);
            }else {
                break;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }


    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        int[] arr = new int[]{3, 4, 1, 2, 1};
        insertSort.sort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
