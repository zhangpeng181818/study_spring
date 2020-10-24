package com.nuc.zp.leetcode.item401_500;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。
 * 返回一个包含所有深度的链表的数组。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：[1,2,3,4,5,null,7,8]
 * <p>
 * 1
 * /  \
 * 2    3
 * / \    \
 * 4   5    7
 * /
 * 8
 * <p>
 * 输出：[[1],[2,3],[4,5,7],[8]]
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/list-of-depth-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ListOfDepth0403 {
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> listNodes = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (tree != null) {
            listNodes.add(new ListNode(tree.val));
            queue.add(tree);
        }
        while (!queue.isEmpty()) {
            ListNode head = new ListNode(-1);
            ListNode tail = head;
            List<TreeNode> treeNodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    ListNode listNode = new ListNode(poll.left.val);
                    tail.next = listNode;
                    tail = listNode;
                    treeNodeList.add(poll.left);
                }
                if (poll.right != null) {
                    ListNode listNode = new ListNode(poll.right.val);
                    tail.next = listNode;
                    tail = listNode;
                    treeNodeList.add(poll.right);
                }
            }
            queue.addAll(treeNodeList);
            if (head.next != null) {
                listNodes.add(head.next);
            }
        }

        return listNodes.toArray(new ListNode[0]);
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
