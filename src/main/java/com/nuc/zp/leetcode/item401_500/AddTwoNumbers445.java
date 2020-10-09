package com.nuc.zp.leetcode.item401_500;

import com.nuc.zp.leetcode.item1_100.GetKthFromEnd22;

import java.util.Stack;

/**
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddTwoNumbers445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = pushStack(l1);
        Stack<Integer> stack2 = pushStack(l2);
        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;

    }

    private Stack<Integer> pushStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        return stack;
    }


    public static void main(String[] args) {
        AddTwoNumbers445 addTwoNumbers445 = new AddTwoNumbers445();
        ListNode l1 = addTwoNumbers445.new ListNode(7);
        l1.next = addTwoNumbers445.new ListNode(2);
        l1.next.next = addTwoNumbers445.new ListNode(4);
        l1.next.next.next = addTwoNumbers445.new ListNode(3);

        ListNode l2 = addTwoNumbers445.new ListNode(5);
        l2.next = addTwoNumbers445.new ListNode(6);
        l2.next.next = addTwoNumbers445.new ListNode(4);


        System.out.println(addTwoNumbers445.addTwoNumbers(l1, l2));

        l1 = addTwoNumbers445.new ListNode(3);
        l1.next = addTwoNumbers445.new ListNode(9);
        l1.next.next = addTwoNumbers445.new ListNode(9);
        l1.next.next.next = addTwoNumbers445.new ListNode(9);
        l1.next.next.next.next = addTwoNumbers445.new ListNode(9);
        l1.next.next.next.next.next = addTwoNumbers445.new ListNode(9);
        l1.next.next.next.next.next.next = addTwoNumbers445.new ListNode(9);
        l1.next.next.next.next.next.next.next = addTwoNumbers445.new ListNode(9);
        l1.next.next.next.next.next.next.next.next = addTwoNumbers445.new ListNode(9);
        l1.next.next.next.next.next.next.next.next.next = addTwoNumbers445.new ListNode(9);

        l2 = addTwoNumbers445.new ListNode(7);


        System.out.println(addTwoNumbers445.addTwoNumbers(l1, l2));


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
