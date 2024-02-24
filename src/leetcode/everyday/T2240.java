package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/9/1 15:49
 * @Description
 */
public class T2240 {
    
    public static void main(String[] args) {
        long l = new T2240().waysToBuyPensPencils2(20, 10, 5);
        System.out.println(l);
    }
    
    
    public long waysToBuyPensPencils1(int total, int cost1, int cost2) {
        int i1 = total / cost1;
        long res = 0;
        for (int i = 0; i <= i1; i++) {
            int remain = total - cost1 * i;
            res += remain / cost2 + 1;
        }
        return res;
    }
    
    /**
     * f(total) = f(total - cost1) + 1 + f(total - cost2) + 1;
     * @param total
     * @param cost1
     * @param cost2
     * @return
     */
    public long waysToBuyPensPencils2(int total, int cost1, int cost2) {
        long[] dp = new long[total + 1];
        int[] costs = {cost1, cost2};
        for (int cost : costs) {
            for (int i = cost; i <= total; i++) {
               dp[i] += dp[i - cost] + 1;
            }
        }
        return dp[total] + 1;
    }
    
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        Map<Integer, Long> map = new HashMap<>();
        int[] costs = {cost1, cost2};
        return calc(total, costs, map) + 1;
    }
    
    private long calc(int total, int[] costs, Map<Integer, Long> map) {
        if (map.get(total) != null){
            return map.get(total);
        }
        long result = 0;
        for (int cost : costs) {
            if (total >= cost){
                result += calc(total - cost, costs, map) + 1;
            }
        }
        map.put(total, result);
        return result;
    }
}
