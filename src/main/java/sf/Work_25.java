package sf;

import java.util.*;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-23
 * @Description: 滑动窗口最大值
 * 采用单调队列来解决，利用其可以头尾插入与删除的特性维持一个单调队列
 * 头或尾即为最大或最小元素
 */
public class Work_25 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_25());
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            //初始化单调队列，存储的为索引，其对应的元素值单调递减
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                //维持单调性
                deque.pollLast();
            }
            //尾部入队列
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];//存储最大值
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                //维持单调性
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                //防止最大值不在当前窗口中
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;

    }


    @Override
    public void run(Object... args) {
        int[] nums = {1,6,3,4,8,7,9,5,4,25,6,6,47,9,6,3,4,20,3,0,7};
        int[] ints = maxSlidingWindow(nums, 4);
        System.out.println("ints = " + Arrays.toString(ints));

    }
}
