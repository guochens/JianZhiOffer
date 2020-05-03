package com.sgc.p2;

import java.util.ArrayList;
import java.util.Arrays;

//题目描述
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
//输入描述:
//输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
public class p26 {

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "abbc";
        String s2 = "";
        //System.out.println(Permutation(s));
        //System.out.println(Permutation(s1));
        System.out.println(Permutation(s2));

    }

    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if(str.equals("")){
            return arrayList;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        arrayList.add(new String(chars));
        permutationSub(chars, arrayList);
        return arrayList;
    }

    public static void permutationSub(char[] chars, ArrayList<String> arrayList){
        int index = chars.length-1;

        for(;index>0 && chars[index-1]>=chars[index];index--);

        if(index<=0){
            return;
        }else{
            index--;
        }

        int index_j = chars.length-1;
        for(;index_j>index && chars[index_j]<=chars[index];index_j--);

        if (index<index_j){
            char temp = chars[index];
            chars[index] = chars[index_j];
            chars[index_j] = temp;
            index++;
            index_j = chars.length-1;
            while(index<index_j){
                temp = chars[index];
                chars[index] = chars[index_j];
                chars[index_j] = temp;
                index++;
                index_j--;
            }
        }

        arrayList.add(new String(chars));
        permutationSub(chars,arrayList);
    }

}
