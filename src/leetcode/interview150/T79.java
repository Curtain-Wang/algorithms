package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/20 16:20
 * @Description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class T79 {
    char[][] board;
    String word;
    boolean[][] visited;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public static void main(String[] args) {
        System.out.println(new T79().exist(new char[][]{{'a'}}, "a"));
    }
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(int i, int j, int size) {
        if (board[i][j] != word.charAt(size)) {
            return false;
        } else {
            if (size + 1 == word.length()) {
                return true;
            }
            visited[i][j] = true;
            for (int[] direction : directions) {
                int newi = i + direction[0];
                int newj = j + direction[1];
                if (inArea(newi, newj) && !visited[newi][newj]) {
                    if (dfs(newi, newj, size + 1)) {
                        return true;
                    }
                }
            }
            visited[i][j] = false;
        }
        return false;
        
    }
    
    private boolean inArea(int newi, int newj) {
        return newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length;
    }
}
