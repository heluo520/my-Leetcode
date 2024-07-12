package sort;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 快速排序
 * 先整体(将哨兵左右子区间看做一个元素)有序再局部有序
 * 选取一个元素(一般是第一个)为哨兵，作为比较基准，初始化两个指针
 * 一个指向头，一个指向尾部。从尾部找一个比基准元素小的元素，将其放入头指针指向的位置，
 * 再从左边找一个比基准元素大的元素放入尾指针位置，知道首尾指针相遇，即找到了基准元素放入的位置，将基准元素放入
 * 对于其左区间(元素都已经比基准元素小了)与右区间(元素都已经比基准元素大了)重复执行上述操作，区间长度为1时即为递归出口
 *
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
