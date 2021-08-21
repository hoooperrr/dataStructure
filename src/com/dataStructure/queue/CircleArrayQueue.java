package com.dataStructure.queue;

import java.util.Scanner;

public class CircleArrayQueue {
    private int rear;
    private int front;
    private int maxSize;
    private int[] arr;

    public CircleArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }

    public Boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addData(int n) {
        if (isFull()) {
            System.out.println("isFull");
            return;
        }
//        rear++;
//        arr[(rear + maxSize) % maxSize] = n;
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public Boolean isEmpty() {
        return rear % maxSize == front;
    }

    public int getData() {
        if (isEmpty()) {
//                System.out.println("isEmpty");
            throw new RuntimeException("isEmpty");
        }
//        front++;
//        return arr[front % maxSize];
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if (isEmpty()) {
//                System.out.println("isEmpty");
            return;
        }
//            for (int i : arr) {
//                System.out.println(i);
//            }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
//                System.out.println("isEmpty");
            throw new RuntimeException("isEmpty");
        }
        return arr[front];
    }

    public static void main(String[] args) {
        boolean loop = true;
        CircleArrayQueue queue = new CircleArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char input = ' ';
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            input = scanner.next().charAt(0); //接收一个字符
            switch (input) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addData(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getData();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
    }

}
