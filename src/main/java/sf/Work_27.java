package sf;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-07-29
 * @Description: 验证栈序列
 * 入栈后如果相等则出栈，出栈后栈不为空继续比较，如果不相等那么其前面的可能会相等，但不需要管
 * 到最后如果栈不为空则表明顺序是有问题的
 */
public class Work_27 implements PrintRunTime{
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length!=popped.length){
            return false;
        }
        Stack<Integer> pushStack = new Stack<>();
        for (int j=0,i = 0; i < pushed.length; i++) {
            pushStack.push(pushed[i]);
            while (!pushStack.isEmpty() && pushStack.peek().equals(popped[j])) {
                pushStack.pop();
                j++;
            }
        }
        return pushStack.isEmpty();
    }

    public static void main(String[] args){
        PrintRunTime.proxyRun(new Work_27());
    }

    @Override
    public void run(Object... args) {
        int[] pushed = {1,2,3,5,4};
        int[] popped = {4,5,3,2,1};
        boolean b = validateStackSequences(pushed, popped);
        System.out.println("b = " + b);
    }

}

