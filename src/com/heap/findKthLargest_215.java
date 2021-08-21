package com.heap;

public class findKthLargest_215 {
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

    public int findKthLargest(int[] nums, int k) {
        buildMaxHeap(nums, nums.length);

        MaxHeap maxHeap = new MaxHeap(10 ^ 4);
//        if(maxHeap.isFull(maxHeap)) return;
        int index = ++maxHeap.size;

        for (int i : nums) {
            maxHeap.elements[maxHeap.size++] = i;

        }


    }

    public void buildMaxHeap(int[] nums, int size) {
        int[] heap = new int[size];
        int heapsize = 0;
        heap[0] = 10 ^ 4;
        for (int i : nums) {
            heap[++heapsize] = i;
            int index = heapsize;
            if (heap[index] > heap[index / 2]) {
                int tmp = heap[index / 2];
                heap[index / 2] = heap[index];
                heap[index] = tmp;
            }
        }
    }
}
