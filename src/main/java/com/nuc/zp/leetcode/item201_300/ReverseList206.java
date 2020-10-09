package com.nuc.zp.leetcode.item201_300;

import java.util.Stack;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseList206 {

//    public ListNode reverseList(ListNode head) {
//        Stack<Integer> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head.val);
//            head = head.next;
//        }
//
//        head = new ListNode(0);
//        ListNode tail = head;
//        while (!stack.isEmpty()) {
//            tail.next = new ListNode(stack.pop());
//            tail = tail.next;
//        }
//        return head.next;
//    }

    public ListNode reverseList(ListNode head) {
        ListNode listNode = new ListNode(0);
        while (head != null) {
            if (listNode.next == null) {
                listNode.next = new ListNode(head.val);
            } else {
                listNode.next = new ListNode(head.val, listNode.next);
            }
            head = head.next;
        }
        return listNode.next;
    }


    public static void main(String[] args) {
        ReverseList206 reverseList206 = new ReverseList206();
        ListNode listNode = reverseList206.new ListNode(1);
        listNode.next = reverseList206.new ListNode(2);
        listNode.next.next = reverseList206.new ListNode(3);
        listNode.next.next.next = reverseList206.new ListNode(4);
        listNode.next.next.next.next = reverseList206.new ListNode(5);
        System.out.println(reverseList206.reverseList(listNode));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
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
