package com.nuc.zp.tree;

/**
 *       5
 *     /  \
 *    6    7
 *   /
 *  8
 */
public class Tree01 {

    /**
     * 根左右
     * @param node
     */
    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    /**
     * 左中右
     * @param node
     */
    public void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    public void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Node n4 = new Node(8);
        Node n3 = new Node(7);
        Node n2 = new Node(6, n4, null);
        Node n1 = new Node(5, n2, n3);
        Tree01 tree01 = new Tree01();
        tree01.preorder(n1);
        System.out.println();
        tree01.inorder(n1);
        System.out.println();
        tree01.postorder(n1);
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }
    }
}
