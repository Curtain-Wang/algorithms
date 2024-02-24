package leetcode.hot100;

/**
 * @Author Curtain
 * @Date 2023/9/19 16:13
 * @Description
 */
public class T739_1 {
    
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j = j + ans[j]) {
                if (temperatures[i] < temperatures[j]){
                    ans[i] = j - i;
                    break;
                }else if (ans[j] == 0){
                    ans[i] = 0;
                }
            }
        }
        return ans;
    }
}
