package ProHot_100;

public class Pro009_PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
        System.out.println(new Solution().isPalindrome(-121));
        System.out.println(new Solution().isPalindrome(10));
        System.out.println(new Solution().isPalindrome(9));
        System.out.println(new Solution().isPalindrome(-101));
    }

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || (x % 10 == 0 && x != 0))
                return false;

            int reverse = 0;
            while (reverse < x) {
                reverse = reverse * 10 + x % 10;
                x /= 10;
            }
            return x == reverse || reverse / 10 == x;
        }
    }

    static class Solution2 {
        public boolean isPalindrome(int x) {
            if (x < 0)
                return false;

            String s = String.valueOf(x);
            int i = 0, j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
