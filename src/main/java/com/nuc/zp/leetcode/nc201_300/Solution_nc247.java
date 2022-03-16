package com.nuc.zp.leetcode.nc201_300;

import java.util.Arrays;

/**
 * 描述
 * 给定一个数组 nums 和一个目标值 target ，请问从 nums 中选出三个数，使其之和尽量接近目标数，
 * 即三数之和与目标数只差绝对值尽可能小。
 * <p>
 * 返回满足题面要求的三数之和。
 * <p>
 * 数据范围：数组长度满足 3 \le n \le 300 \3≤n≤300  ，数组中的值满足 |nums[i]| \le 1000 \∣nums[i]∣≤1000  ，目标值满足 |target| \le 10^4 \∣target∣≤10
 * 4
 * ，可以保证只有一个结果。
 * 示例1
 * 输入：
 * [-1,2,1,-4],1
 * 复制
 * 返回值：
 * 2
 * 复制
 * 说明：
 * 最接近 1 的三数之和是 -1+2+1 = 2
 * 示例2
 * 输入：
 * [0,0,0],1
 * 复制
 * 返回值：
 * 0
 * 复制
 * 说明：
 * 只有一种选择 0+0+0
 * 示例3
 * 输入：
 * [0,1,0,0],0
 * 复制
 * 返回值：
 * 0
 */
public class Solution_nc247 {

    /**
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int ClosestSum(int[] nums, int target) {
        // write code here
        quickSort(nums, 0, nums.length - 1);
        int n = nums.length;;
        int res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n;i++){
            //通过双指针确认第2个数和第3个数
            int l=i+1,r=n-1;
            while(l<r){
                //i下标对应第1个数，l下标对应第2个数，r下标对应第3个数
                int sum=nums[i]+nums[l]+nums[r];
                //如果有更小的绝对值，则跟新sun
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
                //如果sum小于target，则朝sum变大的方向移动
                if(sum<target){
                    l++;
                }
                //如果sum大于target，则朝sum变小的方向移动
                else if(sum>target){
                    r--;
                }
                //如果等于，则绝对值为0，直接返回sum
                else{
                    return sum;
                }
            }
        }
        return res;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int[] partation = partation(arr, left, right);
        quickSort(arr, left, partation[0] - 1);
        quickSort(arr, partation[1] + 1, right);
    }

    private int[] partation(int[] arr, int left, int right) {
        int less = left - 1;
        int more = right;
        while (left < more) {
            if (arr[left] < arr[right]) {
                swap(arr, ++less, left++);
            } else if (arr[left] > arr[right]) {
                swap(arr, left, --more);
            } else {
                left++;
            }
        }
        swap(arr, more, right);
        return new int[]{less + 1, more};
    }

    private void swap(int[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        arr[left] = arr[left] ^ arr[right];
        arr[right] = arr[left] ^ arr[right];
        arr[left] = arr[left] ^ arr[right];

    }


    public static void main(String[] args) {
        Solution_nc247 solution_nc247 = new Solution_nc247();
        int[] arr = new int[]{-1, 2, 1, -4};
        solution_nc247.ClosestSum(arr, 0);
        System.out.println(Arrays.toString(arr));
    }
}
