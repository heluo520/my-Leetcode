package sf;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description: 使用两个栈模拟队列
 */
class MyQueue {
    public Stack<Integer> pushStack = new Stack<>();
    public Stack<Integer> outStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!outStack.empty()){
            //将出栈栈中的元素先倒入入栈栈，是为了保持元素顺序
            pushStack.push(outStack.pop());
        }
        pushStack.push(x);
    }

    public int pop() {
        while (!pushStack.empty()){
            //将入栈栈的元素倒入出栈栈，因为这样元素顺序才满足队列顺序
            outStack.push(pushStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.empty()){
            //出栈栈为空将入栈栈中的元素加入出栈栈
            while (!pushStack.empty()){
                outStack.push(pushStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return pushStack.empty() && outStack.empty();
    }
}

public class Work_08 implements PrintRunTime{
    @Override
    public void run(Object... args) {

    }
}
