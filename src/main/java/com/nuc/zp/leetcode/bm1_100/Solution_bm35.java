package com.nuc.zp.leetcode.bm1_100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 *
 */
public class Solution_bm35 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isCompleteTree (TreeNode root) {
        // write code here
        List<String> vals = new ArrayList<>();
        if (root!=null) {
            Queue<TreeNode> nodeQueue = new ArrayDeque<>();
            nodeQueue.add(root);
            vals.add(root.val+"");
            while (!nodeQueue.isEmpty()){
                TreeNode node = nodeQueue.poll();

                if (node.left==null&&node.right==null){
                    vals.add(" ");
                    vals.add(" ");
                    continue;
                }
                if (node.left!=null){
                    nodeQueue.add(node.left);
                    vals.add(node.val+"");
                }else {
                    vals.add(" ");
                }

                if (node.right!=null){
                    nodeQueue.add(node.right);
                    vals.add(node.val+"");
                }else {
                    vals.add(" ");
                }
            }
        }
        String trim = String.join("", vals).trim();
        return !trim.contains(" ");
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
        Solution_bm35 solution_bm35 = new Solution_bm35();
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);


        System.out.println(solution_bm35.isCompleteTree(root));
    }
}
