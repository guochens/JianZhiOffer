package com.sgc.p2;

public class p42 {
    public static void main(String[] args) {
        String S="abcXYZdef";
        System.out.println(LeftRotateString(S, 3));

    }
    public static String LeftRotateString(String str,int n) {
        if(str.length()<n){
            return "";
        }
        String res1 = str.substring(n,str.length());
        String res2 = str.substring(0,n);
        return res1+res2;
    }
}
