package com.sgc.p2;

import java.util.HashMap;
import java.util.Map;

//求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
// 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
// ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
public class p30 {
    public static void main(String[] args) {

        char[] temp = String.valueOf(20).toCharArray();
        System.out.println(NumberOf1Between1AndN_Solution(13));
        System.out.println(NumberOf1Between1AndN_Solution(Integer.MAX_VALUE));
    }

    static Map<Integer,Integer> map = new HashMap<>();

    public static int NumberOf1Between1AndN_Solution(int n) {
        int res = 0;

        for(int i = 1;i<n;i++){
            res += sub(i);
        }
        return res;
    }

    public static int sub(int num){
        int temp = num;
        int res= 0;
        while(num>0){
            if(map.containsKey(num)){
                res += map.get(num);
                break;
            }
            int i = num%10;
            if(i==1){
                res++;
            }
            num = num / 10;
        }
        map.put(temp,res);
        return res;
    }
}
