package com.sgc.p2;
//求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
public class p46 {

    public static void main(String[] args) {
        System.out.println(Sum_Solution1(100));
    }

    public static int Sum_Solution1(int n){
        int res = (int)(Math.pow(n,2)+n);
        return res>>1;
    }

    public static int Sum_Solution(int n) {
        int sum = n;
        boolean flag = (sum>0) && (sum = sum + Sum_Solution(n-1))>0;
        return sum;
    }
}
