package sf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-22
 * @Description: 三数之和
 */
public class Work_23 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_23());
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);//先排序，利用双指针向中间逼近
        int i = 0;
        while (i < nums.length &&  nums[i]<=0){
            int j=i+1,k=nums.length-1;
            if(i>0&& nums[i]==nums[i-1]){//剪枝，当nums大于0则不可能和为0
                i++;
                continue;
            }
            while (j<k){
                //两个指针向中间靠拢
                int s = nums[i]+nums[j]+nums[k];
                if (s>0){
                    //值大了则右指针左移，碰到与之前一样的数要跳过，剪枝
                    while (j<k && nums[k]==nums[--k]);
                } else if (s < 0) {
                    //小了则左指针右移
                    while (j<k && nums[j]==nums[++j]);
                }else {
                    //相等则加入解
                    List<Integer> t = new ArrayList<>();
                    Collections.addAll(t,nums[i],nums[j],nums[k]);
                    list.add(t);
                    //继续移动左右指针并剪枝
                    while (j<k && nums[k]==nums[--k]);
                    while (j<k && nums[j]==nums[++j]);
                }
            }
            i++;//下一个元素
        }
        return list;
    }
    @Override
    public void run(Object... args) {
        int[] a = new int[]{1,6,3,-7,-2,-3,2,1};
        List<List<Integer>> list = threeSum(new int[]{0,0,0});
        System.out.println("list = " + list);
    }
}
