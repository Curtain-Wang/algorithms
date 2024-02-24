package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/21 9:45
 * @Description 45. 跳跃游戏 II
 * 
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i] 
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 */
public class T45 {
    
    public static void main(String[] args) {
        int[] nums = {1,2};
        System.out.println(new T45().jump(nums));
    }
    
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++){
                //如果能到达i
                if (nums[j] + j >= i){
                    if (dp[i] == 0){
                        dp[i] = dp[j] + 1;
                    }else {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
