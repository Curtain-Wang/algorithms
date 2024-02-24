package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/12/25 16:15
 * @Description
 * 
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非严格递增顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class T74 {
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int row = 0;
//        int col = matrix[0].length - 1;
//        while (col >= 0 && row < matrix.length){
//            if (matrix[row][col] > target){
//                col--;
//            }else if (matrix[row][col] < target){
//                row++;
//            }else {
//                return true;
//            }
//        }
//        return false;
//    }
    int n, m;
    int[][] matrix;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.matrix = matrix;
        this.n = matrix.length;
        this.m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            int val = getVal(mid);
            if (val == target){
                return true;
            }else if (val < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    private int getVal(int mid) {
        int row = mid / m;
        int col = mid % m;
        return matrix[row][col];
    }
}
