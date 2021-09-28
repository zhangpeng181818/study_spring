package com.nuc.zp.leetcode.nc001_100;

public class Solution_nc2 {
    public void reorderList(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode node1 = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tail = slow;
        if (fast != null) {
            slow = slow.next;
        }
        tail.next = null;
        ListNode dummy = new ListNode(-1);
        ListNode pos = dummy;
        ListNode node2 = reverse(slow);
        while (node1 != null && node2 != null) {
            pos.next = node1;
            pos = node1;
            node1 = node1.next;

            ListNode cur = node2;
            pos.next = cur;
            pos = cur;
            node2 = node2.next;
        }
        if (node1!=null){
            pos.next = node1;
        }
        head = dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Solution_nc2 solution_nc50 = new Solution_nc2();
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(4);
        ListNode _3 = new ListNode(6);
        ListNode _4 = new ListNode(3);
//        ListNode _5 = new ListNode(7);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
//        _4.next = _5;

        solution_nc50.reorderList(_1);

        while (_1 != null) {
            System.out.println(_1.val);
            _1 = _1.next;
        }
    }
}
