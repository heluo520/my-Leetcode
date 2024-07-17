package sf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-17
 * @Description: 回文序列
 * abba、abcba、cabcba
 *
 * 统计出现次数为基数的字符个数，如果大于1则表明不能构成回文序列
 */
public class Work_14 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_14());
    }

    public boolean canPermutePalindrome(String s){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        int count = 0;
        for (Integer value : map.values()) {
            if(value%2!=0){//统计出现次数为基数的字符个数
                count++;
            }
        }
        return count<2;
    }
    @Override
    public void run(Object... args) {
        boolean b = canPermutePalindrome("ccaabcba");
        System.out.println("b = " + b);
    }
}
