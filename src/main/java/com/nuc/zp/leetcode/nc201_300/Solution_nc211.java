package com.nuc.zp.leetcode.nc201_300;

import java.util.*;

/**
 * 描述
 * 给定链表的头节点，旋转链表，将链表每个节点往右移动 k 个位置，原链表后 k 个位置的节点则依次移动到链表头。
 * <p>
 * 即，例如链表 ： 1->2->3->4->5 k=2 则返回链表 4->5->1->2->3
 * <p>
 * 数据范围：链表中节点数满足 0 \le n \le 1000\0≤n≤1000  ， 0 \le k \le 10^9 \0≤k≤10
 * 9
 * <p>
 * 示例1
 * 输入：
 * {1,2,3,4,5},2
 * 复制
 * 返回值：
 * {4,5,1,2,3}
 * 复制
 * 示例2
 * 输入：
 * {1,2,3},3
 * 复制
 * 返回值：
 * {1,2,3}
 */
public class Solution_nc211 {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @param k    int整型
     * @return ListNode类
     */
    public ListNode rotateLinkedList(ListNode head, int k) {
        // write code here
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        int length = 0;
        ListNode tail = null;
        while (p1 != null) {
            tail = p1;
            p1 = p1.next;
            length++;
        }
        if (k == length) return head;
        k = k < length ? k : k % length;

        ListNode p2 = head;
        k = length -k -1;
        while (k>0){
            p2 = p2.next;
            k--;
        }
        ListNode res = p2.next;
        p2.next = null;
        tail.next = head;
        return res;
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
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        Solution_nc211 solution_nc211 = new Solution_nc211();
        System.out.println(solution_nc211.rotateLinkedList(listNode,1));
    }
}
