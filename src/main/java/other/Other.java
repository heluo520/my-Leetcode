package other;

import java.util.*;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-10
 * @Description:
 */
public class Other {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,7,9,6,5,6};
        List<List<Integer>> a = findSumIsTarget(arr, 10);
        System.out.println(a);
    }
    //求数组中全部两元素和为target的元素索引
    public static List<List<Integer>> findSumIsTarget(int[] arr,int target){
        Map<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(target-arr[i]) && !visited.contains(arr[i])){
                list.add(Arrays.asList(map.get(target-arr[i]),i));
                visited.add(arr[i]);
            }
            map.put(arr[i],i);
        }
        return list;
    }
}
