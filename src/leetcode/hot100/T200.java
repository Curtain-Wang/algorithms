package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/12 13:22
 * @Description
 */
public class T200 {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited;
    char[][] grid;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int row = grid.length;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && !visited[i][j]){
                    result++;
                    visited[i][j] = true;
                    findArea(i, j);
                }
            }
        }
        return result;
    }
    
    private void findArea(int i, int j) {
        for (int[] direction : directions) {
            int nexti = i + direction[0];
            int nextj = j + direction[1];
            if (isInArea(nexti, nextj) && grid[nexti][nextj] == '1' && !visited[nexti][nextj]){
                visited[nexti][nextj] = true;
                findArea(nexti, nextj);
            }
        }
    }
    
    private boolean isInArea(int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
