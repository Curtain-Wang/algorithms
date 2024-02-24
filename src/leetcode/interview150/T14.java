package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/12 9:25
 * @Description 最长公共前缀
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class T14 {
    
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(new T14().longestCommonPrefix(strs));
    }
    
    public String longestCommonPrefix(String[] strs) {
        int index = 0;
        boolean falg = true;
        while (falg){
            if (strs[0].length() <= index){
                break;
            }
            char c = strs[0].charAt(index);
            for (int j = 1; j < strs.length; j++) {
                if (index >= strs[j].length() || strs[j].charAt(index) != c){
                    index--;
                    falg = false;
                    break;
                }
            }
            index++;
        }
        return strs[0].substring(0, index);
    }
}
