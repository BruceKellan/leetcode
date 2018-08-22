package top.brucekellan.leetcode;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 41. First Missing Positive
 * Given an unsorted integer array, find the smallest missing positive integer.
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 * @Author: 37
 * @Date: Created at 18:03 2018/8/22
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }
        Iterator<Integer> iterator = set.iterator();
        int res = 1;
        boolean flag = false;
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            if (next > 0) {
                flag = true;
            }
            if (flag) {
                if (next != res) {
                    break;
                }
                res++;
            }
        }
        return res;
    }

}
