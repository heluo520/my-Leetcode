package sf;

import java.util.*;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-15
 * @Description: 第一个不重复的字符索引
 */
public class Work_12 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_12());
    }

    public int firstUniqChar(String s) {
        char[] charArray = s.toCharArray();
        List<Character> list = new ArrayList<>();//存储不重复的字符
        Set<Character> remove = new HashSet<>();//重复了的字符
        for (int i = 0; i < charArray.length; i++) {
            if(list.contains(charArray[i])){//重复
                remove.add(charArray[i]);
            }else {//不重复
                list.add(charArray[i]);
            }
        }
        list.removeAll(remove);//移除重复的元素
        return list.isEmpty()?-1:s.indexOf(list.get(0));
    }
    @Override
    public void run(Object... args) {
        String s = "lwwapsedleedtaa";
        int i = firstUniqChar(s);
        System.out.println("i = " + i);
    }
}
