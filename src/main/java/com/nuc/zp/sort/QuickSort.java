package com.nuc.zp.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int pos = pos(arr, left, right);

        quickSort(arr, left, pos - 1);
        quickSort(arr, pos + 1, right);

    }

    public int pos(int[] arr, int left, int right) {
        int key = arr[left];
        int pos = left;
        while (left < right) {
            while (left < right && key <= arr[right]) {
                right--;
            }
            while (left < right && key >= arr[left]) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            } else {
                break;
            }
        }
        if (pos != right) {
            swap(arr, pos, right);
        }
        return right;
    }

    public void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }


    public void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{3, 4, 1, 2, 1, 8, 6, 5};
        quickSort.sort(arr);
        quickSort.print(arr);
    }
}
