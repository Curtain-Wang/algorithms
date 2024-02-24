package look_back;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/7/24 10:23
 * @Description
 */
public class T87 {
    
    public static void main(String[] args) {
        List<String> list = new T87().resotreIpAddress("10203040");
        System.out.println(list);
    }
    
    private List<String> resotreIpAddress(String s) {
        List<String> list = new ArrayList<>();
        helper(s, 0, 0, "", "", list);
        return list;
    }
    
    private void helper(String s, int index, int i, String seg, String ip, List<String> list) {
        if (index == s.length() && i == 3 && isValidSeg(seg)) {
            list.add(ip + seg);
        } else if (index < s.length() && i <= 3){
            char ch = s.charAt(index);
            if (isValidSeg(seg + ch)){
                helper(s, index + 1, i, seg + ch, ip, list);
            }
            if (seg.length() > 0 && i < 3){
                helper(s, index + 1, i + 1, "" + ch, ip + seg + ".", list);
            }
        }
    }
    
    private boolean isValidSeg(String segI) {
        return Integer.valueOf(segI) <= 255 && (segI.equals("0") || segI.charAt(0) != '0');
    }
}
