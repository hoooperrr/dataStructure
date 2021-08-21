package com.dataStructure.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        boolean loop = true;
        ArrayQueue queue = new ArrayQueue(10);
        Scanner scanner = new Scanner(System.in);
        char input = ' ';
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            input = scanner.next().charAt(0); //接收一个字符
            switch (input){
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

    static class ArrayQueue {
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

        public void addData(int n) {
            if (isFull()) {
                System.out.println("isFull");
                return;
            }
            rear++;
            arr[rear] = n;
        }

        public Boolean isEmpty() {
            return rear == front;
        }

        public int getData() {
            if (isEmpty()) {
//                System.out.println("isEmpty");
                throw new RuntimeException("isEmpty");
            }
            front++;
            return arr[front];
        }

        public void showQueue() {
            if (isEmpty()) {
//                System.out.println("isEmpty");
                return;
            }
//            for (int i : arr) {
//                System.out.println(i);
//            }
            for (int i = 0; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }

        public int headQueue() {
            if (isEmpty()) {
//                System.out.println("isEmpty");
                throw new RuntimeException("isEmpty");
            }
            return arr[front + 1];
        }
    }
}
