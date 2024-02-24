package leetcode.everyday;

import java.util.Collections;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/11/24 8:57
 * @Description
 */
public class T2824 {
    
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        Integer lastIndex = nums.size() - 1;
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            while (nums.get(i) + nums.get(lastIndex) >= target && lastIndex > i){
                lastIndex--;
            }
            if (i == lastIndex){
                break;
            }
            ans += lastIndex - i;
        }
        return ans;
    }
}
