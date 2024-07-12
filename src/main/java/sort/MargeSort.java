package sort;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 归并排序
 * 思想是将待排序区间分割给左右子区间，左右子区间排好序后再合并。
 * 递归的进行，区间长度为1时是递归出口。先局部有序后整体有序。
 */
public class MargeSort implements BaseSort{
    public static void main(String[] args) {
        int[] arr = {1,6,4,3,1,8,7,5};
        BaseSort.runSort(arr,new MargeSort());
    }

    @Override
    public void sort(int[] arr) {
        margeSort(arr,0,arr.length-1);
    }
    public void margeSort(int arr[],int low,int high){
        if(low>=high){//递归出口，区间长度为1
            return;
        }
        int mid = low+(high-low)/2;
        margeSort(arr,low,mid);
        margeSort(arr,mid+1,high);
        marge1(arr,low,mid,high);
    }
    /* 方法一 */
    public void marge1(int[] arr, int low,int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left1 = low,left2 = mid+1,k=0;
        while (left1<=mid && left2<=high){//将较小的那个放入到临时数组中
            temp[k++] = arr[left1]<arr[left2]?arr[left1++]:arr[left2++];
        }
        while (left1<=mid){//左子序列有剩余
            temp[k++] = arr[left1++];
        }
        while (left2<=high){//右子序列有剩余
            temp[k++] = arr[left2++];
        }
        for (int i = 0; i < temp.length; i++) {//合并递归中的左右子序列到原数组中
            arr[low+i] = temp[i];//此处的low为待排序的子序列起始位置
        }
    }
    /* 方法二 ，比方法一少一个变量k，且只需要一次循环，但总的循环次数应该是一致的*/
    public void marge2(int[] arr, int low,int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left1 = low,left2 = mid+1;
        for (int i = 0; i < temp.length; i++) {
            if(left1>mid){//左区间指针超过中点，说明只剩右区间有剩余
                temp[i] = arr[left2++];
            } else if (left2 > high) {//右区间指针超过右区间边界，说明只剩左区间有剩余
                temp[i] = arr[left1++];
            } else if (arr[left1] < arr[left2]) {//两个区间都还有剩余
                temp[i] = arr[left1++];
            }else {
                temp[i] = arr[left2++];
            }
        }
        for (int i = 0; i < temp.length; i++) {//将排序好的临时数组中的元素放入原数组相应区间内
            arr[low+i] = temp[i];
        }
    }
}
