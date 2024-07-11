package datastruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 *
 * @Author: zws
 * @Date: 2024-06-05
 * @Description: 用数组实现的栈
 */
public class StackByArray<T> {
    private T[] stack;
    private int top = 0;
    //实际数组大小
    private int len;
    {
        this.len = 10;
        stack = (T[]) new Object[len];
    }
    public StackByArray(){}
    public StackByArray(int len){
        this.len = len;
        stack = (T[]) new Object[len];
    }
    public T pop(){
        if(top<1){
           throw new ArrayIndexOutOfBoundsException("元素不存在");
        }
        return stack[--top];
    }
    public void push(T e){
        if(top>=stack.length){
            stack = ofCopy(stack);
        }
        stack[top++] = e;
    }

    /**
     * 返回栈中实际元素个数
     * @return
     */
    public int getSize(){
        return top;
    }

    public T[] ofCopy(T[] oldStack){
        len = len+(len>>1);
        T[] newStack = (T[]) new Object[len];
        for (int i = 0; i < oldStack.length; i++) {
            newStack[i] = oldStack[i];
        }
        return newStack;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
