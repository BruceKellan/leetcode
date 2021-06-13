package top.brucekellan.base;

import java.util.Arrays;

public class InsertionSort {
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int tmp = nums[i];
            int j = 0;
            for (j = i - 1; j >= 0 && nums[j] > nums[i]; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = tmp;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 9, 5, 8};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
