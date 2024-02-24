package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/11/10 15:36
 * @Description
 */
public class T2300 {
    
    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        int success = 7;
        System.out.println(new T2300().successfulPairs(spells, potions, success));
    }
    
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] paris = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            paris[i] = cal(spells[i], success, potions);
        }
        return paris;
    }
    
    private int cal(int spell, long success, int[] potions) {
        int left = 0;
        int right = potions.length - 1;
        while (left <= right){
            int mid = left + (right - left >> 1);
            if (bigger(spell, potions[mid], success)){
                if (left == right){
                    return potions.length - left;
                }
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return potions.length - left;
    }
    
    private boolean bigger(int spell, int potion, long success) {
        if (success % spell == 0){
            return potion >= (success / spell);
        }else {
            return potion > (success / spell);
        }
    }
}
