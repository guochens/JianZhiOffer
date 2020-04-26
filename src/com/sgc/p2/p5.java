package com.sgc.p2;

import javax.swing.*;
import java.util.Stack;

public class p5 {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
        stack2.clear();
        Stack<Integer> stack_temp = new Stack<>();
        stack_temp.addAll(stack1);
        int length = stack1.size();
        while(length>0){
            int temp = stack_temp.pop();
            stack2.push(temp);
            length--;
        }
    }

    public static int pop() {
        if(stack2.size()<=0){
            return -1;
        }
        int res = stack2.pop();
        stack1.clear();
        Stack<Integer> stack_temp = new Stack<>();
        stack_temp.addAll(stack2);
        int length = stack2.size();
        while(length>0){
            int temp = stack_temp.pop();
            stack1.push(temp);
            length--;
        }
        return res;
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        int i1 = pop();

    }
}
