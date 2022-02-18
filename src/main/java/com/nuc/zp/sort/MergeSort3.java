package com.nuc.zp.sort;

import java.util.Arrays;

public class MergeSort3 {

    public static int process(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return process(arr, left, mid) + process(arr, mid + 1, right)
                + merge(arr, left, mid, right);
    }

//         3,2,4,5,0
//           /   \
//        3,2,4   5,0
//         / \     / \
//       3,2  4    5  0
//      /  \
//     3   2
    public static int merge(int[] arr, int l, int m, int r) {
        int[] helper = new int[r - l + 1];
        int p1 = l;
        int p2 = m + 1;
        int result = 0;
        int i = 0;
        while (p1 <= m && p2 <= r) {
            result += arr[p1] < arr[p2] ? r - p2 + 1 : 0;
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
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
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 4, 5, 0};
        /**
         * 3-2
         * 3-0
         * 2-0
         * 4-0
         * 5-0
         *
         */

        System.out.println(process(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
    }
}
