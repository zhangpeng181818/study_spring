package com.nuc.zp.leetcode.item1_100;

import java.util.ArrayList;
import java.util.List;

public class ReorderList143 {

    public void reorderList(ListNode head) {
        List<ListNode> nodeList = new ArrayList<>();
        int count = 0;
        ListNode tail = head;
        while (tail != null) {
            nodeList.add(tail);
            count++;
            tail = tail.next;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        int i = 0, j = count - 1;
        while (i <= j) {
            ListNode before = nodeList.get(i);
            ListNode after = nodeList.get(j);
            newTail.next = before;
            before.next = after;
            newTail = after;
            i++;
            j--;
        }
        head = newHead.next;
        newTail.next=null;
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
    }
}
