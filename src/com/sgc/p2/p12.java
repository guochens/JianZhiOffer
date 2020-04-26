package com.sgc.p2;

import java.util.ArrayList;

public class p12 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        reOrderArray(array);
    }
    //冒泡法排序，前偶后奇交换！

    public static void reOrderArray(int [] array) {
        int length = array.length;
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for(int i = 0;i<length;i++){
            if(array[i]%2!=0){
                odd.add(array[i]);
            }else{
                even.add(array[i]);
            }
        }
        int index = 0;
        for(index = 0; index<odd.size();index++){
            array[index] = odd.get(index);
        }
        for(;index<length&&index<odd.size()+even.size();index++){
            array[index] = even.get(index-odd.size());
        }

    }
}
