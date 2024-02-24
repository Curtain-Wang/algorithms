package leetcode.everyday;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/10/8 17:06
 * @Description
 * 
 * 给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
 */
public class T2034 {
}

class StockPrice {
    
    Map<Integer, Integer> map;
    Integer maxDay = 0;
    TreeMap<Integer, Integer> pricesMap;
    
    public StockPrice() {
        map = new HashMap<>();
        pricesMap = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (map.containsKey(timestamp)){
            int old = map.get(timestamp);
            if (pricesMap.merge(old, -1, Integer::sum) == 0){
                pricesMap.remove(old);
            }
        }
        map.put(timestamp, price);
        pricesMap.merge(price, 1, Integer::sum);
        maxDay = Math.max(timestamp, maxDay);
    }
    
    public int current() {
        return map.get(maxDay);
    }
    
    public int maximum() {
        return pricesMap.lastKey();
    }
    
    public int minimum() {
        return pricesMap.firstKey();
    }
}
