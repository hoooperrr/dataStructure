package com.dataStructure.sequence;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] A, int N) {
        int[] tmpA = new int[N];
        int length = 1;
        while (length < N) {
            mergePass(A, tmpA, N, length);
            length *= 2;
            //前一步的结果倒回A
            mergePass(tmpA, A, N, length);
            length *= 2;
        }
    }

    public static void merge(int[] A, int[] tmpA, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
//        int right = leftEnd + 1;
//        int numElements = rightEnd - left + 1;
        int tmp = left;
//        for (int i = left; i < leftEnd; i++) {
        while (left <= leftEnd && right <= rightEnd) {
            if (A[left] <= A[right]) {
                tmpA[tmp++] = A[left++];
            } else {
                tmpA[tmp++] = A[right++];
            }
        }

        while (left <= leftEnd) {
            tmpA[tmp++] = A[left++];
        }
        while (right <= rightEnd) {
            tmpA[tmp++] = A[right++];
        }
        //递归时需要复制回A，非递归不需要
//        for (int elem : tmpA) {
//            A[left++] = elem;
//        }
    }

    public static void mergePass(int[] A, int[] tmpA, int N, int length) {
        int i;
        for (i = 0; i < N - length * 2; i += 2 * length) {// N - length * 2空出最后一个子列
            merge(A, tmpA, i, i + length, i + length * 2 - 1);
        }
        if (i + length < N) {//表示right开头还有元素,结尾注意！！
            merge(A, tmpA, i, i + length, N - 1);//结尾必须是N-1
        } else {
            if (N - i >= 0)
                System.arraycopy(A, i, tmpA, i, N - i);
//            for (int j = i; j < N; j++) {
//                tmpA[j] = A[j];
//            }
        }
    }

    public static void main(String[] args) {
        int[] A = {2, 5, 9, 87, 6, 28, 41, 5, 10};
        mergeSort(A, A.length);
        System.out.println(Arrays.toString(A));
    }
}
