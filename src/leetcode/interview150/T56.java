//package leetcode.interview150;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @Author Curtain
// * @Date 2023/10/26 20:21
// * @Description
// */
//public class T56 {
//    
//    public int[][] merge(int[][] intervals) {
//        ThreadLocal threadLocal = new ThreadLocal();
//        threadLocal.set();
//        threadLocal.remove();
//        new Thread(() -> {
//            threadLocal.set();
//        }).start();
//        List<int[]> list = new ArrayList<>();
//        List<int[]> collect = Arrays.stream(intervals).sorted((o1, o2) -> o1[0] - o2[0]).collect(Collectors.toList());
//        list.add(collect.get(0));
//        for (int i = 1; i < collect.size(); i++) {
//            int[] ints = list.get(list.size() - 1);
//            int[] ints1 = collect.get(i);
//            if (ints[1] >= ints1[0]){
//                ints[1] = Math.max(ints1[1], ints[1]);
//            }else {
//                list.add(ints1);
//            }
//        }
//        int[][] ans = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            ans[i][0] = list.get(i)[0];
//            ans[i][1] = list.get(i)[1];
//        }
//        return ans;
//    }
//    
//}
