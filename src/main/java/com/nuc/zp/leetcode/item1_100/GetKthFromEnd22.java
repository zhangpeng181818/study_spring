package com.nuc.zp.leetcode.item1_100;

import java.util.List;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，
 * 本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetKthFromEnd22 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        while (k > 0) {
            head = head.next;
            k--;
        }
        while (head != null) {
            head = head.next;
            p = p.next;
        }
        return p;
    }

    public static void main(String[] args) {
        GetKthFromEnd22 getKthFromEnd22 = new GetKthFromEnd22();
        ListNode listNode = getKthFromEnd22.new ListNode(1);
        listNode.next = getKthFromEnd22.new ListNode(2);
        listNode.next.next = getKthFromEnd22.new ListNode(3);
        listNode.next.next.next = getKthFromEnd22.new ListNode(4);
        listNode.next.next.next.next = getKthFromEnd22.new ListNode(5);
        System.out.println(getKthFromEnd22.getKthFromEnd(listNode, 2));
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
