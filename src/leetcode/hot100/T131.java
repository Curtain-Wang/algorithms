package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/14 10:00
 * @Description
 */
public class T131 {
    List<List<String>> result = new ArrayList<>();
    List<String> demo = new ArrayList<>();
    String s = null;
    public List<List<String>> partition(String s) {
        this.s = s;
        recall(0);
        return result;
    }
    
    private void recall(int startIndex) {
        if (s.length() == startIndex) {
            result.add(new ArrayList<>(demo));
        } else {
            for (int i = startIndex; i < s.length(); i++) {
                if (isPalindromeStr(startIndex, i)) {
                    demo.add(s.substring(startIndex, i + 1));
                    recall(i + 1);
                    demo.remove(demo.size() - 1);
                }
            }
        }
    }
    
    private boolean isPalindromeStr(int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
