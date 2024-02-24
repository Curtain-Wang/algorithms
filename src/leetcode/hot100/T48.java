package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/24 15:45
 * @Description
 */
public class T48 {
    
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j<((n % 2 == 0) ? n / 2 : n / 2 + 1); j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1- j];
                matrix[n - 1 - i][n - 1- j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}
