package top.brucekellan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @Author: 37
 * @Date: Created at 21:05 2018/8/27
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result  = new ArrayList<>();
        resolve(result, nums, 0);
        return result;
    }

    private void resolve(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num: nums) {
                temp.add(num);
            }
            result.add(temp);
        }
        for(int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            resolve(result, nums, index + 1);
            swap(nums, index, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
