package top.brucekellan.leetcode;

import java.util.Arrays;


/**
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        boolean[] isUse = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            isUse[i] = true;
            for (int j = 0; j < nums.length; j++) {
                if (isUse[j] == false) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            isUse[i] = false;
        }
        return null;
    }
}
