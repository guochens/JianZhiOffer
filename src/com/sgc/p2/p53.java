package com.sgc.p2;

import java.util.*;

//题目描述
//请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
//输出描述:
//如果当前字符流没有存在出现一次的字符，返回#字符。
public class p53 {

    //int[] test = new int[256];
    Map<Character,Integer> map =new HashMap<>();
    ArrayList<Character> arrayList = new ArrayList<>();

    public  void main(String[] args) {
        //test[0] = '1';
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(ch=='\n'){
            arrayList.clear();
            map.clear();
        }
        arrayList.add(ch);
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        ArrayList<Character> arrayList1 = new ArrayList<>();
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()==1){
                arrayList1.add(entry.getKey());
            }
        }
        for(int i =0;i<arrayList.size();i++){
            if(arrayList1.contains(arrayList.get(i))){
                return arrayList.get(i);
            }
        }
        return '#';
    }
}
