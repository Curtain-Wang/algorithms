package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/31 15:33
 * @Description
 */
public class T57 {
    
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {6, 8};
        System.out.println(new T57().insert(intervals, newInterval));
    }
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] ans = new int[1][2];
            ans[0][0] = newInterval[0];
            ans[0][1] = newInterval[1];
            return ans;
        }
        List<int[]> ansList = new ArrayList<>();
        int i = 0;
        int flag = 1;
        while (i < intervals.length) {
            //没有交集，直接添加
            if (intervals[i][0] > newInterval[1] || intervals[i][1] < newInterval[0]) {
                ansList.add(intervals[i]);
            } else {
                flag = 0;
                int[] addInt = new int[2];
                addInt[0] = Math.min(intervals[i][0], newInterval[0]);
                //新区间不会超过当前区间
                if (newInterval[1] <= intervals[i][1]) {
                    addInt[1] = intervals[i][1];
                    ansList.add(addInt);
                    i++;
                    continue;
                }
                addInt[1] = newInterval[1];
                //新区间会超过下个区间
                while (i < intervals.length - 1 && intervals[i + 1][1] < newInterval[1]) {
                    i++;
                }
                //此时时，新区间能超过当前区间，但是超不过下个区间
                //新区间能到达下个区间
                if (i < intervals.length - 1 && newInterval[1] >= intervals[i + 1][0]) {
                    addInt[1] = intervals[i + 1][1];
                    i++;
                }
                ansList.add(addInt);
            }
            i++;
        }
        int[][] ans = new int[ansList.size() + flag][2];
        int k = 0;
        for (int j = 0; j < ans.length; j++) {
            if (flag == 0 || (k < ansList.size() && ansList.get(k)[0] < newInterval[0])) {
                ans[j][0] = ansList.get(k)[0];
                ans[j][1] = ansList.get(k)[1];
                k++;
            } else {
                flag = 0;
                ans[j][0] = newInterval[0];
                ans[j][1] = newInterval[1];
            }
        }
        return ans;
    }
}
