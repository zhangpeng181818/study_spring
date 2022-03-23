package com.nuc.zp.leetcode.bm1_100;

/**
 * 描述
 * 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
 * <p>
 * 进阶： 空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
 * <p>
 * 数据范围:
 * -231<=nums[i]<=231-1
 * 0<=len(nums)<=5*105
 * 示例1
 * 输入：
 * [1,0,2]
 * 复制
 * 返回值：
 * 3
 * 复制
 * 示例2
 * 输入：
 * [-2,3,4,1,5]
 * 复制
 * 返回值：
 * 2
 * 复制
 * 示例3
 * 输入：
 * [4,5,6,8,9]
 * 复制
 * 返回值：
 * 1
 */
public class Solution_bm53 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
//    public int minNumberDisappeared(int[] nums) {
//        // write code here
//        int max = -1;
//        for (int val : nums) {
//            if (val > max) {
//                max = val;
//            }
//        }
//        Integer[] vals = new Integer[max + 1];
//        for (int val : nums) {
//            if (val >= 0) {
//               if (vals[val]==null){
//                   vals[val]=0;
//               }
//                vals[val]++;
//            }
//        }
//        int i = 1;
//        for ( ; i < vals.length; i++) {
//            if (vals[i] == null) {
//                return i;
//            }
//        }
//        return i;
//    }
    public int minNumberDisappeared(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i]>0&&nums[i]<=n&&nums[i]!=nums[nums[i]-1]){
                int tmp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return n+1;

    }

    public static void main(String[] args) {
        Solution_bm53 solution_bm53 = new Solution_bm53();
        System.out.println(solution_bm53.minNumberDisappeared(new int[]{1, 0, 2}));//3
        System.out.println(solution_bm53.minNumberDisappeared(new int[]{-2, 3, 4, 1, 5}));//2
        System.out.println(solution_bm53.minNumberDisappeared(new int[]{4, 5, 6, 8, 9}));//1
    }
}
