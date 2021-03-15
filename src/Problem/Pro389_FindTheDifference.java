package Problem;

/**
 * @author shilijun
 * @date 2020/12/18 18:41
 */
public class Pro389_FindTheDifference {
    
    public static void main(String[] args) {
        
    }

    /**
     * 给定两个字符串 s 和 t，它们只包含小写字母。
     * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
     * 请找出在 t 中被添加的字母。
     */
    public char findTheDifference(String s, String t) {
        if (s == null || s.length() < 1) {
            return (t != null && t.length() > 0) ? t.charAt(0) : ' ';
        } else if (t == null || t.length() < 1) {
            return s.charAt(0);
        }

        int[] countS = new int[27];
        int[] countT = new int[27];
        for (int i = 0; i < 27; i++) {
            countS[i] = 0;
            countT[i] = 0;
        }
        for (char c : s.toCharArray()) {
            countS[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            countT[c - 'a']++;
        }
        for (int i = 0; i < 27; i++) {
            if (countS[i] != countT[i])
                return (char) ('a' + i);
        }
        return ' ';
    }
}
