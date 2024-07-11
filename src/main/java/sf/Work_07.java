package sf;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 最小栈，通过常数级的时间复杂度求栈中最小元素
 */
class MinStack{
    public List<Integer> stack;
    public List<Integer> min = new ArrayList<>();
    public MinStack() {
        stack = new ArrayList<>();
    }

    public void push(int val) {
        if(min.size()==0){
            min.add(val);
        }else {
            for (int i = min.size()-1; i >= 0 ; i--) {
                if(min.get(i)<=val){
                    min.add(i+1,val);
                    break;
                }else if(i==0){
                    min.add(i,val);
                }
            }
        }
        stack.add(val);
    }

    public void pop() {
        if (stack.size()!=0){
            Integer top = stack.get(stack.size() - 1);
            stack.remove(stack.size()-1);
            int i = min.indexOf(top);
            min.remove(i);
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return min.get(0);
    }
}
public class Work_07 implements PrintRunTime{
    public static void main(String[] args) {
        PrintRunTime.proxyRun(new Work_07());
    }

    @Override
    public void run(Object... args) {
        MinStack minStack = new MinStack();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);
        printStack(minStack);
        minStack.pop();
        printStack(minStack);
        minStack.pop();
        printStack(minStack);
        minStack.pop();
        printStack(minStack);
    }

    private static void printStack(MinStack minStack) {
        System.out.println(minStack.stack);
        System.out.println(minStack.min);
        System.out.println(minStack.getMin());
    }
}
