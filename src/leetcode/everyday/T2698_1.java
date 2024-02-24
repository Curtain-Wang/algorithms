package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/25 10:11
 * @Description
 */
public class T2698_1 {
    static int[] f = new int[1001];
    static {
        for (int i = 1; i <= 1000; i++) {
            f[i] = f[i  -1];
            if (check(i * i, i)){
                f[i] += i * i;
            }
        }
    }
    
    public int punishmentNumber(int n) {
        return f[n];
    }
    
    private static boolean check(int t, int x) {
        if (t == x){
            return true;
        }
        int d = 10;
        while (t >= d && x >= (t % d)){
            if (check(t / d , x - (t % d))){
                return true;
            }
            d *= 10;
        }
        return false;
    }
}
