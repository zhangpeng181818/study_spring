package com.nuc.zp.leetcode.bm1_100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution_bm37 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @param p int整型
     * @param q int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int p, int q) {
        // write code here
        List<Integer> val1 = find(root,p);
        List<Integer> val2 = find(root,q);

        int val = root.val;
        for (int i = 0; i < Math.min(val1.size(),val2.size()); i++) {
            if (val1.get(i).equals(val2.get(i))){
                val = val1.get(i);
            }else {
                break;
            }
        }

        return val;
    }

    List<Integer> find(TreeNode root, int val){
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        while (cur!=null){
            list.add(cur.val);
            if (cur.val>val){
                cur = cur.left;
            }else if (cur.val<val){
                cur = cur.right;
            }else {
                break;
            }
        }
        return list;
    }



    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 示例1
     * 输入：
     * {7,1,12,0,4,11,14,#,#,3,5},1,12
     * 复制
     * 返回值：
     * 7
     * 复制
     * 说明：
     * 节点1 和 节点12的最近公共祖先是7
     * 示例2
     * 输入：
     * {7,1,12,0,4,11,14,#,#,3,5},12,11
     * 复制
     * 返回值：
     * 12
     * 复制
     * 说明：
     * 因为一个节点也可以是它自己的祖先.所以输出12
     * @param args
     */
    public static void main(String[] args) {
        Solution_bm37 solution_bm35 = new Solution_bm37();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        7,1,12,0,4,11,14,#,#,3,5
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(14);
        root.left.left.left = null;
        root.left.left.right = null;
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        System.out.println(solution_bm35.lowestCommonAncestor(root,12,1));


    }
}
