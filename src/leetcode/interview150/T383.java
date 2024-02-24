package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/18 10:31
 * @Description  赎金信
 * 
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 *
 * 如果可以，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class T383 {
    
    public static void main(String[] args) {
        System.out.println(new T383().canConstruct("az", "ab"));
    }
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineChars = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            magazineChars[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (magazineChars[ransomNote.charAt(i) - 'a']-- == 0){
                return false;
            }
        }
        return true;
    }
}
