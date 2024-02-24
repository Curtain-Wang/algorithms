package leetcode.hot100;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author Curtain
 * @Date 2023/9/21 14:49
 * @Description
 */
public class T295 {
    
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        
    }
}
class MedianFinder {
    
    //最小堆,存储大的那一半数据
    Queue<Integer> queueA = new PriorityQueue<>();
    //最大堆,存储小的那一半数据
    Queue<Integer> queueB = new PriorityQueue<>((x, y) -> y - x);
    
    public MedianFinder() {
    }
    
    public void addNum(int num) {
        if (queueA.size() == queueB.size()){
            queueB.offer(num);
            queueA.offer(queueB.poll());
        }else {
            queueA.offer(num);
            queueB.offer(queueA.poll());
        }
    }
    
    public double findMedian() {
        if (queueA.size() == queueB.size()){
            double a = queueA.peek();
            double b = queueB.peek();
            return a + (b - a) / 2;
        }else {
            return queueA.peek();
        }
    }
}
