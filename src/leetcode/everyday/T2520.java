package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/26 9:15
 * @Description
 */
public class T2520 {
    public int countDigits(int num) {
        int ans = 0;
        int tmp = num;
        while (tmp > 0){
            if (tmp % 10 != 0 && num % (tmp % 10) == 0){
                ans++;
            }
            tmp /= 10;
        }
        return ans;
    }
    
}
