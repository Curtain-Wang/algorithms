package leetcode.interview150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/10/19 13:04
 * @Description 同构字符串
 * 
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 *
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 *
 *
 *
 * 示例 1:
 *
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 *
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 5 * 10^4
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class T205 {
    
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = map.get(s.charAt(i));
            if (character == null){
                map.put(s.charAt(i), t.charAt(i));
            }else {
                if (!character.equals(t.charAt(i))){
                    return false;
                }
            }
        }
        Set<Character> set = new HashSet<>();
        for (Character value : map.values()) {
            if (set.contains(value)){
                return false;
            }else {
                set.add(value);
            }
        }
        return true;
    }
}
