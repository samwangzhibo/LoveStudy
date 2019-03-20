package com.example.wangzhibo.lovestudy.codeinterview;

import java.util.LinkedList;

/**
 * 2个队列实现栈
 * Created by samwangzhibo on 2019/3/19.
 */

public class CustomStack<T> {
    LinkedList<T> listA = new LinkedList<>();
    LinkedList<T> listB = new LinkedList<>();

    T pop(){
        if (listA.isEmpty() && listB.isEmpty()){
            throw new RuntimeException("stack is null");
        }
        T tail = null;
        while (!listA.isEmpty() && listA.peek() != null){
            if (listA.size() == 1){
                tail = listA.poll();
            }else {
                listB.offer(listA.poll());
            }
        }

        while (!listB.isEmpty() && listB.peek() != null){
            listA.offer(listB.poll());
        }
        return tail;
    }

    void push(T element){
        listA.offer(element);
    }

    boolean isEmpty(){
        return listA.isEmpty();
    }

    public static void main(String[] args) {
        CustomStack<Integer> customStack = new CustomStack();
        for (int i=0; i < 10; i++){
            customStack.push(i);
        }

       while (!customStack.isEmpty()){
            System.out.println(customStack.pop());
       }
    }
}
