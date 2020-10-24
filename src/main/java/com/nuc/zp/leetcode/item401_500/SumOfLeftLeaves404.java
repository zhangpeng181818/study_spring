package com.nuc.zp.leetcode.item401_500;

/**
 *   计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfLeftLeaves404 {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        return sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right)
                + (root.left!=null && root.left.left==null && root.left.right==null ? root.left.val : 0);
    }

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
