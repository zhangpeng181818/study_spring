package com.nuc.zp.leetcode.nc201_300;

import java.util.*;

/**
 * 描述
 * 给定一个奇数位升序，偶数位降序的链表，返回对其排序后的链表。
 *
 * 题面解释：例如链表 1->3->2->2->3->1 是奇数位升序偶数位降序的链表，而 1->3->2->2->3->2 则不符合题目要求。
 *
 * 数据范围：链表中元素个数满足 1 \le n \le 10000 \1≤n≤10000  ，链表中的元素大小满足 1 \le val \le 100000 \1≤val≤100000
 * 示例1
 * 输入：
 * {1,3,2,2,3,1}
 * 复制
 * 返回值：
 * {1,1,2,2,3,3}
 * 复制
 * 示例2
 * 输入：
 * {1,2,2}
 * 复制
 * 返回值：
 * {1,2,2}
 */
public class Solution_nc207 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode sortLinkedList (ListNode head) {
        // write code here
        if (head == null || head. next ==null) return head;
        ListNode p0 = head.next.next;
        ListNode p1 = head;
        ListNode p3 = p1;
        ListNode p2 = head.next;
        ListNode p4 = p2;
        int i = 1;
        while (p0!=null){
            if (i%2==1){
                p1.next = p0;
                p1 = p1.next;
            }else {
                p2.next = p0;
                p2 = p2.next;
            }
            i++;
            p0 = p0.next;
        }
        p1.next = null;
        p2.next = null;
        System.out.println("p3="+p3);
        System.out.println("p4="+p4);
        ListNode reverse = reverse(p4);
        ListNode merge = merge(p3, reverse);
        return merge;
    }

    public ListNode reverse(ListNode head){
        ListNode p1 = head;
        ListNode p2 = null;
        ListNode p3 = p1;
        while (p1!=null){
            p1 = p1.next;
            p3.next = p2;
            p2 = p3;
            p3 = p1;
        }
        return p2;
    }

    public ListNode merge(ListNode p1,ListNode p2){
        ListNode p3 = p1;
        ListNode p4 = p2;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (p3!=null&&p4!=null){

            if (p3.val<=p4.val){
                p.next = p3;
                p3=p3.next;
            }else {
                p.next = p4;
                p4 = p4.next;
            }
            p = p.next;
        }
        if (p4!=null){
            p.next = p4;
        }else if (p3 != null){
            p.next = p3;
        }
        return head.next;
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
        Solution_nc207.ListNode listNode = new Solution_nc207.ListNode(1);
        listNode.next = new Solution_nc207.ListNode(2);
        listNode.next.next = new Solution_nc207.ListNode(3);
        listNode.next.next.next = new Solution_nc207.ListNode(4);
        listNode.next.next.next.next = new Solution_nc207.ListNode(5);
        Solution_nc207 solution_nc207 = new Solution_nc207();
//        System.out.println(solution_nc207.reverse(listNode));

        Solution_nc207.ListNode listNode2 = new Solution_nc207.ListNode(1);
        listNode2.next = new Solution_nc207.ListNode(2);
        listNode2.next.next = new Solution_nc207.ListNode(3);

//        System.out.println(solution_nc207.merge(listNode,listNode2));

//        Solution_nc207.ListNode listNode3 = new Solution_nc207.ListNode(1);
//        listNode3.next = new Solution_nc207.ListNode(3);
//        listNode3.next.next = new Solution_nc207.ListNode(2);
//        listNode3.next.next.next = new Solution_nc207.ListNode(2);
//        listNode3.next.next.next.next = new Solution_nc207.ListNode(3);
//        listNode3.next.next.next.next.next = new Solution_nc207.ListNode(1);
//        System.out.println(solution_nc207.sortLinkedList(listNode3));


        Solution_nc207.ListNode listNode4 = new Solution_nc207.ListNode(1);
        listNode4.next = new Solution_nc207.ListNode(2);
        listNode4.next.next = new Solution_nc207.ListNode(2);
        System.out.println(solution_nc207.sortLinkedList(listNode4));
    }
}
