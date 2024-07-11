package sort;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 插入排序
 */
public class InsertSort implements BaseSort{
    public static void main(String[] args) {
        int[] arr = {1, 6, 6, 7, 9, 5, 4, 3};
        BaseSort.runSort(arr,new InsertSort());
    }

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int base = arr[i];
            int j = i-1;
            while (j>=0 && base<arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = base;
        }
    }
}
