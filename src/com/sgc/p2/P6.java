package com.sgc.p2;

public class P6 {
    public static int minNumberInRotateArray(int [] array) {
        int length = array.length;
        for(int i = 0;i<length-1;i++){
            if(array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
    }
}
