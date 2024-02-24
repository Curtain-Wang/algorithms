package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/26 9:26
 * @Description
 */
public class T76 {
    
    public String minWindow(String s, String t) {
        String ans = "";
        int[] c1 = new int[52];
        int[] c2 = new int[52];
        int tot = 0;
        for (int i = 0; i < t.length(); i++) {
            if (c1[getIndex(t.charAt(i))]++ == 0){
                tot++;
            }
        }
        for (int i = 0, j = 0; i < s.length(); i++) {
            int idxI = getIndex(s.charAt(i));
            if (++c2[idxI] == c1[idxI]){
                tot--;
            }
            int idxJ = getIndex(s.charAt(j));
            while (j < i && c2[idxJ] > c1[idxJ]){
                c2[idxJ]--;
                idxJ = getIndex(s.charAt(++j));
            }
            if (tot == 0 && (ans == "" || ans.length() > (i - j + 1))){
                ans = s.substring(j, i + 1);
            }
        }
        return ans;
    }
    
    private int getIndex(char c) {
        return (c >= 'A' && c <= 'Z') ? c - 'A' + 26 : c - 'a';
    }
}
