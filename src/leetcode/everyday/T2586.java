package leetcode.everyday;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/11/7 19:09
 * @Description
 */
public class T2586 {
    static Set<Character> set = new HashSet<>();
    static {
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
    }
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))){
                ans++;
            }
        }
        return ans;
    }
}
