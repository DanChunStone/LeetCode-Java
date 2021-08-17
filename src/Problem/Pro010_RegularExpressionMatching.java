package Problem;

/**
 * @author shilijun
 * @date 2021/3/19 17:01
 */
public class Pro010_RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(new Solution2().isMatch("aa", "a"));
    }

    /**
     * 给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。
     */
    static class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null)
                return false;

            return isMatch(s.toCharArray(), 0, s.length(), p.toCharArray(), 0, p.length());
        }

        public boolean isMatch(char[] chars, int start, int end, char[] charsP, int startP, int endP) {
            if (start == end) { // s已经匹配完了
                if (startP == endP)
                    return true;
                if (endP - startP >= 2 && charsP[startP + 1] == '*') {
                    return isMatch(chars, start, end, charsP, startP + 2, endP);
                }
                return false;
            }
            if (startP == endP) // s没有匹配完，但是p匹配完了
                return false;

            if (chars[start] == charsP[startP] || charsP[startP] == '.') {
                if (startP + 1 < endP && charsP[startP + 1] == '*') {
                    return isMatch(chars, start + 1, end, charsP, startP, endP) || isMatch(chars, start, end, charsP, startP + 2, endP);
                } else {
                    return isMatch(chars, start + 1, end, charsP, startP + 1, endP);
                }
            } else if (startP + 1 < endP && charsP[startP + 1] == '*') {
                return isMatch(chars, start, end, charsP, startP + 2, endP);
            }
            return false;
        }
    }

    /**
     * 解法二：动态规划
     */
    static class Solution2 {
        public boolean isMatch(String s, String p) {
            if (s == null || p == null)
                return false;

            int m = s.length();
            int n = p.length();
            boolean[][] result = new boolean[s.length() + 1][p.length() + 1];
            result[0][0] = true;
            for (int i = 1; i <= n; i++) {
                if (i > 1 && p.charAt(i - 1) == '*') {
                    result[0][i] = result[0][i - 2];
                } else {
                    result[0][i] = false;
                }
            }
            for (int i = 1; i <= m; i++) {
                result[i][0] = false;
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || '.' == p.charAt(j - 1)) {
                        result[i][j] = result[i - 1][j - 1];
                    } else if ('*' == p.charAt(j - 1)) {
                        if (s.charAt(i - 1) == p.charAt(j - 2) || '.' == p.charAt(j - 2)) {
                            result[i][j] = result[i - 1][j] || result[i - 1][j - 1] || result[i][j - 1] || result[i][j - 2];
                        } else {
                            result[i][j] = result[i][j - 2];
                        }
                    } else {
                        result[i][j] = false;
                    }
                }
            }
            return result[m][n];
        }
    }
}
