package sf;


/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-23
 * @Description: 旋转字符串
 * 利用旋转字符串的特性，s+s包含其全部能旋转出的子串
 */
public class Work_26 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_26());
    }
    public boolean rotateString(String s, String goal) {
        //在两字符串长度相等的前提下，s+s是包含了其旋转可以形成的全部子字符串的，只需判断goal是否其其子串即可
        return s.length()==goal.length() && (s+s).contains(goal);
    }
    @Override
    public void run(Object... args) {
        boolean b = rotateString("abcde", "abced");
        System.out.println("b = " + b);
    }
}
