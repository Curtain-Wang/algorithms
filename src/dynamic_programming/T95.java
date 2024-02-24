package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/8/1 14:10
 * @Description
 */
public class T95 {
    
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence3("abcde", "badfe"));
    }
    
    public static int longestCommonSubsequence(String text1, String text2){
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                char ch1 = text1.charAt(i);
                char ch2 = text2.charAt(j);
                if (ch1 == ch2){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
    
    public static int longestCommonSubsequence2(String text1, String text2){
        if (text1.length() < text2.length()){
            return longestCommonSubsequence2(text2, text1);
        }
        int[][] dp = new int[2][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                char ch1 = text1.charAt(i);
                char ch2 = text2.charAt(j);
                if (ch1 == ch2){
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                }else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j + 1]);
                }
            }
        }
        return dp[text1.length() % 2][text2.length()];
    }
    
    public static int longestCommonSubsequence3(String text1, String text2){
        if (text1.length() < text2.length()){
            return longestCommonSubsequence2(text2, text1);
        }
        int[] dp = new int[text2.length() + 1];
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < text1.length(); i++){
            for (int j = 0; j < text2.length(); j++){
                if (text1.charAt(i) == text2.charAt(j)){
                    cur  = pre + 1;
                }else {
                    cur = Math.max(dp[j], dp[j + 1]);
                }
                pre = dp[j + 1];
                dp[j + 1] = cur;
            }
        }
        return dp[text2.length()];
    }
}
