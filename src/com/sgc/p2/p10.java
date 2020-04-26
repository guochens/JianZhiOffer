package com.sgc.p2;

import java.util.ArrayList;

public class p10 {
    public static int NumberOf1(int n) {
        int num = 0;

        if(n<0){
            long l = n;
            l=-l;
            ArrayList<Integer> temp = Number(l);
            l = 0;
            for(int i=0;i<31&&i<temp.size();i++){
                int add_temp = 1-temp.get(i);
                for(int j=0;j<i;j++){
                    add_temp*=2;
                }
                l=l+add_temp;
            }
            l++;
            ArrayList<Integer> n2 = Number(l);
            for(int i=0;i<31&&i<n2.size();i++){
                if(n2.get(i)==0){
                    num++;
                }
            }
            if(n2.size()<temp.size()){
                num++;
            }
            return 32-num;
        }
        ArrayList<Integer> n2 = Number(n);
        for(int i=0;i<n2.size();i++){
            if(n2.get(i)==1){
                num++;
            }
        }
        return num;
    }

    public static ArrayList<Integer> Number(long n){
        ArrayList<Integer> a = new ArrayList<>();
        while(n>0){
            long temp = n%2;
            n = n/2;
            if(temp>0){
                a.add(1);
            }else{
                a.add(0);
            }
        }
        return a;
    }

//一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，
// 它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。
// 这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。
// 如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，
// 就可以进行多少次这样的操作
    public static int NumberOf2(int n) {
        int count=0;
        while(n!=0){
            count++;
            n = n&(n-1);
        }
        return count;
    }
    public static void main(String[] args) {
//        System.out.println(NumberOf1(-1234567));
//        System.out.println(NumberOf1(20));
//        System.out.println(NumberOf1(-10));
//        System.out.println(NumberOf1(-3));
//        System.out.println(NumberOf1(-1));
        System.out.println(NumberOf2(-1234567));
        System.out.println(NumberOf2(20));
        System.out.println(NumberOf2(-10));
        System.out.println(NumberOf2(-3));
        System.out.println(NumberOf2(-1));
    }
}
