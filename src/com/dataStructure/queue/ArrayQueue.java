package com.dataStructure.queue;

public class ArrayQueue {

    private int rear;
    private int front;
    private int maxSize;
    private int[] arr;

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    public Boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addData() {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);

    }
}
