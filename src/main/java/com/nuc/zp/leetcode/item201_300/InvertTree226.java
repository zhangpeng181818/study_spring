package com.nuc.zp.leetcode.item201_300;

/**
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertTree226 {
    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }

    public void reverse(TreeNode root) {
        if (root != null) {
            reverse(root.left);
            reverse(root.right);
            swap(root);
        }
    }

    private void swap(TreeNode root) {
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(1);
        treeNode4.left = treeNode2;
        treeNode4.right = treeNode7;
        treeNode7.left = treeNode6;
        treeNode7.right = treeNode9;
        treeNode2.left = treeNode1;
        treeNode2.right = treeNode3;
        InvertTree226 invertTree226 = new InvertTree226();
        System.out.println(invertTree226.invertTree(treeNode4));
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
