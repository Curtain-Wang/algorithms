package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/2 13:32
 * @Description f(i,j) = f(i -1, j - 1) + f(i - 1, j)
 */
public class T97 {
    
    
    public static void main(String[] args) {
        System.out.println(numDistinct2("appple", "apple"));
    }
    
    public static int numDistinct(String s, String t){
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 0; i < s.length(); i++){
            dp[i + 1][0] = 1;
            for (int j = 0; j <= i && j < t.length(); j++) {
                char ch1 = s.charAt(i);
                char ch2 = t.charAt(j);
                if (ch1 == ch2){
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                }else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    
    public static int numDistinct1(String s, String t){
        int[] dp = new int[t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            int prev = 1;
            int cur;
            for (int j = 0; j <= i && j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)){
                    cur = prev + dp[j + 1];
                }else {
                    cur = dp[j + 1];
                }
                prev = dp[j + 1];
                dp[j + 1] = cur;
            }
        }
        return dp[t.length()];
    }
    
    public static int numDistinct2(String s, String t){
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.min(i, t.length() - 1); j >= 0 ; j--) {
                if (s.charAt(i) == t.charAt(j)){
                    dp[j + 1] += dp[j];
                }
                if (i == s.length() - 1 && j == t.length() - 1){
                    return dp[t.length()];
                }
            }
        }
       return dp[t.length()];
    }
}
