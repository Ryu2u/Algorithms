package com.ryu2u.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 * @Description:
 * @date 2023/7/19 11:17
 */
public class ch225_用队列实现栈 {
    @Test
    public void test(){
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());

    }
    class MyStack{
        List<Integer> list = new ArrayList<>();
        public MyStack() {

        }

        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            return list.remove(list.size()-1);
        }

        public int top() {
            return list.get(list.size()-1);
        }

        public boolean empty() {
            return list.isEmpty();
        }

    }

}
