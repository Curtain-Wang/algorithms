package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/17 10:01
 * @Description
 * 
 * 根据 百度百科 ， 生命游戏 ，简称为 生命 ，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * 
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 */
public class T289 {
    
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {1, 1}, {1, -1}};
    
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int aliveCount = getAliveCount(board, i, j);
                //死亡
                if (aliveCount < 2 || aliveCount > 3){
                    board[i][j] = board[i][j] == 0 ? 0 : 2;
                }
                //存活
                if (aliveCount == 3){
                    board[i][j] = board[i][j] == 1 ? 1 : 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }
    
    private int getAliveCount(int[][] board, int i, int j) {
        int count = 0;
        for (int[] direction : directions) {
            int newi = i + direction[0];
            int newj = j + direction[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length){
                if (board[newi][newj] == 1 || board[newi][newj] == 2){
                    count++;
                }
            }
        }
        return count;
    }
}
