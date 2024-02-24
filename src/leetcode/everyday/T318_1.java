package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/11/6 10:17
 * @Description
 */
public class T318_1 {
    
    public int maxProduct1(String[] words) {
        int result = 0;
        int[] wordsInt = new int[words.length];
        int index = 0;
        for (String word : words) {
            int val = 0;
            for (int i = 0; i < word.length(); i++) {
                val |= (1 << (word.charAt(i) - 'a'));
            }
            wordsInt[index++] = val;
        }
        for (int i = 0; i < wordsInt.length; i++) {
            for (int j = i + 1; j < wordsInt.length; j++) {
                if ((wordsInt[i] & wordsInt[j]) == 0){
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }
    
    public int maxProduct(String[] words) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int val = 0;
            for (int j = 0; j < words[i].length(); j++) {
                val |= (1 << words[i].charAt(j));
            }
            if (!map.containsKey(val) || map.get(val) < words[i].length()){
                map.put(val, words[i].length());
            }
        }
        for (Integer val : map.keySet()) {
            for (Integer val1 : map.keySet()) {
                if ((val & val1) == 0){
                    result = Math.max(result, map.get(val) * map.get(val1));
                }
            }
        }
        return result;
    }
}
