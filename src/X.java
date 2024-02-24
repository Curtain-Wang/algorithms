/**
 * @Author Curtain
 * @Date 2023/10/27 15:15
 * @Description
 */
public class X {
    public static void main(String[] args) {
        String acsVersion = "ACS500B_P1.0.12_HW2.1.0_SW1.8.35";
        int indexP = acsVersion.indexOf("_P");
        String substring = acsVersion.substring(indexP + 2);
        int index = substring.indexOf("_");
        String version = substring.substring(0, index);
        System.out.println(version);
    }
}
