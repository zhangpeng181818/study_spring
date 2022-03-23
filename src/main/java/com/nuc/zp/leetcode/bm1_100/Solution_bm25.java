package com.nuc.zp.leetcode.bm1_100;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 * 示例1
 * 输入：
 * {1,#,2,3}
 * 复制
 * 返回值：
 * [3,2,1]
 * 复制
 * 说明：
 * 如题面图
 * 示例2
 * 输入：
 * {1}
 * 复制
 * 返回值：
 * [1]
 */
public class Solution_bm25 {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型一维数组
     */
    public int[] postorderTraversal(TreeNode root) {
        // write code here
        if (root == null) return new int[]{};
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            stack2.push(node);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }

        }
        int[] res = new int[stack2.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack2.pop().val;
        }

        return res;
    }


//    public int[] postorderTraversal(TreeNode root) {
//        // write code here
//        if (root==null) return new int[]{};
//        Queue<TreeNode> queue = new ArrayDeque<>();
//        postOrder(root,queue);
//        int[] res = new int[queue.size()];
//        for (int i = 0; i < res.length && queue.size()>0; i++) {
//            res[i] = queue.poll().val;
//        }
//        return res;
//    }
//
//   public void postOrder(TreeNode root,Queue<TreeNode> queue){
//        if (root == null){
//            return;
//        }
//        postOrder(root.left,queue);
//        postOrder(root.right,queue);
//        queue.add(root);
//   }


    public static void main(String[] args) {
        Solution_bm25 solution_bm25 = new Solution_bm25();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(Arrays.toString(solution_bm25.postorderTraversal(treeNode)));
    }
}
