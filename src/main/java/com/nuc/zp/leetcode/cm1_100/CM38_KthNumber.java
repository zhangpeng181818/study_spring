package com.nuc.zp.leetcode.cm1_100;

/**
 * 描述
 * 给定一个数int k，将素因子只有3、5、7的数从小到大排列，返回其中第k个数。保证k小于等于100。
 * <p>
 * 测试样例：
 * 3
 * 返回
 * 7
 */
public class CM38_KthNumber {

    public int findKth(int k) {
        int [] array =new int[k];
        int num3=0;
        int num5=0;
        int num7=0;
        array[0]=3;
        array[1]=5;
        array[2]=7;

        for(int i=3;i<k;i++){
            //思路：每个数都是找三个数中最小的数*3或5或7得出来的，
            array[i]=Math.min(Math.min(array[num3]*3,array[num5]*5),array[num7]*7);
            if(array[i]==array[num3]*3) num3++;
            if(array[i]==array[num5]*5) num5++;
            if(array[i]==array[num7]*7) num7++;
        }

        return array[k - 1];
    }


    public static void main(String[] args) {
        CM38_KthNumber cm38_kthNumber = new CM38_KthNumber();
        System.out.println(cm38_kthNumber.findKth(4));
    }
}
