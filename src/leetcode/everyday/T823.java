package leetcode.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/8/29 10:46
 * @Description
 */
public class T823 {
    
    public int numFactoredBinaryTrees(int[] arr) {
        long mod = (long) (1e9 + 7);
        Map<Integer, Long> map = new HashMap();
        Arrays.sort(arr);
        map.put(arr[0], 1L);
        long ans = 1;
        for (int i = 1; i < arr.length; i++){
            long count = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0){
                    count += (map.get(arr[j]) * map.getOrDefault(arr[i] / arr[j], 0L)) % mod;
                    count %= mod;
                }
            }
            map.put(arr[i], count);
            ans += count;
            ans %= mod;
        }
        return (int) ans;
    }
}
