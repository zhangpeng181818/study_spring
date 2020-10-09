package com.nuc.zp.leetcode.item1_100;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode tail = listNode;
        while (tail != null && tail.next != null) {
            swap(tail);
            tail = tail.next.next;
        }
        return listNode.next;
    }

    private void swap(ListNode prev) {
        ListNode before = prev.next;
        if (before == null) return;
        ListNode after = before.next;
        if (after == null) return;
        before.next = after.next;
        after.next = before;
        prev.next = after;
    }

    public static void main(String[] args) {
        SwapPairs24 swapPairs24 = new SwapPairs24();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        System.out.println(swapPairs24.swapPairs(listNode));
    }

    public static class ListNode {
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
