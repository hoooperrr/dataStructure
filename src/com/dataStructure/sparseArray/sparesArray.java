package com.dataStructure.sparseArray;

public class sparesArray {
    public static void main(String[] args) {
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] arr : chessArr1) {
            for (int chess : arr) {
                System.out.printf("%d\t", chess);
            }
            System.out.println("\n");
        }

        int sum = 0;
        for (int[] arr : chessArr1) {
            for (int chess : arr) {
                if (chess != 0) sum++;
            }
        }

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        sparseArr[0][2] = count;

        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //===============恢复数组======================
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] arr : chessArr2) {
            for (int chess : arr) {
                System.out.printf("%d\t", chess);
            }
            System.out.println("\n");
        }
    }
}
