package top.brucekellan.leetcode;

/**
 * 32. Longest Valid Parentheses
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 * @author brucekellan
 */
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1){
            return 0;
        }
        //DP version
        char[] S = s.toCharArray();
        int[] DP = new int[S.length];
        int max = 0;
        for(int i = 1; i < S.length; i++){
            if(S[i] == ')'){
                int j = i - 1 - DP[i - 1];
                if(j >= 0 && S[j] == '('){
                    DP[i] = 2 + DP[i - 1] + (j > 0? DP[j - 1] : 0);
                }
            }

            max = Math.max(max, DP[i]);
        }
        return max;
    }

}
