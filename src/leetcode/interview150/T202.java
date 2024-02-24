package leetcode.interview150;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/10/22 11:18
 * @Description
 */
public class T202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (true){
            int newVal = 0;
            while (n != 0){
                newVal += (n % 10) * (n % 10);
                n /= 10;
            }
            if (newVal == 1){
                return true;
            }
            if (set.contains(newVal)){
                return false;
            }
            set.add(newVal);
            n = newVal;
        }
    }
    
}
