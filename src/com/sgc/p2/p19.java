package com.sgc.p2;
import java.util.Stack;

public class p19 {

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> stack_temp = new Stack<>();

    public static void main(String[] args) {
        push(3);
        System.out.println(min());
        push(4);
        System.out.println(min());
        push(2);
        System.out.println(min());
        push(3);
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        pop();
        System.out.println(min());
        push(0);
        System.out.println(min());
    }

    public static void push(int node) {
        if(!stack_temp.isEmpty()) {
            int min = stack_temp.peek();
            if(node<=min) {
                stack_temp.push(node);
            }
        }else {
            stack_temp.push(node);
        }
        stack.push(node);
    }

    public static void pop() {
        int pop = stack.pop();
        if(stack_temp.peek()==pop) {
            stack_temp.pop();
        }
    }

    public static int top() {
        if(!stack.isEmpty()){
            return stack.peek();
        }
        throw new RuntimeException("stack is empty");
    }

    public static int min() {
        if(!stack_temp.isEmpty()){
            return stack_temp.peek();
        }
        throw new RuntimeException("stack is empty");
    }
}
