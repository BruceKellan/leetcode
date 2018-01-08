package top.brucekellan.leetcode;

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 * <p>
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * @author brucekellan
 * @create 2018-01-08
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int value = map.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) {
                value = value + map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
            } else {
                value = value + map.get(s.charAt(i));
            }
        }
        return value;
    }
}
