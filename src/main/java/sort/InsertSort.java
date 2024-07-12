package sort;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 插入排序
 * 第一个元素为基本有序序列，倒序遍历有序序列找到后一个元素要插入的位置，遍历n-1遍即可
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
