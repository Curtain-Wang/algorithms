package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/5 9:38
 * @Description
 */
public class T191 {
    public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1){
                ans++;
            }
        }
        return ans;
    }
}
