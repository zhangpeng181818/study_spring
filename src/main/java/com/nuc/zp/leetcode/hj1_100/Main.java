package com.nuc.zp.leetcode.hj1_100;

public class Main {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            String resp = "";
            Node node = this;
            while (node != null) {
                resp = resp + " " + node.value;
                node = node.next;
            }
            return resp.trim();
        }
    }

    Node deleteTargetNodeFromLinkTable(int[] arr) {
        int targetValue = arr[arr.length - 1];
        Node head = new Node(arr[1]);
        int len = arr[0];
        for (int i = 2; i < arr.length - 1; i += 2) {
            Node p = head;
            while (p != null) {
                if (p.value == arr[i + 1]) {
                    Node temp = new Node(arr[i]);
                    temp.next = p.next;
                    p.next = temp;
                    break;
                } else {
                    p = p.next;
                }
            }
        }
        Node p1 = head;
        if (p1.value == targetValue) {
            return p1.next;
        }
        while (p1.next != null) {
            if (p1.next.value == targetValue) {
                p1.next = p1.next.next;
                break;
            } else {
                p1 = p1.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.deleteTargetNodeFromLinkTable(new int[]{5, 2, 3, 2, 4, 3, 5, 2, 1, 4, 3}));
        System.out.println(main.deleteTargetNodeFromLinkTable(new int[]{6, 2, 1, 2, 3, 2, 5, 1, 4, 5, 7, 2, 2}));


    }
}