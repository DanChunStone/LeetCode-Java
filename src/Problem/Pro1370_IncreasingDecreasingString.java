package Problem;

import helper.ProblemObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shilijun
 * @date 2020/11/25 10:20
 */
public class Pro1370_IncreasingDecreasingString extends ProblemObject {

    public static void main(String[] args) {
        System.out.println(getInstance().sortString("aaaabbbbcccc"));
    }

    /**
     * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
     *
     * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     * 重复步骤 2 ，直到你没法从 s 中选择字符。
     * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     * 重复步骤 5 ，直到你没法从 s 中选择字符。
     * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
     *
     * 请你返回将 s 中字符重新排序后的 结果字符串 。
     */
    public String sortString(String s) {
        if (s == null || s.length() <= 1)
            return s;
        
        char[] chars = s.toCharArray();
        int[] counts = new int[26];
        for (char c : chars) {
            counts[c - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    stringBuilder.append((char) ('a' + i));
                    counts[i]--;
                }
            }
            
            for (int i = 25; i >= 0; i--) {
                if (counts[i] > 0) {
                    stringBuilder.append((char) ('a' + i));
                    counts[i]--;
                }
            }
        }
        return stringBuilder.toString();
    }
    
    public static Pro1370_IncreasingDecreasingString getInstance() {
        return new Pro1370_IncreasingDecreasingString();
    }
}
