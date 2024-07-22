package sf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-19
 * @Description:
 */
public class Work_22 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_22());
    }
    public int lengthOfLongestSubstring(String s) {
        //方法一、双指针法，或者说是两个循环
        /*if(s==null || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        Set<Character> set = new HashSet<>();
        int i=0,j=i+1;
        int len = 1;
        while (i<s.length()){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }
            int temp = 1;
            while (j<s.length() && !set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                temp++;
                j++;
            }
            len = Math.max(len, temp);
            i++;
            j=i+1;
            set.clear();
        }
        return len;*/

        //滑动窗口法
        if(s==null || s.length()==0){
            return 0;
        }
        if(s.length()==1){
            return 1;
        }
        Map<Character,Integer> map = new HashMap<>();
        int len = 1;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                //有这个字符则窗口左边界为发生冲突字符的位置后，其位置之后才不会和当前值冲突
                left = Math.max(left, map.get(s.charAt(i))+1 );
            }
            //值为索引
            map.put(s.charAt(i),i);
            len = Math.max(len,i-left+1);
        }
        return len;
    }
    @Override
    public void run(Object... args) {
        int i = lengthOfLongestSubstring("dvdf");
        System.out.println("i = " + i);
    }
}
