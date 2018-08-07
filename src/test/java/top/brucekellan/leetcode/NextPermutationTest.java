package top.brucekellan.leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class NextPermutationTest {

    @Test
    public void nextPermutation() {
        int [] a = new int[]{6,5,4,3,2,1};
        new NextPermutation().nextPermutation(a);
        System.out.println(Arrays.toString(a));


        a = new int[]{6,5,4,8,7,5,1};
        new NextPermutation().nextPermutation(a);
        System.out.println(Arrays.toString(a));
    }
}