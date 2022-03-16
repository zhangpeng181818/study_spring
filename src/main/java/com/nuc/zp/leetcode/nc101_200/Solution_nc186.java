package com.nuc.zp.leetcode.nc101_200;

public class Solution_nc186 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode swapLinkedPair (ListNode head) {
        // write code here
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = head;
        ListNode pre = dummy;
        while (p1 != null&& p1.next!=null){
            ListNode last = p1.next.next;
            ListNode p2 = p1.next;
            p1.next = last;
            p2.next = p1;
            pre.next = p2;
            p1 = last;
            pre = pre.next.next;

        }
        return  dummy.next;
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
        Solution_nc186 solution_nc186 = new Solution_nc186();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        System.out.println(solution_nc186.swapLinkedPair(listNode));
    }
}
