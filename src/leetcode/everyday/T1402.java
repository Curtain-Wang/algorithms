package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/10/22 8:46
 * @Description
 */
public class T1402 {
    
    public static void main(String[] args) {
        int[] nums = {4, 3, 2};
        System.out.println(new T1402().maxSatisfaction(nums));
    }
    
    /**
     * 2 3 4
     * 4
     * 4 * 2 + 3
     * 4 * 3 + 3 * 2
     *
     * @param satisfaction
     * @return
     */
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int ans = 0;
        int suffixSUm = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            if (satisfaction[i] >= 0 || suffixSUm > Math.abs(satisfaction[i])) {
                ans += suffixSUm + satisfaction[i];
                suffixSUm += satisfaction[i];
            } else {
            }
            break;
        }
        return ans;
    }
}
