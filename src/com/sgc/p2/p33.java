package com.sgc.p2;
//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p33 {

    public static void main(String[] args) {
        String s = "aaabbbc";
        System.out.println(FirstNotRepeatingChar(s));
        System.out.println(FirstNotRepeatingChar1(s));
    }

    public static int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }
            else{
                map.put(chars[i],1);
            }
        }
        ArrayList<Character> arrayList = new ArrayList<>();
        for(Character c:map.keySet()){
            if(map.get(c)==1){
                arrayList.add(c);
            }
        }
        if(arrayList.size()==0){
            return -1;
        }else {
            for(int i = 0;i<chars.length;i++){
                if(arrayList.contains(chars[i])){
                    return i;
                }
            }
        }
        return 0;
    }

    public static int FirstNotRepeatingChar1(String str) {
        if(str == null || str.length()==0) return -1;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!list.contains(ch)){
                list.add(Character.valueOf(ch));
            }else{
                list.remove(Character.valueOf(ch));
            }
        }
        if(list.size() <=0) return -1;
        return str.indexOf(list.get(0));
    }
}
