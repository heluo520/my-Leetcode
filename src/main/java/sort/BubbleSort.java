package sort;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-10
 * @Description:
 */
public class BubbleSort implements BaseSort{
    public static void main(String[] args) {
        int[] arr = {3,1,5,6,8,8,4,9,7};
        BaseSort.runSort(arr,new BubbleSort());
    }
    public void sort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if(arr[j]>arr[j+1]){
                    swap(j,j+1,arr);
                }
            }
        }
    }
    public static void swap(int a,int b,int[] arr){
        arr[a] = arr[a]^arr[b];
        arr[b] = arr[a]^arr[b];
        arr[a] = arr[a]^arr[b];
    }
}
