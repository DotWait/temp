package com.dotwai;

import com.dotwai.entity.AVLNode;

public class AVLTree {
    private static AVLNode root;
    private static boolean taller = false;
    private static int maxDepth = 0;

    private static void LeftRotate() {
        AVLNode lc = root.getLeftNode();
        root.setLeftNode(lc.getRightNode());
        lc.setRightNode(root);
        root = lc;
    }

    private static void RightRotate() {
        AVLNode rc = root.getRightNode();
        root.setRightNode(rc.getLeftNode());
        rc.setLeftNode(root);
        root = rc;
    }

    public static void insert(AVLNode newNode) {
        int depth = 1;
        if (root == null) {
            root = newNode;
            maxDepth ++;
            return;
        }
        AVLNode node = root;
        AVLNode preNode = root;
        while (node != null) {
            depth++;
            preNode = node;
            if (node.getValue() < newNode.getValue()) {
                node = node.getRightNode();
            } else if (node.getValue() > newNode.getValue()) {
                node = node.getLeftNode();
            } else {
                System.out.println("the node is already exist");
                node.setCount(node.getCount() + 1);
                return;
            }
        }
        if(preNode.getValue() > newNode.getValue()){
            /*insert left node*/
            preNode.setLeftNode(newNode);
            if (depth > maxDepth){
                maxDepth = depth;
                taller = true;
            }
        }else if (preNode.getValue() < newNode.getValue()){
            /*insert right node*/
            preNode.setRightNode(newNode);
            if (depth > maxDepth){
                maxDepth = depth;
                taller = true;
            }
        }else {
            System.out.println("the node is already exist");
            node.setCount(node.getCount() + 1);
            return;
        }

        if (taller){
            
        }
    }
}
