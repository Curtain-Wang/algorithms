package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/21 13:12
 * @Description 合并区间
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */
public class T56 {
    
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
//        int[][] intervals = {{1,4},{4,5}};
        int[][] merge = new T56().merge(intervals);
        System.out.println(merge);
    }
    
    private int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        int[][] res = new int[intervals.length][2];
        int index = -1;
        for (int[] interval : intervals) {
            if (index == -1 || interval[0] > res[index][1]){
                res[++index] = interval;
            }else {
                res[index][1] = Math.max(res[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, index + 1);
    }
    
    public int[][] merge1(int[][] intervals) {
        int[][] dp = new int[105][2];
        for (int[] interval : intervals) {
            dp[interval[0]][0]++;
            dp[interval[1]][1]++;
        }
        int count = 0;
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < dp.length; i++) {
            if (dp[i][0] > 0 && count == 0) {
                //说明此刻是一个区间的起点
                int[] a = new int[2];
                a[0] = i;
                result.add(a);
            }
            count += dp[i][0];
            count -= dp[i][1];
            //说明此刻是一个区间的终点
            if (count == 0 && dp[i][1] != 0){
                result.get(result.size() - 1)[1] = i;
            }
        }
        int[][] result1 = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            result1[i][0] = result.get(i)[0];
            result1[i][1] = result.get(i)[1];
        }
        return result1;
    }
}
