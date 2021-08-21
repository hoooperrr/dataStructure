package com.dataStructure.sequence;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Bubble_Select_Insert {
    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
//        bubble(arr);
//        select(arr);
        insert(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr1[i] = (int) (Math.random() * 80000);
        }
//        System.out.println(Arrays.toString(arr));
        Date date1 = new Date();
//        bubbleMy(arr1);
//        select(arr1);
        insert(arr1);
        Date date2 = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = simpleDateFormat.format(date1);
        String s2 = simpleDateFormat.format(date2);
        System.out.println(s1 + '\n' + s2);


    }

    public static void insert(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }

    public static void select(int[] arr) {

        for (int j = 0; j < arr.length - 1; j++) {
            int min = arr[j];
            int minIndex = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            if (min != arr[j]) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
        }
    }

    public static void bubbleMy(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
//            flag = false;
            for (int j = i; j < arr.length; j++) {//遍历过程中遇到的最小的都放在arr[i]
                if (arr[j] < arr[i]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
//            System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(arr));
//            for (int j = 1; j < arr.length; j++) {
//                    if (arr[j] < arr[1]) {
//                        temp = arr[1];
//                        arr[1] = arr[j];
//                        arr[j] = temp;
//                    }
//    } System.out.println(Arrays.toString(arr));}
        }
    }

    public static void bubble(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
