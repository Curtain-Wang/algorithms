package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/11/24 9:04
 * @Description
 */
public class T200 {
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited = null;
    char[][] grid = null;
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new boolean[rows][cols];
        this.grid = grid;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //岛屿的起点
                if (!visited[i][j] && grid[i][j] == '1'){
                    ans++;
                    getArea(i, j);
                }
            }
        }
        return ans;
    }
    
    private void getArea(int i, int j) {
        visited[i][j] = true;
        for (int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            if (isInArea(newi, newj) && !visited[newi][newj] && grid[newi][newj] == '1'){
                getArea(newi, newj);
            }
        }
    }
    
    private boolean isInArea(int newi, int newj) {
        return newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length;
    }
}
