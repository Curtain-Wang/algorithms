package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/11/24 9:19
 * @Description
 */
public class T200_1 {
    
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //岛屿的起点
                if (grid[i][j] == '1'){
                    ans++;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }
    
    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i > grid.length || j < 0 || j > grid[0].length || grid[i][j] == '1'){
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid);
        dfs(i + 1, j, grid);
        dfs(i, j - 1, grid);
        dfs(i, j + 1, grid);
    }
}
