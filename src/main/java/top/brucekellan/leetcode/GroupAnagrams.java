package top.brucekellan.leetcode;

import java.util.*;

/**
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 *
 * @author brucekellan
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        StringBuilder stringBuilder = null;
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            stringBuilder = new StringBuilder();
            for (char c : chars) {
                stringBuilder.append(c);
            }
            String key = stringBuilder.toString();
            if (map.get(key) == null) {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(key, temp);
            } else {
                List<String> temp = map.get(key);
                temp.add(str);
                map.put(key, temp);
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
