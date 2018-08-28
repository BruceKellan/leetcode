package top.brucekellan.leetcode;

import java.util.*;

/**
 * 47. Permutations II
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * Example:
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 *
 * @Author: 37
 * @Date: Created at 21:14 2018/8/28
 */
public class PermutationsII {


    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<String> set = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        resolve(set, result, nums, 0);
        return result;
    }

    private void resolve(Set<String> set, List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                stringBuilder = stringBuilder.append(nums[i]).append(":");
            }
            if (!set.contains(stringBuilder.toString())) {
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < nums.length; i++) {
                    temp.add(nums[i]);
                }
                result.add(temp);
                set.add(stringBuilder.toString());
                return;
            } else {
                return;
            }
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            resolve(set, result, nums, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
