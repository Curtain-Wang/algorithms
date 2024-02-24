package leetcode.interview150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/10/16 10:32
 * @Description 有效的数独
 * <p>
 * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * <p>
 * <p>
 * 注意：
 * <p>
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 空白格用 '.' 表示。
 */
public class T36 {
    
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new T36().isValidSudoku(board));
    }
    
    public boolean isValidSudoku1(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> blockMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            rowMap.put(i, new HashSet<>());
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    //行
                    Set<Character> set = rowMap.get(i);
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                    //列
                    set = colMap.getOrDefault(j, new HashSet<>());
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                    colMap.put(j, set);
                    //块
                    set = blockMap.getOrDefault(i / 3 * 3 + j / 3, new HashSet<>());
                    if (set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                    blockMap.put(i / 3 * 3 + j / 3, set);
                }
            }
        }
        return true;
    }
    
    public boolean isValidSudoku2(char[][] board) {
        boolean[][] row  = new boolean[10][10], col = new boolean[10][10], block = new boolean[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.'){
                    int idx = i / 3 * 3 + j / 3;
                    int val = board[i][j] - '0';
                    if (row[i][val] || col[j][val] || block[idx][val]){
                        return false;
                    }
                    row[i][val] = col[j][val] = block[idx][val] = true;
                }
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        int[] row  = new int[9], col = new int[9], block = new int[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.'){
                    int idx = i / 3 * 3 + j / 3;
                    int val = board[i][j] - '0';
                    if (((row[i] >> val) & 1) == 1 || ((col[j] >> val) & 1) == 1 || ((block[idx] >> val) & 1) == 1){
                        return false;
                    }
                    row[i] += 1 << val;
                    col[j] += 1 << val;
                    block[idx] += 1 << val;
                }
            }
        }
        return true;
    }
}
