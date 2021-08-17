package Problem;

public class Pro003_LengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        char[] chars = s.toCharArray();
        int[] length = new int[s.length()];
        int maxLength = length[0] = 1;
        
        for (int i = 1; i < s.length(); i++) {
            length[i] = 1;
            
            for (int j = 1; j <= length[i - 1]; j++) {
                if (chars[i - j] == chars[i]) {
                    break;
                }
                length[i]++;
            }
            
            if (maxLength < length[i]) {
                maxLength = length[i];
            }
        }
        return maxLength;
    }
}
