package com.nuc.zp.leetcode.nc201_300;

/**
 * 示例1
 * 输入：
 * {1,2,3}
 * 复制
 * 返回值：
 * {1,2,3}
 * 复制
 * 示例2
 * 输入：
 * {2,4,1}
 * 复制
 * 返回值：
 * {1,2,4}
 */
public class Solution_nc244 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode insertionSortList(ListNode head) {
        // write code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy.next;
        ListNode p2 = dummy.next.next;
        while (p2!=null){
            if (p1.val <= p2.val){
                p2 = p2.next;
                p1 = p1.next;
            }else {
                ListNode temp = p2;
                p1.next=p2.next;
                p2 = p2.next;
                ListNode pre = dummy;
                ListNode pos = pre.next;
                while (pos!=p1||pre==dummy){
                    while (pos.val<= temp.val){
                        pos = pos.next;
                        pre = pre.next;
                    }
                    temp.next =pos;
                    pre.next = temp;
                    break;
                }

            }
        }


        return dummy.next;
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
        Solution_nc244 solution_nc244 = new Solution_nc244();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        System.out.println(solution_nc244.insertionSortList(listNode));
    }
}
