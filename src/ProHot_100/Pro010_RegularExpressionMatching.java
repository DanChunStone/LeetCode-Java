package ProHot_100;

/**
 * @author shilijun
 * @date 2021/3/19 17:01
 */
public class Pro010_RegularExpressionMatching {

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aab", "c*a*b"));
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
}
