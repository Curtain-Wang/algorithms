package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/2 10:31
 * @Description
 */
public class T96 {
    
    public static void main(String[] args) {
        System.out.println(isInterLeave3("aabcc", "dbbca", "aadbbcbcac"));
    }
    
    public static boolean isInterLeave(String s1, String s2, String s3){
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < s1.length(); i++) {
            dp[i + 1][0] = s1.charAt(i) == s3.charAt(i) && dp[i][0];
        }
        for (int j = 0; j < s2.length(); j++){
            dp[0][j + 1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
        }
        for (int i = 0; i < s1.length(); i++){
            for (int j = 0; j < s2.length(); j++){
                dp[i + 1][j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1) && dp[i][j + 1]) || (s2.charAt(j) == s3.charAt(i + j + 1) && dp[i + 1][j]);
            }
        }
        return dp[s1.length()][s2.length()];
    }
    
    public static boolean isInterLeave2(String s1, String s2, String s3){
        if (s1.length() + s2.length() != s3.length()){
            return false;
        }
        if (s1.length() < s2.length()){
            return isInterLeave2(s2, s1, s3);
        }
        boolean[][] dp = new boolean[2][s2.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < s2.length(); j++){
            dp[0][j + 1] = s2.charAt(j) == s3.charAt(j) && dp[0][j];
        }
        for (int i = 0; i < s1.length(); i++){
            dp[(i + 1) % 2][0] = s1.charAt(i) == s3.charAt(i) && dp[i % 2][0];
            for (int j = 0; j < s2.length(); j++){
                dp[(i + 1) % 2][(j + 1)] = (s1.charAt(i) == s3.charAt(i + j + 1) && dp[i % 2][j + 1]) || (s2.charAt(j) == s3.charAt(i + j + 1) && dp[(i + 1) % 2][j]);
            }
        }
        return dp[s1.length() % 2][s2.length()];
    }
    
    public static boolean isInterLeave3(String s1, String s2, String s3){
        if (s1.length() < s2.length()){
            return isInterLeave3(s2, s1, s3);
        }
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int j = 0; j < s2.length(); j++){
            dp[j + 1] = s2.charAt(j) == s3.charAt(j) && dp[j];
        }
        for (int i = 0; i < s1.length(); i++){
            dp[0] = s1.charAt(i) == s3.charAt(i) && dp[0];
            for (int j = 0; j < s2.length(); j++){
                dp[j + 1] = (s1.charAt(i) == s3.charAt(i + j + 1) && dp[j + 1]) || (s2.charAt(j) == s3.charAt(i + j + 1) && dp[j]);
            }
        }
        return dp[s2.length()];
    }
}
