package datastruct;

import java.util.Arrays;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-03
 * @Description: 小根堆，以及求TopX问题
 */

public class Heap {
    private Integer[] value;
    private int count;
    private int size(){
        return value.length;
    }
    static class HeapTopX{//内部类，用于求解TopX问题
        private Integer[] nodes;
        private int lastIndex;//最后一个索引的位置

        private HeapTopX(int size,Integer[] arr){
            //初始化TopX问题的堆，即求出数组arr中最大的size个元素
            nodes = new Integer[size];
            lastIndex = size-1;
            //初始化
            System.arraycopy(arr,0,nodes,0,size);
            initMinHeap();//调整为小根堆
            for (int i = lastIndex+1; i < arr.length; i++) {
                //加入后续元素
                add(arr[i]);
            }
        }
        private void initMinHeap(){
            //初始化小根堆
            //从第一个非叶子节点开始，倒序遍历进行下滤调整堆
            int parent = parent(lastIndex);
            for (int i = parent; i >=0 ; i--) {
                siftDown(i);
            }
        }
        @Override
        public String toString() {
            return "HeapTopX："+ Arrays.toString(nodes);
        }
        private void siftDown(int v){
            //下溢
            while (true) {
                int l=left(v);
                int r=right(v);
                int cur=v;
                if(l<=lastIndex && nodes[l]<nodes[cur]){
                    //左子结点不为空且左子结点的值小于当前结点
                    cur = l;
                }
                if(r<=lastIndex && nodes[r]<nodes[cur]){
                    cur = r;
                }
                if(cur==v){
                    //最小结点就是当前节点
                    break;
                }
                swap(v,cur);//将最小结点换到上面
                v = cur;
            }
        }

        private void add(int e){
            if(e>nodes[0]){
                nodes[0] = e;
                siftDown(0);
            }
        }
        private void swap(int index1,int index2){
            nodes[index1] = nodes[index1]^nodes[index2];
            nodes[index2] = nodes[index1]^nodes[index2];
            nodes[index1] = nodes[index1]^nodes[index2];
        }
        private int left(int index){
            return 2*index+1;
        }

        private int right(int index){
            return 2*index+2;
        }
        private int parent(int index){
            return (index-1)/2;
        }

    }
    public static HeapTopX initTopX(int x,Integer[] arr){
        if(x>arr.length){
            throw new ArrayIndexOutOfBoundsException("所求最大数个数大于原数组的长度");
        }
        return new HeapTopX(x,arr);
    }

    private void initSiftDown(){
        long l = System.currentTimeMillis();
        Integer parent = parent(count - 1);
        for (int i = parent; i >= 0; i--) {
            siftDown(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);

    }
    private void initSiftUp(){
        long l = System.currentTimeMillis();
        for (int i = value.length-1; i >= 0; i--) {
            siftUp(i);
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
    public Heap(Integer[] value) {
        this.value = value;
        count = value.length;
        //initSiftUp();
        initSiftDown();
    }
    public int peek(){
        return value[0];
    }
    private void swap(int f,int l){
        value[f] = value[f]^value[l];
        value[l] = value[f]^value[l];
        value[f] = value[f]^value[l];
    }
    public Integer poll(){//删除
        if(value[0]==null){
            return null;
        }
        int top = value[0];
        swap(0,count-1);
        value[(count-1)] = null;
        count--;
        siftDown(0);
        return top;
    }
    public void push(int v){
        expand();
        value[count] = v;
        count++;
        siftUp(count-1);
    }
    private Integer parent(int index){
        return (index-1)/2;
    }
    private Integer left(int index){
        return 2*index+1;
    }
    private Integer right(int index){
        return 2*index+2;
    }
    private void siftUp(int v) {
        //上溢
        if (count!=0){
            while (true){
                Integer parent = parent(v);
                Integer left = left(parent);
                Integer right = right(parent);
                int cur = v;
                if(right<count){
                    //其父结点有右子结点，取最小
                    cur=value[left]>value[right]?right:left;
                }
                if(value[parent]>value[cur]){
                    //比较父结点与最小子结点的大小，将小的与父结点交换
                    swap(parent,cur);
                    v = parent;//更新目标结点
                }
                if(v!=parent || v==0){
                    //目标结点没有变动或到根结点则退出
                    break;
                }
            }
        }
    }
    private void siftDown(int v){
        //下溢
        if(count!=0){
            while (true) {
                int l=left(v);
                int r=right(v);
                int cur=v;
                if(l<count && value[l]<value[cur]){
                    //左子结点不为空且左子结点的值小于当前结点
                    cur = l;
                }
                if(r<count && value[r]<value[cur]){
                    cur = r;
                }
                if(cur==v){
                    //最小结点就是当前节点
                    break;
                }
                swap(v,cur);//将最小结点换到上面
                v = cur;
            }

        }
    }
    private void expand(){
        //扩容
        if(count==size()){
            value = Arrays.copyOf(value, size()+(size()>>1));
        }
    }
    @Override
    public String toString() {
        return "Heap: "+Arrays.toString(value);
    }

}
