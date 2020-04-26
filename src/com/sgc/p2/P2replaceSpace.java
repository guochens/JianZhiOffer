package com.sgc.p2;

import java.util.Scanner;

public class P2replaceSpace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuffer sbf = new StringBuffer();
        while(true){
            String s = scanner.nextLine();
            if(s.equals("")){
                break;
            }
            sbf.append(s+"\n");
        }
        String str = replaceSpace(sbf);
        System.out.println(str);
    }

    public static String replaceSpace(StringBuffer str){
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<length;i++){
            char c = str.charAt(i);
            if(c ==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

