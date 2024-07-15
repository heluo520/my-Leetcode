package sf;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-15
 * @Description: 有效的字母异位词
 */
public class Work_11 implements PrintRunTime{

    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_11());

    }
    public boolean isAnagram0(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] charArray1 = s.toCharArray();
        char[] charArray2 = t.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1,charArray2);
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> sMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);
            }else{
                sMap.put(s.charAt(i),1);
            }
            if(sMap.containsKey(t.charAt(i))){
                sMap.put(t.charAt(i),sMap.get(t.charAt(i))-1);
            }else {
                sMap.put(t.charAt(i),-1);
            }
        }
        return sMap.values().stream().noneMatch(e -> e != 0);
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> sMap = new HashMap<>();
        Map<Character,Integer> tMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i),sMap.get(s.charAt(i))+1);
            }else{
                sMap.put(s.charAt(i),1);
            }
        }
        len = t.length();
        for (int i = 0; i < len; i++) {
            if(tMap.containsKey(t.charAt(i))){
                tMap.put(t.charAt(i),tMap.get(t.charAt(i))+1);
            }else{
                tMap.put(t.charAt(i),1);
            }
        }
        return sMap.equals(tMap);
    }
    @Override
    public void run(Object... args) {
        boolean anagram = isAnagram0("aospnonx", "xanosnoa");
        System.out.println(anagram);
    }
}
