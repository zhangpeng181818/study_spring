package com.nuc.zp.leetcode.bm1_100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Solution_bm30 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }


    TreeNode pre = null;
    TreeNode root = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        Convert(pRootOfTree.left);
        if (root == null) {
            root = pRootOfTree;
        }
        if (pre != null) {
            pRootOfTree.left = pre;
            pre.right = pRootOfTree;
        }
        pre = pRootOfTree;
        Convert(pRootOfTree.right);
        return root;

    }




    public static void main(String[] args) {
        Solution_bm30 solution_bm30 = new Solution_bm30();
//        {10,6,14,4,8,12,16}
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(solution_bm30.Convert(root));
    }
}