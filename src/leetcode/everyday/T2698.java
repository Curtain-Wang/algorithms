package leetcode.everyday;

/**
 * @Author Curtain
 * @Date 2023/10/25 8:23
 * @Description
 */
public class T2698 {
    
    public static void main(String[] args) {
        System.out.println(new T2698().punishmentNumber(10));
    }
    
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i)){
                ans += (i * i);
            }
        }
        return ans;
    }
    
    private boolean check(int i) {
        String iiStr = String.valueOf(i * i);
        for (int j = 1; j <= iiStr.length(); j++) {
            if (calc(iiStr, 0, j, 0, i)){
                return true;
            }
        }
        return false;
    }
    
    private boolean calc(String iiStr, int start, int endIndex, int sum, int i) {
        sum += Integer.valueOf(iiStr.substring(start, endIndex));
        if (sum == i && endIndex == iiStr.length()){
            return true;
        }else if (sum > i){
            return false;
        }else {
            for (int j = 1; j <= iiStr.length() - endIndex; j++) {
                if (calc(iiStr, endIndex, endIndex + j, sum, i)){
                    return true;
                }
            }
        }
        return false;
    }
}
