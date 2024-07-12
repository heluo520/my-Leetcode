package sf;

import java.util.*;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-10
 * @Description: 有效的括号
 *  类似逆波兰式的解决方法
 */
public class Work_06 implements PrintRunTime{

    public static void main(String[] args) throws InterruptedException {
        PrintRunTime.proxyRun(new Work_06(),"()");
    }
    public  boolean isValid(String s) {
        if(s==null){//空不符合
            return false;
        }
        int len = s.length();
        if(len%2!=0 || len==0){//长度不为偶数或为空字符串也不符合
            return false;
        }
        Map<Character,Character> map = new HashMap<>();//存储匹配对，是有序的
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        Stack<Character> stack = new Stack<>();//存储字符串中的每一个字符
        char[] charArray = s.toCharArray();
        for (char c: charArray) {//逐个遍历
            if(stack.isEmpty()){//栈为空入栈
                stack.add(c);
            }else {//栈不为空
                Character peek = stack.peek();//看栈顶元素
                //栈顶元素不在map中表示不是按顺序的，比如}，因为如果是按顺序{}则{必然先与}入栈，而{未入栈就出现了}表明出现了不匹配的字符}
                if(!map.containsKey(peek)){
                    return false;
                }
                if(map.get(peek)==c){//栈顶元素对应的匹配项是当前字符，则出栈，匹配完一对
                    stack.pop();
                }else {
                    //未匹配则入栈
                    stack.push(c);
                }
            }
            System.out.println(stack);
        }
        if(stack.isEmpty()){//最后如果栈为空表明全部都有匹配，否则说明有的字符没有对应的匹配项
            return true;
        }
        return false;
    }


    @Override
    public void run(Object...args) {
        boolean valid = isValid((String) args[0]);
        System.out.println("valid = " + valid);
    }
}
