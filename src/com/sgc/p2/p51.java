package com.sgc.p2;
//请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
// 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
// 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
public class p51 {
    public static void main(String[] args) {
        //"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
        String s1 = "aaa";
        String p1 = "a.a";
        String p2 = "ab*ac*a";
        String p3 = "aa.a";
        String p4 = "ab*a";
        String s2 = "";
        String p5 = ".*";
        String p6 = ".";
        String s3 = "a";
        String p7 = ".";
        String p9 = "C*";
        String s4 = "aa";
        String p10 = "a*";
        String p11 = "a*a";
        String s5 ="bcbbabab";
        String s6 ="bbbba";
        String p12 = ".*a*a";
        //System.out.println(match(s1.toCharArray(), p1.toCharArray()));//true
        System.out.println(match(s1.toCharArray(), p2.toCharArray()));//true
        System.out.println(match(s3.toCharArray(), p7.toCharArray()));//true
        System.out.println(match(s1.toCharArray(), p3.toCharArray()));//false
        System.out.println(match(s1.toCharArray(), p4.toCharArray()));//false
        System.out.println(match(s2.toCharArray(), p5.toCharArray()));//true
        System.out.println(match(s2.toCharArray(), p6.toCharArray()));//false
        System.out.println(match(s2.toCharArray(), p9.toCharArray()));//true
        System.out.println(match(s4.toCharArray(), p10.toCharArray()));//true
        System.out.println(match(s1.toCharArray(), p11.toCharArray()));//true
        System.out.println(match(s5.toCharArray(), p12.toCharArray()));//false
        System.out.println(match(s6.toCharArray(), p12.toCharArray()));//true

    }

    public static boolean match(char[] str, char[] pattern){
        if(pattern.length==0){
            if(str.length==0){
                return true;
            }else{
                return false;
            }
        }
        int index = 0;
        char pat = '*';
        int i=0;
        for(;i<pattern.length;i++){
            if(pattern[i]=='.'){
                if(i==pattern.length-2 && pattern[i+1]=='*'){
                    return true;
                }else {
                    index++;
                }
            }else if(pattern[i]=='*'  && index<str.length){
                int length = 0;
                if(i>=1){
                    pat = pattern[i-1];
                }
                for(int j =pattern.length-1;j>i;j--){
                    if(pattern[j]=='*'){
                        length--;
                    }else{
                        length++;
                    }
                }
                length = length<0?0:length;         //关键，不能无限匹配，要考虑到全局情况
                while (index<str.length-length &&(str[index] == pat||pat=='.')) {
                    if(index<str.length){
                        index++;
                    }
                    i = pattern.length-(str.length-index)-1;
                }
            }else if(index>=str.length) {
                break;
            }else {
                if(str[index]==pattern[i]){
                    index++;
                }else if(index==str.length-1 && i<pattern.length-1){
                    if(pattern[i+1]!='*'){
                        return false;
                    }else{
                        pat = pattern[i];
                    }
                }
            }
        }
        if(index==str.length){
            if(i==pattern.length-2){
                if(pattern[i+1]=='*'){
                     return true;
                }
                return false;
            }else if(i==pattern.length){
                return true;
            }
            return false;
        }else {
            return false;
        }
    }
}
