package nowcoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2024/2/23 9:57
 * @Description
 */
public class NC61 {
    
    
    
    
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param numbers int整型一维数组 
     * @param target int整型 
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])){
                res[0] = map.get(numbers[i]) + 1;
                res[1] = i + 1;
            }
            map.put(target - numbers[i], i);
        }
        return res;
    }
}
