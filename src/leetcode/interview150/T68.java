package leetcode.interview150;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Curtain
 * @Date 2023/10/12 13:49
 * @Description 文本左右对齐
 * 
 * 给定一个单词数组 words 和一个长度 maxWidth ，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用 “贪心算法” 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 注意:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 *
 * 示例 1:
 *
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。       
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"]，maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 *
 *
 * 提示:
 *
 * 1 <= words.length <= 300
 * 1 <= words[i].length <= 20
 * words[i] 由小写英文字母和符号组成
 * 1 <= maxWidth <= 100
 * words[i].length <= maxWidth
 */
public class T68 {
    
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(new T68().fullJustify(words, 16));
    }
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int remainSize = maxWidth;
        List<StringBuilder> lineWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (remainSize >= words[i].length()){
                lineWords.add(new StringBuilder(words[i]));
                remainSize -= words[i].length() + 1;
            }else {
                ans.add(calcLineStr(lineWords, remainSize + lineWords.size()));
                lineWords = new ArrayList<>();
                lineWords.add(new StringBuilder(words[i]));
                remainSize = maxWidth - words[i].length() - 1;
            }
        }
        ans.add(lastLineStr(lineWords, remainSize + lineWords.size()));
        return ans;
    }
    
    private String lastLineStr(List<StringBuilder> lineWords, int fillSpaceNum) {
        StringBuilder sb = lineWords.get(0);
        for (int i = 1; i < lineWords.size(); i++) {
            sb.append(" ").append(lineWords.get(i));
            fillSpaceNum--;
        }
        for (int i = 0; i < fillSpaceNum; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }
    
    private String calcLineStr(List<StringBuilder> lineWords, int fillSpaceNum) {
        StringBuilder sb = lineWords.get(0);
        if (lineWords.size() == 1){
            for (int i = 0; i < fillSpaceNum; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }
        while (fillSpaceNum > 0){
            for (int i = 0; i < lineWords.size() - 1; i++) {
                if (fillSpaceNum > 0){
                    StringBuilder lineWord = lineWords.get(i);
                    lineWord.append(" ");
                    fillSpaceNum--;
                }else {
                    break;
                }
                
            } 
        }
        for (int i = 1; i < lineWords.size(); i++) {
            sb.append(lineWords.get(i));
        }
        return sb.toString();
    }
}
