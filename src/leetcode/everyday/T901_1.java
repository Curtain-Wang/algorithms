package leetcode.everyday;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/7 10:07
 * @Description
 */
public class T901_1 {
    
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(32));
        System.out.println(stockSpanner.next(1));
        System.out.println(stockSpanner.next(1));
        System.out.println(stockSpanner.next(1));
        System.out.println(stockSpanner.next(1));
    }
    
    static class StockSpanner {
        private int curDay = -1;
        private Deque<int[]> deque = new ArrayDeque<>();
        public StockSpanner() {
            deque.push(new int[]{-1, Integer.MAX_VALUE});
        }
        
        public int next(int price) {
            while (price >= deque.peek()[1]){
                deque.pop();
            }
            int[] peek = deque.peek();
            curDay++;
            deque.push(new int[]{curDay, price});
            return curDay - peek[0];
        }
    }
}


