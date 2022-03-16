package com.nuc.zp.leetcode.nc101_200;

public class Solution_nc189 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode plusOne(ListNode head) {
        // write code here
        if (head == null) {
            return head;
        }
        //链表反转
        ListNode node = reverse(head);
        //遍历
        ListNode p1 = node;

        int jin = 1;
        while (p1 != null) {
            int val = p1.val  + jin;
            jin = 0;
            if (val < 10) {
                p1.val = val;
                break;
            }
            jin++;
            p1.val = 0;
            p1 = p1.next;
        }


        //链表反转

        ListNode res = reverse(node);
        ListNode resp = new ListNode(-1);
        if (jin != 0) {
            ListNode next = new ListNode(jin);
            resp.next = next;
            next.next = res;
        } else {
            resp.next = res;
        }
        return resp.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = null;
        ListNode p3 = p1;
        while (p1 != null) {
            p1 = p1.next;
            p3.next = p2;
            p2 = p3;
            p3 = p1;
        }
        return p2;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Solution_nc189 solution_nc189 = new Solution_nc189();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(9);
        listNode.next.next = new ListNode(8);
        System.out.println(solution_nc189.plusOne(listNode));
    }

}
