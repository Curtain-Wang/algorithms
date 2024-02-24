package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/10/28 9:57
 * @Description
 */
public class T2558 {
    
    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        System.out.println(new T2558().pickGifts(gifts, 4));
    }
    
    public long pickGifts(int[] gifts, int k) {
        Arrays.sort(gifts);
        int length = gifts.length;
        while (k-- > 0){
            int tmp = (int) Math.sqrt(gifts[length - 1]);
            int index = length - 1;
            while (index > 0 && gifts[index - 1] > tmp){
                gifts[index] = gifts[index - 1];
                index--;
            }
            gifts[index] = tmp;
        }
        long ans = 0;
        for (int gift : gifts) {
            ans += gift;
        }
        return ans;
    }
}
