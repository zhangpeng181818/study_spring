package com.nuc.zp.leetcode.item1_100;

import java.util.*;
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
public class DeleteDuplicates82 {
    PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);

    Map<String, AtomicInteger> map = new HashMap<>();

    public ListNode deleteDuplicates(ListNode head) {
        while (head != null) {
            AtomicInteger value = map.get(String.valueOf(head.val));
            if (value == null) {
                map.put(String.valueOf(head.val), new AtomicInteger(1));
            } else {
                value.getAndIncrement();
            }
            head = head.next;
        }

        for (Map.Entry entry : map.entrySet()) {
            if (entry.getValue() != null) {
                AtomicInteger entryValue = (AtomicInteger) entry.getValue();
                if (entryValue.get() > 1) continue;
                queue.add(new ListNode(Integer.parseInt(entry.getKey().toString())));
            }
        }
        head = new ListNode(-1);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            tail.next = poll;
            tail = poll;
        }
        tail.next = null;
        return head.next;
    }


    public static void main(String[] args) {
        DeleteDuplicates82 deleteDuplicates82 = new DeleteDuplicates82();

        ListNode head = deleteDuplicates82.new ListNode(1);
        head.next = deleteDuplicates82.new ListNode(1);
        head.next.next = deleteDuplicates82.new ListNode(1);
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
