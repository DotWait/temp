package com.dotwai;

import com.dotwai.entity.BinaryNode;

import java.util.Random;

public class BinarySortTree {
    private static BinaryNode root;

    private static Random random = new Random();

    public static BinaryNode getRoot(){
        return root;
    }

    public static void init(int n, int limit){
        for (int i=0;i<n;i++){
            insert(random.nextInt(limit));
        }
    }

    public static void insert(int value){
        if (root == null){
            root = new BinaryNode(value, null, null, null);
            return;
        }
        BinaryNode node = root;
        BinaryNode preNode = node;
        while (node != null){
            preNode = node;
            if (node.getValue() > value){
                node = node.getLeftNode();
            }else if (node.getValue() < value){
                node = node.getRightNode();
            }else{
                return;
            }
        }
        if (preNode.getValue() > value){
            preNode.setLeftNode(new BinaryNode(value, preNode, null, null));
        }else if (preNode.getValue() < value){
            preNode.setRightNode(new BinaryNode(value, preNode, null, null));
        }
    }

    public static BinaryNode search(int key){
        if (root == null){
            return null;
        }
        BinaryNode node = root;
        while (node != null){
            if (node.getValue() > key){
                node = node.getLeftNode();
            }else if (node.getValue() < key){
                node = node.getRightNode();
            }else{
                return node;
            }
        }
        return null;
    }

    public static void delete(int value){
        if (root == null){
            return ;
        }
        BinaryNode node = root;
        while (node != null){
            if (node.getValue() > value){
                node = node.getLeftNode();
            }else if (node.getValue() < value){
                node = node.getRightNode();
            }else{
                break;
            }
        }
        if (node == null){
            return;
        }
        BinaryNode parent = node.getParent();
        if (node.getLeftNode() == null && node.getRightNode() == null){
            /*no child node*/
            if (parent.getLeftNode() != null && parent.getLeftNode().getValue() == node.getValue()){
                parent.setLeftNode(null);
            }else if (parent.getRightNode() != null && parent.getRightNode().getValue() == node.getValue()){
                parent.setRightNode(null);
            }
        }else if (node.getLeftNode() == null || node.getRightNode() == null){
            /*only one child node*/
            BinaryNode child = node.getLeftNode() == null ? node.getRightNode() : node.getLeftNode();
            if (parent.getLeftNode() != null && parent.getLeftNode().getValue() == node.getValue()){
                parent.setLeftNode(child);
                child.setParent(parent);
            }else if (parent.getRightNode() != null && parent.getRightNode().getValue() == node.getValue()){
                parent.setRightNode(child);
                child.setParent(parent);
            }
        }else {
            /*two children*/
            BinaryNode preNode = node.getLeftNode();
            while (preNode.getRightNode() != null){
                preNode = preNode.getRightNode();
            }
            delete(preNode.getValue());
            if (parent.getLeftNode() != null && parent.getLeftNode().getValue() == node.getValue()){
                parent.setLeftNode(preNode);
            }else {
                parent.setRightNode(preNode);
            }
            preNode.setParent(parent);
            preNode.setLeftNode(node.getLeftNode());
            preNode.setRightNode(node.getRightNode());
            if (node.getLeftNode() != null){
                node.getLeftNode().setParent(preNode);
            }
            if (node.getRightNode() != null){
                node.getRightNode().setParent(preNode);
            }
        }
    }

    public static void traverse(){
        BinaryNode node = root;
        inOrderTraverse(node);
    }

    private static void inOrderTraverse(BinaryNode node){
        if (node == null){
            return;
        }
        inOrderTraverse(node.getLeftNode());
        print(node);
        inOrderTraverse(node.getRightNode());
    }

    private static void print(BinaryNode node){
        System.out.println(node.getValue());
    }

    public static void destroy(){
        root = null;
    }

}
