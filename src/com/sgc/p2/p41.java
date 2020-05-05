package com.sgc.p2;

import java.util.ArrayList;

public class p41 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int sum = 7;
        System.out.println(FindNumbersWithSum(array, sum));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(array.length<2){
            return arrayList;
        }
        int index_min = 0;
        int index_max = array.length-1;
        int min = array[index_min];
        int max = array[index_max];

        while (min<max){
            int add = min+max;
            if(add == sum){
                arrayList.add(min);
                arrayList.add(max);
                break;
            }
            else if(add>sum){
                index_max--;
                max = array[index_max];
            }else if(add<sum){
                index_min++;
                min = array[index_min];
            }
        }
        return arrayList;
    }
}
