package sf;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-17
 * @Description: 最长回文串
 * aaabbbccccddddeed
 *
 * 出现次数为偶数的一定是回文，直接加，为基数的如果大于1个则加len-1
 * 最后如果统计的回文长度小于字符串长度说明是有出现次数为基数的字符，最后的长度再加1即是最后所求的最长回文长度
 */
public class Work_15 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_15());
    }
    public int longestPalindrome(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        int len = 0;
        boolean is = false;
        for (Integer value : map.values()) {
            if(value%2==0){
                len += value;
            }else {
                is = true;
                if(value>1){
                    len += (value-1);
                }
            }
        }
        return is?len+1:len;
    }
    @Override
    public void run(Object... args) {
        int i = longestPalindrome("AsferereevvvvllllDDDEEE");
        System.out.println("i = " + i);
    }
}
