package leetcode.interview150;

/**
 * @Author Curtain
 * @Date 2023/10/10 15:03
 * @Description
 */
public class T12_1 {
    private String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < vals.length; i++) {
            String str = strs[i];
            Integer val = vals[i];
            while (num >= val){
                sb.append(str);
                num -= val;
            }
        }
        return sb.toString();
    }
}
