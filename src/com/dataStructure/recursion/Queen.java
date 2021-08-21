package com.dataStructure.recursion;

import java.util.concurrent.ScheduledExecutorService;

public class Queen {
    int max = 8;
    int[] array = new int[max];
    int count = 0;

    public static void main(String[] args) {
        Queen queen = new Queen();
        queen.check(0);
        System.out.println(queen.count);
    }

    public void check(int n) {
        if (n == max) {
            print();
            count++;
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
//                return;
            }
        }
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (array[n] == array[i] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }

    public void print() {
        for (int j : array) System.out.print(j + " ");
        System.out.println();
    }
}
