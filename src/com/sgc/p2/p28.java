package com.sgc.p2;

import java.util.ArrayList;
import java.util.Stack;

//输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
public class p28 {

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        int k = 6;
        System.out.println(GetLeastNumbers_Solution(input, k));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if(input.length==0){
            return arrayList;
        }else if(input.length<k){
            return arrayList;
        }
        int[] res = new int[k];
        for(int i = 0;i<k;i++){
            res[i] = Integer.MAX_VALUE;
        }
        for(int i = 0;i<input.length;i++){
            int j = k-1;
            for(;j>=0 && input[i]<res[j];j--);
            j++;

            for(int k1 = k-1;k1>j;k1--){
                res[k1] = res[k1-1];
            }
            if(j<k) {
                res[j] = input[i];
            }
        }
        for(int temp : res){
            arrayList.add(temp);
        }
        return arrayList;
    }
}
