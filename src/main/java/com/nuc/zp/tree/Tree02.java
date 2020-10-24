package com.nuc.zp.tree;

public class Tree02 {

    public void insert(Tree tree, int val) {
        Node node = new Node(val);
        if (tree.root == null) {
            tree.root = node;
        } else {
            Node temp = tree.root;
            while (temp != null) {
                if (temp.data > val) {
                    if (temp.left == null) {
                        temp.left = node;
                        break;
                    } else {
                        temp = temp.left;
                    }
                } else {
                    if (temp.right == null) {
                        temp.right = node;
                        break;
                    } else {
                        temp = temp.right;
                    }
                }
            }
        }
    }

    public int getTreeHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int left = getTreeHeight(node.left);
            int right = getTreeHeight(node.right);
            return Math.max(left, right) + 1;
        }
    }

    public int getMaxNum(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftMaxNum = getMaxNum(node.left);
            int rightMaxNum = getMaxNum(node.right);
            return Math.max(node.data, Math.max(leftMaxNum, rightMaxNum));
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 3, 8, 2, 5, 1, 7};
        Tree02 tree02 = new Tree02();
        Tree tree = new Tree();
        for (int num : arr) {
            tree02.insert(tree, num);
        }

        tree02.preorder(tree.root);
        System.out.println();
        tree02.inorder(tree.root);
        System.out.println();
        tree02.postorder(tree.root);
        System.out.println();
        System.out.println(tree02.getTreeHeight(tree.root));
        System.out.println(tree02.getMaxNum(tree.root));
    }

    static class Tree {
        Node root;
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

    public void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    /**
     * 左中右
     *
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
}
