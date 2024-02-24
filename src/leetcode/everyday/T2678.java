package leetcode.everyday;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/10/23 9:14
 * @Description
 */
public class T2678 {
    

    
//    public int countSeniors(String[] details) {
//        return (int) Arrays.stream(details).filter(detail -> Integer.valueOf(detail.substring(11, 13)) > 60).count();
//    }
    
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            if (Integer.valueOf(detail.substring(11, 13)) > 60){
                ans++;
            }
        }
        return ans;
    }
}
