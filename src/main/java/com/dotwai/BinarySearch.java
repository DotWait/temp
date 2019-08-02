package com.dotwai;

import com.dotwai.utils.Table;

public class BinarySearch {
    private static int[] staticOrderTable;

    public static void initTable(int n, int stepLimit) {
        staticOrderTable = Table.staticOrderTable(n, stepLimit);
//        Print.print(staticOrderTable);
    }

    public static int searchKey(int key) {
        int low = 0;
        int high = staticOrderTable.length-1;
        while (low <= high) {
            int middle = (low + high) / 2;
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

    public static int getKey(int index){
        return staticOrderTable[index];
    }

    public static int searchKeyRecursive(int key, int low, int high){
        if (low > high){
            return -1;
        }
        int middle = (low + high) >> 1;
        if (key < staticOrderTable[middle]) {
            return searchKeyRecursive(key, low , middle -1);
        } else if (key > staticOrderTable[middle]) {
            return searchKeyRecursive(key , middle+1, high);
        } else {
            return middle;
        }
    }
}
