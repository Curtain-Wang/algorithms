package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/2 15:10
 * @Description f(n, m) = Math.min(f(n - 1, m), f(n, m - 1)) + nums[n - 1][m - 1]
 */
public class T99 {
    
    public static void main(String[] args) {
        int[][] gird = {{1,3,1},{2,5,2},{3,4,1}};
        System.out.println(new T99().minPathSum(gird));
    }
    
    public int minPathSum(int[][] gird){
        int n = gird.length;
        int m = gird[0].length;
        for (int i = 1; i < m; i++) {
            gird[0][i] += gird[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            gird[i][0] += gird[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                gird[i][j] += Math.min(gird[i - 1][j], gird[i][j - 1]);
            }
        }
        return gird[n - 1][m - 1];
    }
}
