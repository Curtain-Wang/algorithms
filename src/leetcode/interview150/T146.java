package leetcode.interview150;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/11/15 10:17
 * @Description
 */
public class T146 {
    
    
}
class LRUCache {
    LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity;
    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return linkedHashMap.getOrDefault(key, -1);
    }
    
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return linkedHashMap.size() > capacity;
    }
}
