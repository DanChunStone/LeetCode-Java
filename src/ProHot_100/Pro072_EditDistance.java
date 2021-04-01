package ProHot_100;

/**
 * @author shilijun
 * @date 2021/3/27 16:19
 */
public class Pro072_EditDistance {
    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("horse", "ros"));
    }

    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * 你可以对一个单词进行如下三种操作：
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * 
     * 方法：使用动态规划
     * 对于任意位置[i,j]，定义为 字符串1的0-i下标的子字符串 和 字符串2的0-j下标的子字符串 之间转换的最少操作数
     * 那么要计算出该位置的最少操作数，可以通过计算三个子问题的操作数来完成，该问题可以看成：
     * [i - 1][j] 问题在字符串1上新增了一个字符
     * [i][j - 1] 问题在字符串2上新增了一个字符
     * [i - 1][j - 1] 问题在该位置进行了一次字符转换(如果该位置字符相等，则不需要转换)
     */
    static class Solution {
        public int minDistance(String word1, String word2) {
            if (word1 == null || word2 == null || word1.equals(word2))
                return 0;
            if (word1.length() == 0 || word2.length() == 0)
                return word1.length() + word2.length();

            int[][] dpArray = new int[word1.length() + 1][word2.length() + 1];
            for (int i = 0; i < word1.length() + 1; i++)
                dpArray[i][0] = i;
            for (int i = 0; i < word2.length() + 1; i++)
                dpArray[0][i] = i;

            char[] chars1 = word1.toCharArray();
            char[] chars2 = word2.toCharArray();
            for (int i = 1; i <= word1.length(); i++) {
                for (int j = 1; j <= word2.length(); j++) {
                    if (chars1[i - 1] != chars2[j - 1]) {
                        dpArray[i][j] = Math.min(dpArray[i - 1][j], Math.min(dpArray[i][j - 1], dpArray[i - 1][j - 1])) + 1;
                    } else {
                        dpArray[i][j] = Math.min(dpArray[i - 1][j], Math.min(dpArray[i][j - 1], dpArray[i - 1][j - 1] - 1)) + 1;
                    }
                }
            }

            return dpArray[word1.length()][word2.length()];
        }
    }
}
