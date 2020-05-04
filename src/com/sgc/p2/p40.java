package com.sgc.p2;

import java.util.ArrayList;
import java.util.Comparator;

public class p40 {
    public static void main(String[] args) {

        //System.out.println(FindContinuousSequence(21));
        //System.out.println(FindContinuousSequence(3));
        //System.out.println(FindContinuousSequence(9));
        System.out.println(FindContinuousSequence(15));
        System.out.println(FindContinuousSequence(100));
        System.out.println(FindContinuousSequence1(15));
        System.out.println(FindContinuousSequence1(100));
    }

    //滑动窗口法
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(sum<3){
            return arrayLists;
        }
        int min = 1;
        int max = 2;
        int add = min + max;
        while (min*2<=sum && max<sum){
            if(add<sum){
                max++;
                add += max;
            }else if(add>sum){
                add-=min;
                min++;
            }else{
                ArrayList<Integer> arrayList = new ArrayList<>();
                for(int i = min;i<=max;i++){
                    arrayList.add(i);
                }
                arrayLists.add(arrayList);
                add-=min;
                min++;
            }
        }
        return arrayLists;
    }


    //穷举
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for(int i = 2;i<=sum/2+1;i = i+2){
            int duishu = i/2;
            int he = sum/duishu;
            if(he*duishu==sum && he%2==1 && he>i){
                ArrayList<Integer> arrayList = new ArrayList<>();
                int first = sum/i-duishu+1;
                for (int j = 0;j<i;j++) {
                    arrayList.add(first+j);
                }
                arrayLists.add(arrayList);
            }
        }
        for(int i = 3;i<=sum/2+1;i = i+2){
            int mid = sum/i;
            if(mid*i==sum && mid*2>i){
                ArrayList<Integer> arrayList = new ArrayList<>();
                int first = sum/i-i/2;
                for(int j = 0;j<i;j++){
                    arrayList.add(first+j);
                }
                arrayLists.add(arrayList);
            }
        }
        arrayLists.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size()>o2.size()? -1:1;
            }
        });
        return arrayLists;
    }
}
