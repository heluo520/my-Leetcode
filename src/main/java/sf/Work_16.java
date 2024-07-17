package sf;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-17
 * @Description: 判断子序列
 * ab baab
 */
public class Work_16 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_16());

    }
    public boolean test(String s,String t){
        //方法二，按照索引必须是升序来判断
        if("".equals(s)){
            return true;
        }
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            //从idx+1的位置开始搜索返回其第一次出现的索引
            int index = t.indexOf(s.charAt(i),idx+1);
            if(index>idx){//升序
                idx = index;
            }else {//降序
                return false;
            }
        }
        return true;
    }
    public boolean isSubsequence(String s, String t) {
        //方法一，双指针法
        if("".equals(s)){
            return true;
        }
        int sp = 0;
        int tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
                tp++;
            } else {
                tp++;
            }
        }
        //字符s匹配完表示是其子序列
        return sp>=s.length();
    }
    @Override
    public void run(Object... args) {
        boolean b = test("ab", "baab");
        System.out.println("b = " + b);
    }
}
