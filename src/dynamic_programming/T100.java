package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/2 15:38
 * @Description f(i, j) = Math.min(f(i - 1, j - 1), f(i - 1, j)) + T(i,j)
 */
public class T100 {
    
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();list1.add(2);list.add(list1);
        List<Integer> list2 = new ArrayList<>();list2.add(3);list2.add(4);list.add(list2);
        List<Integer> list3 = new ArrayList<>();list3.add(6);list3.add(5);list3.add(7);list.add(list3);
        List<Integer> list4 = new ArrayList<>();list4.add(4);list4.add(1);list4.add(8);list4.add(3);list.add(list4);
        
        System.out.println(new T100().minimumTotal2(list));
    }
    
    public int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();
        int minPath = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            List<Integer> now = triangle.get(i);
            List<Integer> last = triangle.get(i - 1);
            now.set(0, now.get(0) +last.get(0));
            for (int j = 1; j < now.size(); j++) {
                if (j == now.size() - 1){
                    now.set(j, now.get(j) + last.get(j - 1));
                }else {
                    now.set(j, now.get(j) + Math.min(last.get(j - 1), last.get(j))); 
                }
                if (i == n - 1){
                    minPath = Math.min(minPath, now.get(j));
                }
            }
        }
        return minPath;
    }
    
    
    public int minimumTotal1(List<List<Integer>> triangle){
        int length = triangle.size();
        int[][] dp = new int[length][length];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < length; i++) {
            List<Integer> list = triangle.get(i);
            dp[i][0] = dp[i - 1][0] + list.get(0);
            for (int j = 1; j < list.size() - 1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + list.get(j);
            }
            dp[i][list.size() - 1] = dp[i - 1][list.size() - 2] + list.get(list.size() - 1);
        }
        int minPath = Integer.MAX_VALUE;
        for (int i = 0; i < dp[length - 1].length; i++) {
            minPath = Math.min(dp[length - 1][i], minPath);
        }
        return minPath;
    }
    
    public int minimumTotal2(List<List<Integer>> triangle){
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            dp[list.size() - 1] = dp[list.size() - 2] + list.get(list.size() - 1);
            for (int j = list.size() - 2; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
            }
            dp[0] += list.get(0);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }
        return min;
    }
    
}
