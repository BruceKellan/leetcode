package top.brucekellan.leetcode;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in
 * words exactly once and without any intervening characters.
 * Example 1:
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * Input:
 *   s = "wordgoodstudentgoodword",
 *   words = ["word","student"]
 * Output: []
 * @Author: 37
 * @Date: Created at 19:44 2018/8/14
 */
public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring3(String s, String[] words) {
        //N为字符串长度
        int N = s.length();
        //结果集,长度必定不超过字符串长度
        List<Integer> indexes = new ArrayList<Integer>(s.length());
        if (words.length == 0) {
            return indexes;
        }
        //M为单个单词的长度
        int M = words[0].length();
        //如果所有单词连接之后的长度超过字符串长度，则返回空结果集
        if (N < M * words.length) {
            return indexes;
        }
        //last 字符串中最后一个可以作为单词起始点的下标
        int last = N - M + 1;
        //map存储word和其在table[0]中对应的下标
        Map<String, Integer> mapping = new HashMap<String, Integer>(words.length);
        //table[0]存储每个word出现的真实次数，table[1]存储每个word目前为止出现的统计次数
        int [][] table = new int[2][words.length];
        //failures存储words中不重复值的总数，例如["good","bad","good","bad"]，failures=2
        int failures = 0, index = 0;
        for (int i = 0; i < words.length; ++i) {
            Integer mapped = mapping.get(words[i]);
            if (mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }
        //遍历字符串s，判断字符串当前下标后是否存在words中的单词，如果存在，则填入table中的下标，不存在则为-1
        int [] smapping = new int[last];
        for (int i = 0; i < last; ++i) {
            String section = s.substring(i, i + M);
            Integer mapped = mapping.get(section);
            if (mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }
        //fix the number of linear scans
        for (int i = 0; i < M; ++i) {
            //reset scan variables
            //number of current mismatches
            int currentFailures = failures;
            int left = i, right = i;
            Arrays.fill(table[1], 0);
            //here, simple solve the minimum-window-substring problem
            //保证右节点不超出边界
            while (right < last) {
                //保证左右节点之间的子字符串能够包含所有的word值
                while (currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if (target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += M;
                }
                while (currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if (target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        //instead of checking every window, we know exactly the length we want
                        if ((length / M) ==  words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += M;
                }
            }

        }
        return indexes;
    }

}
