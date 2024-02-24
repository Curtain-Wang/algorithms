package leetcode.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/22 10:32
 * @Description 字母异位词分组
 * 
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class T49 {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] used = new int[strs.length];
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (used[i] == 0){
                result.add(getAllogramWords(strs, used, i));
            }
        }
        return result;
    }
    
    private List<String> getAllogramWords(String[] strs, int[] used, int i) {
        List<String> result = new ArrayList<>();
        result.add(strs[i]);
        int[] baseChars = new int[26];
        for (int j = 0; j < strs[i].length(); j++) {
            baseChars[strs[i].charAt(j) - 'a']++;
        }
        for (int j = i + 1; j < strs.length; j++) {
            if (used[j] == 0 && strs[j].length() == strs[i].length()){
                int[] chars = new int[26];
                for (int k = 0; k < strs[j].length(); k++) {
                    chars[strs[j].charAt(k) - 'a']++;
                }
                if (Arrays.equals(baseChars, chars)){
                    result.add(strs[j]);
                    used[j] = 1;
                }
            }
        }
        return result;
    }
}
