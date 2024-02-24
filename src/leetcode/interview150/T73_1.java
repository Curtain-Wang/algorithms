package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/22 10:12
 * @Description
 */
public class T73_1 {
    public void setZeroes(int[][] matrix) {
        boolean row0Flag = false;
        boolean col0Flag = false;
        //判断第一行有没有0
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                row0Flag = true;
                break;
            }
        }
        //判断第一列有咩有0
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                col0Flag = true;
                break;
            }
        }
        //以第一行和第一列标志0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row0Flag) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col0Flag) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
