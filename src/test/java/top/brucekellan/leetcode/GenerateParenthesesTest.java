package top.brucekellan.leetcode;

import org.junit.Test;

import java.util.List;

public class GenerateParenthesesTest {

    @Test
    public void resolve1() {
        List<String> result = new GenerateParentheses().resolve1(3);
        System.out.println(result.toString());
    }

    @Test
    public void resolve2() {
        List<String> result = new GenerateParentheses().resolve2(3);
        System.out.println(result.toString());
    }
}