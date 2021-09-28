package com.nuc.zp.leetcode.nc001_100;

public class Solution_nc88 {


    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, n - 1, n - K);
//        print(a);
        return a[n - K];
    }

    public void quickSort(int[] arr, int left, int right, int k) {
        if (left >= right) {
            return;
        }
        int pos = getPos(arr, left, right);

        if (pos <= k) {
            left = pos + 1;
            quickSort(arr, left, right, k);
        } else {
            right = pos - 1;
            quickSort(arr, left, right, k);
        }
    }

    public int getPos(int[] arr, int left, int right) {
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
        swap(arr, pos, right);
        return right;
    }


    public void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
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

        Solution_nc88 solutionNc88 = new Solution_nc88();
//        System.out.println(solutionNc88.findKth(new int[]{1, 3, 5, 2, 2}, 5, 3));
        System.out.println(solutionNc88.findKth(new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663}, 49, 24));
    }
}
