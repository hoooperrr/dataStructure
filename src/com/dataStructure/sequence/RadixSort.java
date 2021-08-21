package com.dataStructure.sequence;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void radixSort3(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];

        for (int i = 0; i < arr.length; i++) {
            int digit0 = arr[i] % 10;
            bucket[digit0][bucketElementCount[digit0]++] = arr[i];
        }

        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i].length > 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
        }

        //2.
        Arrays.fill(bucketElementCount, 0);

        for (int i = 0; i < arr.length; i++) {
            int digit1 = (arr[i] % 100) / 10;
            bucket[digit1][bucketElementCount[digit1]++] = arr[i];
        }

        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i].length > 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
        }

        //3.
        Arrays.fill(bucketElementCount, 0);

        for (int i = 0; i < arr.length; i++) {
            int digit2 = (arr[i] % 1000 - arr[i] % 100) / 100;
            bucket[digit2][bucketElementCount[digit2]++] = arr[i];
        }

        index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i].length > 0) {
                for (int j = 0; j < bucketElementCount[i]; j++) {
                    arr[index++] = bucket[i][j];
                }
            }
        }


    }

    public static void radixSort(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] bucketElementCount = new int[10];
        int maxLength = 3;

        for (int p = 0, n = 1; p < maxLength; p++, n *= 10) {
                for (int i = 0; i < arr.length; i++) {
                    int digit0 = arr[i] / n % 10;
                    bucket[digit0][bucketElementCount[digit0]++] = arr[i];
                }

                int index = 0;
                for (int i = 0; i < bucketElementCount.length; i++) {
                    if (bucketElementCount[i] > 0) {
                        for (int j = 0; j < bucketElementCount[i]; j++) {
                            arr[index++] = bucket[i][j];
                        }
                    }
                }
                Arrays.fill(bucketElementCount, 0);
            }

    }

    public static void main(String[] args) {
        int[] arr1 = {53, 3, 542, 748, 14, 214};
        radixSort(arr1);

        System.out.println("基数排序后 " + Arrays.toString(arr1));

        // 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
//        int[] arr = new int[8000000];
//        for (int i = 0; i < 8000000; i++) {
//            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//        }
//        System.out.println("排序前");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
////
//        radixSort(arr);
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序前的时间是=" + date2Str);

//        System.out.println("基数排序后 " + Arrays.toString(arr1));
    }
}
