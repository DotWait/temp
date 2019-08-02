package com.dotwai;

import com.dotwai.utils.Table;

public class InterploationSearch {
    private static int[] staticOrderTable;

    public static void initTable(int n, int stepLimit) {
        staticOrderTable = Table.staticOrderTable(n, stepLimit);
//        Print.print(staticOrderTable);
    }

    public static int searchKey(int key) {
        int low = 0;
        int high = staticOrderTable.length - 1;
        while (low <= high) {
            int middle = (low + high) * (key - staticOrderTable[low]) / (staticOrderTable[high] - staticOrderTable[low]);
            if (key < staticOrderTable[middle]) {
                high = middle - 1;
            } else if (key > staticOrderTable[middle]) {
                low = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static int getKey(int index) {
        return staticOrderTable[index];
    }
}
