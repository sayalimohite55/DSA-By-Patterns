package com.patterns.twoPointers;

import com.patterns.common.SLLNode;

public class RemoveNthNodeFromEnd {
    static SLLNode removeNthNodeFromEnd_Approach_I(SLLNode head, int n) {
        int totalNodes = 0;
        SLLNode node = head, prev = head;
        while(node != null) {
            totalNodes++;
            node = node.next;
        }

        int nodeIndexToRemove = totalNodes - n;
        if(nodeIndexToRemove == 0) {
            return head.next;
        }

        node = head;
        for(int i=0;i<nodeIndexToRemove; i++) {
            prev = node;
            node = node.next;
        }
        prev.next = node.next;
        return head;
    }

    static SLLNode removeNthNodeFromEnd_Approach_II(SLLNode head, int n) {
        SLLNode p1, p2;
        p1 = p2 = head;

        // Below loop will place p2 n nodes away from p1
        for(int i=0;i<n; i++) {
            p2 = p2.next;
        }

        if(p2 == null)
            return head.next;

        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p1.next = p1.next.next;
        return head;
    }

    public static void main(String[] args) {
        //Approach I - using 2 passes
        SLLNode head = SLLNode.createSLL(new int[]{1,2,3,4,5,6,7,8,9,10});
        SLLNode.printSLL(head);

        head = removeNthNodeFromEnd_Approach_I(head, 3);
        SLLNode.printSLL(head);

        head = removeNthNodeFromEnd_Approach_I(head, 9);
        SLLNode.printSLL(head);

        //Approach II - using single pass
        System.out.println();
        head = SLLNode.createSLL(new int[]{1,2,3,4,5,6,7,8,9,10});
        SLLNode.printSLL(head);

        head = removeNthNodeFromEnd_Approach_II(head, 3);
        SLLNode.printSLL(head);

        head = removeNthNodeFromEnd_Approach_II(head, 9);
        SLLNode.printSLL(head);
    }
}
