package dynamic_programming;

/**
 * @Author Curtain
 * @Date 2023/7/31 10:04
 * @Description
 */
public class T92 {
    public static void main(String[] args) {
        String s = "00110000";
        System.out.println(new T92().minFlipsMonoIncre(s));
    }
    
    private int minFlipsMonoIncre(String s){
        if (s == null || s.length() == 0 || s.length() == 1){
            return 0;
        }
        int[] f = new int[2];
        int[] g = new int[2];   
        if (s.charAt(0) == '0'){
            f[0] = 0;
            g[0] = 1;
        }else {
            f[0] = 1;
            g[0] = 0;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0'){
                f[i % 2] = f[(i - 1) % 2];
                g[i % 2] = Math.min(f[(i - 1) % 2], g[(i - 1) % 2]) + 1;
            }else {
                f[i % 2] = f[(i - 1) % 2] + 1;
                g[i % 2] = Math.min(f[(i - 1) % 2], g[(i - 1) % 2]);
            }
        }
        return Math.min(f[(s.length() - 1) % 2], g[(s.length() - 1) % 2]);
    }
}
