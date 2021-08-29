package com.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxQueue {
    /*
    LinkedList<Integer> list;
    int cnt;
    int max;
    public MaxQueue() {
        list = new LinkedList<>();
        cnt = 0;
        max = -1;
    }

    public int max_value() {
        if(cnt>0){
            return max;
        }
        else if(list.size()>0){
            return list.peek();
        }
        else {
            return -1;
        }
    }

    public void push_back(int value) {
        if(value>=max){
            cnt=list.size()+1;
            max=value;
        }
        list.add(value);
    }

    public int pop_front() {
        if(cnt>0){
            cnt--;
        }
        else {
            max=-1;
        }
        return list.size()>0?list.pop():-1;
    }

    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        mq.push_back(4);
        mq.push_back(2);
        mq.push_back(3);
        mq.push_back(2);
        mq.push_back(1);
        System.out.println("max:"+mq.max_value());
        System.out.println("pop:"+mq.pop_front());
        System.out.println("max:"+mq.max_value());
        System.out.println("pop:"+mq.pop_front());
        System.out.println("max:"+mq.max_value());
        System.out.println("pop:"+mq.pop_front());
        System.out.println("max:"+mq.max_value());
        System.out.println("pop:"+mq.pop_front());
        System.out.println("max:"+mq.max_value());
        System.out.println("pop:"+mq.pop_front());
    }
     */
    LinkedList<Integer> list;
    LinkedList<Integer> maxList;

    public MaxQueue() {
        list = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value() {
        return list.size() > 0 ? maxList.peek() : -1;
    }

    public void push_back(int value) {
        while (maxList.size() > 0 && maxList.peekLast() < value) {
            maxList.pollLast();
        }
        list.add(value);
        maxList.add(value);
    }

    public int pop_front() {
        if (list.size() == 0) {
            return -1;
        }
        if (list.peekFirst() == maxList.peekFirst()) {
            maxList.pop();
        }
        return list.pop();
    }
}



