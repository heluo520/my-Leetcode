package sf;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 解密字符串
 * n3[a2[ab]] -> naabaabaab
 */
public class Work_09 implements PrintRunTime{
    public static void main(String[] args) {
        String s = "n3[a2[ab]]";
        PrintRunTime.proxyRun(new Work_09(),s);
    }
    public static String decodeString(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder builder = new StringBuilder();//存储最后的字符串
        Stack<Character> stack = new Stack();//存储解密后的字符串，开始时是加密时的字符串
        for (char c: charArray) {//遍历加密字符串
            if(c==']'){//当前字符为此则需要进行一次解密
                StringBuilder num = new StringBuilder();//数字
                StringBuilder str = new StringBuilder();//存储每一次解密后的不加数字的字符串
                while (!stack.empty()){//考虑最后一次解密的情况
                    Character pop = stack.pop();
                    if(pop>='0' && pop<='9'){
                        //为数字
                        num.append(pop);
                        if(!stack.empty()){
                            Character peek = stack.peek();
                            if(peek<'0'||peek>'9'){
                                //后一个元素不为数字，说明数字已经结束
                                //已经满足解密条件
                                break;
                            }
                        }
                    }else if(pop!='['){
                        //为字母
                        str.append(pop);
                    }
                }
                str = str.reverse();
                num = num.reverse();
                String string = str.toString();
                if (num.length()!=0) {//进行解密拼接
                    for (int j = 0; j < Integer.parseInt(num.toString())-1; j++) {
                        str.append(string);
                    }
                }
                char[] chars = str.toString().toCharArray();
                for (char cs : chars) {//将解密后的字符串重新加入栈中
                    stack.push(cs);
                }
            }else {
                //还不需要进行解密
                stack.push(c);
            }
        }
        for (Character character : stack) {
            //解密后的字符串
            builder.append(character);
        }
        return builder.toString();
    }
    @Override
    public void run(Object... args) {
        String s = decodeString((String) args[0]);
        System.out.println("解密后的字符串："+s);
    }
}
