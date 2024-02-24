package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/10/29 12:07
 * @Description
 */
public class t74 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;
        while (h > 0){
            if (citations[citations.length - h] >= h){
                return h;
            }
            h--;
        }
        return h;
    }
}
