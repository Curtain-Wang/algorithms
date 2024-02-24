package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/26 11:25
 * @Description
 */
public class T48_1 {
    
    int[][] matrix;
    
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        for (int i = 0; i <= matrix.length / 2; i++) {
            for (int j = 0; j <= (matrix.length + 1) / 2; j++) {
                xz(i, j);
            }
        }
    }
    
    private void xz(int startI, int j) {
        int val = matrix[startI][j];
        for (int i = 0; i < 4; i++) {
            int[] next = getNext(startI, j);
            int temp = matrix[next[0]][next[1]];
            matrix[next[0]][next[1]] = val;
            val = temp;
            startI = next[0];
            j = next[1];
        }
    }
    
    private int[] getNext(int i, int j) {
        int[] ans = new int[2];
        ans[0] = j;
        ans[1] = matrix.length - i - 1;
        return ans;
    }
}
