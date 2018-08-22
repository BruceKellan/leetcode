package top.brucekellan.leetcode;

import org.junit.Test;

public class FirstMissingPositiveTest {

    @Test
    public void firstMissingPositiveTest() {
        int res1 = new FirstMissingPositive().firstMissingPositive(new int[]{1, 2, 0});
        int res2 = new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1});
        int res3 = new FirstMissingPositive().firstMissingPositive(new int[]{7, 8, 9, 11, 12});
        print(res1);
        print(res2);
        print(res3);
    }

    public void print(int res) {
        System.out.println(res);
    }

}