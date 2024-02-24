package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/8 11:05
 * @Description
 * 
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class T79 {
    
    private int[][] directions = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if (dfs(board, i, j, word, 0, visited)){
                        return true;
                    }else {
                        visited[i][j] = false;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, int row, int col, String word, int wordNow, boolean[][] visited) {
        if (wordNow == word.length() - 1){
            return true;
        }
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow < 0 || nextRow >= board.length || nextCol < 0 || nextCol >= board[0].length){
                continue;
            }
            if (visited[nextRow][nextCol]){
                continue;
            }
            if (board[nextRow][nextCol] == word.charAt(wordNow + 1)){
                visited[nextRow][nextCol] = true;
                if (dfs(board, nextRow, nextCol, word, wordNow + 1, visited)){
                    return true;
                }else {
                    visited[nextRow][nextCol] = false;
                }
            }
        }
        return false;
    }
}
