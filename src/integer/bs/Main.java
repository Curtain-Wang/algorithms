package integer.bs;

/**
 * @Author Curtain
 * @Date 2023/9/20 9:10
 * @Description
 */
public class Main {
    
    //查找第一个大于等于8的位置
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(new Main().loweBound(nums, 8));
        System.out.println(new Main().loweBound(nums, 9) - 1);
        
    }
    
    private int loweBound(int[] nums, int target){
        int left = 0;//左闭
        int right = nums.length - 1;//右闭
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }
}
