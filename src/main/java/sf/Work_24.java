package sf;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-22
 * @Description: 字符串之和
 */
public class Work_24 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_24());
    }
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1,j = num2.length()-1,add = 0;
        StringBuilder builder = new StringBuilder();
        while (i>=0 || j>=0 || add != 0){
            int x = i>=0?num1.charAt(i)-'0':0;//高位补0
            int y = j>=0?num2.charAt(j)-'0':0;
            int sum = x+y+add;
            builder.append(sum%10);
            add = sum/10;
            i--;
            j--;
        }
        builder.reverse();
        return builder.toString();
    }
    @Override
    public void run(Object... args) {
        String s = addStrings("6913259244", "71103343");
        System.out.println("s = " + s);
    }
}
