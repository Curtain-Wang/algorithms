package graph;

/**
 * @Author Curtain
 * @Date 2023/8/9 16:10
 * @Description
 */
public class T112 {
    
    public static void main(String[] args) {
        int[][] matrix = {{3, 4, 5}, {3, 2, 8}, {2, 2, 1}};
        System.out.println(new T112().longestIncreasingPath(matrix));
    }
    
    private int longestIncreasingPath(int[][] matrix){
        int longest = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] lengths = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int length = dfs(matrix, lengths, i, j);
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
    
    private int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        if (lengths[i][j] > 0){
            return lengths[i][j];
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int length = 1;
        for (int[] dir : dirs) {
            int r = i - dir[0];
            int c = j - dir[1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] > matrix[i][j]){
                length = Math.max(dfs(matrix, lengths, r, c) + 1, length);
            }
        }
        lengths[i][j] = length;
        return length;
    }
}
