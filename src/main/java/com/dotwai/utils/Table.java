package com.dotwai.utils;

import java.util.Random;

public class Table {

    private static Random random = new Random();

    public static int[] staticTable(int n, int limit) {
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            table[i] = random.nextInt(limit);
        }
        return table;
    }

    public static int[] staticOrderTable(int n, int stepLimit) {
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                table[i] = random.nextInt(stepLimit);
            } else {
                table[i] = table[i - 1] + random.nextInt(stepLimit);
            }
        }
        return table;
    }
}
