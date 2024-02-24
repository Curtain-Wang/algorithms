package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/14 14:45
 * @Description
 */
public class T1222_1 {
    
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {1, -1}, {1, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
    
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[][] isQueen = new boolean[8][8];
        for (int[] queen : queens) {
            isQueen[queen[0]][queen[1]] = true;
        }
        for (int[] direction : directions) {
            int nextRow = king[0] + direction[0];
            int nextCol = king[1] + direction[1];
            while (isInArea(nextRow, nextCol)){
                if (isQueen[nextRow][nextCol]){
                    List<Integer> queen = new ArrayList<>();
                    queen.add(nextRow);
                    queen.add(nextCol);
                    ans.add(queen);
                    break;
                }
                nextRow += direction[0];
                nextCol += direction[1];
            }
        }
        return ans;
    }
    
    private boolean isInArea(int nextRow, int nextCol) {
        return nextRow >= 0 && nextRow < 8 && nextCol >= 0 &&nextCol < 8;
    }
}
