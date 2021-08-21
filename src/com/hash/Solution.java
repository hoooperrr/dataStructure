package com.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        result = new int[]{i, j};
                    }
                }
            }
        }
        return result;
    }

    public int[] twoSumHash(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[]{hm.get(target - nums[i]), i};
            }
            hm.put(nums[i],i); //
        }
        return new int[0];
    }




    public static void main(String[] args) {
        System.out.println("nums = ");
        Scanner scanner = new Scanner(System.in);
        String as = scanner.nextLine();
        System.out.println(as);

        String pattern = "\\[((\\num)(\\,))*(\\num)(\\])";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(as);
        if (m.find()) {
            System.out.println("Found value: " + m.group(0));
            System.out.println("Found value: " + m.group(1));
            System.out.println("Found value: " + m.group(2));
            System.out.println("Found value: " + m.group(3));
        } else {
            System.out.println("NO MATCH");
        }
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        System.out.println(scanner.nextInt());
        ArrayList<Integer> intArr = new ArrayList<Integer>();

        String s = scanner.nextLine();
        int i = 0;
        intArr.add(i);

        int[] ints = {};
        i = 0;
        for (Integer integer : intArr) {
            ints[i] = Integer.valueOf(integer);
            i++;
        }
        System.out.println(ints);
        System.out.println("target = ");
        int target = scanner.nextInt();

//        new Solution().twoSum(ints, target);
    }
}
