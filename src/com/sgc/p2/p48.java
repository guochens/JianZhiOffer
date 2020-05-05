package com.sgc.p2;

public class p48 {
    public static void main(String[] args) {
        String s = "123";
        String s1 = "-2147483649";
        System.out.println(StrToInt(s));
        System.out.println(StrToInt(s1));
    }

    public static int StrToInt1(String str) {
        if(str.equals("")){
            return 0;
        }
        int res = 0;
        //System.out.println(Integer.MIN_VALUE);
        //boolean minus = false;
        if(str.charAt(0)=='+'){
            int i = 0;
            str = str.substring(1);
            for(;i<str.length();i++){
                if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                    return 0;
                }
                res = res*10+str.charAt(i)-'0';
            }
        }else if(str.charAt(0)=='-'){
            str = str.substring(1);
            for(int i = 0;i<str.length();i++){
                if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                    return 0;
                }
                res = res*10-(str.charAt(i)-'0');
            }
        }

        return res;
    }

    public static long StrToInt(String str) {
        if(str.equals("")){
            return 0;
        }
        long res = 0;
        //System.out.println(Integer.MIN_VALUE);
        //boolean minus = false;
        if(str.charAt(0)=='+'){
            int i = 0;
            str = str.substring(1);
            for(;i<str.length();i++){
                if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                    return 0;
                }
                res = res*10+str.charAt(i)-'0';
            }
        }else if(str.charAt(0)=='-'){
            str = str.substring(1);
            for(int i = 0;i<str.length();i++){
                if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                    return 0;
                }
                res = res*10-(str.charAt(i)-'0');
            }
        }else{
            int i = 0;
            for(;i<str.length();i++){
                if(str.charAt(i)>'9'||str.charAt(i)<'0'){
                    return 0;
                }
                res = res*10+str.charAt(i)-'0';
            }
        }
        return res;
    }
}
