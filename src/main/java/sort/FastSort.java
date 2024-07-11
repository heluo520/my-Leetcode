package sort;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 快速排序
 */
public class FastSort implements BaseSort{
    public static void main(String[] args) {
        int[] arr = {1, 6, 4, 2, 6, 7, 3, 9};
        BaseSort.runSort(arr,new FastSort());
    }
    @Override
    public void sort(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private  void quickSort(int[] arr,int low,int high) {
        if(low>=high){//区间长度为1时停止
            return;
        }
        int insertPoint = partition(arr, low, high);
        quickSort(arr,low,insertPoint-1);//左区间
        quickSort(arr,insertPoint+1,high);//右区间
    }

    private  int partition(int[] arr,int low,int high) {
        int base = arr[low];
        while (low<high){
            while (low<high && arr[high]>=base)//从右边找首个小于基准的
                //low<high 是为了考虑元素升序的情况
                high--;
            arr[low] = arr[high];//交换位置，high位置可以视为空
            while (low<high && arr[low]<=base)//从左边找首个大于基准的
                low++;
            arr[high] = arr[low];//交换位置
        }
        arr[low] = base;//找到了基准元素的插入位置
        return low;//返回基准元素的位置用于左右中区间排序
    }
}
