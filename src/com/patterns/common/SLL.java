package com.patterns.common;

public class SLL {
    public static class Node {
        public int data;
        public Node next;

        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    public static Node createSLL(int[] input) {
        Node head = null, newNode, current = null;

        for(int val : input) {
            newNode = new Node(val);
            if(head == null) {
                head = current = newNode;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }
        return head;
    }

    public static void printSLL(Node node) {
        System.out.println("\nSingly Linked List : ");
        while(node != null) {
            System.out.print("->" + node.data);
            node = node.next;
        }
    }
}

