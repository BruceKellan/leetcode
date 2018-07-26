package top.brucekellan.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 * @author brucekellan
 * @create 2017-12-22
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().solve2("baabaa"));
    }

    /**
     * 动态规划
     * @return
     */
    public String solve1(String s) {
        int len = s.length();
        if( len <= 1 ) {
            return s;
        }
        int start = 0, end = 0;
        char [] cArray = s.toCharArray();
        boolean [][] temp = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            temp[i][i] = true;
            for(int j = 0; j < i; j++) {
                if(j + 1 == i) {
                    temp[j][i] = cArray[i] == cArray[j];
                } else {
                    temp[j][i] = temp[j + 1][i - 1] && cArray[i] == cArray[j];
                }
                if(temp[j][i] && i - j > end - start) {
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end);
    }

    /**
     * 马拉车算法
     * @param s
     * @return
     */
    public String solve2(String s) {
        String str = prepare(s);
        int len = str.length();
        int max = 0;
        int index = 0;
        for(int i = 0; i < len; i++) {
            int start = i;
            int end = i;
            int res = 0;
            while(start >= 0 && end < len && str.charAt(start) == str.charAt(end)) {
                res++;
                start--;
                end++;
            }
            if(res > max) {
                max = res - 1;
                index = i;
            }
        }
        String result = str.substring(index - max, index + max + 1);
        return over(result);
    }

    public String prepare(String s) {
        char [] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (char c: chars) {
            stringBuilder.append(c);
            stringBuilder.append("#");
        }
        return stringBuilder.toString();
    }

    public String over(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char [] chars = s.toCharArray();
        for (char c: chars) {
            if(c != '#') {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }
}
