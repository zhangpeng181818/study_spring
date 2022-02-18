package com.nuc.zp.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MergeSort2 {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int[] helper = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            helper[i++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }
        while (p1 <= m) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= r) {
            helper[i++] = arr[p2++];
        }

        for (int j = 0; j < helper.length; j++) {
            arr[l + j] = helper[j];
        }
    }

    public static void main(String[] args) {
        int length = 10;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(length);
        }
        mergeSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
