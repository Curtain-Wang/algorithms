package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2024/1/10 15:36
 * @Description
 */
public class T9 {
    
    //    public boolean isPalindrome(int x) {
//        if (x < 0){
//            return false;
//        }
//        List<Integer> list = new ArrayList<>();
//        while (x > 0){
//            list.add(x % 10);
//            x /= 10;
//        }
//        for (int i = 0; i < list.size() / 2; i++) {
//            if (list.get(i).intValue() != list.get(list.size() - i - 1)){
//                return false;
//            }
//        }
//        return true;
//    }
    
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int n = 0;
        while (x > n){
            n = n * 10 + x % 10;
            x /= 10;
        }
        return n == x || n / 10 == x;
    }
}
