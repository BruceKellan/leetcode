package top.brucekellan.leetcode;

import java.util.*;

/**
 * 22. Generate Parentheses
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author brucekellan
 */
public class GenerateParentheses {

    public List<String> resolve1(int n) {
        List<String> resultList = new ArrayList<>();
        helperResolve1(resultList, "", 0, n);
        return resultList;
    }

    public void helperResolve1(List<String> resultList, String str, int rightNeed, int leftHave) {
        if (rightNeed == 0 && leftHave == 0) {
            resultList.add(str);
            return;
        }
        if (rightNeed > 0) {
            helperResolve1(resultList, str + ")", rightNeed - 1, leftHave);
        }
        if (leftHave > 0) {
            helperResolve1(resultList, str + "(", rightNeed + 1, leftHave - 1);
        }
    }

    public List<String> resolve2(int n) {
        Map<Integer, List<String>> resultList = new HashMap<>(n);
        resultList.put(0, Arrays.asList(""));
        StringBuilder temp;
        int z;
        for(int i = 1; i <= n; i++) {
            List<String> array = new ArrayList<>();
            for(int j = 0; j < i; j++) {
                z = i - j - 1;
                for(String a: resultList.get(j)) {
                    for (String b: resultList.get(z)) {
                        temp = new StringBuilder();
                        array.add(temp.append("(").append(a).append(")").append(b).toString());
                    }
                }
            }
            resultList.put(i, array);
        }
        return resultList.get(n);
    }

}
