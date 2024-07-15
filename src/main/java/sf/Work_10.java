package sf;

import java.util.PriorityQueue;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-14
 * @Description: 使用优先队列模拟大根堆与小根堆来解决求中位数问题
 */
class MedianFinder {

    public static PriorityQueue<Integer> minHeap;
    public static PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1,o2)->o2-o1);
    }

    public void addNum(int num) {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if(minSize==0 && maxSize==0){
            minHeap.offer(num);
        }else if(minSize==maxSize){
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        }else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if(minSize==0 && maxSize==0){
            throw new NullPointerException();
        }
        return minSize==maxSize?(minHeap.peek()+maxHeap.peek())/2.0:minHeap.peek();
    }
}
public class Work_10 implements PrintRunTime {
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_10());
    }

    @Override
    public void run(Object... args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        for (int i=0;i<100000;i++) {
            medianFinder.addNum(i);
        }
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());


    }
}
