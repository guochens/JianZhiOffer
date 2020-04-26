package com.sgc.p2;

public class p7 {
    public static int Fibonacci(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        int a1 = 0;
        int a2 = 1;
        int res = 0;
        for(int i = 1;i<n;i++){
            res = a1+a2;
            a1 = a2;
            a2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(0));
        System.out.println(Fibonacci(1));
        System.out.println(Fibonacci(2));
        System.out.println(Fibonacci(3));
        System.out.println(Fibonacci(4));
        System.out.println(Fibonacci(5));
        System.out.println(Fibonacci(6));
        System.out.println(Fibonacci(7));

    }
}
