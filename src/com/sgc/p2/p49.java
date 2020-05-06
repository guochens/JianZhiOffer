package com.sgc.p2;

import java.util.HashSet;
import java.util.Set;

public class p49 {
    public static void main(String[] args) {
        int [] numbers = {};
        int[] dup = {};
        int[] num = {2,1,3,1,4};
        //System.out.println(duplicate(numbers, 0, dup));
        System.out.println(duplicate(num, 5, dup));
    }
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        //duplication = new int[1];
        if(numbers.length<=0){
            //duplication[0] = -1;
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i<length;i++){
            if(set.contains(numbers[i])){
                duplication[0] = numbers[i];
                return true;
            }else {
                set.add(numbers[i]);
            }
        }
        return false;
    }
}
