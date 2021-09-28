package com.nuc.zp.leetcode.nc001_100;

public class Solution_nc50 {
    /**
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy .next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null){
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);

            start.next = next;

            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        ListNode pre = null;
        ListNode next = null;
        while (start!=null){
            next = start.next;
            start.next = pre;
            pre = start;
            start = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        Solution_nc50 solution_nc50 = new Solution_nc50();
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(4);
        ListNode _5 = new ListNode(5);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        ListNode node = solution_nc50.reverseKGroup(_1, 2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
