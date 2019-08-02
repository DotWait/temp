package com.dotwai;

import com.dotwai.utils.Print;
import com.dotwai.utils.Table;

public class FibonacciSearch {
    private static int[] staticOrderTable;

    private static int[] fibonacciSeq;

    public static void initTable(int n, int stepLimit) {
        staticOrderTable = Table.staticOrderTable(n, stepLimit);
        System.out.println("the :" + staticOrderTable[5000]);
        generate(25);
//        Print.print(staticOrderTable);
    }

    public static int[] generate(int n) {
        fibonacciSeq = new int[n];
        fibonacci(fibonacciSeq, n - 1);
        return fibonacciSeq;
    }

    private static int fibonacci(int[] arr, int i) {
        if (i <= 1) {
            arr[i] = 1;
            return arr[i];
        }
        arr[i] = fibonacci(arr, i - 1) + fibonacci(arr, i - 2);
        return arr[i];
    }

    public static int searchKey(int key) {
        if (staticOrderTable == null) {
            return -1;
        }
        int fIndex = getFibonacci(staticOrderTable.length);
        int fLength = fibonacciSeq[fIndex] - 1;
        int sLength = staticOrderTable.length;
        /*填充空余空间*/
        int[] newTable = staticOrderTable;
        if (fLength > sLength) {
            newTable = new int[fLength];
            for (int i = 0; i < sLength; i++) {
                newTable[i] = staticOrderTable[i];
            }
            for (int i = sLength; i < fLength; i++) {
                newTable[i] = staticOrderTable[staticOrderTable.length - 1];
            }
        }

        int low = 0;
        int high = fibonacciSeq[fIndex] - 1;
        while (low <= high) {
            int middle = low + fibonacciSeq[fIndex - 1] - 1;
            System.out.println("fIndex:" + fIndex);
            System.out.println("middle:" + middle);
            if (key < newTable[middle]) {
                high = middle - 1;
                fIndex = fIndex - 1;
            } else if (key > newTable[middle]) {
                low = middle + 1;
                fIndex = fIndex - 2;
            } else {
                if (middle <= high) {
                    return middle;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }

    private static int getFibonacci(int n) {
        for (int i = 0; i < fibonacciSeq.length; i++) {
            if (fibonacciSeq[i] >= n) {
                return i;
            }
        }
        return -1;
    }

    public static int getKey(int index) {
        return staticOrderTable[index];
    }
}
