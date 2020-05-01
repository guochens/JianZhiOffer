package com.sgc.p2;


import java.util.Stack;

public class p20 {

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        int[] popA1 = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA, popA));
        System.out.println(IsPopOrder(pushA, popA1));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, j = 0;i<=pushA.length&&j<popA.length;){
            if(!stack.isEmpty()) {
                while(!stack.isEmpty()&&stack.peek()==popA[j]){
                    stack.pop();
                    j++;
                }
            }
            if(i<pushA.length){
                stack.push(pushA[i]);
                i++;
            }else{
                break;
            }
        }
        return stack.isEmpty();
    }
}
