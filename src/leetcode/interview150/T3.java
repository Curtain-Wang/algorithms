package leetcode.interview150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/10/20 14:08
 * @Description 无重复字符的最长子串
 * 
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 10^4
 * s 由英文字母、数字、符号和空格组成
 */
public class T3 {
    
    public static void main(String[] args) {
        System.out.println(new T3().lengthOfLongestSubstring("pwwkew"));
    }
    
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()){
            char rightC = s.charAt(right);
            if (map.containsKey(rightC) && map.get(rightC) >= left){
                ans = Math.max(ans, right - left);
                left = map.get(rightC) + 1;
            }
            map.put(rightC, right);
            right++;
        }
        return Math.max(ans, right - left);
    }
}
