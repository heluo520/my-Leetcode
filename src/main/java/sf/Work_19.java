package sf;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-18
 * @Description: 两数之和
 */
public class Work_19 implements PrintRunTime{
    public static void main(String[] args) {

        PrintRunTime.proxyRun(new Work_19());
    }
    public int[] twoSum(int[] numbers, int target) {
        //方法一
        /*for (int i = 0; i < numbers.length; i++) {
            int t = target-numbers[i];
            for (int j = i+1;j<numbers.length;j++){
                if(t == numbers[j]){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return new int[]{-1,-1};*/

        //方法二、二分查找
        for (int i = 0; i < numbers.length; i++) {
            int t = target-numbers[i];
            int low=i+1;
            int high=numbers.length-1;
            while (low<=high){
                int mid = low+(high-low)/2;
                if(numbers[mid]==t){
                    return new int[]{i+1,mid+1};
                }else if(numbers[mid]<t){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return new int[]{-1,-1};
    }

    @Override
    public void run(Object... args) {
        int[] arr = {1,2,3,4,4,9,56,90};
        int target = 8;
        int[] sum = twoSum(arr, target);
        System.out.println("sum = " + Arrays.toString(sum));
    }
}
