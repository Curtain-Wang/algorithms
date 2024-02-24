package leetcode.interview150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/12/8 11:24
 * @Description
 * 
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * 
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 */
public class T212 {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Set<String> wordSet = new HashSet<>();
    List<String> ans = new ArrayList<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            wordSet.add(word);
        }
        int rows = board.length;
        int cols = board[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(board[i][j]);
                //开始匹配
                boolean[][] visited = new boolean[rows][cols];
                bfs(visited, sb, i, j, board);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return ans;
    }
    
    private void bfs(boolean[][] visited, StringBuilder sb, int i, int j, char[][] board) {
        if (sb.length() > 10){
            return;
        }
        if (wordSet.contains(sb.toString())){
            String s = sb.toString();
            ans.add(s);
            wordSet.remove(s);
        }
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            if (inAread(newi, newj, board) && !visited[newi][newj]){
                sb.append(board[newi][newj]);
                bfs(visited, sb, newi, newj, board);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        visited[i][j] = false;
    }
    
    private boolean inAread(int newi, int newj, char[][] board) {
        return newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length;
    }
}
