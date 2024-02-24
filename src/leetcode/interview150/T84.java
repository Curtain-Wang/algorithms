package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/13 15:09
 * @Description
 */
public class T84 {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()){
            char tc = t.charAt(tIndex);
            char sc = s.charAt(sIndex);
            if (tc == sc){
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}
