package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/10/24 15:22
 * @Description
 */
public class T380 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.getRandom());
    }
    
}
class RandomizedSet {
    
    int[] a = new int[200000];
    int idx = 0;
    Map<Integer, Integer> valueIndexMap = new HashMap<>();
    Random random = new Random();
    
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)){
            return false;
        }
        a[idx] = val;
        valueIndexMap.put(val, idx++);
        return true;
    }
    
    public boolean remove(int val) {
        if (!valueIndexMap.containsKey(val)){
            return false;
        }
        Integer removeIndex = valueIndexMap.get(val);
        valueIndexMap.remove(val);
        if (removeIndex != idx - 1){
            valueIndexMap.put(a[idx - 1], removeIndex);
            a[removeIndex] = a[idx - 1];
        }
        idx--;
        return true;
    }
    
    public int getRandom() {
        return a[random.nextInt(idx)];
    }
}