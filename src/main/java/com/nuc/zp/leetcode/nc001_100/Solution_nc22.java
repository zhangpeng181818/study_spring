package com.nuc.zp.leetcode.nc001_100;

public class Solution_nc22 {

    public void merge(int A[], int m, int B[], int n) {
        if(A.length==0 ||m==0) {
            System.arraycopy(B,0,A,0,n);
            return;
        }
        for(int i=0,j=0;i<A.length&&j<B.length;){
            if(m>0&&A[i]<=B[j]){
                i++;
                m--;
            }else if(m>0){
                System.arraycopy(A,i,A,i+1,A.length-i+j);
                A[i] = B[j];
                j++;
                i++;
                m--;
            }else if(m<=0){
                System.arraycopy(B,j,A,i,n-j);
                break;
            }
        }


    }

    public static void main(String[] args) {
        Solution_nc22 solutionNc22 = new Solution_nc22();
        int[] A = {1, 2, 3,0,0,0};
        solutionNc22.merge(A,3,new int[]{2,5,6},3);
        for (int a:A){
            System.out.println(a+" ");
        }
    }
}
