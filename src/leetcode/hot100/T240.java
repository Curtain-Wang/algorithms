package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/28 10:32
 * @Description
 */
public class T240 {
    
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        
    }
    
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix[matrix.length - 1][matrix[0].length - 1] < target || matrix[0][0] > target){
            return false;
        }
        int x = 0;
        int y = matrix[0].length - 1;
        while (x < matrix.length && y >= 0){
            if (matrix[x][y] == target){
                return true;
            }
            if (matrix[x][y] < target){
                x++;
                continue;
            }else {
                y--;
                continue;
            }
        }
        return false;
    }
}
