package com.nuc.zp.leetcode.item1_100;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        ListNode head = new ListNode(0);
        ListNode tail = head;
        queue.offer(l1);
        queue.offer(l2);
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        tail.next = null;
        return head.next;
    }

    public static void main(String[] args) {
        MergeTwoLists21 mergeTwoLists21 = new MergeTwoLists21();
        ListNode l1 = mergeTwoLists21.new ListNode(1);
        l1.next = mergeTwoLists21.new ListNode(2);
        l1.next.next = mergeTwoLists21.new ListNode(4);

        ListNode l2 = mergeTwoLists21.new ListNode(1);
        l2.next = mergeTwoLists21.new ListNode(3);
        l2.next.next = mergeTwoLists21.new ListNode(4);
        System.out.println(mergeTwoLists21.mergeTwoLists(l1, l2));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
