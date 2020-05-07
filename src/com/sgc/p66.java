package com.sgc;

import java.util.Enumeration;

public class p66 {
    public static void main(String[] args) {
        System.out.println(cutRope2(8));
        System.out.println(cutRope1(8));
        System.out.println(cutRope(8));

    }

    //贪心算法
    public static  int cutRope2(int target){
        if(target==1){
            return 0;
        }else if(target==2){
            return 1;
        }else if(target==3){
            return 2;
        }
        int timesof2 = 0;
        int timesof3 = target/3;
        if(target-timesof3*3==1){
            timesof3--;
        }
        timesof2 = (target-timesof3*3)/2;
        return (int)(Math.pow(2,timesof2)*Math.pow(3,timesof3));
    }

    //递归
    public static int cutRope1(int target){
        if(target==1){
            return 0;
        }else if(target==2){
            return 1;
        }else if(target==3){
            return 2;
        }
        return subcut(target);
    }

    public static int subcut(int target){
        if(target<4){
            return target;
        }
        int res = 0;
        for(int i = 2;i<target;i++){
            int a = subcut(target-i);
            int b = subcut(i);
            int temp = a*b;
            res = res>temp?res:temp;
        }
        return res;
    }

    //动态规划
    public static int cutRope(int target) {
        int[] dp = new int[target+1];
        if(target==1){
            return 0;
        }else if(target==2){
            return 1;
        }else if(target==3){
            return 2;
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4;i<=target;i++){
            for(int j = 2;j<i/2+1;j++){
                dp[i] = dp[j]*dp[i-j] > dp[i]?dp[j]*dp[i-j]:dp[i];
            }
        }
        return dp[target];
    }
}
