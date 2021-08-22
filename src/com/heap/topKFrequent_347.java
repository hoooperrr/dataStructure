package com.heap;

import java.util.*;

public class topKFrequent_347 {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            if (numMap.containsKey(num)) numMap.put(num, numMap.get(num) + 1);
            else numMap.put(num, 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return numMap.get(o1) - numMap.get(o2);
            }
        });
        for (Integer num : numMap.keySet()) {
            if (heap.size() < k) {
                heap.add(num);
            }
            if (numMap.get(num) > heap.peek()) {
                heap.remove();
                heap.add(num);
            }
        }

        int[] result = new int[heap.size()];
        int i = 0;
        for (Integer getK : heap) {
            result[i++]=getK;
        }
//        可以替换成result.addAll(heap);
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 4, 5, 1};
        System.out.println(topKFrequent(nums, 1));
    }
}
