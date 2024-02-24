package leetcode.hot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/8/12 11:30
 * @Description
 */
public class T128 {
    
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Set set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        int maxLength = 1;
        for (int num : nums) {
            if (!set.contains(num)){
                continue;
            }
            int length = getLength(set, num);
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
    
    private int getLength(Set set, int num) {
        set.remove(num);
        int length = 1;
        if (set.contains(num - 1)){
            length += getLength(set, num - 1);
        }
        if (set.contains(num + 1)){
            length += getLength(set, num + 1);
        }
        return length;
    }
}
