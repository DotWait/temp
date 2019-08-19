package com.dotwai;

import com.dotwai.entity.AVLNode;

public class AVLTree {
    private static AVLNode root;
    private static boolean taller = false;
    private static int maxDepth = 0;

    private static final int LH = 1;
    private static final int EH = 0;
    private static final int RH = -1;

    private static final int LEFT = 1;
    private static final int RIGHT = 2;

    private static int firstDirect = 0;
    private static int secondDirect = 0;

    public static AVLNode getRoot(){
        return root;
    }

    public static int getDepth(){
        return maxDepth;
    }

    private static AVLNode leftRotate(AVLNode root) {
        AVLNode lc = root.getLeftNode();
        root.setLeftNode(lc.getRightNode());
        lc.setRightNode(root);
        return lc;
    }

    private static AVLNode rightRotate(AVLNode root) {
        AVLNode rc = root.getRightNode();
        root.setRightNode(rc.getLeftNode());
        rc.setLeftNode(root);
        return rc;
    }

    public static void insert(AVLNode newNode) {
        firstDirect = 0;
        secondDirect = 0;
        int depth = 1;
        if (root == null) {
            root = newNode;
            maxDepth++;
            root.setBf(EH);
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
        depth++;
        if (maxDepth < depth){
            maxDepth = depth;
        }
        if (preNode.getValue() > newNode.getValue()) {
            /*insert left node*/
            preNode.setLeftNode(newNode);
            AVLNode balance = bfCalculate(newNode);
            if (balance != null){
                //判断旋转方式
                AVLNode balanceRoot = balance(balance);
                if (balanceRoot!= null){
                    while (balanceRoot.getParent() != null){
                        balanceRoot = balanceRoot.getParent();
                    }
                    root = balanceRoot;
                }
            }
        } else if (preNode.getValue() < newNode.getValue()) {
            /*insert right node*/
            preNode.setRightNode(newNode);
            AVLNode balance = bfCalculate(newNode);
            if (balance != null){
                //判断旋转方式
                AVLNode balanceRoot = balance(balance);
                if (balanceRoot!= null){
                    while (balanceRoot.getParent() != null){
                        balanceRoot = balanceRoot.getParent();
                    }
                    root = balanceRoot;
                }
            }
        } else {
            System.out.println("the node is already exist");
            node.setCount(node.getCount() + 1);
        }
    }

    private static AVLNode bfCalculate(AVLNode node) {
        AVLNode parent = node.getParent();
        while (parent != null) {
            if (parent.getValue() > node.getValue()) {
                secondDirect = firstDirect;
                firstDirect = LEFT;
                int bf = parent.getBf() + LH;
                parent.setBf(bf);
                if (bf >= 2) {
                    return parent;
                }
            } else {
                secondDirect = firstDirect;
                firstDirect = RIGHT;
                int bf = parent.getBf() + RH;
                parent.setBf(bf);
                if (bf <= -2) {
                    return parent;
                }
            }
            node = parent;
            parent = node.getParent();
        }
        return null;
    }

    private static AVLNode balance(AVLNode node){
        if (firstDirect == LEFT){
            if (secondDirect == LEFT){
                /*一次左旋*/
                return leftRotate(node);
            }else if (secondDirect == RIGHT){
                /*先右旋，再左旋*/
                return leftRotate(rightRotate(node));
            }else {
                return null;
            }
        }else if (firstDirect == RIGHT){
            if (secondDirect == RIGHT){
                /*一次右旋*/
                return rightRotate(node);
            }else if (secondDirect == LEFT){
                /*先左旋，再右旋*/
                return rightRotate(leftRotate(node));
            }else {
                return null;
            }
        }else {
            return null;
        }
    }
}
