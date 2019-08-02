package com.dotwai;

import java.util.ArrayList;
import java.util.List;

public class NQueenSolution {
    private static List<Integer[][]> solutions = new ArrayList<>();
    private static long count = 1;

    public static List<Integer[][]> nQueen(int n) {
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
        tracking(arr, 0, n);
        return solutions;
    }

    private static void tracking(int[][] arr, int i, int n) {
        //第i-1行及以上的所有行都已经放置了queen
        //判断第i行是否超过了数组的最大行数限制，若超过则输出结果
        if (i >= n) {
            System.out.println(count++);
            Integer[][] newArr = new Integer[n][n];
            for (int k = 0; k < n; k++) {
                for (int h = 0; h < n; h++) {
                    newArr[k][h] = arr[k][h];
                }
            }
            solutions.add(newArr);
            return;
        }
        //若不超过则在第i行放置queen
        for (int k = 0; k < n; k++) {
            //在第i行k列放置queen
            arr[i][k] = 1;
            //判断queen的放置是否合理，若合理，进入下一行放置
            if (!conflict(arr, i, k, n)) {
                tracking(arr, i + 1, n);
            }
            //若不合理，拿回queen
            arr[i][k] = 0;
        }
    }

    private static boolean conflict(int[][] arr, int i, int j, int n) {
        return rowConflict(arr, i, j) || colConflict(arr, i, j)
                || leftConflict(arr, i, j) || rightConflict(arr, i, j, n);
    }

    private static boolean rowConflict(int[][] arr, int i, int j) {
        for (int k = 0; k < j; k++) {
            if (arr[i][k] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean colConflict(int[][] arr, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (arr[k][j] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean leftConflict(int[][] arr, int i, int j) {
        for (int k = 1; k <= i; k++) {
            if (leftOutOfIndex(i, j, k)) {
                break;
            }
            if (arr[i - k][j - k] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean leftOutOfIndex(int i, int j, int k) {
        return i - k < 0 || j - k < 0;
    }

    private static boolean rightConflict(int[][] arr, int i, int j, int n) {
        for (int k = 1; k <= i; k++) {
            if (rightOutOfIndex(i, j, k, n)) {
                break;
            }
            if (arr[i - k][j + k] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean rightOutOfIndex(int i, int j, int k, int n) {
        return i - k < 0 || j + k >= n;
    }
}
