package sf;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-19
 * @Description:
 */
public class Work_21 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_21());
    }
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        s = s.trim();
        String[] split = s.split("\\s+");
        for (int i = split.length-1; i >=0 ; i--) {
            builder.append(split[i]);
            if(i!=0){
                builder.append(" ");
            }
        }
        return builder.toString();
    }
    @Override
    public void run(Object... args) {
        String s = "    a good   example  ";
        String s1 = reverseWords(s);
        System.out.println("s1 = " + s1);
    }
}
