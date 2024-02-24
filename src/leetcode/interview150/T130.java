package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/11/24 9:36
 * @Description
 */
public class T130 {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        //边缘dfs
        for (int i = 0; i < cols; i++) {
            dfs(0, i, board);
            dfs(rows - 1, i, board);
        }
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, board);
            dfs(i, cols - 1, board);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfs(int row, int col, char[][] board) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] = '1';
        dfs(row + 1, col, board);
        dfs(row - 1, col, board);
        dfs(row, col - 1, board);
        dfs(row, col + 1, board);
    }
    
}
