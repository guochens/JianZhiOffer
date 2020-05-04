package com.sgc.p2;
//统计一个数字在排序数组中出现的次数。

import java.util.Arrays;

public class p36 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,5,5,5};
        System.out.println(GetNumberOfK(a, 0));
        System.out.println(GetNumberOfK(a, 2));
        System.out.println(GetNumberOfK(a, 3));
        System.out.println(GetNumberOfK(a, 4));
        System.out.println(GetNumberOfK(a, 5));
    }

    //二分法搜索 
    public static int GetNumberOfK(int [] array , int k) {
        int res = 0;
        if(array.length==0){
            return res;
        }
        int index = Arrays.binarySearch(array,k);
        if(index<0){
            return 0;
        }
        int i = index;
        int j = index;
        for(;array[i]==k;i++) {
            if(i>=array.length-1){
                i++;
                break;
            }
        }
        for(;array[j]==k;j--){
            if(j<=0){
                j--;
                break;
            }
        }
        res = i-j-1;
        return res;
    }
}
