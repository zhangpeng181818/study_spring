package com.nuc.zp.leetcode.item601_700;

public class Tree2str606 {

    private StringBuilder stringBuilder = new StringBuilder();

    public String tree2str(TreeNode t) {
        order(t);
        return stringBuilder.toString();
    }

    private void order(TreeNode t) {
        if (t != null) {
            stringBuilder.append(t.val);
            if (t.left == null && t.right == null) return;
            stringBuilder.append("(");
            order(t.left);
            stringBuilder.append(")");
            if (t.right == null) return;
            stringBuilder.append("(");
            order(t.right);
            stringBuilder.append(")");
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(1);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(4);
//        root.left = node2;
//        root.right = node3;
//        node2.left = node4;
//        Tree2str606 tree2str606 = new Tree2str606();
//        System.out.println(tree2str606.tree2str(root));

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.right = node4;
        Tree2str606 tree2str606 = new Tree2str606();
        System.out.println(tree2str606.tree2str(root));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
