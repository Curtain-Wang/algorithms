package leetcode.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Curtain
 * @Date 2023/10/11 16:09
 * @Description
 * 奖励最顶尖的 K 名学生
 */
public class T2512 {
    
    public static void main(String[] args) {
        String[] positive_feedback = {"smart","brilliant","studious"};
        String[] negative_feedback = {"not"};
        String[] report = {"this student is not studious","the student is smart"};
        int[] student_id = {1,2};
        new T2512().topStudents(positive_feedback, negative_feedback, report, student_id, 2);
    }
    
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String, Integer> gradeMap = new HashMap<>();
        for (String s : positive_feedback) {
            gradeMap.put(s, 3);
        }
        for (String s : negative_feedback) {
            gradeMap.put(s, -1);
        }
        List<int[]> grades = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            int grade = 0;
            String[] words = report[i].split(" ");
            for (String word : words) {
                grade += gradeMap.getOrDefault(word, 0);
            }
            int[] ig = new int[2];
            ig[0] = student_id[i];
            ig[1] = grade;
            grades.add(ig);
        }
        List<Integer> collect = grades.stream().sorted((i1, i2) -> i1[1] != i2[1] ? i2[1] - i1[1] : i1[0] - i2[0]).map(ints -> ints[0]).collect(Collectors.toList());
        return collect.subList(0, k);
    }
}
