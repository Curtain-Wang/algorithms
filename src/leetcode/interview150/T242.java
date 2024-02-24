package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/20 14:04
 * @Description
 */
public class T242 {
    
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        int[] si = new int[26];
        int[] ti = new int[26];
        for (int i = 0; i < s.length(); i++) {
            si[s.charAt(i) - 'a']++;
            ti[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (si[i] != ti[i]){
                return false;
            }
        }
        return true;
    }
    
}
