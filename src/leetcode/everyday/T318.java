package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/11/6 9:05
 * @Description 最大单词长度乘积
 * 
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
 * 
 * 示例 1：
 *
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16 
 * 解释：这两个单词为 "abcw", "xtfn"。
 * 示例 2：
 *
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4 
 * 解释：这两个单词为 "ab", "cd"。
 * 示例 3：
 *
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0 
 * 解释：不存在这样的两个单词。
 * 
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 */
public class T318 {
    
    public int maxProduct(String[] words) {
        int result = 0;
        int[][] wordsArray = new int[words.length][26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                wordsArray[i][words[i].charAt(j) - 'a'] = 1;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (result >= words[i].length() * words[j].length()){
                    continue;
                }
                if (containSameChar(wordsArray[i], wordsArray[j])){
                    continue;
                }
                result = words[i].length() * words[j].length();
            }
        }
        return result;
    }
    
    private boolean containSameChar(int[] word1, int[] word2) {
        for (int i = 0; i < word1.length; i++) {
            if (word1[i] == 1 && word2[i] == 1){
                return true;
            }
        }
        return false;
    }
}
