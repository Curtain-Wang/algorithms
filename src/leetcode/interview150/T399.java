package leetcode.interview150;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/11/29 16:25
 * @Description
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 * 注意：未在等式列表中出现的变量是未定义的，因此无法确定它们的答案。
 * 
 * map 加 回溯
 */
public class T399 {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> startMap = new HashMap();
        double[] ans = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String start = equation.get(0);
            String end = equation.get(1);
            Map<String, Double> endMap = startMap.get(start);
            if (endMap == null){
                endMap = new HashMap<>();
                startMap.put(start, endMap);
            }
            endMap.put(end, values[i]);
            if (values[i] == 0){
                continue;
            }
            endMap = startMap.get(end);
            if (endMap == null){
                endMap = new HashMap<>();
                startMap.put(end, endMap);
            }
            endMap.put(start, 1 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            ans[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), startMap, 1.0);
        }
        
        return ans;
    }
    
    private double dfs(String start, String end, Map<String, Map<String, Double>> startMap, double nowValue){
        Map<String, Double> endMap = startMap.get(start);
        if (endMap == null){
            return -1;
        }
        Double endValue = endMap.get(end);
        if (endValue != null){
            return nowValue * endValue;
        }
        double ans = -1;
        for (String s : endMap.keySet()) {
            startMap.remove(start);
            ans = dfs(s, end, startMap, endMap.get(s) * nowValue);
            startMap.put(start, endMap);
            if (ans != -1){
                return ans;
            }
        }
        return ans;
    }
}
