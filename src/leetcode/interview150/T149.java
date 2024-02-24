package leetcode.interview150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author Curtain
 * @Date 2024/2/22 9:34
 * @Description
 * 
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * 
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * points 中的所有点 互不相同
 */
public class T149 {
    
//    public int maxPoints(int[][] points) {
//        Map<String, Integer> countMap = new HashMap<>();
//        for (int[] point1 : points) {
//            Set<String> cache = new HashSet<>();
//            for (int[] point2 : points) {
//                //相同点不做处理
//                if (point1[0] == point2[0] && point1[1] == point2[1]){
//                    continue;
//                }
//                String kb = calcKB(point1, point2);
//            }
//        }
//    }
    
    /**
     * k * i1 = y1 - b
     * k * i2 = y2 - b
     * k(i1 - i2) = y1 - y2
     *b = y1 - k * i1;
     * @param point1
     * @param point2
     * @return
     */
//    private String calcKB(int[] point1, int[] point2) {
//        int kfz = point1[1] - point2[1];
//        int bfm = point1[0] - point2[0];
//        int b = point1[1] - kfz *
//    }
}
