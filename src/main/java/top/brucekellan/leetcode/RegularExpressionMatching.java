package top.brucekellan.leetcode;

/**
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 * @author brucekellan
 * @create 2018-01-01
 */
public class RegularExpressionMatching {

    public boolean isMatch01(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        if(p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        if(p.charAt(1) != '*') {
            if(s.isEmpty()) {
                return false;
            }
            return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') && isMatch01(s.substring(1), p.substring(1));
        }
        while(!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            if(isMatch01(s, p.substring(2))) {
                return true;
            }
            s = s.substring(1);
        }
        return isMatch01(s, p.substring(2));
    }

    public boolean isMatch02(String s, String p) {
        if(p.isEmpty()) {
            return s.isEmpty();
        }
        if(p.length() > 1 && p.charAt(1) == '*') {
            return isMatch02(s, p.substring(2))
                    || (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
                    && isMatch02(s.substring(1), p);
        }
        return !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
                && isMatch02(s.substring(1), p.substring(1));
    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int sL = s.length(), pL = p.length();
        boolean[][] dp = new boolean[sL + 1][pL + 1];
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        dp[0][0] = true;
        for (int i = 2; i <= pL; ++i) {
            if (pc[i - 1] == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= sL; ++i) {
            for (int j = 1; j <= pL; ++j) {

                if (pc[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2] || (pc[j - 2] == sc[i - 1] || pc[j - 2] == '.') && dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && (pc[j - 1] == '.' || pc[j - 1] == sc[i - 1]);
                }
            }
        }
        return dp[sL][pL];
    }
}
