package leetcode.everyday;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/28 13:44
 * @Description
 */
public class T57 {
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int st = newInterval[0];
        int ed = newInterval[1];
        boolean insert = false;
        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];
            if (ed < s){
                if (!insert){
                    ans.add(new int[]{st, ed});
                }
                ans.add(interval);
                insert = true;
            }else if (e < st){
                ans.add(interval);
            }else {
                st = Math.min(interval[0], st);
                ed = Math.max(interval[1], ed);
            }
        }
        if (!insert){
            ans.add(new int[]{st, ed});
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
