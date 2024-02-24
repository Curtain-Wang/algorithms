package graph;

import java.util.Arrays;

/**
 * @Author Curtain
 * @Date 2023/8/10 13:15
 * @Description
 */
public class T117 {
    
    public static void main(String[] args) {
        String[] words = {"tars", "rats", "arts", "star", "open"};
        System.out.println(new T117().numSimilarGroups(words));
        
    }
    
    private int numSimilarGroups(String[] words){
        int[] faters = new int[words.length];
        for (int i = 0; i < faters.length; i++) {
            faters[i] = i;
        }
        int count = words.length;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (similar(words, i, j) && union(faters, i, j)){
                    count--;
                }
            }
        }
        return count;
    }
    
    private boolean union(int[] faters, int i, int j) {
        int fatherI = findFather(faters, i);
        int fatherJ = findFather(faters, j);
        if (fatherI != fatherJ){
            faters[fatherI] = fatherJ;
            return true;
        }
        return false;
    }
    
    private int findFather(int[] faters, int i) {
        if (faters[i] != i){
            faters[i] = findFather(faters, faters[i]);
        }
        return faters[i];
    }
    
    private boolean similar(String[] words, int i, int j) {
        char[] charsi = words[i].toCharArray();
        char[] charsj = words[j].toCharArray();
        for (int i1 = 0; i1 < charsi.length - 1; i1++) {
            for (int i2 = i1 + 1; i2 < charsi.length; i2++) {
                swap(charsi, i1, i2);
                if (Arrays.equals(charsi, charsj)){
                    return true;
                }
                swap(charsi, i1, i2);
            }
        }
    
        return false;
    }
    private void swap(char[] a, int i, int j){
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
}
