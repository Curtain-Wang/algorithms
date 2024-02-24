package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/31 16:23
 * @Description
 * 
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 */
public class T155 {
    
    static class MinStack {
    
        List<Integer> data = new ArrayList<>();
        int min = Integer.MAX_VALUE;
    
        public MinStack() {
        
        }
    
        public void push(int val) {
            data.add(val);
            min = Math.min(min, val);
        }
    
        public void pop() {
            Integer top = data.get(data.size() - 1);
            data.remove(data.size() - 1);
            if (top == min){
                min = Integer.MAX_VALUE;
                for (Integer datum : data) {
                    min = Math.min(datum, min);
                }
            }
        }
    
        public int top() {
            return data.get(data.size() - 1);
        }
    
        public int getMin() {
            return min;
        }
    }
}


