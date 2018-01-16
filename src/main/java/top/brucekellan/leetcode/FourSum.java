package top.brucekellan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author brucekellan
 * @create 2018-01-16
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        while(i < nums.length - 3) {
            int j = i + 1;
            while(j < nums.length - 2) {
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left++], nums[right--]));
                        while (left < right && nums[left] == nums[left - 1]) {
                            ++left;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            --right;
                        }
                    } else if (sum < target) {
                        ++left;
                    } else {
                        --right;
                    }
                }
                while (nums[j] == nums[++j] && j < nums.length - 2) ;
            }
            while(nums[i] == nums[++i] && i < nums.length - 3);
        }
        return list;
    }

}
