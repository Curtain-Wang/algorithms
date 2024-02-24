package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/2/19 9:17
 * @Description
 */
public class T221 {
    
//    public int maximalSquare(char[][] matrix) {
//        int result = 0;
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        
//        int[][] dp = new int[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
//            result = Math.max(result, dp[i][0]);
//        }
//        for (int i = 0; i < cols; i++) {
//            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
//            result = Math.max(result, dp[0][i]);
//        }
//        for (int i = 1; i < rows; i++) {
//            for (int j = 1; j < cols; j++) {
//                if (matrix[i][j] == '1'){
//                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
//                    result = Math.max(dp[i][j], result);
//                }
//            }
//        }
//        return result * result;
//    }
    
    public static void main(String[] args) {
        System.out.println(new T221().maximalSquare(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
    
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[] dp = new int[cols];
        for (int i = 0; i < cols; i++) {
            dp[i] = matrix[0][i] == '1' ? 1 : 0;
            result = Math.max(result, dp[i]);
        }
        for (int i = 1; i < rows; i++) {
            int tmp = dp[0];
            dp[0] = matrix[i][0] == '1' ? 1 : 0;
            result = Math.max(result, dp[0]);
            for (int j = 1; j < cols; j++) {
                int val = matrix[i][j] == '1' ? Math.min(Math.min(dp[j], dp[j - 1]), tmp) + 1 : 0;
                tmp = dp[j];
                dp[j] = val;
                result = Math.max(result, val);
            }
        }
        return result * result;
    }
}
