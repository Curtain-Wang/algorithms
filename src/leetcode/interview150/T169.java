package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/8 14:57
 * @Description
 * 
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 */
public class T169 {
    
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 4};
        System.out.println(new T169().majorityElement(nums));
    }
    
    public int majorityElement(int[] nums) {
        int ans = 0;
        int vote = 0;
        for (int num : nums) {
            if (vote == 0){
                ans = num;
            }
            vote += ans == num ? 1 : -1;
        }
        return ans;
    }
}
