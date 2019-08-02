package com.dotwai.utils;

import com.dotwai.entity.BinaryNode;

import java.util.*;

public class Print {
    private static final int LEFT = 0;
    private static final int RIGHT = 1;
    private static int col = 0;
    private static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(-2,"|");
        map.put(-3,"——");
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*public static void printTree(BinaryNode root, int deep){
        double pow = Math.pow(2, deep - 1);
        int length = (int) pow * 2 - 1;
        Integer[][] arr = new Integer[deep][length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int flagCount = 0;
        for (int i=0;i<arr.length;i++){
            flagCount = (int) Math.pow(2, i);
            int step = (int) Math.pow(2, flagCount * (-1)) * length;
            if (stack.isEmpty()){
                stack.push(step);
                arr[i][step] = root.getValue();
            }else {
                while (!stack.isEmpty()){
                    Integer pos = stack.pop();
                    temp.push(pos-step);
                    temp.push(pos+step);
                    arr[i][pos-step] = root.
                }
            }
        }
    }*/

    public static void print(int[][] arr) {
        System.out.println("=========================");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    System.out.print("\t");
                } else {
                    System.out.print(arr[i][j] + "\t");
                }
            }
            System.out.println();
        }
        System.out.println("=========================");
    }
    
    /*public static void printBinaryTree(BinaryNode root, int deep){
        int lastLayerNodeNum = (int) Math.pow(2, deep - 1);
        int lastLayerArrayNum = lastLayerNodeNum * 2;
        int[][] treeArr = new int[deep][lastLayerArrayNum];
        List<Record> records = new ArrayList<>();
        traverse(treeArr, records, root, 0, lastLayerArrayNum);
        print(treeArr);
    }

    static class Record{
        private int deep;
        private int direction;

        public Record(int deep, int direction) {
            this.deep = deep;
            this.direction = direction;
        }

        public int getDeep() {
            return deep;
        }

        public void setDeep(int deep) {
            this.deep = deep;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }
    }

    private static void traverse(int[][] treeArr, List<Record> records, BinaryNode node, int deep, int length){
        if (node == null){
            return;
        }
        records.add(new Record(deep, LEFT));
        traverse(treeArr, records, node.getLeftNode(), deep + 1, length);
        saveNode(treeArr, records, node, deep, length);
        records.remove(records.size() - 1);
        records.add(new Record(deep, RIGHT));
        traverse(treeArr, records, node.getRightNode(), deep + 1, length);
        records.remove(records.size() - 1);
    }

    private static void saveNode(int[][] treeArr, List<Record> records, BinaryNode node, int deep, int length){
        int totalStep = getTotalStep(records, length);
        treeArr[deep][totalStep] = node.getValue();
    }

    private static int getTotalStep(List<Record> records, int length){
        int totalStep = length;
        for (Record record : records){
            if(record.getDirection() == 1){
                totalStep += length / (int) Math.pow(2, record.getDeep() + 1);
            }else {
                totalStep -= length / (int) Math.pow(2, record.getDeep() + 1);
            }
        }
        return totalStep;
    }*/

    /**
     * 横向打印
     *
     * @param root
     */
    public static void printBinaryTree(BinaryNode root) {
        traverse(root, 0);
    }

    private static void traverse(BinaryNode node, int deep) {
        if (node == null) {
            return;
        }
        traverse(node.getLeftNode(), deep + 1);
        printNode(node, deep);
        traverse(node.getRightNode(), deep + 1);
    }

    private static void printNode(BinaryNode node, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("\t");
        }
        System.out.println(node.getValue());
    }

    public static void printBinaryTree(BinaryNode root, int deep) {
        col = 0;
        int lastLayerNodeNum = (int) Math.pow(2, deep - 1);
        int[][] treeArr = new int[deep][lastLayerNodeNum * 2];
        traverse(root, treeArr, 0);
        print(treeArr);
//        printBinarySortTree(treeArr);
    }

    private static void traverse(BinaryNode node, int[][] treeArr, int deep) {
        if (node == null) {
            return;
        }
        traverse(node.getLeftNode(), treeArr, deep + 1);
        saveNode(node, treeArr, deep);
        traverse(node.getRightNode(), treeArr, deep + 1);
    }

    private static void saveNode(BinaryNode node, int[][] treeArr, int deep) {
        treeArr[deep][col++] = node.getValue();
    }

   /* public static void printBinarySortTree(int[][] tree) {
        for (int i = 1; i < tree.length; i++) {
            for (int j = 0; j < tree[0].length; j++) {
                if (tree[i][j] != 0) {
                    int left = -1;
                    int right = -1;
                    int k = -1;
                    int g = -1;
                    for (k = j; k >= 0; k--) {
                        if (tree[i - 1][k] != 0) {
                            left = tree[i - 1][k];
                            break;
                        }
                    }
                    for (g = j; g < tree[0].length; g++) {
                        if (tree[i - 1][g] != 0) {
                            right = tree[i - 1][g];
                            break;
                        }
                    }
                    if (left == -1) {
                        drawLineRight(tree, i, j, i-1, g);
                    }
                    if (right == -1){
                        drawLineLeft(tree, i, j, i-1, k);
                    }
                    if (left != -1 && right != -1){
                        for (int h=left;h<right;h++){
                            if (tree[i-2][h] != 0){
                                if (tree[i-2][h] < tree[i][j]){
                                    drawLineRight(tree, i, j, i-1, g);
                                }else {
                                    drawLineLeft(tree, i, j, i-1, k);
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }

        for (int i=0;i<tree.length;i++){
            for (int j=0;j<tree[0].length;j++){
                if(tree[i][j] == 0){
                    System.out.print("  ");
                }else if (tree[i][j] == -2){
                    System.out.print(map.get(-2));
                }else if (tree[i][j] == -3){
                    System.out.print(map.get(-3));
                }else {
                    System.out.print(tree[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void drawLineRight(int[][] tree, int currentX, int currentY, int lastX, int lastY){
        tree[lastX][currentY] = -2;
        for (int i=currentY+1;i<lastY;i++){
            tree[lastX][i] = -3;
        }
    }

    private static void drawLineLeft(int[][] tree, int currentX, int currentY, int lastX, int lastY){
        tree[lastX][currentY] = -2;
        for (int i=lastY+1;i<currentY;i++){
            tree[lastX][i] = -3;
        }
    }*/
}
