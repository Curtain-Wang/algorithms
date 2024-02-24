package leetcode.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/10/20 13:54
 * @Description 单词规律
 * 
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 *
 *
 * 示例1:
 *
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 */
public class T290 {
    
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if (sArray.length != pattern.length()){
            return false;
        }
        Map<Character, String> sp = new HashMap<>();
        Map<String, Character> ps = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char pc = pattern.charAt(i);
            String si = sArray[i];
            if (sp.get(pc) != null && !sp.get(pc).equals(si)){
                return false;
            }
            sp.put(pc, si);
            if (ps.get(si) != null && !ps.get(si).equals(pc)){
                return false;
            }
            ps.put(si, pc);
        }
        return true;
    }
}
