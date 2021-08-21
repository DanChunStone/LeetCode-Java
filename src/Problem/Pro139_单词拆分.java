package Problem;

import java.util.*;

public class Pro139_单词拆分 {

    public static void main(String[] args) {
        System.out.println(new Pro139_单词拆分().wordBreak("leetcode", new ArrayList<>(Arrays.asList("leet", "code"))));
        System.out.println(new Pro139_单词拆分().wordBreak("applepenapple", new ArrayList<>(Arrays.asList("apple", "pen"))));
        System.out.println(new Pro139_单词拆分().wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }

    /**
     * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
     * 说明：
     * 拆分时可以重复使用字典中的单词。
     * 你可以假设字典中没有重复的单词。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || wordDict == null || "".equals(s) || wordDict.size() == 0) {
            return true;
        }

        Set<String> set = new HashSet<>(wordDict);
        boolean[] temp = new boolean[s.length() + 1];
        temp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            temp[i + 1] = false;
            for (int j = 0; j < i + 1; j++) {
                if (temp[j] && set.contains(s.substring(j, i + 1))) {
                    temp[i + 1] = true;
                    break;
                }
            }
        }
        return temp[s.length()];
    }
}
