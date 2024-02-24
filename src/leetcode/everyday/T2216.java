package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/11/21 14:42
 * @Description
 */
public class T2216 {
    public int minDeletion(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int index = (i - cnt);
            //计数下标不管
            if (index % 2 != 0){
                continue;
            }
            //说明要将改元素删掉
            if (nums[i] == nums[i + 1]){
                cnt++;
            }
        }
        if ((nums.length - cnt) % 2 == 0){
            return cnt;
        }else {
            return cnt + 1;
        }
    }
}
