package ProHot_100;

public class Pro079_单词搜索 {

    public static void main(String[] args) {
        System.out.println(new Pro079_单词搜索().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCCED"));
        System.out.println(new Pro079_单词搜索().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "SEE"));
        System.out.println(new Pro079_单词搜索().exist(new char[][]{{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}}, "ABCB"));
    }

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     */
    public boolean exist(char[][] board, String word) {
        
    }
}
