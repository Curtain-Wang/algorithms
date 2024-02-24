package leetcode.hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/9/22 11:02
 * @Description
 */
public class T118 {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> line = new ArrayList<>();
        line.add(1);
        ans.add(line);
        for (int i = 1; i < numRows; i++) {
            line = new ArrayList<>();
            line.add(1);
            for (int j = 1; j <= i; j++) {
                if (j < i){
                    line.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }else {
                    line.add(1);
                }
            }
            ans.add(line);
        }
        return ans;
    }
}
