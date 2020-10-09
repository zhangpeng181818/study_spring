package com.nuc.zp.leetcode.item201_300;


public class DeleteNode0203 {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        if (next != null) {
            node.val = next.val;
            node.next = next.next;
        }
    }

    public static void main(String[] args) {
        DeleteNode0203 deleteNode0203 = new DeleteNode0203();
        ListNode listNode = deleteNode0203.new ListNode(1);
        ListNode listNode2 = deleteNode0203.new ListNode(2);
        ListNode listNode3 = deleteNode0203.new ListNode(3);
        ListNode listNode4 = deleteNode0203.new ListNode(4);
        ListNode listNode5 = deleteNode0203.new ListNode(5);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        deleteNode0203.deleteNode(listNode4);
        System.out.println(listNode);

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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
