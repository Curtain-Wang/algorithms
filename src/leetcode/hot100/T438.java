package leetcode.hot100;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/14 9:29
 * @Description 找到字符串中所有字母异位词
 * 
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * 
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */
public class T438 {
    
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(new T438().findAnagrams(s, p));
    }
    
    public List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()){
            return result;
        }
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        int diff = 0;
        for (int i : count) {
            if (i != 0){
                diff++;
            }
        }
        if (diff == 0){
            result.add(0);
        }
        for (int i = 0; i < s.length() - p.length(); i++) {
            //滑动窗口要去掉第i个元素，如果第i元素对应的计数是多出来一个的话，那么去掉刚好减少一个差异
            if (count[s.charAt(i) - 'a'] == 1){
                diff--;
            }else if (count[s.charAt(i) - 'a'] == 0){
                diff++;
            }
            count[s.charAt(i) - 'a']--;
            if (count[s.charAt(i + p.length()) - 'a'] == -1){
                diff--;
            }else if (count[s.charAt(i + p.length()) - 'a'] == 0){
                diff++;
            }
            count[s.charAt(i + p.length()) - 'a']++;
            if (diff == 0){
                result.add(i + 1);
            }
        }
        return result;
    }
    
    /**
     * 普通版滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] intsp = new int[26];
        for (int i = 0; i < p.length(); i++) {
            intsp[p.charAt(i) - 'a']++;
        }
        int[] window = new int[26];
        int left = 0;
        int right = 0;
        while (right < s.length()){
            window[s.charAt(right) - 'a']++;
            if (right - left == p.length() - 1){
                if (Arrays.equals(intsp, window)){
                    result.add(left);
                }
                window[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return result;
    }
}
