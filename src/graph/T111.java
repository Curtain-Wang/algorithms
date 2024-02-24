package graph;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/8/9 14:44
 * @Description
 */
public class T111 {
    
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> e1 = new ArrayList<>();
        e1.add("a");
        e1.add("b");
        equations.add(e1);
        List<String> e2 = new ArrayList<>();
        e2.add("b");
        e2.add("c");
        equations.add(e2);
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>();
        q1.add("a");
        q1.add("c");
        queries.add(q1);
        List<String> q2 = new ArrayList<>();
        q2.add("b");
        q2.add("a");
        queries.add(q2);
        List<String> q3 = new ArrayList<>();
        q3.add("x");
        q3.add("x");
        queries.add(q3);
        System.out.println(new T111().calcEquation(equations, values, queries));
    }
    
    private double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if (!graph.containsKey(from) || !graph.containsKey(to)) {
                result[i] = -1;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(visited, from, to, graph);
            }
        }
        return result;
    }
    
    private double dfs(Set<String> visited, String from, String to, Map<String, Map<String, Double>> graph) {
        if (from.equals(to)) {
            return 1.0;
        }
        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            String key = entry.getKey();
            if (!visited.contains(key)) {
                double result2 = entry.getValue();
                double result1 = dfs(visited, key, to, graph);
                if (result1 > 0) {
                    return result2 * result1;
                }
            }
        }
        visited.remove(from);
        return -1;
    }
    
    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> list = equations.get(i);
            map.putIfAbsent(list.get(0), new HashMap<>());
            map.get(list.get(0)).put(list.get(1), values[i]);
            map.putIfAbsent(list.get(1), new HashMap<>());
            map.get(list.get(1)).put(list.get(0), 1 / values[i]);
        }
        return map;
    }
}
