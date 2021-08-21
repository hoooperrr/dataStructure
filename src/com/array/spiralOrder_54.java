package com.array;

import com.linkedlist.reverseList_206;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int left = 0;
        int right = matrix[top].length - 1;
        int bottom = matrix.length - 1;
        List<Integer> list = new ArrayList<>();
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; ++i) {
                list.add(matrix[top][i]);
            }
            for (int i = top + 1; i <= bottom; ++i) {
                list.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {//!!!!!!!!!!!
                for (int i = right - 1; i >= left + 1; --i) {
                    list.add(matrix[bottom][i]);
                }
                for (int i = bottom; i >= top + 1; --i) {
                    list.add(matrix[i][left]);
                }
            }
            top += 1;
            right -= 1;
            left += 1;
            bottom -= 1;
//            while (top == bottom) {
//                for (int i = left; i <= right; ++i) {
//                    list.add(matrix[top][i]);
//                }
//                bottom -= 1;
//                top += 1;
//            }
        }
        return list;
    }

    public static List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }


    public static void main(String[] args) {
        int[][] matrix = {{3}, {2}};
        List<Integer> list = spiralOrder(matrix);
        list.forEach(System.out::println);
    }

}
