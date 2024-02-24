package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/10/22 11:00
 * @Description
 */
public class T1 {
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
