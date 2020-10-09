package com.nuc.zp.leetcode.item1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */
public class DeleteDuplicates82_2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            while (head.next != null && head.val == head.next.val) {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        DeleteDuplicates82_2 deleteDuplicates82 = new DeleteDuplicates82_2();

        ListNode head = deleteDuplicates82.new ListNode(1);
        head.next = deleteDuplicates82.new ListNode(1);
        head.next.next = deleteDuplicates82.new ListNode(2);
        head.next.next.next = deleteDuplicates82.new ListNode(2);
        head.next.next.next.next = deleteDuplicates82.new ListNode(3);

        System.out.println(deleteDuplicates82.deleteDuplicates(head));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
