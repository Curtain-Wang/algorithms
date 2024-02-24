package leetcode.interview150;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2023/10/26 19:46
 * @Description
 */
public class T128 {
    
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                //新的集合
                int lenght = 1;
                while (set.contains(++num)) {
                    lenght++;
                }
                ans = Math.max(ans, lenght);
            }
        }
        return ans;
    }
    
}
