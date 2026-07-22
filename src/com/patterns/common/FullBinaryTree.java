package com.patterns.common;

import java.util.LinkedList;
import java.util.Queue;

public class FullBinaryTree {

    public static class Node {
        int data;
        Node parent;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.parent = this.left = this.right = null;
        }
    }

    /*
    * Intuition:
    * Here the input is in form of level order traversal (BFS representation)
    * To construct a binary tree from input, we use queue
    * Start with first element as root element
    * Add it to queue
    * pop node from queue, add new node to its left and right and add it to queue
    * repeat
    *
    * Assumption: Its a full binary tree
    * */
    public static Node createBinaryTree(int[] input) {
        Node root = null;
        if(input.length > 0) {
            root = new Node(input[0]);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            int index = 1;
            while(!queue.isEmpty() && index+1 < input.length){
                Node current = queue.poll();
                Node left = new Node(input[index++]);
                Node right = new Node(input[index++]);

                current.left = left;
                current.right = right;

                left.parent = current;
                right.parent = current;

                queue.add(left);
                queue.add(right);
            }
        }
        return root;
    }

    public static void printBinaryTree_BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(" " + node.data + ",");

            if(node.left == null)
                continue;
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    /*
    * Intuition:
    * Identify height of a tree
    * For each level, you'll need to keep track of no of spaces and nodes to be printed
    * */
    public static void printBinaryTree_BFS_PatternI(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        while(!queue.isEmpty()) {
            if(size == 0) {
                size = queue.size();
                System.out.println();
            }
            Node node = queue.poll();
            size --;
            System.out.print(" " + node.data + ",");

            if(node.left == null)
                continue;
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public static void printBinaryTree_BFS_PatternII(Node root) {
        int height = computeHeight(root);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 0, level = 0, leadingSpaces = 0, betweenSpaces = 0;
        while(!queue.isEmpty()) {
            if(size == 0) {
                size = queue.size();
                System.out.println();
                level ++;

                leadingSpaces = (int) Math.pow(2,height - level) - 1;
                betweenSpaces = (int) Math.pow(2,height - level + 1) - 1;
                for(int i=0; i<leadingSpaces; i++)
                    System.out.print(" ");
            }

            Node node = queue.poll();
            size --;
            System.out.print(node.data);

            if(size > 0)
                for(int i=0; i<betweenSpaces; i++)
                    System.out.print(" ");

            if(node.left == null)
                continue;
            queue.add(node.left);
            queue.add(node.right);
        }
    }

    public static int computeHeight(Node root) {
        int height = 0;
        while(root != null) {
            height ++;
            root = root.left;
        }
        return height;
    }

    public static Node findNode(Node root, int num) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.data == num)
                return node;

            if(node.left == null)
                continue;
            queue.add(node.left);
            queue.add(node.right);
        }
        return null;
    }

    public static int lowestCommonAncestor(Node a, Node b) {
        Node p = a, q = b;
        while(p != q) {
            p = p.parent == null ? a : p.parent;
            q = q.parent == null ? b : q.parent;
        }
        return p.data;
    }
}
