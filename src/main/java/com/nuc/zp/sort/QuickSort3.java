package com.nuc.zp.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort3 {

    public static void main(String[] args) {
        int length = 10;
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(10);
        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        swap(arr, left + (int) (Math.random() * (right - left + 1)), right);
        int pos = getPos(arr, left, right);
        quickSort(arr, left, pos - 1);
        quickSort(arr, pos + 1, right);
    }

//    public static void swap(int[] arr, int left, int right) {
//        if (left == right) return;
//        arr[left] = arr[left] ^ arr[right];
//        arr[right] = arr[left] ^ arr[right];
//        arr[left] = arr[left] ^ arr[right];
//    }

    public static void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }




    public static int getPos(int[] arr, int left, int right) {
        int temp = arr[left];
        int pos = left;

        while (left < right) {

            while (left < right && arr[right] >= temp) {
                right--;
            }

            while (left < right && arr[left] <= temp) {
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
}
