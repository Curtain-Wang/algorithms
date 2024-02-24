package leetcode.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Curtain
 * @Date 2023/11/23 9:44
 * @Description
 */
public class T1410 {
    
    public static Map<String, Character> map = new HashMap<>();
    
    static {
        map.put("&quot;", '"');
        map.put("&apos;", '\'');
        map.put("&amp;", '&');
        map.put("&gt;", '>');
        map.put("&lt;", '<');
        map.put("&frasl;", '/');
    }
    
    public static void main(String[] args) {
        System.out.println(new T1410().entityParser("&&gt;"));
    }
//    public String entityParser(String text) {
//        int n = text.length();
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < n; ) {
//            if (text.charAt(i) == '&') {
//                int j = i + 1;
//                while (j < n && j - i < 6 && text.charAt(j) != ';') j++;
//                String sub = text.substring(i, Math.min(j + 1, n));
//                if (map.containsKey(sub)) {
//                    sb.append(map.get(sub));
//                    i = j + 1;
//                    continue;
//                }
//            }
//            sb.append(text.charAt(i++));
//        }
//        return sb.toString();
//    }
    
    public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int length = text.length();
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            //可能是一个转义
            if (c == '&') {
                int startIndex = i;
                //遍历到；或者&暂停
                while (++i < length && i - startIndex < 6 && text.charAt(i) != '&' && text.charAt(i) != ';') {
                    continue;
                }
                if (i < length && text.charAt(i) == '&'){
                    i--;
                }
                String substring = text.substring(startIndex, Math.min(length, i + 1));
                Character character = map.get(substring);
                if (character != null) {
                    sb.append(character);
                }else {
                    sb.append(substring);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

//    public String entityParser(String text) {
//        for (int i = 0; i < text.length();) {
//            char c  = text.charAt(i);
//            //可能是一个转义
//            if (c == '&'){
//                int startIndex = i;
//                //遍历到；或者&暂停
//                while (++i < text.length() && text.charAt(i) != '&' && text.charAt(i) != ';'){
//                    continue;
//                }
//                if (i == text.length()){
//                    break;
//                }
//                if (text.charAt(i) == ';'){
//                    Character character = map.get(text.substring(startIndex, i + 1));
//                    if (character != null){
//                        text = text.substring(0, startIndex) + character + text.substring(i + 1);
//                        i = startIndex + 1;
//                    }
//                }
//            }else {
//                i++;
//            }
//        }
//        return text;
//    }
}
