package com.heap;

import java.util.Arrays;

public class findKthLargest_215 {
    /*
    public static class MaxHeap {
        int size = 0;
        int maxSize;
        int capacity = maxSize;
        int[] elements = new int[maxSize + 1];

        public MaxHeap(int maxSize) {
            this.maxSize = maxSize;
        }

        public Boolean isFull(MaxHeap heap) {
            return size == maxSize;
        }
    }



    //
    public static void percDown(int[] nums, int p) {
        int parent, child;
        int tmp = nums[p];
        for (parent = p; parent * 2 <= nums.length; parent = child) {
            child = parent * 2;
            if (child != nums.length && nums[child] < nums[child + 1]) {
                child++;
            }
            if (tmp >= nums[child]) break;
            else nums[parent] = nums[child];
        }
        nums[parent] = tmp;
    }

    public static void buildHeapPerc(int[] nums) {
        int i;
        for (i = nums.length / 2; i > 0; i--)
            percDown(nums, i);
        System.out.println(Arrays.toString(nums));
    }
    */

    public static int findKthLargest(int[] nums, int k) {
        int size=nums.length;
        int[] heap = buildMaxHeap(nums, size);
        System.out.println(Arrays.toString(heap));
        int max = heap[1];
        for (int i = 1; i < k; i++) {
            deleteMax(heap, size);
            size--;
        }
        System.out.println(Arrays.toString(heap));
        return heap[1];
    }
    //
    public static int[] buildMaxHeap(int[] nums, int size) {
        int[] heap = new int[size + 1];
        int heapSize = 0;
        heap[heapSize] = Integer.MAX_VALUE;
        for (int i : nums) {
//            heap[++heapSize] = i;
            int index = ++heapSize;
            for (; i > heap[index / 2]; index = index / 2) {
                heap[index] = heap[index / 2];
            }
            heap[index] = i;
        }
        return heap;
    }

    public static void deleteMax(int[] nums, int size) {
        int parent, child;
        int tmp = nums[size];
        for (parent = 1; parent * 2 <= size; parent = child) {
            child = parent * 2;
            if ((child != size) && nums[child] < nums[child + 1]) {
                child++;
            }
            if (tmp >= nums[child]) break;
            else nums[parent] = nums[child];
        }
        nums[parent] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
}
