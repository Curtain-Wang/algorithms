package leetcode.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/20 15:06
 * @Description 螺旋矩阵
 * <p>
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class T54 {
    //右下左上
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
//    public List<Integer> spiralOrder(int[][] matrix) {
//        int[] pos = {0, 0};
//        List<Integer> result = new ArrayList<>();
//        int[] directionIndex = {0};
//        while (true) {
//            result.add(matrix[pos[0]][pos[1]]);
//            matrix[pos[0]][pos[1]] = 200;
//            //获取下一个位置
//            int[] newPos = getNextPos(pos, directionIndex, matrix);
//            if (newPos[0] == pos[0] && newPos[1] == pos[1]){
//                break;
//            }
//            pos = newPos;
//        }
//        return result;
//    }
    
    private int[] getNextPos(int[] pos, int[] directionIndex, int[][] matrix) {
        int[] newPos = Arrays.copyOf(pos, 2);
        for (int i = 0; i < 2; i++) {
            int newRow = pos[0] + directions[directionIndex[0]][0];
            int newCol = pos[1] + directions[directionIndex[0]][1];
            //要改变方向了
            if (newRow < 0 || newRow >= matrix.length || newCol < 0 || newCol >= matrix[0].length || matrix[newRow][newCol] == 200){
                directionIndex[0] = (directionIndex[0] + 1) % 4;
                continue;
            }else {
                newPos[0] = newRow;
                newPos[1] = newCol;
                break;
            }
        }
        return newPos;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while (true) {
            //左往右
            for (int i = l; i <= r; i++) {
                result.add(matrix[t][i]);
            }
            if (++t > b){
                break;
            }
            //上往下
            for (int i = t; i <= b; i++) {
                result.add(matrix[i][r]);
            }
            if (--r < l){
                break;
            }
            //右往左
            for (int i = r; i >= l; i--) {
                result.add(matrix[b][i]);
            }
            if (--b < t){
                break;
            }
            //下往上
            for (int i = b; i >= t; i--) {
                result.add(matrix[i][l]);
            }
            if (++l > r){
                break;
            }
        }
        return result;
    }
}
