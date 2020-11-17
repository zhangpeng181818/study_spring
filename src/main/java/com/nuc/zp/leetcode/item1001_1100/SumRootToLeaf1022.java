package com.nuc.zp.leetcode.item1001_1100;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * <p>
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 以 10^9 + 7 为模，返回这些数字之和。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入：[1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *  
 * <p>
 * 提示：
 * <p>
 * 树中的结点数介于 1 和 1000 之间。
 * node.val 为 0 或 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumRootToLeaf1022 {

    int res = 0;

    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return res;
    }

    public void preOrder(TreeNode root, int val) {
        if (root != null) {
            // 值先移位，后相加
            int tmp = (val << 1) + root.val;

            // 当前节点是叶子节点
            if (root.left == null && root.right == null) {
                res += tmp;
            } else {
                // 当前节点的左子节点不为空，继续递归，val的值是父节点的值，也就是tmp
                if (root.left != null) {
                    preOrder(root.left, tmp);
                }
                if (root.right != null) {
                    preOrder(root.right, tmp);
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(0);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(1);
        TreeNode treeNode6 = new TreeNode(0);
        TreeNode treeNode7 = new TreeNode(1);

        treeNode.left = treeNode2;
        treeNode.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        SumRootToLeaf1022 sumRootToLeaf1022 = new SumRootToLeaf1022();
        System.out.println(sumRootToLeaf1022.sumRootToLeaf(treeNode));
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
