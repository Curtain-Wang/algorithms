package leetcode.interview150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2024/1/15 14:40
 * @Description
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 *
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * 
 * 序列 DP
 * 将字符串 s 长度记为 n，wordDict 长度记为 m。为了方便，我们调整字符串 s 以及将要用到的动规数组的下标从 1 开始。
 *
 * 定义 f[i] 为考虑前 i 个字符，能否使用 wordDict 拼凑出来：当 f[i]=true 代表 s[1...i] 能够使用 wordDict 所拼凑，反之则不能。
 *
 * 不失一般性考虑 f[i] 该如何转移：由于 f[i] 需要考虑 s[1...i] 范围内的字符，若 f[i] 为 True 说明整个 s[1...i] 都能够使用 wordDict 拼凑，自然也包括最后一个字符 s[i] 所在字符串 sub。
 *
 * 我们可以枚举最后一个字符所在字符串的左端点 j，若 sub=s[j...i]在 wordDict 中出现过，并且 f[j−1]=True，
 * 说明 s[0...(j−1)] 能够被拼凑，并且子串 sub 也在 wordDict，可得 f[i] = True。
 *
 * 为了快速判断某个字符是否在 wordDict 中出现，我们可以使用 Set 结构对 wordDict[i]进行转存。
 *
 */ 
public class T139 {
    
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new T139().wordBreak("leetcode", wordDict));
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>();
        for (String word : wordDict) {
            wordSet.add(word);
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i && !dp[i]; j++) {
                String substring = s.substring(j, i);
                if (wordSet.contains(substring)){
                    dp[i] = dp[j];
                }
            }
        }
        return dp[s.length()];
    }
}
