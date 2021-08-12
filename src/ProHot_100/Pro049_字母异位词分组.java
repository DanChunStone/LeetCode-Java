package ProHot_100;

import java.util.*;

public class Pro049_字母异位词分组 {

    public static void main(String[] args) {
        System.out.println(new Pro049_字母异位词分组().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(new Pro049_字母异位词分组().groupAnagrams(new String[]{""}));
        System.out.println(new Pro049_字母异位词分组().groupAnagrams(new String[]{"a"}));
    }

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母都恰好只用一次。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length <= 0)
            return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            List<String> value = map.computeIfAbsent(key, k -> new ArrayList<>());
            value.add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue() != null)
                result.add(entry.getValue());
        }

        return result;
    }
}
