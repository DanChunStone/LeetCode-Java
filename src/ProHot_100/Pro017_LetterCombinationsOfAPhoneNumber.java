package ProHot_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Pro017_LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("234"));
        System.out.println(new Solution().letterCombinations(""));
        System.out.println(new Solution().letterCombinations("2"));
    }

    static class Solution {

        static final String[] map = new String[]{
                "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz",
        };

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0)
                return new ArrayList<>();

            char[] chars = digits.toCharArray();
            int length = digits.length();
            int depth = 0;
            int[] indexs = new int[length];
            for (int i = 0; i < length; i++)
                indexs[i] = -1;

            List<String> result = new ArrayList<>();
            while (depth >= 0 && depth < length) {
                int index = ++indexs[depth];

                if (depth == length - 1) {
                    while (index < map[(chars[length - 1] - '1')].length()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(map[(chars[i] - '1')].charAt(indexs[i]));
                        }
                        result.add(stringBuilder.toString());
                        index = ++indexs[depth];
                    }
                    indexs[depth] = -1;
                    depth--;
                    continue;
                }
                if (depth == 0 && index >= map[(chars[0] - '1')].length()) {
                    break;
                }
                if (index >= map[(chars[depth] - '1')].length()) {
                    indexs[depth] = -1;
                    depth--;
                    continue;
                }
                
                depth++;
            }
            return result;
        }
    }
}
