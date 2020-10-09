package com.nuc.zp.leetcode.item1_100;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateRight61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            count++;
        }
        tail.next = head;
        k = k % count;
        k = count - k;
        while (k > 0) {
            k--;
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }

    public static void main(String[] args) {
        RotateRight61 rotateRight61 = new RotateRight61();
        ListNode listNode = rotateRight61.new ListNode(1);
        listNode.next = rotateRight61.new ListNode(2);
        listNode.next.next = rotateRight61.new ListNode(3);
        listNode.next.next.next = rotateRight61.new ListNode(4);
        listNode.next.next.next.next = rotateRight61.new ListNode(5);

        System.out.println(rotateRight61.rotateRight(listNode, 2));


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
