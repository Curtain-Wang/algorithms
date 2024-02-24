package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/1 13:29
 * @Description f(i) = 0 || f(i) = Math.min(f(j)....) + 1
 */
public class T94 {
    
    
    public static void main(String[] args) {
        System.out.println(new T94().minCut("aaba"));
    }
    
    public int minCut(String s){
        boolean[][] isPal = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j <= i; j++){
                char ch1 = s.charAt(i);
                char ch2 = s.charAt(j);
                if (ch1 == ch2 && (j + 1 >= i || isPal[j + 1][i - 1])){
                    isPal[j][i] = true;
                }else {
                    isPal[j][i] = false;
                }
            }
        }
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (isPal[0][i]){
                dp[i] = 0;
            }else {
                dp[i] = i;
                for (int j = 0; j <= i; j++){
                    if (isPal[j][i]){
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
