package com.nuc.zp.leetcode.item1_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 示例：
 * <p>
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 * 说明：
 * <p>
 * 给定的 k 保证是有效的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KthToLast0202 {
    public int kthToLast(ListNode head, int k) {
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        return nodeList.get(nodeList.size() - k).val;
    }

    public static void main(String[] args) {
        KthToLast0202 kthToLast0202 = new KthToLast0202();
        ListNode listNode = kthToLast0202.new ListNode(1);
        listNode.next = kthToLast0202.new ListNode(2);
        listNode.next.next = kthToLast0202.new ListNode(3);
        listNode.next.next.next = kthToLast0202.new ListNode(4);
        listNode.next.next.next.next = kthToLast0202.new ListNode(5);
        System.out.println(kthToLast0202.kthToLast(listNode, 2));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


    }
}
