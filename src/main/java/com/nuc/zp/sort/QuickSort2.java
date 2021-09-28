package com.nuc.zp.sort;

import java.util.Arrays;

public class QuickSort2 {

    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pos = getPos(arr, left, right);
        quickSort(arr, left, pos - 1);
        quickSort(arr, pos + 1, right);

    }

    private int getPos(int[] arr, int left, int right) {
        int key = arr[left];
        int pos = left;
        while (left < right) {
            while (left < right && key <= arr[right]) right--;
            while (left < right && key >= arr[left]) left++;
            if (left <= right) {
                swap(arr, pos, left);
            } else {
                break;
            }
        }
        return left;
    }

    private void swap(int[] arr, int pos, int left) {
        if (pos != left) {
            arr[pos] = arr[pos] + arr[left];
            arr[left] = arr[pos] - arr[left];
            arr[pos] = arr[pos] - arr[left];
        }
    }


    public static void main(String[] args) {
        QuickSort2 quickSort2 = new QuickSort2();
        int[] arr = new int[]{5, 4, 1, 2, 0};
        quickSort2.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
