package Problem;

public class Pro014_LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new Solution().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0 || strs[0].length() < 1)
                return "";

            int minLength = Integer.MAX_VALUE;
            for (String s : strs)
                minLength = Math.min(minLength, s.length());

            StringBuilder result = new StringBuilder();
            int index = 0;
            while (index < minLength) {
                char c = strs[0].charAt(index);
                for (String s : strs) {
                    if (s.charAt(index) != c) {
                        return result.toString();
                    }
                }
                result.append(c);
                index++;
            }
            return result.toString();
        }
    }
}
