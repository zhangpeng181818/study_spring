package com.nuc.zp.leetcode.bm1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 * 例如：                                 下面这棵二叉树是对称的
 * <p>
 * 下面这棵二叉树不对称。
 * <p>
 * 数据范围：节点数满足 0 \le n \le 10000≤n≤1000，节点上的值满足 |val| \le 1000∣val∣≤1000
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 备注：
 * 你可以用递归和迭代两种方法解决这个问题
 * 示例1
 * 输入：
 * {1,2,2,3,4,4,3}
 * 复制
 * 返回值：
 * true
 * 复制
 * 示例2
 * 输入：
 * {8,6,9,5,7,7,5}
 * 复制
 * 返回值：
 * false
 */
public class Solution_bm31 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        ArrayList<String> left = new ArrayList<>();
        ArrayList<String> right = new ArrayList<>();
        listLeft(pRoot.left, left);
        listRight(pRoot.right, right);
        return String.join("", left).equals(String.join("", right));
    }


    public void listLeft(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("#");
            return;
        }
        list.add(node.val + "");
        listLeft(node.left, list);
        listLeft(node.right, list);
    }

    public void listRight(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("#");
            return;
        }
        list.add(node.val + "");
        listRight(node.right, list);
        listRight(node.left, list);
    }


    public static void main(String[] args) {
    }
}