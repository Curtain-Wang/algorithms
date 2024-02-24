package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/9/27 13:53
 * @Description 移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * [3,2,2,3]
 */
public class T27 {
    
    public static void main(String[] args) {
        int[] nums = {0, 4, 4, 0, 4, 4, 4, 0, 2};
        System.out.println(new T27().removeElement(nums, 4));
    }
    
    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val){
                swap(nums, i--, j--);
            }
        }
        return j + 1;
    }
    
    private void swap(int[] nums, int i, int end) {
        int temp = nums[i];
        nums[i] = nums[end];
        nums[end] = temp;
    }
}
