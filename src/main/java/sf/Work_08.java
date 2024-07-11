package sf;

import java.util.Stack;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-11
 * @Description:
 */
class MyQueue {
    public Stack<Integer> pushStack = new Stack<>();
    public Stack<Integer> outStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while (!outStack.empty()){
            pushStack.push(outStack.pop());
        }
        pushStack.push(x);
    }

    public int pop() {
        while (!pushStack.empty()){
            outStack.push(pushStack.pop());
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.empty()){
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
