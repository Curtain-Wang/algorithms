package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2024/1/4 14:26
 * @Description
 */
public class T190 {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int t = (n >> i) & 1;
            if (t == 1){
                ans |= (1 << (31 - i));
            }
        }
        return ans;
    }
}
