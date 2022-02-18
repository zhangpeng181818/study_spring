package com.nuc.zp.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSort3 {

    public static void main(String[] args) {
        int length = 10;
        int[] arr = new int[]{5, 4, 1, 2, 0};
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = ThreadLocalRandom.current().nextInt(10);
//        }
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int l = left;
        int r = right;
        int temp = arr[left];
        while (l<r ){
            while (l<r&&arr[l]<temp){
                l++;
            }
            while (l<r&&arr[r]>temp){
                r--;
            }
            if (l<=r){
               if (l!= left){
                   arr[l] = arr[l]^arr[left];
                   arr[left] = arr[l]^arr[left];
                   arr[l] = arr[l]^arr[left];
               }

            }else {
                break;
            }
        }
        quickSort(arr, left, l-1);
        quickSort(arr,l+1,right);
    }
}
