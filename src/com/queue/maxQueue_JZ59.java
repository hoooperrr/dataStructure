package com.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class maxQueue_JZ59 {
    static class MaxQueue {
        List<Integer> queue;
        LinkedList<Integer> queueMax;
        int maxValue;
        int front;
        int rear;
        int maxIndex;

        public MaxQueue() {
            this.queue = new ArrayList<Integer>();
            this.front = -1;
            this.rear = -1;
            this.maxValue = -1;
            this.maxIndex = front;
        }

        public int max_value() {
            if (front == rear) { //队列空
                return -1;
            }
            maxValue = queue.get(front + 1);
            for (int i = front + 1; i <= rear; ++i) {
                maxValue = queue.get(i) < maxValue ? maxValue : queue.get(i);
            }
            return maxValue;
        }

        public void push_back(int value) {
            queue.add(value);
            ++this.rear;
            //O1
//            if (value > maxValue) {
//                maxIndex = rear;
//                queueMax.add(value);
//            }
//            if (value > maxValue) maxValue = value;
        }

        public int pop_front() {
            if (front == rear) {//队列空
                return -1;
            }
            int pop = queue.get(++this.front);

//            if (front == maxIndex) {
//                queueMax.removeFirst();
//            }
            return pop;
        }
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        int value = 1;
        obj.push_back(1);
        obj.push_back(2);
        obj.push_back(3);
        int param_3 = obj.pop_front();
        System.out.println(param_3);
        System.out.println(obj.max_value());
    }
}
