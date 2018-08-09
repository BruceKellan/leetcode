package top.brucekellan.leetcode;

/**
 * 53. Maximum Subarray
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * @Author: 37
 * @Date: Created at 21:36 2018/8/9
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int ans = 0;
        int maxn = Integer.MIN_VALUE;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (ans < 0) {
                ans = 0;
            }
            ans += nums[i];
            maxn = Math.max(maxn, ans);
        }
        return maxn;
    }

}
