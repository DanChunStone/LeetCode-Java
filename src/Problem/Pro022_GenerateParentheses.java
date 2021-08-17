package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author danchun
 * @date 2021/4/14 11:25
 */
public class Pro022_GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(2));
        System.out.println(new Solution().generateParenthesis(3));
        System.out.println(new Solution().generateParenthesis(4));
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            ArrayList<List<String>> result = new ArrayList<>();
            result.add(Arrays.asList(""));
            result.add(Arrays.asList("()"));
            if (n == 0) {
                return new ArrayList<>();
            }
            if (n == 1) {
                return result.get(1);
            }

            for (int i = 2; i <= n; i++) {
                List<String> temp = new ArrayList<>();
                for (int j = 0; j < i; j++) {
                    for (String s1 : result.get(j)) {
                        for (String s2 : result.get(i - 1 - j)) {
                            temp.add("(" + s1 + ")" + s2);
                        }
                    }
                }
                result.add(temp);
            }
            return result.get(n);
        }
    }
}
