package com.sgc.p2;

import java.util.ArrayList;
import java.util.Arrays;

//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class p39 {

    public static void main(String[] args) {
        int[] array = {1,1,43,54,43,54,93,20,33,93};
        int[] array1 = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce1(array,num1,num2);
        FindNumsAppearOnce(array1,num1,num2);

    }

    public static void FindNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        if(array.length<2){
            return;
        }
        int xor = 0;
        for(int i = 0;i<array.length;i++){
            xor ^= array[i];
        }
        int flag = 1;
        while((xor & flag) == 0) {
            flag <<= 1;
        }
        //ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<array.length;i++){
            if((flag & array[i])==0){
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        if(array.length<2){
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0;i<array.length-1;i++){
            if(array[i]==array[i+1]){
                i++;
            }else{
                arrayList.add(array[i]);
            }
        }
        if(array[array.length-1]!=array[array.length-2]){
            arrayList.add(array[array.length-1]);
        }
        num1[0] = arrayList.get(0);
        num2[0] = arrayList.get(1);
    }
}
