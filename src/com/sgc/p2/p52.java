package com.sgc.p2;
//请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
// 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
// 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
public class p52 {

    public static void main(String[] args) {
        String s1 = "+100";
        String s2 = "5e2";
        String s3 = "-123";
        String s4 = "3.1416";
        String s5 = "-1E-16";


        String s6 = "12e";
        String s7 = "1a3.14";
        String s8 = "1.2.3";
        String s9 = "+-5";
        String s10 = "12e+4.3";

        String s11 = "-.123";

        System.out.println(isNumeric(s1.toCharArray()));
        System.out.println(isNumeric(s2.toCharArray()));
        System.out.println(isNumeric(s3.toCharArray()));
        System.out.println(isNumeric(s4.toCharArray()));
        System.out.println(isNumeric(s5.toCharArray()));

        System.out.println(isNumeric(s6.toCharArray()));
        System.out.println(isNumeric(s7.toCharArray()));
        System.out.println(isNumeric(s8.toCharArray()));
        System.out.println(isNumeric(s9.toCharArray()));
        System.out.println(isNumeric(s10.toCharArray()));

        System.out.println(isNumeric(s11.toCharArray()));

        System.out.println(isNumeric1(s1.toCharArray()));
        System.out.println(isNumeric1(s2.toCharArray()));
        System.out.println(isNumeric1(s3.toCharArray()));
        System.out.println(isNumeric1(s4.toCharArray()));
        System.out.println(isNumeric1(s5.toCharArray()));

        System.out.println(isNumeric1(s6.toCharArray()));
        System.out.println(isNumeric1(s7.toCharArray()));
        System.out.println(isNumeric1(s8.toCharArray()));
        System.out.println(isNumeric1(s9.toCharArray()));
        System.out.println(isNumeric1(s10.toCharArray()));

        System.out.println(isNumeric1(s11.toCharArray()));

    }

    public static boolean isNumeric1(char[] str){
        String s = String.valueOf(str);
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([Ee][+-]?[0-9]+)?");
    }

    public static boolean isNumeric(char[] str) {
        if(str.length==0){
            return false;
        }
        for(int i = 0;i<str.length;i++){
            if(str[i]=='E'||str[i]=='e'){
                if(i==str.length-1){
                    return false;
                }
                return sub1(str,0,i-1) && sub2(str,i+1,str.length-1);
            }
        }
        return sub1(str,0,str.length-1);
    }

    public static boolean sub1(char[] str,int start,int end){
        if(start>end){
            return false;
        }
        int status = 0;//0:小数点前，1，小数点后
        int i = start;
        if(str[i]=='+'||str[start]=='-'){
            i++;
        }
        for(;i<=end;i++){
            if(status==0) {
                if(str[i]=='.'){
                    status=1;
                }else if(str[i]<'0' || str[i]>'9'){
                    return false;
                }
            } else if (status == 1) {
                if(str[i]<'0' || str[i]>'9'){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sub2(char[] str,int start,int end){
        if(start>end){
            return false;
        }
        int i = start;
        if(str[i]=='+'||str[start]=='-'){
            i++;
        }
        for(;i<=end;i++){
            if(str[i]<'0' || str[i]>'9'){
                return false;
            }
        }
        return true;
    }
}
