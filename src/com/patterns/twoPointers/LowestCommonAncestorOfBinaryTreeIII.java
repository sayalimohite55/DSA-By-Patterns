package com.patterns.twoPointers;

/*
* Problem Statement :
* You are given two nodes, p and q. The task is to return their lowest common ancestor (LCA).
* Both nodes have a reference to their parent node. The tree’s root is not provided; you must use the parent pointers
* to find the nodes’ common ancestor.
*
* Note: The lowest common ancestor of two nodes, p and q, is the lowest node in the binary tree, with both
* p and q as descendants. In a tree, a descendant of a node is any node reachable by following edges downward from
* that node, including the node itself.
*
* Constraints:
* −10^4 ≤ Node.data ≤ 10^4
* The number of nodes in the tree is in the range [2,500]
* All Node.data are unique.
* p != q
* Both p and q are present in the tree.
* */

import com.patterns.common.FullBinaryTree;

public class LowestCommonAncestorOfBinaryTreeIII {


    public static void main(String[] args) {
        FullBinaryTree.Node tree1 = FullBinaryTree.createBinaryTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
        FullBinaryTree.printBinaryTree_BFS(tree1);
        System.out.println("\n");
        FullBinaryTree.printBinaryTree_BFS_PatternI(tree1);
        System.out.println("\n");
        FullBinaryTree.printBinaryTree_BFS_PatternII(tree1);

        System.out.println("\n\nLCA: " + FullBinaryTree.lowestCommonAncestor(
                FullBinaryTree.findNode(tree1,4), FullBinaryTree.findNode(tree1,7)));

        System.out.println("LCA: " + FullBinaryTree.lowestCommonAncestor(
                FullBinaryTree.findNode(tree1,8), FullBinaryTree.findNode(tree1,11)));

        System.out.println("LCA: " + FullBinaryTree.lowestCommonAncestor(
                FullBinaryTree.findNode(tree1,1), FullBinaryTree.findNode(tree1,11)));

        System.out.println("LCA: " + FullBinaryTree.lowestCommonAncestor(
                FullBinaryTree.findNode(tree1,15), FullBinaryTree.findNode(tree1,6)));
    }
}
