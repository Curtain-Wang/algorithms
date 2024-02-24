package leetcode;

/**
 * @Author Curtain
 * @Date 2024/2/23 16:16
 * @Description
 */
public class T1839 {
    
    public int longestBeautifulSubstring(String word) {
        int ans = 0;
        int type = 1;
        int len = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)){
                len++;
            }else if (word.charAt(i) > word.charAt(i - 1)){
                len++;
                type++;
            }else {
                len = 1;
                type = 1;
            }
            if (type == 5){
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
