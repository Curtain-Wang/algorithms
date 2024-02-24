package leetcode.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/8/14 9:56
 * @Description
 */
public class Test {
    
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            //在长度为26的int数组target中存储字符串p中对应字符（a~z）出现的次数
            //如p="abc",则target为[1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
            //如p="bbdfeee",则target为[0,2,0,1,3,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
            int[] target = new int[26];
            for (int i = 0; i < p.length(); i++) {
                target[p.charAt(i) - 'a']++;
            }
            //双指针构建滑动窗口原理：
            //1.右指针right先向右滑动并在window中存储对应字符出现次数
            //2.当左右指针间的字符数量（包括左右指针位置的字符）与p长度相同时开始比较
            //3.比较完成后，左右指针均向右滑动一位，再次比较
            //4.以后一直重复2、3，直到end指针走到字符串s的末尾
            int left = 0, right = 0;
            int[] window = new int[26];//构建一个与target类似的，存储了字符串s从left位置到right位置的窗口中字符对应出现次数的数组
            List<Integer> ans = new ArrayList<Integer>();
            while (right < s.length()) {
                window[s.charAt(right) - 'a']++;//每次右指针right滑动，字符串s的right位置的字符出现次数加1
                if (right - left + 1 == p.length()) {
                    if (Arrays.equals(window, target)) ans.add(left);//通过Arrays.equals方法，当window数组与target数组相等即为异或词
                    window[s.charAt(left) - 'a']--;//比较完成后，字符串s的left位置的字符出现次数减1（减1是因为左指针下一步要向右滑动）
                    left++;//左指针向右滑动
                }
                right++;//右指针向右滑动
            }
            return ans;
        }
    }
}
