package leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/7 9:44
 * @Description
 * 
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 *
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 *
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 *
 * 实现 StockSpanner 类：
 *
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 */
public class T901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(32));
        System.out.println(stockSpanner.next(82));
        System.out.println(stockSpanner.next(73));
        System.out.println(stockSpanner.next(99));
        System.out.println(stockSpanner.next(91));
    }
    
    static class StockSpanner {
        private List<Integer> list;
        public StockSpanner() {
            list = new ArrayList<>();
        }
        
        public int next(int price) {
            int width = 1;
            for (int i = list.size() - 1; i >= 0; i--){
                if (list.get(i) <= price){
                    width++;
                }else {
                    break;
                }
            }
            list.add(price);
            return width;
        }
    }
}


