package top.brucekellan.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author MR
 * @create 2017/12/6
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("dvdf"));
    }

//
//    public int lengthOfLongestSubstring(String s) {
//        if(s.length() == 1) {
//            return 1;
//        }
//        int max = 0;
//        for (int i = 0; i < s.length() - 1; i++) {
//            int length = 1;
//            boolean isHave = true;
//            StringBuilder stringBuilder = new StringBuilder().append(s.charAt(i));
//            for (int j = i + 1; j < s.length(); j++) {
//                char c = s.charAt(j);
//                isHave = checkisHave(stringBuilder, c);
//                if (isHave) {
//                    break;
//                } else {
//                    length++;
//                    stringBuilder.append(c);
//                }
//            }
//            if (length > max) {
//                max = length;
//            }
//        }
//        return max;
//    }

//
//    private boolean checkisHave(StringBuilder stringBuilder, char c) {
//        for (int i = 0; i < stringBuilder.length(); i++) {
//            if (stringBuilder.charAt(i) == c) {
//                return true;
//            }
//        }
//        return false;
//    }


    public int lengthOfLongestSubstring(String s) {
        Set<Character> characters = new HashSet<Character>();
        int max = 0, i = 0, j = 0;
        while(i < s.length() && j < s.length()) {
            if(!characters.contains(s.charAt(j))) {
                characters.add(s.charAt(j++));
                max = Math.max(max, j - i);
            } else {
                characters.remove(s.charAt(i++));
            }
        }
        return max;
    }


}
