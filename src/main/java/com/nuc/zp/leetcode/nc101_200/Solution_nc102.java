package com.nuc.zp.leetcode.nc101_200;

public class Solution_nc102 {

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        return 0;
    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode _7 = new TreeNode(7);
        TreeNode _4 = new TreeNode(4);
        TreeNode _6 = new TreeNode(6);
        TreeNode _0 = new TreeNode(0);
        TreeNode _8 = new TreeNode(8);

        TreeNode _2 = new TreeNode(2,_7,_4);
        TreeNode _1 = new TreeNode(1,_0,_8);
        TreeNode _5 = new TreeNode(5,_6,_2);
        TreeNode _3 = new TreeNode(3,_5,_1);

        Solution_nc102 solutionNc102 = new Solution_nc102();
        System.out.println(solutionNc102.lowestCommonAncestor(_3, 5, 1));
    }
}
