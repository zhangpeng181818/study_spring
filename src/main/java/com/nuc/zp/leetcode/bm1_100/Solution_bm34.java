package com.nuc.zp.leetcode.bm1_100;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 */
public class Solution_bm34 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isValidBST(TreeNode root) {
        // write code here
        if (root != null && root.left != null) {
            boolean judge = judge(root.left, root.val, true);
            if (!judge) {
                return false;
            }
        }

        if (root != null && root.right != null) {
            boolean judge = judge(root.right, root.val, false);
            if (!judge) {
                return false;
            }
        }
        return true;
    }

    public boolean judge(TreeNode root, int val, boolean isLeft) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if ((isLeft && node.val > val) || (!isLeft && node.val < val)) {
                return false;
            }
            if (node.right != null) {
                if (node.val > node.right.val) {
                    return false;
                }
                stack.push(node.right);
            }
            if (node.left != null) {
                if (node.val < node.left.val) {
                    return false;
                }
                stack.push(node.left);
            }
        }
        return true;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Solution_bm34 solution_bm34 = new Solution_bm34();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);

        System.out.println(solution_bm34.isValidBST(root));
    }
}
