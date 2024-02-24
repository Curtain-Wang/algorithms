package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/15 16:41
 * @Description
 */
public class T74 {
    
    private int row, col;
    private int[][] matrix = null;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        row = matrix.length;
        col = matrix[0].length;
        return bs(target, 0, row * col - 1);
    }
    
    private boolean bs(int target, int left, int right) {
        if (left == right){
            return target == matrix[left / col][left % col];
        }else {
            int mid = left + right >> 1;
            int midValue = matrix[mid / 4][mid % 4];
            if (target == midValue){
                return true;
            }else if (target < midValue){
                return bs(target, left, mid);
            }else {
                return bs(target, mid + 1, right);
            }
        }
    }
}
