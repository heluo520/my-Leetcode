package sort;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-10
 * @Description: 选择排序 找出最小值的索引后交换其与第一个元素的位置
 */
public class SelectSort implements BaseSort{
    public static void main(String[] args)  {
        int[] arr = {3,1,5,6,8,8,4,9,7};
        SelectSort selectSort = new SelectSort();
        BaseSort.runSort(arr, selectSort);
    }



    public  void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i){
                //否则会与为0
                swap(i,min,arr);
            }
        }
    }
    public static void swap(int a,int b,int[] arr){
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }
}
