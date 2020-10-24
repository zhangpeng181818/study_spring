package com.nuc.zp.leetcode.item101_200;

import java.util.*;

public class LevelOrder102 {


    Queue<TreeNode> queue = new ArrayDeque<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root!=null){
            queue.add(root);
            list.add(Collections.singletonList(root.val));
        }
        while (!queue.isEmpty()) {
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> nodeVals = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    nodeVals.add(poll.left.val);
                    nodes.add(poll.left);
                }
                if (poll.right!=null){
                    nodeVals.add(poll.right.val);
                    nodes.add(poll.right);
                }
            }
            if (!nodeVals.isEmpty()){
                list.add(nodeVals);
            }
            queue.addAll(nodes);
        }
        return list;
    }



    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);
        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;
        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;
        LevelOrder102 levelOrder102 = new LevelOrder102();
        System.out.println(levelOrder102.levelOrder(treeNode3));


    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
