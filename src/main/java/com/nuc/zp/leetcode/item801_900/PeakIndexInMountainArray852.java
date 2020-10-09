package com.nuc.zp.leetcode.item801_900;

/**
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,0]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PeakIndexInMountainArray852 {

//    public int peakIndexInMountainArray(int[] arr) {
//        int index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (i + 1 < arr.length && arr[i] < arr[i + 1]) {
//                index = i + 1;
//            } else {
//                break;
//            }
//        }
//        return index;
//    }

    public int peakIndexInMountainArray(int[] arr) {
        int index = 0;
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int med = ((right - left) >> 1) + left;
            if (arr[med] < arr[med + 1]) {
                left = med + 1;
            } else {
                right = med - 1;
                index = med;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        PeakIndexInMountainArray852 peakIndexInMountainArray852 = new PeakIndexInMountainArray852();
        System.out.println(peakIndexInMountainArray852.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray852.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }
}
