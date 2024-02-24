package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/8 15:53
 * @Description
 * 
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class T121 {
    
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            ans = Math.max(ans, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return ans;
    }
}
