package leetcode.interview150;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/12/1 16:47
 * @Description 给你一个大小为 n x n 的整数矩阵 board ，方格按从 1 到 n^2 编号，编号遵循 转行交替方式 ，从左下角开始 （即，从 board[n - 1][0] 开始）每一行交替方向。
 * <p>
 * 玩家从棋盘上的方格 1 （总是在最后一行、第一列）开始出发。
 * <p>
 * 每一回合，玩家需要从当前方格 curr 开始出发，按下述要求前进：
 * <p>
 * 选定目标方格 next ，目标方格的编号符合范围 [curr + 1, min(curr + 6, n^2)] 。
 * 该选择模拟了掷 六面体骰子 的情景，无论棋盘大小如何，玩家最多只能有 6 个目的地。
 * 传送玩家：如果目标方格 next 处存在蛇或梯子，那么玩家会传送到蛇或梯子的目的地。否则，玩家传送到目标方格 next 。
 * 当玩家到达编号 n^2 的方格时，游戏结束。
 * r 行 c 列的棋盘，按前述方法编号，棋盘格中可能存在 “蛇” 或 “梯子”；如果 board[r][c] != -1，那个蛇或梯子的目的地将会是 board[r][c]。编号为 1 和 n^2 的方格上没有蛇或梯子。
 * <p>
 * 注意，玩家在每回合的前进过程中最多只能爬过蛇或梯子一次：就算目的地是另一条蛇或梯子的起点，玩家也 不能 继续移动。
 * <p>
 * 举个例子，假设棋盘是 [[-1,4],[-1,3]] ，第一次移动，玩家的目标方格是 2 。那么这个玩家将会顺着梯子到达方格 3 ，但 不能 顺着方格 3 上的梯子前往方格 4 。
 * 返回达到编号为 n^2 的方格所需的最少移动次数，如果不可能，则返回 -1。
 */
public class T909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{1, 0});
        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int index = poll[0];
            int cnt = poll[1];
            cnt++;
            for (int i = index + 1; i <= Math.min(target, index + 6); i++) {
                int row = n - (i - 1) / n - 1;
                int col = 0;
                if ((i - 1) / n % 2 == 0) {
                    col = (i - 1) % n;
                } else {
                    col = (n - i % n) % n;
                }
                int dest = board[row][col] == -1 ? i : board[row][col];
                if (dest == target){
                    return cnt;
                }
                if (visited[row][col]){
                    continue;
                }
                visited[row][col] = true;
                queue.add(new int[]{dest, cnt});
            }
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
        int i = 36;
        int length = 6;
        int row = length - (i - 1) / length - 1;
        int col = 0;
        if ((i - 1) / length % 2 == 0) {
            col = (i - 1) % length;
        } else {
            col = (length - i % length) % length;
        }
        System.out.println(row);
        System.out.println(col);
    }
}
