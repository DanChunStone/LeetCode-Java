package ProHot_100;

import java.util.HashMap;
import java.util.Map;

public class Pro013_RomanToInteger {
    public static void main(String[] args) {
        System.out.println(new Solution().romanToInt("III"));
        System.out.println(new Solution().romanToInt("IV"));
        System.out.println(new Solution().romanToInt("IX"));
        System.out.println(new Solution().romanToInt("LVIII"));
        System.out.println(new Solution().romanToInt("MCMXCIV"));
    }

    static class Solution {
        static Map<Character, Integer> map = new HashMap<>();

        static {
            map.put('I', 1);
            map.put('V', 5);
            map.put('X', 10);
            map.put('L', 50);
            map.put('C', 100);
            map.put('D', 500);
            map.put('M', 1000);
        }

        public int romanToInt(String s) {
            if (s == null || s.length() == 0)
                return 0;

            int result = 0;
            int length = s.length();
            int i = 0;
            while (i < length) {
                int current = map.get(s.charAt(i));
                int next = i + 1 < length ? map.get(s.charAt(i + 1)) : 0;
                if (next > current) {
                    result += next - current;
                    i = i + 2;
                } else {
                    result += current;
                    i++;
                }
            }
            
            return result;
        }
    }
}
