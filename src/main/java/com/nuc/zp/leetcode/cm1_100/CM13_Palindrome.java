package com.nuc.zp.leetcode.cm1_100;


public class CM13_Palindrome {
    public boolean isPalindrome(ListNode pHead) {
        // write code here
        if(pHead == null || pHead.next== null) return true;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        ListNode p3 = pHead;

        while(p2!=null&&p3.next!=null){
            p2 = p2.next;
            p3 = p3.next.next;
        }
        if(p3!=null){
            p2 = p2.next;
        }

        ListNode p5 = reverse(p2);
        p2.next = null;
        while(p1!=null&&p5!=null){
            if(p1.val!=p5.val){
                return false;
            }
            p1= p1.next;
            p5 = p5.next;
        }

        return true;
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
        CM13_Palindrome cm13Palindrome = new CM13_Palindrome();
        ListNode _1 = new ListNode(1);
        ListNode _2 = new ListNode(2);
        ListNode _3 = new ListNode(3);
        ListNode _4 = new ListNode(2);
        ListNode _5 = new ListNode(1);
        _1.next = _2;
        _2.next = _3;
        _3.next = _4;
        _4.next = _5;

        boolean palindrome = cm13Palindrome.isPalindrome(_1);
        System.out.println(palindrome);
    }
    
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
