package com.patterns.common;

public class SLLNode {
    public int data;
    public SLLNode next;

    public SLLNode(int val) {
        this.data = val;
        this.next = null;
    }

    public static SLLNode createSLL(int[] input) {
        SLLNode head = null, newNode, current = null;

        for(int val : input) {
            newNode = new SLLNode(val);
            if(head == null) {
                head = current = newNode;
            } else {
                current.next = newNode;
                current = current.next;
            }
        }
        return head;
    }

    public static void printSLL(SLLNode node) {
        System.out.println("\nSingly Linked List : ");
        while(node != null) {
            System.out.print("->" + node.data);
            node = node.next;
        }
    }
}

