package top.brucekellan.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class FindFirstAndLastPositionOfElementInSortedArrayTest {

    @Test
    public void searchRange() {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(
                new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, 8)));
    }
}