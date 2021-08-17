package Problem;

public class Pro005_LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(new Pro005_LongestPalindromicSubstring().longestPalindrome("babad"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty())
            return "";

        char[] chars = s.toCharArray();
        int[][] lengthOfPalindrome = new int[s.length()][];
        lengthOfPalindrome[0] = new int[1];
        lengthOfPalindrome[0][0] = 1;

        int[] maxValue = new int[2];
        maxValue[1] = 1;

        for (int i = 1; i < s.length(); i++) {
            lengthOfPalindrome[i] = new int[i + 1];
            
            for (int j = i; j >= 0; j--) {
                if (i == j) {
                    lengthOfPalindrome[i][j] = 1;
                } else if (i - j == 1) {
                    lengthOfPalindrome[i][j] = chars[i] == chars[j] ? 2 : 0;
                } else if (chars[i] == chars[j]) {
                    int middleLength = lengthOfPalindrome[i - 1][j + 1];
                    lengthOfPalindrome[i][j] = middleLength > 0 ? middleLength + 2 : 0;
                } else {
                    lengthOfPalindrome[i][j] = 0;
                }

                if (lengthOfPalindrome[i][j] > maxValue[1]) {
                    maxValue[0] = i;
                    maxValue[1] = lengthOfPalindrome[i][j];
                }
            }
        }

        int start = maxValue[0] - maxValue[1] + 1;
        int end = maxValue[0] + 1;
        return s.substring(start, end);
    }
}
