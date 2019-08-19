package com.dotwai.entity;

public class AVLNode {
    private int value;
    private int count;
    private int deep;
    private int bf;
    private AVLNode parent;
    private AVLNode leftNode;
    private AVLNode rightNode;

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public AVLNode getParent() {
        return parent;
    }

    public void setParent(AVLNode parent) {
        this.parent = parent;
    }

    public AVLNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(AVLNode leftNode) {
        this.leftNode = leftNode;
    }

    public AVLNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(AVLNode rightNode) {
        this.rightNode = rightNode;
    }
}
