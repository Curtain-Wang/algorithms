package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/8 16:04
 * @Description 买卖股票的最佳时机 II
 * 
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 */
public class T122 {
    
    public int maxProfit(int[] prices) {
        int ans = 0;
        int cost = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < cost){
                cost = prices[i];
            }else {
                ans += prices[i] - cost;
                cost = prices[i];
            }
        }
        return ans;
    }
}
