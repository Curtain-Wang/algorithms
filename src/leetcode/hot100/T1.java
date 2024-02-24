package leetcode.hot100;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/12 12:10
 * @Description
 */
public class T1 {
    
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(target - nums[i]);
            if (list == null) {
                continue;
            }
            for (Integer num : list) {
                if (num != i) {
                    return new int[]{i, num};
                }
            }
        }
        return null;
    }
}
