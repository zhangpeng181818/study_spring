package com.nuc.zp.leetcode.nc001_100;

public class Solution_nc133 {

    public ListNode oddEvenList (ListNode head) {
        // write code here
        if(head==null||head.next==null) return head;
        ListNode evenHead = head.next;
        ListNode cur = head;
        ListNode oddTail = null;
        ListNode oddTail2 = null;
        int len = 1;
        while(cur.next!=null){
            len++;
            oddTail = cur.next;
            oddTail2 = cur;
            ListNode next = cur.next;
            cur.next=cur.next.next;
            cur = next;
        }
        if(len%2==1){
            oddTail.next = evenHead;
        }else{
            oddTail2.next = evenHead;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution_nc133 solution_nc50 = new Solution_nc133();
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(4);
        ListNode _3 = new ListNode(6);
        ListNode _4 = new ListNode(3);
        ListNode _5 = new ListNode(7);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        ListNode node = solution_nc50.oddEvenList(_1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
