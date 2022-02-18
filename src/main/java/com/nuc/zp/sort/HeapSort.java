package com.nuc.zp.sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int length = 10;
        int[] arr = new int[]{5, 4, 1, 2, 0, 6};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = ThreadLocalRandom.current().nextInt(10);
//        }
        heapSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr, int left, int right) {
        if (arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int left, int right) {
        if (left != right) {
            arr[left] = arr[left] ^ arr[right];
            arr[right] = arr[left] ^ arr[right];
            arr[left] = arr[left] ^ arr[right];
        }
    }
}
