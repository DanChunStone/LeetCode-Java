package Problem;

/**
 * @author danchun
 * @date 2021/3/30 11:34
 */
public class Pro012_IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(3));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(9));
        System.out.println(new Solution().intToRoman(58));
        System.out.println(new Solution().intToRoman(1994));
    }

    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two one's added together. 
     * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. 
     * However, the numeral for four is not IIII. Instead, the number four is written as IV. 
     * Because the one is before the five we subtract it making four. 
     * The same principle applies to the number nine, which is written as IX. 
     * There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9. 
     * X can be placed before L (50) and C (100) to make 40 and 90. 
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     */
    static class Solution {
        public String intToRoman(int num) {
            StringBuilder result = new StringBuilder();
            
            while (num >= 1000) {
                result.append("M");
                num -= 1000;
            }
            while (num >= 500) {
                if (num >= 900) {
                    result.append("C");
                    result.append("M");
                    num -= 900;
                } else {
                    result.append("D");
                    num -= 500;
                }
            }
            while (num >= 100) {
                if (num >= 400) {
                    result.append("C");
                    result.append("D");
                    num -= 400;
                } else {
                    result.append("C");
                    num -= 100;
                }
            }
            while (num >= 50) {
                if (num >= 90) {
                    result.append("X");
                    result.append("C");
                    num -= 90;
                } else {
                    result.append("L");
                    num -= 50;
                }
            }
            while (num >= 10) {
                if (num >= 40) {
                    result.append("X");
                    result.append("L");
                    num -= 40;
                } else {
                    result.append("X");
                    num -= 10;
                }
            }
            while (num >= 5) {
                if (num >= 9) {
                    result.append("I");
                    result.append("X");
                    num -= 9;
                } else {
                    result.append("V");
                    num -= 5;
                }
            }
            while (num >= 1) {
                if (num >= 4) {
                    result.append("I");
                    result.append("V");
                    num -= 4;
                } else {
                    result.append("I");
                    num -= 1;
                }
            }
            return result.toString();
        }
    }
}
