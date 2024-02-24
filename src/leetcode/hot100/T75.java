package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/7 13:26
 * @Description
 * 
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 *
 *示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 *
 * 进阶：
 *
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class T75 {
    
    public void sortColors1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]){
                    swap(nums, j - 1, j);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        new T75().sortColors(nums);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void sortColors(int[] nums) {
        int nextZeroIndex = 0;
        int nextTwoIndex = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                if (i > nextZeroIndex){
                    swap(nums, i, nextZeroIndex);
                    i--;
                }
                nextZeroIndex++;
            }else if (nums[i] == 2){
                if (i < nextTwoIndex){
                    swap(nums, i, nextTwoIndex);
                    i--;
                }
                nextTwoIndex--;
            }
        }
    }
}
