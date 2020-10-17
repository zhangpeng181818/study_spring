package com.nuc.zp.leetcode.item201_300;


public class IsAnagram242 {

    public boolean isAnagram(String s, String t) {
        if ("".equals(s)&&s.equals(t)) return true;

        if (s.length() != t.length()) return false;
        byte[] sArr = s.getBytes();
        byte[] tArr = t.getBytes();
        mergeSort(sArr, 0, sArr.length - 1);
        mergeSort(tArr, 0, tArr.length - 1);
        return new String(sArr).equals(new String(tArr));
    }

    public void mergeSort(byte[] arr, int l, int r) {
        if (l != r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m + 1, r);
        }
    }

    private void merge(byte[] arr, int l, int m, int r) {
        byte[] left = new byte[m - l];

        byte[] right = new byte[r - m + 1];

        for (int i = l; i < m; i++) {
            left[i - l] = arr[i];
        }

        for (int i = m; i <= r; i++) {
            right[i - m] = arr[i];
        }

        int i = 0, k = l, j = 0;
        while (i < left.length && j < right.length && left[i] != 0 && right[j] != 0) {
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

        while (i < left.length && left[i] != 0) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length && right[j] != 0) {
            arr[k] = right[j];
            j++;
            k++;
        }

    }


    public static void main(String[] args) {
        IsAnagram242 isAnagram242 = new IsAnagram242();
        System.out.println(isAnagram242.isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram242.isAnagram("rat", "car"));
    }
}
