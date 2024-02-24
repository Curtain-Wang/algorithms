package leetcode.interview150;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/10/22 11:29
 * @Description
 */
public class T219 {
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null && i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}
