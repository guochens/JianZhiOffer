package com.sgc.p2;

public class p27 {

    public static void main(String[] args) {
        int[] array = {1,2,3,2,2,2,5,4,2};
        int[] a1 = {1,2,3,2,4,2,5,2,3};
        System.out.println(MoreThanHalfNum_Solution(a1));
        System.out.println(MoreThanHalfNum_Solution(array));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0){
            return 0;
        }
        int times = 0;
        int res = 0;
        for(int i = 0; i<array.length;i++){
            if(times==0){
                res = array[i];
                times++;
                continue;
            }
            if(res!=array[i]){
                times--;
            }else{
                times++;
            }
        }
        if(times>0){
            times = 0;
            for(int i = 0;i<array.length;i++){
                if(array[i]==res){
                    times++;
                }
            }if(times>array.length/2){
                return res;
            }else {
                return 0;
            }
        }else{
            return 0;
        }
    }
}
