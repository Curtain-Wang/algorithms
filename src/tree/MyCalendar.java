package tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @Author Curtain
 * @Date 2023/6/27 11:25
 * @Description
 */
public class MyCalendar {
    private TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    
    public MyCalendar() {
        this.treeMap = new TreeMap<>();
    }
    
    public boolean book(Integer start, Integer end){
        Map.Entry<Integer, Integer> floorEntry = treeMap.floorEntry(start);
        if (floorEntry != null && floorEntry.getValue() > start){
            return false;
        }
        Map.Entry<Integer, Integer> ceiling = treeMap.ceilingEntry(start);
        if (ceiling != null && ceiling.getKey() < end){
            return false;
        }
        treeMap.put(start, end);
        return true;
    }
}
