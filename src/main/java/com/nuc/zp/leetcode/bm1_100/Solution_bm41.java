package com.nuc.zp.leetcode.bm1_100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 *    1
 *  2   3
 *4  5
 示例1
 输入：
 [1,2,4,5,3],[4,2,5,1,3]
 1,3,2,5,4
 复制
 返回值：
 [1,3,5]


          1
        2   3
      4  5 6 7
    8
 [1,2,4,8,5,3,6,7] [8,4,2,5,1,6,3,7]
 [1,3,7,8]



 */
public class Solution_bm41 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 求二叉树的右视图
     * @param xianxu int整型一维数组 先序遍历
     * @param zhongxu int整型一维数组 中序遍历
     * @return int整型一维数组
     */
    private HashMap<Integer, Integer> ans = new HashMap<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int j = 0;
    public int[] solve (int[] xianxu, int[] zhongxu) {
        //将xianxu节点的值映射到相应的中序节点的下标。
        for(int i = 0; i < zhongxu.length; i++){
            map.put(zhongxu[i], i);
        }
        //开始构建二叉树。
        build(xianxu, zhongxu, 0, xianxu.length-1, 0);

        //创建放回答案的数组
        int[] temp = new int[ans.size()];

        //将值传入数组。
        for(int i = 0; i < ans.size(); i++){
            temp[i] = ans.get(i);
        }

        return temp;
    }

    public void build(int[] xianxu, int[] zhongxu, int left, int right, int i){
        if(left > right){
            return;
        }
        int index = map.get(xianxu[j++]);
        //构建左子树
        build(xianxu, zhongxu, left, index-1, i+1);
        //构建右子树
        build(xianxu, zhongxu, index+1, right, i+1);
        //存储第i层的最右边的那个节点。
        ans.put(i, zhongxu[index]);
    }


    public static void main(String[] args) {

    }
}
