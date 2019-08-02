package com.dotwai.entity;

public class BinaryNode {
    private int value;
    private BinaryNode parent;
    private BinaryNode leftNode;
    private BinaryNode rightNode;

    public BinaryNode(int value, BinaryNode parent, BinaryNode leftNode, BinaryNode rightNode) {
        this.value = value;
        this.parent = parent;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryNode getParent() {
        return parent;
    }

    public void setParent(BinaryNode parent) {
        this.parent = parent;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "value=" + value +
                '}';
    }
}
