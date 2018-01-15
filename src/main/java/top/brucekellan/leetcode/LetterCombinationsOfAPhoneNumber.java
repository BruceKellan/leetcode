package top.brucekellan.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * @author brucekellan
 * @create 2018-01-15
 */
public class LetterCombinationsOfAPhoneNumber {

    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return Collections.emptyList();
        List<String> list = new ArrayList<>();
        helper(list, digits, "");
        return list;
    }

    private void helper(List<String> list, String digits, String ans) {
        if (ans.length() == digits.length()) {
            list.add(ans);
            return;
        }
        for (char c : map[digits.charAt(ans.length()) - '2'].toCharArray()) {
            helper(list, digits, ans + c);
        }
    }

}
