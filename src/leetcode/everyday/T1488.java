package leetcode.everyday;

import java.util.*;

/**
 * @Author Curtain
 * @Date 2023/10/13 16:10
 * @Description 避免洪水泛滥
 */
public class T1488 {
    
    public static void main(String[] args) {
        int[] a = {1,2,0,0,2,1};
        System.out.println(new T1488().avoidFlood(a));
    }
    
    public int[] avoidFlood(int[] rains) {
        //满足条件的不下雨日子
        List<Integer> noRainList = new ArrayList<>();
        Set<Integer> rainSet = new HashSet<>();
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < rains.length; i++) {
            //说明要下雨
            if (rains[i] > 0){
                //之前已经下过了
                if (rainSet.contains(rains[i])){
                    //没有可以抽干的日子
                    if (noRainList.size() == 0){
                        return new int[0];
                    }
                    //有可以抽干的日子
                    ans[noRainList.get(0)] = rains[i];
                    noRainList.remove(0);
                }else {
                    rainSet.add(rains[i]);
                }
            }else {
                if (noRainList.size() < rainSet.size()){
                    noRainList.add(i);
                }else {
                    ans[i] = 1;
                }
            }
        }
        for (Integer i : noRainList) {
            ans[i] = 1;
        }
        return ans;
    }
}
