package com.example.wangzhibo.lovestudy.codeinterview;

import java.util.Stack;

/**
 * 两个栈实现队列
 * 进入队列，直接进入有数据的栈
 *
 * 坑：
 * 不要直接用peek()和pop() push()  需要先判空 不然会抛出异常
 *
 * Created by samwangzhibo on 2019/3/19.
 */

public class CustomQueue<T> {
    private Stack<T> stackA = new Stack<>();
    private Stack<T> stackB = new Stack<>();

    private T head; //头结点

    T poll(){
        if (stackA.isEmpty()){
            return null;
        }
        T pollNode;
        while (!stackA.isEmpty() && stackA.peek() != null){
            stackB.push(stackA.pop());
        }

        pollNode = stackB.pop();
        head = stackB.isEmpty() ? null : stackB.peek();

        while (!stackB.isEmpty() && stackB.peek() != null){
            stackA.push(stackB.pop());
        }
        return pollNode;
    }

    T peek(){
        return head;
    }

    void offer(T t){
        if (t == null){
            return;
        }
        if (stackA.isEmpty()){
            head = t;
        }
        stackA.push(t);
    }

    public static void main(String[] args) {
        CustomQueue<Integer> customQueue = new CustomQueue<>();
        for (int i=0;i<10;i++){
            customQueue.offer(i);
        }
        while (customQueue.peek() != null){
            System.out.println(customQueue.poll());
        }
    }

}
