package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/22 15:46
 * @Description 线性 DP
 * 定义 f[i][j] 为使用 s1 的前 i 个字符，使用 s2 的前 j 个字符，能否凑出 s3 的前 i+j 个字符。
 * <p>
 * 为了方便，我们令所有字符串的下标均从 1 开始。
 * <p>
 * 不失一般性，考虑 f[i][j] 如何转移，根据 s1[i]、s2[j] 和 s3[i+j] 是否相等进行分析，即根据当前 s3 的最后一个字符 s3[i+j] 由 s1[i] 和 s2[j] 谁来提供进行讨论：
 * <p>
 * s1[i]=s3[i+j]：说明当前 s3 的最后一个字符 s3[i+j] 可由 s1[i] 提供，而 s3 此前的 i+j−1 个字符，可由 s1 的前 i−1 字符和 s2 的前 j 个字符共同提供。此时若 f[i−1][j] 为真，则有 f[i][j] 为真。
 * s2[j]=s3[i+j]：说明当前 s3 的最后一个字符串 s3[i+j] 可由 s2[j] 提供，而 s3 此前的 i+j−1 个字符，可由 s1 的前 i 字符和 s2 的前 j−1 个字符共同提供。此时若 f[i][j−1] 为真，则有 f[i][j] 为真。
 * 综上，只有上述条件任一成立，f[i][j] 即为真。
 * <p>
 * 一些细节：为了在转移过程中减少边界处理，我们先预处理出 f[0][X] 和 f[X][0] 的状态值（即 s1、s2 和 s3 之间的公共前缀）。
 * <p>
 * 作者：宫水三叶
 * 链接：https://leetcode.cn/problems/interleaving-string/solutions/2358417/gong-shui-san-xie-yi-ti-shuang-jie-ji-yi-51da/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class T97 {
    
    public static void main(String[] args) {
        System.out.println(new T97().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.length() > s2.length()) {
            return isInterleave(s2, s1, s3);
        }
        boolean[] dp = new boolean[s1.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s1.length(); i++) {
            if (dp[i] && s1.charAt(i) == s3.charAt(i)) {
                dp[i + 1] = true;
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            dp[0] = dp[0] && s2.charAt(i) == s3.charAt(i);
            for (int j = 0; j < s1.length(); j++) {
                dp[j + 1] = (s1.charAt(j) == s3.charAt(i + j + 1) && dp[j]) || (s2.charAt(i) == s3.charAt(j + i + 1) && dp[j + 1]);
            }
        }
        return dp[s1.length()];
    }
}
