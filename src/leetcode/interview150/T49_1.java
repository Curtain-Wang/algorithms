package leetcode.interview150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Curtain
 * @Date 2023/10/22 10:44
 * @Description
 */
public class T49_1 {
    
    //    public List<List<String>> groupAnagrams(String[] strs) {
//        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> {
//            int[] si = new int[26];
//            for (int i = 0; i < s.length(); i++) {
//                si[s.charAt(i) - 'a']++;
//            }
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < 26; i++) {
//                if (si[i] > 0){
//                    sb.append((char) ('a' + i)).append(si[i]);
//                }
//            }
//            return sb.toString();
//        })).values());
//    }
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(s -> Arrays.stream(s.split("")).sorted().collect(Collectors.joining()))).values());
    }
    
}
