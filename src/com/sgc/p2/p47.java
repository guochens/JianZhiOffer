package com.sgc.p2;

import java.util.ArrayList;
import java.util.Collections;

//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class p47 {
    public static void main(String[] args) {
        System.out.println(Add1(-1, 5));
        System.out.println(Add1(1, -2));
    }
    public static int Add1(int num1,int num2) {
        int sum = 0;
        int carry = 0;
        sum = num1 ^ num2;
        carry = (num1 & num2)<<1;
        num1 = sum;
        num2 = carry;
        while (carry!=0){
            sum = num1 ^ num2;
            carry = (num1 & num2)<<1;
            num1 = sum;
            num2 = carry;
        }
        return sum;
    }

    public static int Add(int num1,int num2) {
        String bnum1 = Integer.toBinaryString(num1);
        String bnum2 = Integer.toBinaryString(num2);
        ArrayList<Character> arrayList1 = new ArrayList<>();
        ArrayList<Character> arrayList2 = new ArrayList<>();
        for(int i = bnum1.length()-1;i>=0;i--){
            arrayList1.add(bnum1.charAt(i));
        }
        for(int i = bnum2.length()-1;i>=0;i--){
            arrayList2.add(bnum2.charAt(i));
        }
        ArrayList<Character> res = new ArrayList<>();
        char jinwei = '0';
        int i = 0;
        for(;i<arrayList1.size() && i<arrayList2.size();i++){
            if(arrayList1.get(i)=='0' && arrayList2.get(i)=='0'){
                if(jinwei=='1'){
                    res.add('1');
                    jinwei = '0';
                }else {
                    res.add('0');
                }
            }else if((arrayList1.get(i)=='1' && arrayList2.get(i)=='0')||(arrayList1.get(i)=='0' && arrayList2.get(i)=='1')){
                if(jinwei=='1'){
                    res.add('0');
                }else{
                    res.add('1');
                }
            }else{
                if(jinwei=='1'){
                    res.add('1');
                }else{
                    res.add('0');
                    jinwei = '1';
                }
            }
        }
        while (i<arrayList1.size()){
            if(jinwei=='1' && arrayList1.get(i)=='1'){
                res.add('0');
            }else if((jinwei=='1' && arrayList1.get(i)=='0')||(jinwei=='0' && arrayList1.get(i)=='1')){
                res.add('1');
                jinwei = '0';
            }else {
                res.add('0');
            }
            i++;
        }
        while (i<arrayList2.size()){
            if(jinwei=='1' && arrayList2.get(i)=='1'){
                res.add('0');
            }else if((jinwei=='1' && arrayList2.get(i)=='0')||(jinwei=='0' && arrayList2.get(i)=='1')){
                res.add('1');
                jinwei = '0';
            }else {
                res.add('0');
            }
            i++;
        }
        if(jinwei=='1' && res.size()<32){
            res.add('1');
        }
        Collections.reverse(res);
        char[] temp = new char[res.size()];
        for(int j = 0;j<temp.length;j++){
            temp[j] = res.get(j);
        }
        int res_num = Integer.valueOf(new String(temp),2);


        return res_num;
    }
}
