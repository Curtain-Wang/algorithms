package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/8/18 10:07
 * @Description
 */
public class T76 {
    
    public static void main(String[] args) {
        int a = 'a';
        int A = 'A';
        System.out.println(a);
        System.out.println(A);
        
        System.out.println(new T76().minWindow("a", "a"));
    }
    
    public String minWindow(String s, String t) {
        int[] target = new int[52];
        int[] window = new int[52];
        int tot = 0;
        for (int i = 0; i < t.length(); i++) {
            int index = getIndex(t.charAt(i));
            if (target[index] == 0){
                tot++;
            }
            target[index]++;
        }
        int i = 0;
        int j = 0;
        String result = "";
        while (j < s.length()){
            int indexJ = getIndex(s.charAt(j));
            window[indexJ]++;
            if (window[indexJ] == target[indexJ]){
                tot--;
            }
            int indexI = getIndex(s.charAt(i));
            while (window[indexI] > target[indexI] && i < j){
                i++;
                window[indexI]--;
                indexI = getIndex(s.charAt(i));
            }
            //满足覆盖条件的窗口
            if (tot == 0){
                if (result.length() > (j - i + 1)){
                    result = s.substring(i, j + 1);
                }
            }
            j++;
        }
        return result;        
    }
    
    public int getIndex(char a){
        return a >= 'a' ? (a - 'a') : (a - 'A' + 26);
    }
}
