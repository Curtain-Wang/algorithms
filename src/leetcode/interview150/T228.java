package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/24 16:00
 * @Description
 */
public class T228 {
    
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length - 1 && nums[j + 1] - nums[j] == 1){
                j++;
            }
            if (i == j){
                result.add(String.valueOf(nums[i]));
            }else {
                result.add(nums[i] + "-->" + nums[j]);
            }
            i = j;
        }
        return result;
    }
}
