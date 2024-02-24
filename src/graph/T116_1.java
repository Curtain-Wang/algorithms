package graph;

/**
 * @Author Curtain
 * @Date 2023/8/10 11:22
 * @Description
 */
public class T116_1 {
    
    public static void main(String[] args) {
        int[][] sr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(new T116_1().findCycleNum(sr));
    }
    
    public int findCycleNum(int[][] sr){
        int[] fathers = new int[sr.length];
        for (int i = 0; i < sr.length; i++) {
            fathers[i] = i;
        }
        int count = sr.length;
        for (int i = 0; i < sr.length - 1; i++) {
            for (int j = i + 1; j < sr.length; j++){
                if (sr[i][j] == 1 && union(fathers, i, j)){
                    count--;
                }
            }
        }
        return count;
    }
    
    private boolean union(int[] fathers, int i, int j) {
        int fatherI = findFather(fathers, i);
        int fatherJ = findFather(fathers, j);
        if (fatherI != fatherJ){
            fathers[fatherI] = fatherJ;
            return true;
        }
        return false;
    }
    
    private int findFather(int[] fathers, int i) {
        while (fathers[i] != i){
            fathers[i] = findFather(fathers, fathers[i]);
        }
        return fathers[i];
    }
}
