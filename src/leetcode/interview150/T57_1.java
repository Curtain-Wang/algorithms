package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/31 16:19
 * @Description
 */
public class T57_1 {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ansList = new ArrayList<>();
        int ns = newInterval[0];
        int ne = newInterval[1];
        boolean insert = false;
        for (int i = 0; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (ne < s){
                if (!insert){
                    insert = true;
                    ansList.add(new int[]{ns, ne});
                }
                ansList.add(intervals[i]);
            }else if (ns > e){
                ansList.add(intervals[i]);
            }else {
                ns = Math.min(ns, s);
                ne = Math.max(ne, e);
            }
        }
        if (!insert){
            ansList.add(new int[]{ns, ne});
        }
        return ansList.toArray(new int[ansList.size()][]);
    }
}
