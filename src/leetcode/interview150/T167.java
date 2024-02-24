package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/13 15:47
 * @Description
 */
public class T167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 1;
        int right = numbers.length;
        int[] ans = new int[2];
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                ans[0] = left;
                ans[1] = right;
                return ans;
            }
            if (numbers[left] + numbers[right] < target){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
