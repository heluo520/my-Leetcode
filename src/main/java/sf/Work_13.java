package sf;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-16
 * @Description:
 */
public class Work_13 implements PrintRunTime{

    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_13());
    }
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                if(!map.get(s.charAt(i)).equals(t.charAt(i))){
                    return false;
                }
            }else {
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }

    @Override
    public void run(Object... args) {
        boolean isomorphic = isIsomorphic("badc", "baba");
        System.out.println("isomorphic = " + isomorphic);
    }
}
