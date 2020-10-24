package com.nuc.zp.leetcode.item801_900;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
 * <p>
 *  
 * <p>
 * 示例 ：
 * <p>
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 * <p>
 * 5
 * / \
 * 3    6
 * / \    \
 * 2   4    8
 *  /        / \
 * 1        7   9
 * <p>
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 * 9
 *  
 * <p>
 * 提示：
 * <p>
 * 给定树中的结点数介于 1 和 100 之间。
 * 每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-order-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IncreasingBST897 {

    Queue<TreeNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

    public TreeNode increasingBST(TreeNode root) {

        inorder(root);

        TreeNode head = new TreeNode(-1);
        TreeNode tail = head;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            tail.right = poll;
            tail = poll;
        }
        tail.right = null;
        return head.right;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            queue.add(new TreeNode(root.val));
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;
        treeNode6.right = treeNode8;
        treeNode2.left = treeNode1;
        treeNode8.left = treeNode7;
        treeNode8.right = treeNode9;
        IncreasingBST897 increasingBST897 = new IncreasingBST897();
        System.out.println(increasingBST897.increasingBST(treeNode5));

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
