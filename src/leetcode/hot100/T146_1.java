package leetcode.hot100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/9/1 14:54
 * @Description
 */
public class T146_1 {
}

class LRUCache extends LinkedHashMap<Integer, Integer>{
    
    private int capacity;
    
    public LRUCache(int capacity){
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}
