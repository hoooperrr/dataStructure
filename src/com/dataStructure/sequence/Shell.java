package com.dataStructure.sequence;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Shell {
    public static void shell(int[] arr) {
        int gap;
        int n = 1;
        for (gap = arr.length / 2 / n; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
//                System.out.println(Arrays.toString(arr));
            }
//            System.out.println();
        }
    }

    public static void shell1(int[] arr) {
        int insertIndex = 0;
        int insertValue = 0;
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
//                for (int j = i - gap; j >= 0; j -= gap) {
                insertValue = arr[i];
                insertIndex = i;
                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {
                    arr[insertIndex] = arr[insertIndex - gap];
                    insertIndex -= gap;//这一位置的已经在上一句被挪到后面
                }
                if (insertIndex != i) {
                    arr[insertIndex] = insertValue;
                }
//                }
            }
        }
    }


    public static void main(String[] args) {
        int arr[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shell1(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 80000);
        }
//        System.out.println(Arrays.toString(arr));
        Date date1 = new Date();
        shell1(arr1);
        Date date2 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s1 + '\n' + s2);

    }
}
