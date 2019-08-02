package com.dotwai;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    private static List<Integer[][]> solutions = new ArrayList<>();
    private static int[][] arr;

    public static List<Integer[][]> nQueen(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
        tracking(arr, 0, 0);
        return solutions;
    }

    private static void tracking(int[][] arr, int i, int j) {
        System.out.println("i=" + i + ",j=" + j);
        /*满足条件的解法*/
        if (i >= arr.length) {
            System.out.println(1);
            Integer[][] newArr = new Integer[arr.length][arr.length];
            for (int k = 0; k < arr.length; k++) {
                for (int h = 0; h < arr.length; h++) {
                    newArr[k][h] = arr[k][h];
                }
            }
            solutions.add(newArr);
            return;
        }
        /*在第i行上依次放上queen*/
        for (int k = 0; k < arr[0].length; k++) {
            System.out.println("这是第" + i + "行");
            /*放置queen*/
            arr[i][k] = 1;
            /*判断是否冲突*/
            if (!conflict(arr, i, k)) {
                tracking(arr, i + 1, k);
            }
            /*去除放置的queen*/
            arr[i][k] = 0;
        }
    }

    private static boolean conflict(int[][] arr, int i, int j) {
        if (rowSum(arr, i) > 1) {
            return true;
        }
        if (colSum(arr, j) > 1) {
            return true;
        }
        if (leftObliqueSum(arr, i, j) > 1) {
            return true;
        }
        if (rightObliqueSum(arr, i, j) > 1) {
            return true;
        }
        return false;
    }

    private static int rowSum(int[][] arr, int i) {
        int sum = 0;
        for (int k = 0; k < arr[i].length; k++) {
            sum += arr[i][k];
        }
        return sum;
    }

    private static int colSum(int[][] arr, int j) {
        int sum = 0;
        for (int k = 0; k < arr[j].length; k++) {
            sum += arr[k][j];
        }
        return sum;
    }

    private static int leftObliqueSum(int[][] arr, int i, int j) {
        int sum = 0;
        if (i <= j) {
            for (int k = 0; k < i; k++) {
                sum += arr[i - k][j - k];
            }
        } else {
            for (int k = 0; k < j; k++) {
                sum += arr[i - k][j - k];
            }
        }
        return sum;
    }

    private static int rightObliqueSum(int[][] arr, int i, int j) {
        System.out.println("rightOblique:i=" + i + ",j=" + j);
        int sum = 0;
        if (i <= j) {
            for (int k = 0; k < i; k++) {
                if (i - k >= 0 && j + k < arr[i].length) {
                    sum += arr[i - k][j + k];
                }
            }
        } else {
            for (int k = 0; k < j; k++) {
                if (i - k >= 0 && j + k < arr[i].length) {
                    sum += arr[i - k][j + k];
                }
            }
        }
        return sum;
    }
}
