package leetcode.hot100;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/9/21 8:58
 * @Description
 */
public class T139 {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>();
        for (String s1 : wordDict) {
            wordSet.add(s1);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i - 1; j >= 0 && !dp[i]; j--){
                if (wordSet.contains(s.substring(j, i))){
                    dp[i] = dp[j];
                }
            }
        }
        return dp[s.length()];
    }
}
