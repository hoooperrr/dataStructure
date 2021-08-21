package com.dataStructure.sequence;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = arr[left];
            int i = left, j = right;
            while (i < j) {
                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && arr[i] <= pivot) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = pivot;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }

    public static void quickSort1(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        int l = left;
        int r = right;
        int temp;
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) break;

            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //避免死循环，让l有机会大于r
            //与基准相等就跳过，继续判断下一个
            if (arr[r] == pivot) {
                l++;
            }
            if (arr[l] == pivot) {
                r--;
            }
        }

        //l与r相等 粗开，不错开一直满足上面的条件 无法退出
        if (l == r) {
            l++;
            r--;
        }

        if (left < r) {
            quickSort1(arr, left, r);
        }
        if (l < right) {
            quickSort1(arr, l, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 15, 25, 15, 15, 23, 8, 14, 0};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
