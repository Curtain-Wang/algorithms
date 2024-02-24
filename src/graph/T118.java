package graph;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/8/10 13:55
 * @Description
 */
public class T118 {
    
    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {3, 4}, {2, 5}};
        System.out.println(new T118().findRedundantConnection(edges));
    }
    
    public int[] findRedundantConnection(int[][] edges){
        Map<Integer, Integer> fatherMap = new HashMap<>();
        int[] result = null;
        for (int[] edge : edges) {
            fatherMap.putIfAbsent(edge[0], edge[0]);
            fatherMap.putIfAbsent(edge[1], edge[1]);
            if (!union(fatherMap, edge[0], edge[1])){
                result = edge;
            }
        }
        return result;
    }
    
    private boolean union(Map<Integer, Integer> fatherMap, int i, int j) {
        int fatherI = findFather(fatherMap, i);
        int fatherJ = findFather(fatherMap, j);
        if (fatherI != fatherJ){
            fatherMap.put(fatherI, fatherJ);
            return true;
        }
        return false;
    }
    
    private int findFather(Map<Integer, Integer> fatherMap, int i) {
        if (fatherMap.get(i) != i){
            fatherMap.put(i, findFather(fatherMap, fatherMap.get(i)));
        }
        return fatherMap.get(i);
    }
    
}
