package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/15 16:54
 * @Description
 */
public class T74_1 {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int startRow = 0;
        int startCol = col - 1;
        while (startRow < row && col >= 0){
            if (matrix[startRow][startCol] == target){
                return true;
            }else if (matrix[startRow][startCol] > target){
                startCol--;
            }else {
                startRow++;
            }
        }
        return false;
    }
}
