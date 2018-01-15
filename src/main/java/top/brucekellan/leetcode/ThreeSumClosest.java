package top.brucekellan.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * @author brucekellan
 * @create 2018-01-10
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int newDiff = Math.abs(sum - target);
                if (newDiff < diff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target)
                    start++;
                else
                    end--;
            }
        }
        return closest;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        System.out.println(
                new ThreeSumClosest().threeSumClosest(nums, 1));
    }

}
