package ProHot_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Pro076_最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(new Pro076_最小覆盖子串().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Pro076_最小覆盖子串().minWindow("a", "a"));
        System.out.println(new Pro076_最小覆盖子串().minWindow("a", "aa"));
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     */
    private final Map<Character, Integer> original = new HashMap<>();
    private final Map<Character, Integer> cnt = new HashMap<>();

    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        original.clear();
        cnt.clear();

        int sLength = s.length();
        int tLength = t.length();

        for (int i = 0; i < tLength; i++) {
            char c = t.charAt(i);
            original.put(c, original.getOrDefault(c, 0) + 1);
        }

        int ableLength = 0;
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            if (original.containsKey(c)) {
                ableLength++;
            }
        }

        if (ableLength < tLength) {
            return "";
        }

        char[] findString = new char[ableLength];
        int[] findIndex = new int[ableLength];
        int index = 0;
        for (int i = 0; i < sLength; i++) {
            char c = s.charAt(i);
            if (original.containsKey(c)) {
                findString[index] = c;
                findIndex[index] = i;
                index++;
            }
        }

        int left = 0, right = 0;
        int resultLeft = -1, resultRight = -1;
        int resultLength = Integer.MAX_VALUE;
        while (right < ableLength) {
            cnt.put(findString[right], cnt.getOrDefault(findString[right], 0) + 1);

            while (isWindowAvailable() && left <= right) {
                int length = findIndex[right] - findIndex[left] + 1;
                if (length < resultLength) {
                    resultLeft = left;
                    resultRight = right;
                    resultLength = length;
                }

                cnt.put(findString[left], cnt.getOrDefault(findString[left], 0) - 1);
                left++;
            }

            right++;
        }

        return resultLeft >= 0 ? s.substring(findIndex[resultLeft], findIndex[resultRight] + 1) : "";
    }

    private boolean isWindowAvailable() {
        for (char c : original.keySet()) {
            int min = original.get(c);
            int current = cnt.getOrDefault(c, 0);
            if (current < min) {
                return false;
            }
        }
        return true;
    }
}
