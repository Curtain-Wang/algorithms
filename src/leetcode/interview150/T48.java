package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/26 9:48
 * @Description
 */
public class T48 {
    
    int[][] matrix;
    
    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        new T48().rotate(matrix);
    }
    
    public void rotate(int[][] matrix) {
        this.matrix = matrix;
        int startI = 0;
        int startJ = 0;
        int border = matrix.length - 1;
        while (startI < border){
            for (int j = startJ; j < border; j++) {
                xz(startI, j);
            }
            startI++;
            startJ++;
            border--;
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
